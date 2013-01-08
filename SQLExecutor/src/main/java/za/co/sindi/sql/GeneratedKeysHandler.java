/**
 * 
 */
package za.co.sindi.sql;

/**
 * @author Bienfait Sindi
 * @since 05 January 2013
 *
 */
public interface GeneratedKeysHandler<K> extends ResultSetHandler<K> {

	public int[] getColumnIndexes();
	public String[] getColumnNames();
	
//	public <K> K getGeneratedKeys();
}
