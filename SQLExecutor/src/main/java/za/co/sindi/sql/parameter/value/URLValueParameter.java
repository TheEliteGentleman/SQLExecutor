/**
 * 
 */
package za.co.sindi.sql.parameter.value;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import za.co.sindi.sql.parameter.ValueParameter;

/**
 * @author Bienfait Sindi
 * @since 05 January 2013
 *
 */
public class URLValueParameter extends ValueParameter<URL> {

	/**
	 * @param value
	 */
	public URLValueParameter(URL value) {
		super(value);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameter#set(int, java.sql.PreparedStatement)
	 */
	protected void setInternally(int parameterIndex, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		ps.setURL(parameterIndex, value);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameter#set(java.lang.String, java.sql.CallableStatement)
	 */
	protected void setInternally(String parameterName, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		statement.setURL(parameterName, value);
	}
}
