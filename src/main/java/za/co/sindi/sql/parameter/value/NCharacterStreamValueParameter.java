/**
 * 
 */
package za.co.sindi.sql.parameter.value;

import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import za.co.sindi.sql.parameter.ValueParameter;

/**
 * @author Bienfait Sindi
 * @since 06 January 2013
 *
 */
public class NCharacterStreamValueParameter extends ValueParameter<Reader> {

	private long length;
	
	/**
	 * @param value
	 */
	public NCharacterStreamValueParameter(Reader value) {
		this(value, 0);
		// TODO Auto-generated constructor stub
	}
		
	/**
	 * @param value
	 * @param length
	 */
	public NCharacterStreamValueParameter(Reader value, long length) {
		super(value);
		this.length = length;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.parameter.ValueParameter#setInternally(int, java.sql.PreparedStatement)
	 */
	@Override
	protected void setInternally(int parameterIndex, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		if (length > 0) {
			ps.setNCharacterStream(parameterIndex, value, length);
		} else {
			ps.setNCharacterStream(parameterIndex, value);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.parameter.ValueParameter#setInternally(java.lang.String, java.sql.CallableStatement)
	 */
	@Override
	protected void setInternally(String parameterName, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		if (length > 0) {
			statement.setNCharacterStream(parameterName, value, length);
		} else {
			statement.setNCharacterStream(parameterName, value);
		}
	}
}
