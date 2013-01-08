/**
 * 
 */
package za.co.sindi.sql;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.NClob;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.util.Calendar;

/**
 * @author Bienfait Sindi
 * @since 27 December 2012
 *
 */
public interface CallableParameters extends PreparedParameters, Clearable {

	public void registerOutParameter(int parameterIndex, int sqlType);
	public void registerOutParameter(int parameterIndex, int sqlType, int scale);
	public void registerOutParameter(int parameterIndex, int sqlType, String typeName);
	public void registerOutParameter(String parameterName, int sqlType);
	public void registerOutParameter(String parameterName, int sqlType, int scale);
	public void registerOutParameter (String parameterName, int sqlType, String typeName);
	
	public void setNull(String parameterName, int sqlType);
	public void setBoolean(String parameterName, boolean x);
	public void setByte(String parameterName, byte x);
	public void setShort(String parameterName, short x);
	public void setInt(String parameterName, int x);
	public void setLong(String parameterName, long x);
	public void setFloat(String parameterName, float x);
	public void setDouble(String parameterName, double x);
	public void setBigDecimal(String parameterName, BigDecimal x);
	public void setString(String parameterName, String x);
	public void setBytes(String parameterName, byte x[]);
	public void setDate(String parameterName, java.sql.Date x);
	public void setTime(String parameterName, java.sql.Time x);
	public void setTimestamp(String parameterName, java.sql.Timestamp x);
	public void setAsciiStream(String parameterName, java.io.InputStream x, int length);
	public void setBinaryStream(String parameterName, java.io.InputStream x, int length);
	public void setObject(String parameterName, Object x, int targetSqlType);
	public void setObject(String parameterName, Object x);
	public void setCharacterStream(String parameterName, java.io.Reader reader, int length);
	public void setBlob(String parameterName, Blob x);
	public void setClob(String parameterName, Clob x);
	public void setDate(String parameterName, java.sql.Date x, Calendar cal);
	public void setTime(String parameterName, java.sql.Time x, Calendar cal);
	public void setTimestamp(String parameterName, java.sql.Timestamp x, Calendar cal);
	public void setNull(String parameterName, int sqlType, String typeName);

	//------------------------- JDBC 3.0 -----------------------------------
	public void setURL(String parameterName, java.net.URL x);
	
	//------------------------- JDBC 4.0 -----------------------------------
	public void setRowId(String parameterName, RowId x);
	public void setNString(String parameterName, String value);
	public void setNCharacterStream(String parameterName, Reader value, long length);
	public void setNClob(String parameterName, NClob value);
	public void setClob(String parameterName, Reader reader, long length);
	public void setBlob(String parameterName, InputStream inputStream, long length);
	public void setNClob(String parameterName, Reader reader, long length);
	public void setSQLXML(String parameterName, SQLXML xmlObject);
	public void setObject(String parameterName, Object x, int targetSqlType, int scaleOrLength);
	public void setAsciiStream(String parameterName, java.io.InputStream x, long length);
	public void setBinaryStream(String parameterName, java.io.InputStream x, long length);
	public void setCharacterStream(String parameterName, java.io.Reader reader, long length);
    //-----
	public void setAsciiStream(String parameterName, java.io.InputStream x);
	public void setBinaryStream(String parameterName, java.io.InputStream x);
	public void setCharacterStream(String parameterName, java.io.Reader reader);
	public void setNCharacterStream(String parameterName, Reader value);
	public void setClob(String parameterName, Reader reader);
	public void setBlob(String parameterName, InputStream inputStream);
	public void setNClob(String parameterName, Reader reader);
	
	public void visitParameters(CallableStatement statement) throws SQLException;
	public void visitOUTParameters(CallableStatement statement) throws SQLException;
}
