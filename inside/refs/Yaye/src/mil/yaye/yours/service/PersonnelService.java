package mil.yaye.yours.service;

import java.util.Map;

import mil.yaye.yours.dto.AddressDTO;
import mil.yaye.yours.dto.LogonDTO;
import mil.yaye.yours.dto.RegistDTO;
import mil.yaye.yours.dto.SimpleRegistDTO;
import mil.yaye.yours.dto.UserDTO;
import mil.yaye.yours.factory.BeanFactory;
import mil.yaye.yours.vo.AccountVO;
import mil.yaye.yours.vo.AddressVO;
import mil.yaye.yours.vo.UserVO;


/*
 * 注册会员的业务服务中心
 */

public interface PersonnelService {
	
	public abstract void setDAO(BeanFactory daoFactory);
	
	public abstract boolean exit(String logonid);
	
	public abstract boolean exitByJDBC(String logonid);
	
	public abstract int loginCheck(LogonDTO loginDTO); //sessionid是指服务器与客户端建立的会话的id
	
	public abstract int loginCheckByJDBC(LogonDTO logonDTO);//sessionid是指服务器与客户端建立的会话的id
	
	public abstract UserVO getInfo(String logonid, String sessionid);
	
	public abstract UserVO getInfoByJDBC(String logonid, String sessionid);
	
	/**返回这个用户的地址信息**/
	public Map<String, AddressVO> getAddrs(Integer userId);
	
	public abstract AccountVO myAccount(String logonid);

	/**session.save()返回这个persistentObject的ID**/
	public abstract Integer regist(UserDTO userDTO, AddressDTO addrDTO);
	
	public abstract Integer addOneAddr(AddressDTO addrDTO, Integer userId);
	
	public abstract Integer regist(RegistDTO registDTO);

	public abstract Integer simpleRegist(SimpleRegistDTO simpleUserDTO);

	public abstract Integer completeRegist();

	/**修改个人密码**/
	public abstract boolean check_passwd(String logonid, String passwd);

	public abstract Integer modify_passwd();

	/**忘记密码时修改密码的**/
	//	public Integer modify_passwd(){
	//		
	//	}
	/**修改个人信息**/
	public abstract void updateInfo();

	//==================================================================================================
	//以下是user管理员所需要的方法
	//==================================================================================================
	/**删除某个user**/
	public abstract void delete_user(Integer id);

	/**批量删除user,比如那些数据库中status=0的用户**/
	public abstract void delete_user();
}
