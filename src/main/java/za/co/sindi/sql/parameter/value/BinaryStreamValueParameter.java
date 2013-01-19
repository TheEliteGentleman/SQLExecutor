/**
 * 
 */
package za.co.sindi.sql.parameter.value;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import za.co.sindi.sql.parameter.ValueParameter;

/**
 * @author Bienfait Sindi
 * @since 06 January 2013
 *
 */
public class BinaryStreamValueParameter extends ValueParameter<InputStream> {

	private long length;
	
	/**
	 * @param value
	 */
	public BinaryStreamValueParameter(InputStream value) {
		this(value, 0);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param value
	 * @param length
	 */
	public BinaryStreamValueParameter(InputStream value, int length) {
		this(value, (long)length);
	}

	/**
	 * @param value
	 * @param length
	 */
	public BinaryStreamValueParameter(InputStream value, long length) {
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
				ps.setBinaryStream(parameterIndex, value, length);
			} else {
				ps.setBinaryStream(parameterIndex, value, (int)length);
			}
		} else {
			ps.setBinaryStream(parameterIndex, value);
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
				statement.setBinaryStream(parameterName, value, length);
			} else {
				statement.setBinaryStream(parameterName, value, (int)length);
			}
		} else {
			statement.setBinaryStream(parameterName, value);
		}
	}
}
