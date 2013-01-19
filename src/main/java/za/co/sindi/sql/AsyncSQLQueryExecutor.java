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
public interface AsyncSQLQueryExecutor extends SQLExecutor {

	public <T> Future<T> executeQuery(final String query, final ResultSetHandler<T> handler) throws DatabaseExecutionException;
	public <T> Future<T> executeQuery(final String query, final Object[] parameters, final ResultSetHandler<T> handler) throws DatabaseExecutionException;
	public <T> Future<T> executeQuery(final String query, final PreparedParameters parameter, final ResultSetHandler<T> handler) throws DatabaseExecutionException;
	public <T> Future<T> executeQuery(final String query, final ResultSetInfo info, final ResultSetHandler<T> handler) throws DatabaseExecutionException;
	public <T> Future<T> executeQuery(final String query, final Object[] parameters, final ResultSetInfo info, final ResultSetHandler<T> handler) throws DatabaseExecutionException;
	public <T> Future<T> executeQuery(final String query, final PreparedParameters parameters, final ResultSetInfo info, final ResultSetHandler<T> handler) throws DatabaseExecutionException;
	public Future<Integer> executeUpdate(final String query) throws DatabaseExecutionException;
	public Future<Integer> executeUpdate(final String query, final Object... parameters) throws DatabaseExecutionException;
	public Future<Integer> executeUpdate(final String query, final PreparedParameters parameter) throws DatabaseExecutionException;
	public <K> Future<K> executeUpdate(final String query, final Object[] parameters, final GeneratedKeysHandler<K> handler) throws DatabaseExecutionException;
	public <K> Future<K> executeUpdate(final String query, final PreparedParameters parameters, final GeneratedKeysHandler<K> handler) throws DatabaseExecutionException;
//	public Future<Integer> executeUpdate(final String query, final Object[] parameters, final int columnIndexes[], final GeneratedKeysResultSetHandler handler) throws DatabaseExecutionException;
//	public Future<Integer> executeUpdate(final String query, final Parameters parameters, final int columnIndexes[], final GeneratedKeysResultSetHandler handler) throws DatabaseExecutionException;
//	public Future<Integer> executeUpdate(final String query, final Object[] parameters, final String columnNames[], final GeneratedKeysResultSetHandler handler) throws DatabaseExecutionException;
//	public Future<Integer> executeUpdate(final String query, final Parameters parameters, final String columnNames[], final GeneratedKeysResultSetHandler handler) throws DatabaseExecutionException;
	public Future<int[]> executeBatch(final String query, final Object[][] parameters) throws DatabaseExecutionException;
	public Future<int[]> executeBatch(final String query, final PreparedParameters[] parameters) throws DatabaseExecutionException;
}
