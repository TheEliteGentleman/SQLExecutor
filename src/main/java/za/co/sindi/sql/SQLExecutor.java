/**
 * 
 */
package za.co.sindi.sql;

import java.sql.Connection;

/**
 * @author Bienfait Sindi
 * @since 30 December 2012
 *
 */
public interface SQLExecutor {

	public void setConnection(Connection connection);
	public void setCloseConnection(boolean closeConnection);
	public void setFetchDirection(int direction);
	public void setFetchSize(int fetchSize);
	public void setMaxFieldSize(int maxFieldSize);
	public void setMaxRows(int maxRows);
	public void setQueryTimeout(int seconds);
	public int getUpdateCount();
}
