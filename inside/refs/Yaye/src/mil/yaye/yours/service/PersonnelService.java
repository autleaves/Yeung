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
 * ע���Ա��ҵ���������
 */

public interface PersonnelService {
	
	public abstract void setDAO(BeanFactory daoFactory);
	
	public abstract boolean exit(String logonid);
	
	public abstract boolean exitByJDBC(String logonid);
	
	public abstract int loginCheck(LogonDTO loginDTO); //sessionid��ָ��������ͻ��˽����ĻỰ��id
	
	public abstract int loginCheckByJDBC(LogonDTO logonDTO);//sessionid��ָ��������ͻ��˽����ĻỰ��id
	
	public abstract UserVO getInfo(String logonid, String sessionid);
	
	public abstract UserVO getInfoByJDBC(String logonid, String sessionid);
	
	/**��������û��ĵ�ַ��Ϣ**/
	public Map<String, AddressVO> getAddrs(Integer userId);
	
	public abstract AccountVO myAccount(String logonid);

	/**session.save()�������persistentObject��ID**/
	public abstract Integer regist(UserDTO userDTO, AddressDTO addrDTO);
	
	public abstract Integer addOneAddr(AddressDTO addrDTO, Integer userId);
	
	public abstract Integer regist(RegistDTO registDTO);

	public abstract Integer simpleRegist(SimpleRegistDTO simpleUserDTO);

	public abstract Integer completeRegist();

	/**�޸ĸ�������**/
	public abstract boolean check_passwd(String logonid, String passwd);

	public abstract Integer modify_passwd();

	/**��������ʱ�޸������**/
	//	public Integer modify_passwd(){
	//		
	//	}
	/**�޸ĸ�����Ϣ**/
	public abstract void updateInfo();

	//==================================================================================================
	//������user����Ա����Ҫ�ķ���
	//==================================================================================================
	/**ɾ��ĳ��user**/
	public abstract void delete_user(Integer id);

	/**����ɾ��user,������Щ���ݿ���status=0���û�**/
	public abstract void delete_user();
}
