package mil.yaye.yours.ajax;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCconnection {
	
	private String driver ="oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
	private String name = "scott";
	private String password = "tiger";
	
	private Connection connection = null;
	
	public JDBCconnection(){
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url,name,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		return connection;
	}
	public static void close(ResultSet resultSet,PreparedStatement preparedStatement,CallableStatement callableStatement,Statement statement,Connection connection){
		if(resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				if(preparedStatement != null){
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally{
						if(callableStatement != null){
							try {
								callableStatement.close();
							} catch (SQLException e) {
								e.printStackTrace();
							} finally{
								if(statement != null){
									try {
										statement.close();
									} catch (SQLException e) {
										e.printStackTrace();
									} finally {
										if(connection != null){
											try {
												connection.close();
											} catch (SQLException e) {
												e.printStackTrace();
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
