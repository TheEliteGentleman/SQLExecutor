/**
 * 
 */
package za.co.sindi.sql.parameter;

import java.sql.CallableStatement;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import za.co.sindi.sql.Parameter;

/**
 * @author Bienfait Sindi
 * @since 05 January 2013
 *
 */
public abstract class ValueParameter<V> implements Parameter {

	protected V value;
	
	protected ValueParameter(V value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameter#set(int, java.sql.PreparedStatement)
	 */
	public void set(int parameterIndex, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		if (value == null) {
			ParameterMetaData pmd = ps.getParameterMetaData();
			int sqlType = pmd.getParameterType(parameterIndex);
			ps.setNull(parameterIndex, sqlType);
		} else {
			setInternally(parameterIndex, ps);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameter#set(java.lang.String, java.sql.CallableStatement)
	 */
	public void set(String parameterName, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		if (value == null) {
			statement.setNull(parameterName, Types.OTHER);
		} else {
			setInternally(parameterName, statement);
		}
	}
	
	protected abstract void setInternally(int parameterIndex, PreparedStatement ps) throws SQLException;
	protected abstract void setInternally(String parameterName, CallableStatement statement) throws SQLException;
}
