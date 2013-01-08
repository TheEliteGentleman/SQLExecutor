/**
 * 
 */
package za.co.sindi.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Bienfait Sindi
 * @since 01 January 2013
 *
 */
public abstract class AbstractSQLExecutor implements SQLExecutor {

	protected final Logger logger = Logger.getLogger(this.getClass().getName());
	protected Connection connection;
	protected int fetchDirection;
	protected int fetchSize;
	protected int maxFieldSize;
	protected int queryTimeout;
	protected int maxRows;
	protected int updateCount;
	protected boolean closeConnection;
	
	/* (non-Javadoc)
	 * @see za.co.sindi.sql.SQLQueryExecutor#setConnection(java.sql.Connection)
	 */
	public void setConnection(Connection connection) {
		// TODO Auto-generated method stub
		this.connection = connection;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.SQLQueryExecutor#setFetchDirection(int)
	 */
	public void setFetchDirection(int direction) {
		// TODO Auto-generated method stub
		this.fetchDirection = direction;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.SQLQueryExecutor#setFetchSize(int)
	 */
	public void setFetchSize(int fetchSize) {
		// TODO Auto-generated method stub
		this.fetchSize = fetchSize;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.SQLQueryExecutor#setMaxFieldSize(int)
	 */
	public void setMaxFieldSize(int maxFieldSize) {
		// TODO Auto-generated method stub
		this.maxFieldSize = maxFieldSize;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.SQLQueryExecutor#setMaxRows(int)
	 */
	public void setMaxRows(int maxRows) {
		// TODO Auto-generated method stub
		this.maxRows = maxRows;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.SQLQueryExecutor#setQueryTimeout(int)
	 */
	public void setQueryTimeout(int seconds) {
		// TODO Auto-generated method stub
		this.queryTimeout = seconds;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.SQLExecutor#getUpdateCount()
	 */
	public int getUpdateCount() {
		// TODO Auto-generated method stub
		return updateCount;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.SQLExecutor#setCloseConnection(boolean)
	 */
	public void setCloseConnection(boolean closeConnection) {
		// TODO Auto-generated method stub
		this.closeConnection = closeConnection;
	}

	protected void prepareStatement(Statement statement) throws SQLException {
		if (statement != null) {
			//Update fetch direction
			if (fetchDirection >= ResultSet.FETCH_FORWARD && fetchDirection <= ResultSet.FETCH_UNKNOWN) {
				if (logger.isLoggable(Level.INFO)) {
					logger.info("Setting Fetch direction to " + fetchDirection + ".");
				}
				
				statement.setFetchDirection(fetchDirection);
			}
			
			//Updating fetch size
			if (fetchSize >= 0) {
				if (logger.isLoggable(Level.INFO)) {
					logger.info("Setting Fetch size to " + fetchSize + ".");
				}
				
				statement.setFetchSize(fetchSize);
			}
			
			//Updating max filed size
			if (maxFieldSize >= 0) {
				if (logger.isLoggable(Level.INFO)) {
					logger.info("Setting Max Field size to " + maxFieldSize + ".");
				}
				
				statement.setMaxFieldSize(maxFieldSize);
			}
			
			//Updating fetch size
			if (maxRows >= 0) {
				if (logger.isLoggable(Level.INFO)) {
					logger.info("Setting max rows to " + maxRows + ".");
				}
				
				statement.setMaxRows(maxRows);
			}
			
			//Updating query timeout
			if (queryTimeout >= 0) {
				if (logger.isLoggable(Level.INFO)) {
					logger.info("Setting query timeout to " + fetchSize + " seconds.");
				}
				
				statement.setQueryTimeout(queryTimeout);
			}
		}
	}
}
