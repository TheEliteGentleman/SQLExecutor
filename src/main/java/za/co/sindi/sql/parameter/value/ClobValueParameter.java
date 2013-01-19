/**
 * 
 */
package za.co.sindi.sql.parameter.value;

import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import za.co.sindi.sql.parameter.ValueParameter;

/**
 * @author Bienfait Sindi
 * @since 06 January 2013
 *
 */
public class ClobValueParameter extends ValueParameter<Reader> {

	private Clob clob;
	private long length;
	
	/**
	 * @param value
	 * @param clob
	 */
	public ClobValueParameter(Clob clob) {
		super(null);
		this.clob = clob;
	}

	/**
	 * @param value
	 */
	public ClobValueParameter(Reader value) {
		this(value, 0);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param value
	 * @param length
	 */
	public ClobValueParameter(Reader value, long length) {
		super(value);
		this.length = length;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.parameter.ValueParameter#set(int, java.sql.PreparedStatement)
	 */
	@Override
	public void set(int parameterIndex, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		setInternally(parameterIndex, ps);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.parameter.ValueParameter#set(java.lang.String, java.sql.CallableStatement)
	 */
	@Override
	public void set(String parameterName, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		setInternally(parameterName, statement);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.parameter.ValueParameter#setInternally(int, java.sql.PreparedStatement)
	 */
	@Override
	protected void setInternally(int parameterIndex, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		if (clob == null && value == null) {
			ps.setNull(parameterIndex, Types.CLOB);
		} else {
			if (value != null) {
				if (length > 0) {
					ps.setClob(parameterIndex, value, length);
				} else {
					ps.setClob(parameterIndex, value);
				}
			} else {
				ps.setClob(parameterIndex, clob);
			}
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.parameter.ValueParameter#setInternally(java.lang.String, java.sql.CallableStatement)
	 */
	@Override
	protected void setInternally(String parameterName, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		if (clob == null && value == null) {
			statement.setNull(parameterName, Types.CLOB);
		} else {
			if (value != null) {
				if (length > 0) {
					statement.setClob(parameterName, value, length);
				} else {
					statement.setClob(parameterName, value);
				}
			} else {
				statement.setClob(parameterName, clob);
			}
		}
	}
}
