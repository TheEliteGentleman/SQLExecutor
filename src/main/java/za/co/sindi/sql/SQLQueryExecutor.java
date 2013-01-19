/**
 * 
 */
package za.co.sindi.sql;

/**
 * @author Bienfait Sindi
 * @since 30 December 2012
 *
 */
public interface SQLQueryExecutor extends SQLExecutor {

	public <T> T executeQuery(String query, ResultSetHandler<T> handler) throws DatabaseExecutionException;
	public <T> T executeQuery(String query, Object[] parameters, ResultSetHandler<T> handler) throws DatabaseExecutionException;
	public <T> T executeQuery(String query, PreparedParameters parameters, ResultSetHandler<T> handler) throws DatabaseExecutionException;
	public <T> T executeQuery(String query, ResultSetInfo info, ResultSetHandler<T> handler) throws DatabaseExecutionException;
	public <T> T executeQuery(String query, Object[] parameters, ResultSetInfo info, ResultSetHandler<T> handler) throws DatabaseExecutionException;
	public <T> T executeQuery(String query, PreparedParameters parameters, ResultSetInfo info, ResultSetHandler<T> handler) throws DatabaseExecutionException;
	public int executeUpdate(String query) throws DatabaseExecutionException;
	public int executeUpdate(String query, Object... parameters) throws DatabaseExecutionException;
	public int executeUpdate(String query, PreparedParameters parameters) throws DatabaseExecutionException;
	public <K> K executeUpdate(String query, Object[] parameters, GeneratedKeysHandler<K> handler) throws DatabaseExecutionException;
	public <K> K executeUpdate(String query, PreparedParameters parameters, GeneratedKeysHandler<K> handler) throws DatabaseExecutionException;
//	public int executeUpdate(String query, Object[] parameters, int columnIndexes[], GeneratedKeysResultSetHandler handler) throws DatabaseExecutionException;
//	public int executeUpdate(String query, Parameters parameters, int columnIndexes[], GeneratedKeysResultSetHandler handler) throws DatabaseExecutionException;
//	public int executeUpdate(String query, Object[] parameters, String columnNames[], GeneratedKeysResultSetHandler handler) throws DatabaseExecutionException;
//	public int executeUpdate(String query, Parameters parameters, String columnNames[], GeneratedKeysResultSetHandler handler) throws DatabaseExecutionException;
	public int[] executeBatch(String query, Object[][] parameters) throws DatabaseExecutionException;
	public int[] executeBatch(String query, PreparedParameters[] parametersArray) throws DatabaseExecutionException;
}
