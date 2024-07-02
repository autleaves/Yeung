package mil.yaye.yours.ajax;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class AjaxDAOImpl{
	Logger logger = Logger.getLogger(this.getClass());
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private CallableStatement callableStatement = null;
	private ResultSet resultSet = null;
	
	public AjaxDAOImpl(){
		this.connection = new JDBCconnection().getConnection();
	}
	public boolean hasChildren(String parentId){
		boolean flag = false;
		String sql = "BEGIN ?:=dynaNav.hasChildren(?);END;";
		try {
			int icount = 0;
			callableStatement = connection.prepareCall(sql);
			callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);
			callableStatement.setString(2, parentId);
			icount = callableStatement.getInt(1);
			if(icount != 0){flag = true;}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCconnection.close(null, null, callableStatement, null, connection);
		}
		return flag;
	}
	public NavigationVO getChildren(String parentId) {
		String sql = "SELECT classId, name FROM treeMenu WHERE  parentId=? ORDER BY childIndex";
		NavigationVO navigationVO = new NavigationVO();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, parentId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				
			}
		} catch (SQLException e) {
			logger.fatal(e);
		} finally{
			JDBCconnection.close(resultSet, preparedStatement, null, null, connection);
		}
		return navigationVO;
	}

	public boolean validateLogonid(String logonid){
		boolean flag = false;
		PreparedStatement preparedStatement = null;
		CallableStatement callableStatement = null;
		ResultSet result = null;
		String sqlstr = "SELECT COUNT(*) FROM users WHERE logonid=?";
		try {
			preparedStatement = connection.prepareStatement(sqlstr);
			result = preparedStatement.executeQuery();
//			if(result.){}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return flag;
	}
}
