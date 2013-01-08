/**
 * 
 */
package za.co.sindi.sql.impl;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import za.co.sindi.sql.AbstractAsyncSQLExecutor;
import za.co.sindi.sql.AsyncProcedureCallSQLExecutor;
import za.co.sindi.sql.CallableParameters;
import za.co.sindi.sql.CallableStatementHandler;
import za.co.sindi.sql.DatabaseExecutionException;
import za.co.sindi.sql.ProcedureCallSQLExecutor;

/**
 * @author Bienfait Sindi
 * @since 03 January 2013
 *
 */
public class BasicAsyncProcedureCallSQLExecutor extends AbstractAsyncSQLExecutor<ProcedureCallSQLExecutor> implements AsyncProcedureCallSQLExecutor {

	/**
	 * @param executorService
	 * @param sqlExecutor
	 */
	public BasicAsyncProcedureCallSQLExecutor(ExecutorService executorService, ProcedureCallSQLExecutor sqlExecutor) {
		super(executorService, sqlExecutor);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AsyncProcedureCallSQLExecutor#executeCall(java.lang.String, java.lang.Object[], za.co.sindi.sql.CallableStatementHandler)
	 */
	public <T> Future<T> executeCall(final String call, final Object[] parameters, final CallableStatementHandler<T> handler) throws DatabaseExecutionException {
		// TODO Auto-generated method stub
		return executorService.submit(new Callable<T>() {

			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			public T call() throws Exception {
				// TODO Auto-generated method stub
				prepareSQLExecutor(sqlExecutor);
				return sqlExecutor.executeCall(call, parameters, handler);
			}
		});
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AsyncProcedureCallSQLExecutor#executeCall(java.lang.String, za.co.sindi.sql.CallableParameters, za.co.sindi.sql.CallableStatementHandler)
	 */
	public <T> Future<T> executeCall(final String call, final CallableParameters parameters, final CallableStatementHandler<T> handler) throws DatabaseExecutionException {
		// TODO Auto-generated method stub
		return executorService.submit(new Callable<T>() {

			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			public T call() throws Exception {
				// TODO Auto-generated method stub
				prepareSQLExecutor(sqlExecutor);
				return sqlExecutor.executeCall(call, parameters, handler);
			}
		});
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AsyncProcedureCallSQLExecutor#executeBatch(java.lang.String, java.lang.Object[][])
	 */
	public Future<int[]> executeBatch(final String call, final Object[][] parameters) throws DatabaseExecutionException {
		// TODO Auto-generated method stub
		return executorService.submit(new Callable<int[]>() {

			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			public int[] call() throws Exception {
				// TODO Auto-generated method stub
				prepareSQLExecutor(sqlExecutor);
				return sqlExecutor.executeBatch(call, parameters);
			}
		});
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.AsyncProcedureCallSQLExecutor#executeBatch(java.lang.String, za.co.sindi.sql.CallableParameters[])
	 */
	public Future<int[]> executeBatch(final String call, final CallableParameters[] parameters) throws DatabaseExecutionException {
		// TODO Auto-generated method stub
		return executorService.submit(new Callable<int[]>() {

			/* (non-Javadoc)
			 * @see java.util.concurrent.Callable#call()
			 */
			public int[] call() throws Exception {
				// TODO Auto-generated method stub
				prepareSQLExecutor(sqlExecutor);
				return sqlExecutor.executeBatch(call, parameters);
			}
		});
	}
}
