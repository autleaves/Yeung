package mil.yaye.yours.model.jdbcDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import mil.yaye.yours.dto.LogonDTO;

public class UsersJDBCDAO {

	// Fields for JDBC
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	
	
	// Methods
	public void setConnection(Connection connection){
		this.connection = connection;
	}
	public Connection getConnection(){
		return connection;
	}
	public boolean exitByJDBC(Connection connection, Integer id){
		boolean flag = false;
		try {
			connection.setAutoCommit(false);
			String sqlstr = "UPDATE users SET logonid='off' WHERE user_id=?";
			preparedStatement = connection.prepareStatement(sqlstr);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			connection.commit();
			connection.rollback();
			ProxoolJDBCconnection.close(null, preparedStatement, null, null, connection);
		} catch (SQLException e) {
			try {
				if(connection != null){ connection.rollback(); }
			} catch (SQLException e1) {
				e1.printStackTrace();
			} finally {
				ProxoolJDBCconnection.close(null, preparedStatement, null, null, connection);
			}
			e.printStackTrace();
		} finally {
			ProxoolJDBCconnection.close(null, preparedStatement, null, null, connection);
		}
		return flag;
	}
	public int loginCheckByJDBC(Connection connection, LogonDTO logonDTO) {
		int flag = 0;
		try {
			connection.setAutoCommit(false);
			String sqlstr = "SELECT ";
			preparedStatement = connection.prepareStatement(sqlstr);
			int id;
//			preparedStatement.setInt(1, id);
			connection.commit();
			ProxoolJDBCconnection.close(null, preparedStatement, null, null, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
}
