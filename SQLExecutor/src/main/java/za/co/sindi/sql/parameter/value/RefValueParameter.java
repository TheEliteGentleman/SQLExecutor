/**
 * 
 */
package za.co.sindi.sql.parameter.value;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.SQLException;

import za.co.sindi.sql.parameter.ValueParameter;

/**
 * @author Bienfait Sindi
 * @since 05 January 2013
 *
 */
public class RefValueParameter extends ValueParameter<Ref> {

	/**
	 * @param value
	 */
	public RefValueParameter(Ref value) {
		super(value);
		// TODO Auto-generated constructor stub
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
	 * @see za.co.sindi.sql.Parameter#set(int, java.sql.PreparedStatement)
	 */
	protected void setInternally(int parameterIndex, PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		ps.setRef(parameterIndex, value);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameter#set(java.lang.String, java.sql.CallableStatement)
	 */
	protected void setInternally(String parameterName, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Method CallableStatement.setRef(String, Ref) doesn't exist.");
	}
}
