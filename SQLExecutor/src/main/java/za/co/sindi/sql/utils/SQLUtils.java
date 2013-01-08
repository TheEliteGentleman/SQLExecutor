/**
 * 
 */
package za.co.sindi.sql.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Bienfait Sindi
 * @since 03 January 2013
 *
 */
public class SQLUtils {

	/**
	 * 
	 */
	private SQLUtils() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Closes a {@link Connection}.
	 * 
	 * @param connection
	 * @throws SQLException
	 */
	public static void close(Connection connection) throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}
	
	/**
	 * Closes a {@link Statement}/{@link PreparedStatement}/{@link CallableStatement}.
	 * 
	 * @param statement
	 * @throws SQLException
	 */
	public static void close(Statement statement) throws SQLException {
		if (statement != null) {
			statement.close();
			statement = null;
		}
	}
	
	/**
	 * Closes a {@link ResultSet}.
	 * 
	 * @param resultSet
	 * @throws SQLException
	 */
	public static void close(ResultSet resultSet) throws SQLException {
		if (resultSet != null) {
			resultSet.close();
			resultSet = null;
		}
	}
	
	/**
	 * Commits changes that exists in the {@link Connection}.
	 * 
	 * @param connection
	 * @throws SQLException
	 */
	public static void commit(Connection connection) throws SQLException {
		if (connection != null && !connection.getAutoCommit()) {
			connection.commit();
		}
	}
	
	/**
	 * Undo all changes made by the {@link Connection}.
	 * 
	 * @param connection
	 * @throws SQLException
	 */
	public static void rollback(Connection connection) throws SQLException {
		if (connection != null && !connection.getAutoCommit()) {
			connection.rollback();
		}
	}
	
	/**
	 * Commit and close.
	 * 
	 * @param connection
	 * @throws SQLException
	 */
	public static void commitAndClose(Connection connection) throws SQLException {
		try {
			commit(connection);
		} finally {
			close(connection);
		}
	}
	
	public static void rollbackAndClose(Connection connection) throws SQLException {
		try {
			rollback(connection);
		} finally {
			close(connection);
		}
	}
}
