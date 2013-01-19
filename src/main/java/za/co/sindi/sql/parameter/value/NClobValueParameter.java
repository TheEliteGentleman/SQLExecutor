/**
 * 
 */
package za.co.sindi.sql.parameter.value;

import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import za.co.sindi.sql.parameter.ValueParameter;

/**
 * @author Bienfait Sindi
 * @since 06 January 2013
 *
 */
public class NClobValueParameter extends ValueParameter<Reader> {

	private NClob nClob;
	private long length;
	
	/**
	 * @param value
	 * @param nclob
	 */
	public NClobValueParameter(NClob nClob) {
		super(null);
		this.nClob = nClob;
	}

	/**
	 * @param value
	 */
	public NClobValueParameter(Reader value) {
		this(value, 0);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param value
	 * @param length
	 */
	public NClobValueParameter(Reader value, long length) {
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
		if (nClob == null && value == null) {
			ps.setNull(parameterIndex, Types.NCLOB);
		} else {
			if (value != null) {
				if (length > 0) {
					ps.setNClob(parameterIndex, value, length);
				} else {
					ps.setNClob(parameterIndex, value);
				}
			} else {
				ps.setNClob(parameterIndex, nClob);
			}
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.parameter.ValueParameter#setInternally(java.lang.String, java.sql.CallableStatement)
	 */
	@Override
	protected void setInternally(String parameterName, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		if (nClob == null && value == null) {
			statement.setNull(parameterName, Types.NCLOB);
		} else {
			if (value != null) {
				if (length > 0) {
					statement.setNClob(parameterName, value, length);
				} else {
					statement.setNClob(parameterName, value);
				}
			} else {
				statement.setNClob(parameterName, nClob);
			}
		}
	}
}
