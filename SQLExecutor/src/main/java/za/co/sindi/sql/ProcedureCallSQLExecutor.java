/**
 * 
 */
package za.co.sindi.sql;

/**
 * @author Bienfait Sindi
 * @since 01 January 2013
 *
 */
public interface ProcedureCallSQLExecutor extends SQLExecutor {

	public <T> T executeCall(String call, Object[] parameters, CallableStatementHandler<T> handler) throws DatabaseExecutionException;
	public <T> T executeCall(String call, CallableParameters parameters, CallableStatementHandler<T> handler) throws DatabaseExecutionException;
	public <T> T executeCall(String call, Object[] parameters, ResultSetInfo info, CallableStatementHandler<T> handler) throws DatabaseExecutionException;
	public <T> T executeCall(String call, CallableParameters parameters, ResultSetInfo info, CallableStatementHandler<T> handler) throws DatabaseExecutionException;
	public int[] executeBatch(String call, Object[][] parameters) throws DatabaseExecutionException;
	public int[] executeBatch(String call, CallableParameters[] parametersArray) throws DatabaseExecutionException;
}
