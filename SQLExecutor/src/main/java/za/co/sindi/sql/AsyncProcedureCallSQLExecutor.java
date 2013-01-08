/**
 * 
 */
package za.co.sindi.sql;

import java.util.concurrent.Future;

/**
 * @author Bienfait Sindi
 * @since 03 January 2013
 *
 */
public interface AsyncProcedureCallSQLExecutor extends SQLExecutor {

	public <T> Future<T> executeCall(final String call, final Object[] parameters, final CallableStatementHandler<T> handler) throws DatabaseExecutionException;
	public <T> Future<T> executeCall(final String call, final Parameters parameters, final CallableStatementHandler<T> handler) throws DatabaseExecutionException;
	public Future<int[]> executeBatch(final String call, final Object[][] parameters) throws DatabaseExecutionException;
	public Future<int[]> executeBatch(final String call, final Parameters[] parameters) throws DatabaseExecutionException;
}
