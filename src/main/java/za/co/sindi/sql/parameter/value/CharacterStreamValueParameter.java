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
public class CharacterStreamValueParameter extends ValueParameter<Reader> {

	private long length;
	
	/**
	 * @param value
	 */
	public CharacterStreamValueParameter(Reader value) {
		this(value, 0);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param value
	 * @param length
	 */
	public CharacterStreamValueParameter(Reader value, int length) {
		this(value, (long)length);
	}
	
	/**
	 * @param value
	 * @param length
	 */
	public CharacterStreamValueParameter(Reader value, long length) {
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
			if (length > Integer.MAX_VALUE) {
				ps.setCharacterStream(parameterIndex, value, length);
			} else {
				ps.setCharacterStream(parameterIndex, value, (int)length);
			}
		} else {
			ps.setCharacterStream(parameterIndex, value);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.parameter.ValueParameter#setInternally(java.lang.String, java.sql.CallableStatement)
	 */
	@Override
	protected void setInternally(String parameterName, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		if (length > 0) {
			if (length > Integer.MAX_VALUE) {
				statement.setCharacterStream(parameterName, value, length);
			} else {
				statement.setCharacterStream(parameterName, value, (int)length);
			}
		} else {
			statement.setCharacterStream(parameterName, value);
		}
	}
}
