/**
 * 
 */
package za.co.sindi.sql;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.util.Calendar;

/**
 * @author Bienfait Sindi
 * @since 27 December 2012
 *
 */
public interface Parameters extends Clearable {

	public void setNull(int parameterIndex, int sqlType);
	public void setBoolean(int parameterIndex, boolean x);
	public void setByte(int parameterIndex, byte x);
	public void setShort(int parameterIndex, short x);
	public void setInt(int parameterIndex, int x);
	public void setLong(int parameterIndex, long x);
	public void setFloat(int parameterIndex, float x);
	public void setDouble(int parameterIndex, double x);
	public void setBigDecimal(int parameterIndex, BigDecimal x);
	public void setString(int parameterIndex, String x);
	public void setBytes(int parameterIndex, byte x[]);
	public void setDate(int parameterIndex, java.sql.Date x);
	public void setTime(int parameterIndex, java.sql.Time x);
	public void setTimestamp(int parameterIndex, java.sql.Timestamp x);
	public void setAsciiStream(int parameterIndex, java.io.InputStream x, int length);
	public void setBinaryStream(int parameterIndex, java.io.InputStream x, int length);
	public void setObject(int parameterIndex, Object x, int targetSqlType);
	public void setObject(int parameterIndex, Object x);
	public void setCharacterStream(int parameterIndex, java.io.Reader reader, int length);
	public void setRef(int parameterIndex, Ref x);
	public void setBlob(int parameterIndex, Blob x);
	public void setClob(int parameterIndex, Clob x);
	public void setArray(int parameterIndex, Array x);
	public void setDate(int parameterIndex, java.sql.Date x, Calendar cal);
	public void setTime(int parameterIndex, java.sql.Time x, Calendar cal);
	public void setTimestamp(int parameterIndex, java.sql.Timestamp x, Calendar cal);
	public void setNull(int parameterIndex, int sqlType, String typeName);

	//------------------------- JDBC 3.0 -----------------------------------
	public void setURL(int parameterIndex, java.net.URL x);
	
	//------------------------- JDBC 4.0 -----------------------------------
	public void setRowId(int parameterIndex, RowId x);
	public void setNString(int parameterIndex, String value);
	public void setNCharacterStream(int parameterIndex, Reader value, long length);
	public void setNClob(int parameterIndex, NClob value);
	public void setClob(int parameterIndex, Reader reader, long length);
	public void setBlob(int parameterIndex, InputStream inputStream, long length);
	public void setNClob(int parameterIndex, Reader reader, long length);
	public void setSQLXML(int parameterIndex, SQLXML xmlObject);
	public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength);
	public void setAsciiStream(int parameterIndex, java.io.InputStream x, long length);
	public void setBinaryStream(int parameterIndex, java.io.InputStream x, long length);
	public void setCharacterStream(int parameterIndex, java.io.Reader reader, long length);
    //-----
	public void setAsciiStream(int parameterIndex, java.io.InputStream x);
	public void setBinaryStream(int parameterIndex, java.io.InputStream x);
	public void setCharacterStream(int parameterIndex, java.io.Reader reader);
	public void setNCharacterStream(int parameterIndex, Reader value);
	public void setClob(int parameterIndex, Reader reader);
	public void setBlob(int parameterIndex, InputStream inputStream);
	public void setNClob(int parameterIndex, Reader reader);
	
	public void visit(PreparedStatement ps) throws SQLException;
}
