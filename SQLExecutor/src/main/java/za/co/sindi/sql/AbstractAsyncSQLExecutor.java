/**
 * 
 */
package za.co.sindi.sql;

import java.util.concurrent.ExecutorService;

/**
 * @author Bienfait Sindi
 * @since 03 January 2013
 *
 */
public abstract class AbstractAsyncSQLExecutor<T extends SQLExecutor> extends AbstractSQLExecutor {

	protected final ExecutorService executorService;
	protected final T sqlExecutor;
	
	/**
	 * @param executorService
	 * @param sqlExecutor
	 */
	protected AbstractAsyncSQLExecutor(ExecutorService executorService, T sqlExecutor) {
		super();
		
		if (executorService == null) {
			throw new IllegalArgumentException("An java.util.concurrent.ExecutorService may not be null.");
		}
		
		if (sqlExecutor == null) {
			throw new IllegalArgumentException("A SQLExecutor may not be null.");
		}
		
		this.executorService = executorService;
		this.sqlExecutor = sqlExecutor;
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AbstractSQLExecutor#getUpdateCount()
	 */
	@Override
	public int getUpdateCount() {
		// TODO Auto-generated method stub
		if (sqlExecutor != null) {
			return sqlExecutor.getUpdateCount();
		}
		
		return super.getUpdateCount();
	}
	
	protected void prepareSQLExecutor(T sqlExecutor) {
		if (sqlExecutor != null) {
			sqlExecutor.setCloseConnection(this.closeConnection);
			sqlExecutor.setConnection(this.connection);
			sqlExecutor.setFetchDirection(this.fetchDirection);
			sqlExecutor.setFetchSize(this.fetchSize);
			sqlExecutor.setMaxFieldSize(this.maxFieldSize);
			sqlExecutor.setMaxRows(this.maxRows);
			sqlExecutor.setQueryTimeout(this.queryTimeout);
		}
	}
}
