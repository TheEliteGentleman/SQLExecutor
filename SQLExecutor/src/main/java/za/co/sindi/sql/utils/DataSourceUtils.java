/**
 * 
 */
package za.co.sindi.sql.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.CommonDataSource;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import javax.sql.XADataSource;

/**
 * @author Bienfait Sindi
 * @since 03 January 2013
 *
 */
public class DataSourceUtils {

	/**
	 * 
	 */
	private DataSourceUtils() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getConnection(CommonDataSource dataSource) throws SQLException {
		Connection connection = null;
		if (dataSource != null) {
			if (dataSource instanceof ConnectionPoolDataSource) {
				connection = ((ConnectionPoolDataSource)dataSource).getPooledConnection().getConnection();
			} else if (dataSource instanceof DataSource) {
				connection = ((DataSource)dataSource).getConnection();
			} else if (dataSource instanceof XADataSource) {
				connection = ((XADataSource)dataSource).getXAConnection().getConnection();
			}
		}
		
		return connection;
	}
	
	public static Connection getConnection(CommonDataSource dataSource, String userName, String password) throws SQLException {
		Connection connection = null;
		if (dataSource != null) {
			if (dataSource instanceof ConnectionPoolDataSource) {
				connection = ((ConnectionPoolDataSource)dataSource).getPooledConnection(userName, password).getConnection();
			} else if (dataSource instanceof DataSource) {
				connection = ((DataSource)dataSource).getConnection(userName, password);
			} else if (dataSource instanceof XADataSource) {
				connection = ((XADataSource)dataSource).getXAConnection(userName, password).getConnection();
			}
		}
		
		return connection;
	}
}
