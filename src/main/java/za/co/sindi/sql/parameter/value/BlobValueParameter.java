/**
 * 
 */
package za.co.sindi.sql.parameter.value;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import za.co.sindi.sql.parameter.ValueParameter;

/**
 * @author Bienfait Sindi
 * @since 06 January 2013
 *
 */
public class BlobValueParameter extends ValueParameter<InputStream> {

	private Blob blob;
	private long length;
	
	/**
	 * @param value
	 * @param blob
	 */
	public BlobValueParameter(Blob blob) {
		super(null);
		this.blob = blob;
	}

	/**
	 * @param value
	 */
	public BlobValueParameter(InputStream value) {
		this(value, 0);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param value
	 * @param length
	 */
	public BlobValueParameter(InputStream value, long length) {
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
		if (blob == null && value == null) {
			ps.setNull(parameterIndex, Types.BLOB);
		} else {
			if (value != null) {
				if (length > 0) {
					ps.setBlob(parameterIndex, value, length);
				} else {
					ps.setBlob(parameterIndex, value);
				}
			} else {
				ps.setBlob(parameterIndex, blob);
			}
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.parameter.ValueParameter#setInternally(java.lang.String, java.sql.CallableStatement)
	 */
	@Override
	protected void setInternally(String parameterName, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		if (blob == null && value == null) {
			statement.setNull(parameterName, Types.BLOB);
		} else {
			if (value != null) {
				if (length > 0) {
					statement.setBlob(parameterName, value, length);
				} else {
					statement.setBlob(parameterName, value);
				}
			} else {
				statement.setBlob(parameterName, blob);
			}
		}
	}
}
