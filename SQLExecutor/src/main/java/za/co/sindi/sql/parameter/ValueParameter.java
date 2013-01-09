/**
 * 
 */
package za.co.sindi.sql.parameter;

import java.sql.CallableStatement;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.logging.Level;
import java.util.logging.Logger;

import za.co.sindi.sql.Parameter;

/**
 * @author Bienfait Sindi
 * @since 05 January 2013
 *
 */
public abstract class ValueParameter<V> implements Parameter {

	protected final Logger logger = Logger.getLogger(this.getClass().getName());
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
		int sqlType = Types.OTHER;
		if (!(ps instanceof CallableStatement)) {
			ParameterMetaData pmd = ps.getParameterMetaData();
			sqlType = pmd.getParameterType(parameterIndex);
		} else {
			if (logger.isLoggable(Level.INFO)) {
				logger.info("Received a CallableStatement and cannot retrieve a parameter type through ParameterMetaData. Setting sqlType to Types.OTHER.");
			}
		}
		
		if (value == null) {
			if (logger.isLoggable(Level.INFO)) {
				logger.info("Setting parameter index " + parameterIndex + " to null (SQL Type: " + sqlType + ").");
			}
			ps.setNull(parameterIndex, sqlType);
		} else {
			if (logger.isLoggable(Level.INFO)) {
				logger.info("Setting parameter index " + parameterIndex + " to " + value.toString() + " (SQL Type: " + sqlType + ", value type: " + value.getClass().getName() + ").");
			}
			setInternally(parameterIndex, ps);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameter#set(java.lang.String, java.sql.CallableStatement)
	 */
	public void set(String parameterName, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		if (value == null) {
			if (logger.isLoggable(Level.INFO)) {
				logger.info("Setting parameter name '" + parameterName + "' to null.");
			}
			statement.setNull(parameterName, Types.OTHER);
		} else {
			if (logger.isLoggable(Level.INFO)) {
				logger.info("Setting parameter name '" + parameterName + "' to " + value.toString() + " (Value type: " + value.getClass().getName() + ").");
			}
			setInternally(parameterName, statement);
		}
	}
	
	protected abstract void setInternally(int parameterIndex, PreparedStatement ps) throws SQLException;
	protected abstract void setInternally(String parameterName, CallableStatement statement) throws SQLException;
}
