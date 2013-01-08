/**
 * 
 */
package za.co.sindi.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Bienfait Sindi
 * @since 30 December 2012
 *
 */
public interface ResultSetHandler<T> {

	public T handle(ResultSet rs) throws SQLException;
}
