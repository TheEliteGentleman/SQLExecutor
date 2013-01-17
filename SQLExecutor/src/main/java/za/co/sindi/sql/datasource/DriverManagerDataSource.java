/**
 * 
 */
package za.co.sindi.sql.datasource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * @author Bienfait Sindi
 * @since 03 January 2013
 *
 */
public class DriverManagerDataSource implements DataSource {

	private String url;
	private Properties info;

	/**
	 * @param url
	 */
	public DriverManagerDataSource(String url) {
		this(url, null);
	}

	/**
	 * @param url
	 * @param info
	 */
	public DriverManagerDataSource(String url, Properties info) {
		super();
		this.url = url;
		this.info = info;
	}

	/* (non-Javadoc)
	 * @see javax.sql.CommonDataSource#getLogWriter()
	 */
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return DriverManager.getLogWriter();
	}

	/* (non-Javadoc)
	 * @see javax.sql.CommonDataSource#setLogWriter(java.io.PrintWriter)
	 */
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		DriverManager.setLogWriter(out);
	}

	/* (non-Javadoc)
	 * @see javax.sql.CommonDataSource#setLoginTimeout(int)
	 */
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		DriverManager.setLoginTimeout(seconds);
	}

	/* (non-Javadoc)
	 * @see javax.sql.CommonDataSource#getLoginTimeout()
	 */
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return DriverManager.getLoginTimeout();
	}

	/* (non-Javadoc)
	 * @see javax.sql.CommonDataSource#getParentLogger()
	 */
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Method not supported.");
	}

	/* (non-Javadoc)
	 * @see java.sql.Wrapper#unwrap(java.lang.Class)
	 */
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Method not supported.");
	}

	/* (non-Javadoc)
	 * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
	 */
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Method not supported.");
	}

	/* (non-Javadoc)
	 * @see javax.sql.DataSource#getConnection()
	 */
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		if (info == null) {
			return DriverManager.getConnection(url);
		}
		
		return DriverManager.getConnection(url, info);
	}

	/* (non-Javadoc)
	 * @see javax.sql.DataSource#getConnection(java.lang.String, java.lang.String)
	 */
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return DriverManager.getConnection(url, username, password);
	}
}
