/**
 * 
 */
package za.co.sindi.sql.parameter;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import za.co.sindi.sql.Parameter;

/**
 * @author Bienfait Sindi
 * @since 05 January 2013
 *
 */
public abstract class OutParameter implements Parameter {

	protected int sqlType;

	/**
	 * @param sqlType
	 */
	protected OutParameter(int sqlType) {
		super();
		this.sqlType = sqlType;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameter#set(int, java.sql.PreparedStatement)
	 */
	public final void set(int parameterIndex, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		if (ps != null && ps instanceof CallableStatement) {
			set(parameterIndex, (CallableStatement)ps);
		}
	}
	
	protected abstract void set(int parameterIndex, CallableStatement statement) throws SQLException;
}
