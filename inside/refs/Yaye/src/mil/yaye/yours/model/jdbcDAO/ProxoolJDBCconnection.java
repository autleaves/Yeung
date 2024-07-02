package mil.yaye.yours.model.jdbcDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProxoolJDBCconnection {
	
	private Connection connection = null;
	private Context context = null;
	private DataSource datasource = null;
	
	public ProxoolJDBCconnection(){
		try {
			context = new InitialContext();
			datasource = (DataSource) context.lookup("datasource_oracle9i");
			connection = datasource.getConnection();
		} catch (NamingException e) {
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
