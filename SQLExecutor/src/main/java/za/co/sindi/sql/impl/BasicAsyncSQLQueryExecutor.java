/**
 * 
 */
package za.co.sindi.sql.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import za.co.sindi.sql.AbstractAsyncSQLExecutor;
import za.co.sindi.sql.AsyncSQLQueryExecutor;
import za.co.sindi.sql.DatabaseExecutionException;
import za.co.sindi.sql.GeneratedKeysHandler;
import za.co.sindi.sql.Parameters;
import za.co.sindi.sql.ResultSetHandler;
import za.co.sindi.sql.ResultSetInfo;
import za.co.sindi.sql.SQLQueryExecutor;

/**
 * @author Bienfait Sindi
 * @since 03 January 2013
 *
 */
public class BasicAsyncSQLQueryExecutor extends AbstractAsyncSQLExecutor<SQLQueryExecutor> implements AsyncSQLQueryExecutor {

	/**
	 * @param executorService
	 * @param sqlExecutor
	 */
	public BasicAsyncSQLQueryExecutor(ExecutorService executorService, SQLQueryExecutor sqlExecutor) {
		super(executorService, sqlExecutor);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AsyncSQLQueryExecutor#executeQuery(java.lang.String, za.co.sindi.sql.ResultSetHandler)
	 */
	public <T> Future<T> executeQuery(final String query, final ResultSetHandler<T> handler) throws DatabaseExecutionException {
		// TODO Auto-generated method stub
		return executorService.submit(new Callable<T>() {

			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			public T call() throws Exception {
				// TODO Auto-generated method stub
				prepareSQLExecutor(sqlExecutor);
				return sqlExecutor.executeQuery(query, handler);
			}
		});
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AsyncSQLQueryExecutor#executeQuery(java.lang.String, java.lang.Object[], za.co.sindi.sql.ResultSetHandler)
	 */
	public <T> Future<T> executeQuery(final String query, final Object[] parameters, final ResultSetHandler<T> handler) throws DatabaseExecutionException {
		// TODO Auto-generated method stub
		return executorService.submit(new Callable<T>() {

			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			public T call() throws Exception {
				// TODO Auto-generated method stub
				prepareSQLExecutor(sqlExecutor);
				return sqlExecutor.executeQuery(query, parameters, handler);
			}
		});
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AsyncSQLQueryExecutor#executeQuery(java.lang.String, za.co.sindi.sql.Parameters, za.co.sindi.sql.ResultSetHandler)
	 */
	public <T> Future<T> executeQuery(final String query, final Parameters parameters, final ResultSetHandler<T> handler) throws DatabaseExecutionException {
		// TODO Auto-generated method stub
		return executorService.submit(new Callable<T>() {

			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			public T call() throws Exception {
				// TODO Auto-generated method stub
				prepareSQLExecutor(sqlExecutor);
				return sqlExecutor.executeQuery(query, parameters, handler);
			}
		});
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AsyncSQLQueryExecutor#executeQuery(java.lang.String, za.co.sindi.sql.ResultSetInfo, za.co.sindi.sql.ResultSetHandler)
	 */
	public <T> Future<T> executeQuery(final String query, final ResultSetInfo info, final ResultSetHandler<T> handler) throws DatabaseExecutionException {
		// TODO Auto-generated method stub
		return executorService.submit(new Callable<T>() {

			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			public T call() throws Exception {
				// TODO Auto-generated method stub
				prepareSQLExecutor(sqlExecutor);
				return sqlExecutor.executeQuery(query, info, handler);
			}
		});
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AsyncSQLQueryExecutor#executeQuery(java.lang.String, java.lang.Object[], za.co.sindi.sql.ResultSetInfo, za.co.sindi.sql.ResultSetHandler)
	 */
	public <T> Future<T> executeQuery(final String query, final Object[] parameters, final ResultSetInfo info, final ResultSetHandler<T> handler) throws DatabaseExecutionException {
		// TODO Auto-generated method stub
		return executorService.submit(new Callable<T>() {

			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			public T call() throws Exception {
				// TODO Auto-generated method stub
				prepareSQLExecutor(sqlExecutor);
				return sqlExecutor.executeQuery(query, parameters, info, handler);
			}
		});
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AsyncSQLQueryExecutor#executeQuery(java.lang.String, za.co.sindi.sql.Parameters, za.co.sindi.sql.ResultSetInfo, za.co.sindi.sql.ResultSetHandler)
	 */
	public <T> Future<T> executeQuery(final String query, final Parameters parameters, final ResultSetInfo info, final ResultSetHandler<T> handler) throws DatabaseExecutionException {
		// TODO Auto-generated method stub
		return executorService.submit(new Callable<T>() {

			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			public T call() throws Exception {
				// TODO Auto-generated method stub
				prepareSQLExecutor(sqlExecutor);
				return sqlExecutor.executeQuery(query, parameters, info, handler);
			}
		});
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AsyncSQLQueryExecutor#executeUpdate(java.lang.String)
	 */
	public Future<Integer> executeUpdate(final String query) throws DatabaseExecutionException {
		// TODO Auto-generated method stub
		return executorService.submit(new Callable<Integer>() {

			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				prepareSQLExecutor(sqlExecutor);
				return sqlExecutor.executeUpdate(query);
			}
		});
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AsyncSQLQueryExecutor#executeUpdate(java.lang.String, java.lang.Object[])
	 */
	public Future<Integer> executeUpdate(final String query, final Object... parameters) throws DatabaseExecutionException {
		// TODO Auto-generated method stub
		return executorService.submit(new Callable<Integer>() {

			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				prepareSQLExecutor(sqlExecutor);
				return sqlExecutor.executeUpdate(query, parameters);
			}
		});
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AsyncSQLQueryExecutor#executeUpdate(java.lang.String, za.co.sindi.sql.Parameters)
	 */
	public Future<Integer> executeUpdate(final String query, final Parameters parameters) throws DatabaseExecutionException {
		// TODO Auto-generated method stub
		return executorService.submit(new Callable<Integer>() {

			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			public Integer call() throws Exception {
				// TODO Auto-generated method stub
				prepareSQLExecutor(sqlExecutor);
				return sqlExecutor.executeUpdate(query, parameters);
			}
		});
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AsyncSQLQueryExecutor#executeUpdate(java.lang.String, java.lang.Object[], za.co.sindi.sql.GeneratedKeysResultSetHandler)
	 */
	public <K> Future<K> executeUpdate(final String query, final Object[] parameters,final GeneratedKeysHandler<K> handler) throws DatabaseExecutionException {
		// TODO Auto-generated method stub
		return executorService.submit(new Callable<K>() {

			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			public K call() throws Exception {
				// TODO Auto-generated method stub
				prepareSQLExecutor(sqlExecutor);
				return sqlExecutor.executeUpdate(query, parameters, handler);
			}
		});
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AsyncSQLQueryExecutor#executeUpdate(java.lang.String, za.co.sindi.sql.Parameters, za.co.sindi.sql.GeneratedKeysResultSetHandler)
	 */
	public <K> Future<K> executeUpdate(final String query, final Parameters parameters, final GeneratedKeysHandler<K> handler) throws DatabaseExecutionException {
		// TODO Auto-generated method stub
		return executorService.submit(new Callable<K>() {

			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			public K call() throws Exception {
				// TODO Auto-generated method stub
				prepareSQLExecutor(sqlExecutor);
				return sqlExecutor.executeUpdate(query, parameters, handler);
			}
		});
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AsyncSQLQueryExecutor#executeBatch(java.lang.String, java.lang.Object[][])
	 */
	public Future<int[]> executeBatch(final String query, final Object[][] parameters) throws DatabaseExecutionException {
		// TODO Auto-generated method stub
		return executorService.submit(new Callable<int[]>() {

			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			public int[] call() throws Exception {
				// TODO Auto-generated method stub
				prepareSQLExecutor(sqlExecutor);
				return sqlExecutor.executeBatch(query, parameters);
			}
		});
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AsyncSQLQueryExecutor#executeBatch(java.lang.String, za.co.sindi.sql.Parameters[])
	 */
	public Future<int[]> executeBatch(final String query, final Parameters[] parameters) throws DatabaseExecutionException {
		// TODO Auto-generated method stub
		return executorService.submit(new Callable<int[]>() {

			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			public int[] call() throws Exception {
				// TODO Auto-generated method stub
				prepareSQLExecutor(sqlExecutor);
				return sqlExecutor.executeBatch(query, parameters);
			}
		});
	}
}
