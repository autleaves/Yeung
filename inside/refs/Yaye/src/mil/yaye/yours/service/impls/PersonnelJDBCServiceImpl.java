package mil.yaye.yours.service.impls;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mil.yaye.yours.dto.AddressDTO;
import mil.yaye.yours.dto.LogonDTO;
import mil.yaye.yours.dto.RegistDTO;
import mil.yaye.yours.dto.SimpleRegistDTO;
import mil.yaye.yours.dto.UserDTO;
import mil.yaye.yours.factory.BeanFactory;
import mil.yaye.yours.factory.HibernateSessionFactory;
import mil.yaye.yours.model.jdbcDAO.ProxoolJDBCconnection;
import mil.yaye.yours.model.ormDAO.AddressDAO;
import mil.yaye.yours.model.ormDAO.UsersDAO;
import mil.yaye.yours.pojo.Address;
import mil.yaye.yours.pojo.User;
import mil.yaye.yours.service.PersonnelService;
import mil.yaye.yours.vo.AccountVO;
import mil.yaye.yours.vo.AddressVO;
import mil.yaye.yours.vo.UserVO;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonnelJDBCServiceImpl implements PersonnelService {
	
	//Fields
	private static Logger logger = Logger.getLogger(PersonnelJDBCServiceImpl.class.getName());
	
	private BeanFactory daoFactory = null;
	private UsersDAO user_dao = null;
	private AddressDAO address_dao = null;
	
	// Fields for JDBC
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet result = null;
	
	//Constructors
	
	public PersonnelJDBCServiceImpl() {
	}
	/*private PersonnelServiceImpl(){
		String id_u = "UsersDAOImpl";
		String id_a = "AddressDAOImpl";
		users_dao = (UsersDAO)daoFactory.getBean(id_u);
		address_dao = (AddressDAO)daoFactory.getBean(id_a);
	}*/
	
	public void setDAO(BeanFactory daoFactory){
		this.daoFactory = daoFactory;
		String id_u = "UsersDAO";
		String id_a = "AddressDAO";
		user_dao = (UsersDAO) this.daoFactory.getBean(id_u);
		address_dao = (AddressDAO) this.daoFactory.getBean(id_a);
	}
	
	//Methods
	public boolean exit(String logonid){
		boolean flag = false;
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			/*String constructor = "(model.userId, model.logonid)"; //model的前缀不能改变
			String limit = "model.userId";
			User user = user_dao.dynamicReadByProperty(constructor, limit, id);*/
			user_dao.setSession(session);
//			User user = user_dao.read(id);
			User user = (User) user_dao.findByLogonid(logonid).get(0);
			logger.info("退出时user的sessiondid为:.." + user.getSessionid());
			user.setSessionid("$OFF$");
			user_dao.update(user); //执行update操作就一定要先把该条记录的所有字段都查询出来,也就是需要select *;
			logger.info("已经把user的数据库中的sessionid设置为'$OFF$'了............");
			tran.commit();
			session.close();
		} catch (HibernateException e) {
			if(tran != null){ tran.rollback(); }
			e.printStackTrace();
		} finally {
			if(session != null){ session.close(); }
		}
		return flag;
	}
	/**
	 * 直接通过JDBC修改数据库中的某字段,这样就不用把该记录的所有字段信息都查询出来了
	 * 这里通过context.lookup('datasource_oracle9i')的方式从proxool数据源中获取一个数据库连接
	 * @param id
	 * @return
	 */
	public boolean exitByJDBC(String logonid){
		boolean flag = false;
		try {
			connection = new ProxoolJDBCconnection().getConnection();
			connection.setAutoCommit(false);
			
			String sqlstr = "UPDATE users SET sessionid='$OFF$' WHERE logonid=?";
			preparedStatement = connection.prepareStatement(sqlstr);
			preparedStatement.setString(1, logonid);
			preparedStatement.executeUpdate();
			connection.commit();
			
			ProxoolJDBCconnection.close(null, preparedStatement, null, null, connection);
		} catch (SQLException e) {
			try {
				if(!connection.isClosed()){ connection.rollback(); }
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			ProxoolJDBCconnection.close(null, preparedStatement, null, null, connection);
		}
		return flag;
	}
	
	/* (non-Javadoc)
	 * @see mil.yaye.yours.service.impls.PersonnalService#loginCheck(java.lang.String, java.lang.String)
	 */
	public int loginCheck(LogonDTO logonDTO){
		int flag = 0;
//		String rightPasswd = users_dao.
//		在这里进行事务处理,运用TransactionWrapper动态代理进行事务处理
//		IxxxDAO dao = TransactionWrapper.bind(new xxxDAO());
//		dao.xxxmethod(args);
		//1.核对密码
		//2.检查登陆标识字段,如果还没有登陆,修改该字段,如果已经登陆,返回一个状态码,根据这个状态码给客户端提示.
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			//在这里并不能只查询User的部分信息,因为后面执行update语句时,按照当前user的属性,把数据库表的全部修改,
			//如果数据库表中的字段允许为null,这样user为null的属性就会把数据库中的可以为null的字段全部覆盖为null
			//如果不允许为null,就会抛出异常
			user_dao.setSession(session);
			if(user_dao.findByLogonid(logonDTO.getLogonid()).size() == 0){
				logger.info("没有查询到与当前logonid相关的任何信息........没有这个用户存在........");
			}
			User user= null;
			if(user_dao.findByLogonid(logonDTO.getLogonid()).size() > 0){
				logger.info("数据库中确实是有相应的记录..........");
				user= (User) user_dao.findByLogonid(logonDTO.getLogonid()).get(0);
			} else {
				logger.info("数据库中没有相应的记录..........");
			}
			if(user != null){
				if(user.getStatus() == 0) {
					flag = -1;
				}else {
//					logger.info("数据库中的logonid字段为:" + user.getLogonid() + "..........");
					if(user.getPassword().equals(logonDTO.getPassword())){
						if(!user.getSessionid().equals("$OFF$")){
//						logger.info("数据库中的sessionid字段已经为'on'了...");
							logger.info("11此时数据库中的sessionid字段为:" + user.getSessionid());
							flag = 11; //状态码11代表这个user已经登陆
						} else {
							logger.info("7此时数据库中的sessionid字段为:" + user.getSessionid());
							flag = 7; //状态码7代表一切检查完毕,并且没有任何错误
//						logger.info("已经完成修改数据库中的logonid字段为'on'了......");
						}
					} else {
						flag = 4; //状态码4代表密码错误
					}
				}
			} else {
//				flag = 0; //状态码0代表没有这个用户名,但是在客户端浏览器上只提示"用户名或密码错误...",不让客户端知道是没有这个用户名
			}
			tran.commit();
			session.close();
		} catch (HibernateException e) {
			if(tran != null){ tran.rollback(); }
			e.printStackTrace();
		} finally {
			if(session != null){session.close();}
		}
		
		return flag;
	}
	
	public int loginCheckByJDBC(LogonDTO logonDTO) {
		int flag = 0;
		UserVO userInfoVO = new UserVO();
		try {
			connection = new ProxoolJDBCconnection().getConnection();
			connection.setAutoCommit(false);
			String sqlstr = "SELECT password,sessionid,status FROM users WHERE logonid=?";
			preparedStatement = connection.prepareStatement(sqlstr);
			preparedStatement.setString(1, logonDTO.getLogonid());
			result = preparedStatement.executeQuery();
			while(result.next()) {
				userInfoVO.setPassword(result.getString("password"));
				userInfoVO.setSessionid(result.getString("sessionid"));
				userInfoVO.setStatus(result.getInt("status"));
			}
			if(userInfoVO != null){
				if(userInfoVO.getStatus() == 0){
					flag = -1; //状态码-1代表这个用户由于某种原因未起用了.
				} else {
					if(userInfoVO.getPassword().equals(logonDTO.getPassword())){
						if(!userInfoVO.getSessionid().equals("$OFF$")){
							flag = 11; //状态码11代表这个user已经登陆
						} else {
							flag = 7; //状态码7代表一切检查完毕,并且没有任何错误
						}
					} else {
						flag = 4; //状态码4代表密码错误
					}
				}
			} else {
//				flag = 0; //状态码0代表没有这个用户名,但是在客户端浏览器上只提示"用户名或密码错误...",不让客户端知道是没有这个用户名
			}
			connection.commit();
			ProxoolJDBCconnection.close(null, preparedStatement, null, null, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	public UserVO getInfo(String logonid, String sessionid) {
		UserVO userVO = new UserVO();
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			user_dao.setSession(session);
			
			User user = (User) user_dao.findByLogonid(logonid).get(0);
			user.setSessionid(sessionid);
			user_dao.update(user);
			user = (User) user_dao.read(user.getUserId());
			if(user != null) BeanUtils.copyProperties(userVO, user);
			
			logger.info("用hibernateDAO得到的userInfo...............userVO.getSessionid为:" + userVO.getSessionid());
			tran.commit();
			session.close();
		} catch (HibernateException e) {
			if(tran != null){ tran.rollback(); }
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			if(session != null){ session.close(); }
		}
		return userVO;
	}
	
	public UserVO getInfoByJDBC(String logonid, String sessionid){
		UserVO userInfoVO = new UserVO();
		try {
			connection = new ProxoolJDBCconnection().getConnection();
			connection.setAutoCommit(false);
			// 先修改sessionid字段,把当前服务器与客户端建立的会话id保存到数据库users表的sessionid字段中
			String sqlstr = "UPDATE users SET sessionid=? WHERE logonid=?";
			preparedStatement = connection.prepareStatement(sqlstr);
			preparedStatement.setString(1, sessionid);
			preparedStatement.setString(2, logonid);
			preparedStatement.executeUpdate();
			// 再重新查询一次该用户的所有信息,以用来保存到当前会话中
			sqlstr = "SELECT * FROM users WHERE logonid=?";
			preparedStatement = connection.prepareStatement(sqlstr);
			preparedStatement.setString(1, logonid);
			result = preparedStatement.executeQuery();
			while(result.next()) {
				userInfoVO.setUserId(result.getInt("user_id"));
				userInfoVO.setLogonid(result.getString("logonid"));
				userInfoVO.setUsername(result.getString("username"));
				userInfoVO.setPassword(result.getString("password"));
				userInfoVO.setSessionid(result.getString("sessionid"));
				userInfoVO.setStatus(result.getInt("status"));
				userInfoVO.setRegistration(result.getString("registration"));
				userInfoVO.setBonuspoint(result.getInt("bonuspoint"));
				userInfoVO.setMemberclass(result.getString("memberclass"));
			}
			connection.commit();
			ProxoolJDBCconnection.close(null, preparedStatement, null, null, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		return userInfoVO;
	}
	public Map<String, AddressVO> getAddrs(Integer userId){
		Map<String, AddressVO> addrMap = new HashMap<String, AddressVO>();
		List<Address> addrlistTemp = new ArrayList<Address>();
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			address_dao.setSession(session);
			
			addrlistTemp = address_dao.findByForeignkey(userId);
			Iterator<Address> iter = addrlistTemp.iterator();
			AddressVO addrVO = null;
			while(iter.hasNext()){
				BeanUtils.copyProperties(addrVO, iter.next());
				addrMap.put("ADDR_" + addrVO.getAddressId(), addrVO);
			}
			
			tran.commit();
			session.close();
		} catch (HibernateException e) {
			if(tran != null) {tran.rollback();}
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			if(session != null){session.close();}
		}
		return addrMap;
	}
	public AccountVO myAccount(String logonid){
		AccountVO accountVO = new AccountVO();
		
		return accountVO;
	}
	/* (non-Javadoc)
	 * (注册用户时,是通过create一个Address时把User的信息存入到Users表中的)
	 * 这个方法看起来确是有些别扭,但是我也没有办法,因为我的数据库表确是那样建立的
	 * @see mil.yaye.yours.service.impls.PersonnalService#regist(mil.yaye.yours.dto.UserDTO, mil.yaye.yours.dto.AddressDTO)
	 */
	public Integer regist(UserDTO userDTO, AddressDTO addrDTO){
		Integer userId = -1;
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			user_dao.setSession(session);
			address_dao.setSession(session);
			
			User user = new User();
			Address addr = new Address();
			BeanUtils.copyProperties(user, userDTO);
//			SimpleDateFormat dateformat_Ymd = new SimpleDateFormat("yyyy-mm-dd");
//			ParsePosition pos = new ParsePosition(0);
//			dateformat_Ymd.parse(userDTO., arg1)
//			user.setRegistration(dateformat_Ymd.format(new Date(System.currentTimeMillis())));
			BeanUtils.copyProperties(addr, addrDTO);
			addr.setAddrname("Addr");
			
			userId = user_dao.create(user);
			user.setUserId(userId);
//			tran.commit();
			
			addr.setUser(user);
			address_dao.create(addr);
			
			tran.commit();
			session.close();//手动关闭链接,更快地释放资源.
		} catch (HibernateException e) {
			if(tran != null){tran.rollback();}
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally{
			if(session != null){session.close();}
		}
		return userId;
	}
	public Integer regist(RegistDTO registDTO){
		Integer id = -1;
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			user_dao.setSession(session);
			address_dao.setSession(session);
			
			User user = new User();
			Address addr = new Address();
			BeanUtils.copyProperties(user, registDTO);
			BeanUtils.copyProperties(addr, registDTO);
			
			SimpleDateFormat dateformat_Ymd = new SimpleDateFormat("yyyy-mm-dd");
			
			/*long timeMillis = System.currentTimeMillis();
			ParsePosition pos = new ParsePosition(0);
			dateformat_Ymd.parse(registDTO.getBirthday());
			user.setRegistration(dateformat_Ymd.format(new Date(System.currentTimeMillis())));
			addr.setBirthday_date(dateformat_Ymd.parse(registDTO.getBirthday(), pos));*/
			
			user.setUsername(registDTO.getLogonid()); //我先暂且让username字段和logonid字段相同
			user.setRegistration(dateformat_Ymd.format(new Date(System.currentTimeMillis())));
			user.setSessionid("$OFF$"); //设置一些默认值:登陆sessionid,用户登陆成功后更改此段
			user.setStatus(1);	//设置一些默认值:用户状态,(0:未起用,1已起用)
			user.setBonuspoint(0); //设置一些默认值:积分数量
			user.setMemberclass("com"); //设置一些默认值:会员等级 'com'普通注册用户,'vip'vip注册用户
			id = user_dao.create(user); //此时user就变为了一个持久化对象了
			tran.commit();
			
			addr.setAddrname("Addr"); //addrname字段就先这样设置着,因为我还没有明白这个字段的作用是什么
			addr.setIsprimary(0);	//设置一些默认值:是否首要送贷地址,0不是1首要,2特别三个级别
			addr.setMarkfordelete(0); //设置一些默认值:删除标记(0:正常,1:已删除)
			addr.setUser(user); //这个user就是一个持久化对象
			address_dao.create(addr);
			
			tran.commit();
			session.close();//手动关闭链接,更快地释放资源.
		} catch (HibernateException e) {
			if(tran != null){tran.rollback();}
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally{
			if(session != null){session.close();}
		}
		return id;
	}
	public Integer addOneAddr(AddressDTO addrDTO, Integer userId){
		Integer id = -1;
		
		
		
		return id;
	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.service.impls.PersonnalService#simpleRegist(mil.yaye.yours.dto.SimpleRegistDTO)
	 */
	public Integer simpleRegist(SimpleRegistDTO simpleUserDTO){
		Integer id = -1;
		Session session = null;
		Transaction tran = null;
		try {
			User newInstance = new User();
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			user_dao.setSession(session);
			
			try {
				BeanUtils.copyProperties(newInstance, simpleUserDTO);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			id = user_dao.create(newInstance);
			
			tran.commit();
			session.close();
		} catch (HibernateException e) {
			if(tran != null){tran.rollback();}
			e.printStackTrace();
		} finally{
			if(session != null){session.close();}
		}
		return id;
	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.service.impls.PersonnalService#completeRegist()
	 */
	public Integer completeRegist(){
		Integer id = -1;
		
		return id;
	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.service.impls.PersonnalService#check_passwd(java.lang.String, java.lang.String)
	 */
	public boolean check_passwd(String logonid,String passwd){
		boolean flag = false;
		
		return flag;
	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.service.impls.PersonnalService#modify_passwd()
	 */
	public Integer modify_passwd(){
		Integer id = -1;
		/*if(check_passwd()){
			s
		}*/
		//首先要先重新检查一下旧密码的正确,即使是已经登陆了.
		
		return id;
	}
	/**忘记密码时修改密码的**/
//	public Integer modify_passwd(){
//		
//	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.service.impls.PersonnalService#updateInfo()
	 */
	public void updateInfo(){
		
	}
	//==================================================================================================
	//以下是user管理员所需要的方法
	//==================================================================================================
	/* (non-Javadoc)
	 * @see mil.yaye.yours.service.impls.PersonnalService#delete_user(java.lang.Integer)
	 */
	public void delete_user(Integer id){
		
	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.service.impls.PersonnalService#delete_user()
	 */
	public void delete_user(){
		
	}

}
