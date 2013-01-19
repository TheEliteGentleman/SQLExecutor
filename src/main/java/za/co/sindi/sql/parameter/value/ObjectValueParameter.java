/**
 * 
 */
package za.co.sindi.sql.parameter.value;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import za.co.sindi.sql.parameter.ValueParameter;

/**
 * @author Bienfait Sindi
 * @since 05 January 2013
 *
 */
public class ObjectValueParameter extends ValueParameter<Object> {

	private int targetSqlType = Integer.MIN_VALUE;
	private int scaleOrLength = Integer.MIN_VALUE;
	
	/**
	 * @param value
	 */
	public ObjectValueParameter(Object value) {
		super(value);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param value
	 * @param targetSqlType
	 */
	public ObjectValueParameter(Object value, int targetSqlType) {
		super(value);
		this.targetSqlType = targetSqlType;
	}

	/**
	 * @param value
	 * @param targetSqlType
	 * @param scaleOrLength
	 */
	public ObjectValueParameter(Object value, int targetSqlType, int scaleOrLength) {
		super(value);
		this.targetSqlType = targetSqlType;
		this.scaleOrLength = scaleOrLength;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameter#set(int, java.sql.PreparedStatement)
	 */
	protected void setInternally(int parameterIndex, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		if (targetSqlType != Integer.MIN_VALUE) {
			if (scaleOrLength != Integer.MIN_VALUE) {
				ps.setObject(parameterIndex, value, targetSqlType, scaleOrLength);
			} else {
				ps.setObject(parameterIndex, value, targetSqlType);
			}
		} else {
			ps.setObject(parameterIndex, value);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameter#set(java.lang.String, java.sql.CallableStatement)
	 */
	protected void setInternally(String parameterName, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		if (targetSqlType != Integer.MIN_VALUE) {
			if (scaleOrLength != Integer.MIN_VALUE) {
				statement.setObject(parameterName, value, targetSqlType, scaleOrLength);
			} else {
				statement.setObject(parameterName, value, targetSqlType);
			}
		} else {
			statement.setObject(parameterName, value);
		}
	}
}
