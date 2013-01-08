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
public class NullValueParameter extends ValueParameter<Void> {

	private int sqlType;
	private String typeName;
	
	/**
	 * 
	 */
	public NullValueParameter(int sqlType) {
		this(sqlType, null);
		// TODO Auto-generated constructor stub
		this.sqlType = sqlType;
	}

	/**
	 * @param sqlType
	 * @param typeName
	 */
	public NullValueParameter(int sqlType, String typeName) {
		super(null);
		this.sqlType = sqlType;
		this.typeName = typeName;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.parameter.ValueParameter#set(int, java.sql.PreparedStatement)
	 */
	@Override
	public final void set(int parameterIndex, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		setInternally(parameterIndex, ps);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.parameter.ValueParameter#set(java.lang.String, java.sql.CallableStatement)
	 */
	@Override
	public final void set(String parameterName, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		setInternally(parameterName, statement);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameter#set(int, java.sql.PreparedStatement)
	 */
	protected void setInternally(int parameterIndex, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		if (typeName == null || typeName.isEmpty()) {
			ps.setNull(parameterIndex, sqlType);
		} else {
			ps.setNull(parameterIndex, parameterIndex, typeName);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameter#set(java.lang.String, java.sql.CallableStatement)
	 */
	protected void setInternally(String parameterName, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		if (typeName == null || typeName.isEmpty()) {
			statement.setNull(parameterName, sqlType);
		} else {
			statement.setNull(parameterName, sqlType, typeName);
		}
	}
}
