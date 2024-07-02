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
			
			/*String constructor = "(model.userId, model.logonid)"; //model��ǰ׺���ܸı�
			String limit = "model.userId";
			User user = user_dao.dynamicReadByProperty(constructor, limit, id);*/
			user_dao.setSession(session);
//			User user = user_dao.read(id);
			User user = (User) user_dao.findByLogonid(logonid).get(0);
			logger.info("�˳�ʱuser��sessiondidΪ:.." + user.getSessionid());
			user.setSessionid("$OFF$");
			user_dao.update(user); //ִ��update������һ��Ҫ�ȰѸ�����¼�������ֶζ���ѯ����,Ҳ������Ҫselect *;
			logger.info("�Ѿ���user�����ݿ��е�sessionid����Ϊ'$OFF$'��............");
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
	 * ֱ��ͨ��JDBC�޸����ݿ��е�ĳ�ֶ�,�����Ͳ��ðѸü�¼�������ֶ���Ϣ����ѯ������
	 * ����ͨ��context.lookup('datasource_oracle9i')�ķ�ʽ��proxool����Դ�л�ȡһ�����ݿ�����
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
//		���������������,����TransactionWrapper��̬�������������
//		IxxxDAO dao = TransactionWrapper.bind(new xxxDAO());
//		dao.xxxmethod(args);
		//1.�˶�����
		//2.����½��ʶ�ֶ�,�����û�е�½,�޸ĸ��ֶ�,����Ѿ���½,����һ��״̬��,�������״̬����ͻ�����ʾ.
		Session session = null;
		Transaction tran = null;
		try {
			session = HibernateSessionFactory.getSession();
			tran = session.beginTransaction();
			
			//�����ﲢ����ֻ��ѯUser�Ĳ�����Ϣ,��Ϊ����ִ��update���ʱ,���յ�ǰuser������,�����ݿ���ȫ���޸�,
			//������ݿ���е��ֶ�����Ϊnull,����userΪnull�����Ծͻ�����ݿ��еĿ���Ϊnull���ֶ�ȫ������Ϊnull
			//���������Ϊnull,�ͻ��׳��쳣
			user_dao.setSession(session);
			if(user_dao.findByLogonid(logonDTO.getLogonid()).size() == 0){
				logger.info("û�в�ѯ���뵱ǰlogonid��ص��κ���Ϣ........û������û�����........");
			}
			User user= null;
			if(user_dao.findByLogonid(logonDTO.getLogonid()).size() > 0){
				logger.info("���ݿ���ȷʵ������Ӧ�ļ�¼..........");
				user= (User) user_dao.findByLogonid(logonDTO.getLogonid()).get(0);
			} else {
				logger.info("���ݿ���û����Ӧ�ļ�¼..........");
			}
			if(user != null){
				if(user.getStatus() == 0) {
					flag = -1;
				}else {
//					logger.info("���ݿ��е�logonid�ֶ�Ϊ:" + user.getLogonid() + "..........");
					if(user.getPassword().equals(logonDTO.getPassword())){
						if(!user.getSessionid().equals("$OFF$")){
//						logger.info("���ݿ��е�sessionid�ֶ��Ѿ�Ϊ'on'��...");
							logger.info("11��ʱ���ݿ��е�sessionid�ֶ�Ϊ:" + user.getSessionid());
							flag = 11; //״̬��11�������user�Ѿ���½
						} else {
							logger.info("7��ʱ���ݿ��е�sessionid�ֶ�Ϊ:" + user.getSessionid());
							flag = 7; //״̬��7����һ�м�����,����û���κδ���
//						logger.info("�Ѿ�����޸����ݿ��е�logonid�ֶ�Ϊ'on'��......");
						}
					} else {
						flag = 4; //״̬��4�����������
					}
				}
			} else {
//				flag = 0; //״̬��0����û������û���,�����ڿͻ����������ֻ��ʾ"�û������������...",���ÿͻ���֪����û������û���
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
					flag = -1; //״̬��-1��������û�����ĳ��ԭ��δ������.
				} else {
					if(userInfoVO.getPassword().equals(logonDTO.getPassword())){
						if(!userInfoVO.getSessionid().equals("$OFF$")){
							flag = 11; //״̬��11�������user�Ѿ���½
						} else {
							flag = 7; //״̬��7����һ�м�����,����û���κδ���
						}
					} else {
						flag = 4; //״̬��4�����������
					}
				}
			} else {
//				flag = 0; //״̬��0����û������û���,�����ڿͻ����������ֻ��ʾ"�û������������...",���ÿͻ���֪����û������û���
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
			
			logger.info("��hibernateDAO�õ���userInfo...............userVO.getSessionidΪ:" + userVO.getSessionid());
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
			// ���޸�sessionid�ֶ�,�ѵ�ǰ��������ͻ��˽����ĻỰid���浽���ݿ�users���sessionid�ֶ���
			String sqlstr = "UPDATE users SET sessionid=? WHERE logonid=?";
			preparedStatement = connection.prepareStatement(sqlstr);
			preparedStatement.setString(1, sessionid);
			preparedStatement.setString(2, logonid);
			preparedStatement.executeUpdate();
			// �����²�ѯһ�θ��û���������Ϣ,���������浽��ǰ�Ự��
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
	 * (ע���û�ʱ,��ͨ��createһ��Addressʱ��User����Ϣ���뵽Users���е�)
	 * �������������ȷ����Щ��Ť,������Ҳû�а취,��Ϊ�ҵ����ݿ��ȷ������������
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
			session.close();//�ֶ��ر�����,������ͷ���Դ.
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
			
			user.setUsername(registDTO.getLogonid()); //����������username�ֶκ�logonid�ֶ���ͬ
			user.setRegistration(dateformat_Ymd.format(new Date(System.currentTimeMillis())));
			user.setSessionid("$OFF$"); //����һЩĬ��ֵ:��½sessionid,�û���½�ɹ�����Ĵ˶�
			user.setStatus(1);	//����һЩĬ��ֵ:�û�״̬,(0:δ����,1������)
			user.setBonuspoint(0); //����һЩĬ��ֵ:��������
			user.setMemberclass("com"); //����һЩĬ��ֵ:��Ա�ȼ� 'com'��ͨע���û�,'vip'vipע���û�
			id = user_dao.create(user); //��ʱuser�ͱ�Ϊ��һ���־û�������
			tran.commit();
			
			addr.setAddrname("Addr"); //addrname�ֶξ�������������,��Ϊ�һ�û����������ֶε�������ʲô
			addr.setIsprimary(0);	//����һЩĬ��ֵ:�Ƿ���Ҫ�ʹ���ַ,0����1��Ҫ,2�ر���������
			addr.setMarkfordelete(0); //����һЩĬ��ֵ:ɾ�����(0:����,1:��ɾ��)
			addr.setUser(user); //���user����һ���־û�����
			address_dao.create(addr);
			
			tran.commit();
			session.close();//�ֶ��ر�����,������ͷ���Դ.
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
		//����Ҫ�����¼��һ�¾��������ȷ,��ʹ���Ѿ���½��.
		
		return id;
	}
	/**��������ʱ�޸������**/
//	public Integer modify_passwd(){
//		
//	}
	/* (non-Javadoc)
	 * @see mil.yaye.yours.service.impls.PersonnalService#updateInfo()
	 */
	public void updateInfo(){
		
	}
	//==================================================================================================
	//������user����Ա����Ҫ�ķ���
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
