/**
 * 
 */
package za.co.sindi.sql.parameter.out;

import java.sql.CallableStatement;
import java.sql.SQLException;

import za.co.sindi.sql.parameter.OutParameter;

/**
 * @author Bienfait Sindi
 * @since 05 January 2013
 *
 */
public class ScaledOutParameter extends OutParameter {

	private int scale;
	
	/**
	 * @param sqlType
	 * @param scale
	 */
	public ScaledOutParameter(int sqlType, int scale) {
		super(sqlType);
		this.scale = scale;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.OutParameter#set(int, java.sql.CallableStatement)
	 */
	protected void set(int parameterIndex, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		statement.registerOutParameter(parameterIndex, sqlType, scale);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameter#set(java.lang.String, java.sql.CallableStatement)
	 */
	public void set(String parameterName, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		statement.registerOutParameter(parameterName, sqlType, scale);
	}
}
