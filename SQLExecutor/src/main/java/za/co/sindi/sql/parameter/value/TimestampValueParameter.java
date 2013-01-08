/**
 * 
 */
package za.co.sindi.sql.parameter.value;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

import za.co.sindi.sql.parameter.ValueParameter;

/**
 * @author Bienfait Sindi
 * @since 05 January 2013
 *
 */
public class TimestampValueParameter extends ValueParameter<Timestamp> {

	private Calendar cal;
	
	/**
	 * @param value
	 */
	public TimestampValueParameter(Timestamp value) {
		this(value, null);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param value
	 * @param cal
	 */
	public TimestampValueParameter(Timestamp value, Calendar cal) {
		super(value);
		this.cal = cal;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameter#set(int, java.sql.PreparedStatement)
	 */
	protected void setInternally(int parameterIndex, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		if (cal == null) {
			ps.setTimestamp(parameterIndex, value);
		} else {
			ps.setTimestamp(parameterIndex, value, cal);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameter#set(java.lang.String, java.sql.CallableStatement)
	 */
	protected void setInternally(String parameterName, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		if (cal == null) {
			statement.setTimestamp(parameterName, value);
		} else {
			statement.setTimestamp(parameterName, value, cal);
		}
	}
}
