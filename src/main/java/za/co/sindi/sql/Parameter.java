/**
 * 
 */
package za.co.sindi.sql;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Bienfait Sindi
 * @since 05 January 2013
 *
 */
public interface Parameter {

	public void set(int parameterIndex, PreparedStatement ps) throws SQLException;
	public void set(String parameterName, CallableStatement statement) throws SQLException;
}
