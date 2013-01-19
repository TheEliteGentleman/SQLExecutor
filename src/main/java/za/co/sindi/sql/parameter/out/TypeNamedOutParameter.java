/**
 * 
 */
package za.co.sindi.sql.parameter.out;

import java.sql.CallableStatement;
import java.sql.SQLException;

import za.co.sindi.sql.parameter.OutParameter;

/**
 * @author Bienfait Sindi
 * @since 05 January 2013
 *
 */
public class TypeNamedOutParameter extends OutParameter {

	private String typeName;
	
	/**
	 * @param sqlType
	 * @param typeName
	 */
	public TypeNamedOutParameter(int sqlType, String typeName) {
		super(sqlType);
		this.typeName = typeName;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameter#set(java.lang.String, java.sql.CallableStatement)
	 */
	public void set(String parameterName, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		statement.registerOutParameter(parameterName, sqlType, typeName);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.parameter.OutParameter#set(int, java.sql.CallableStatement)
	 */
	@Override
	protected void set(int parameterIndex, CallableStatement statement) throws SQLException {
		// TODO Auto-generated method stub
		statement.registerOutParameter(parameterIndex, sqlType, typeName);
	}
}
