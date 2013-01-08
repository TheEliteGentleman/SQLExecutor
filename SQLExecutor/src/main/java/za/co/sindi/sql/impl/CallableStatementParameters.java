/**
 * 
 */
package za.co.sindi.sql.impl;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import za.co.sindi.sql.NamedParameters;
import za.co.sindi.sql.parameter.ValueParameter;
import za.co.sindi.sql.parameter.value.AsciiStreamValueParameter;
import za.co.sindi.sql.parameter.value.BigDecimalValueParameter;
import za.co.sindi.sql.parameter.value.BinaryStreamValueParameter;
import za.co.sindi.sql.parameter.value.BlobValueParameter;
import za.co.sindi.sql.parameter.value.BooleanValueParameter;
import za.co.sindi.sql.parameter.value.ByteValueParameter;
import za.co.sindi.sql.parameter.value.BytesValueParameter;
import za.co.sindi.sql.parameter.value.CharacterStreamValueParameter;
import za.co.sindi.sql.parameter.value.ClobValueParameter;
import za.co.sindi.sql.parameter.value.DateValueParameter;
import za.co.sindi.sql.parameter.value.DoubleValueParameter;
import za.co.sindi.sql.parameter.value.FloatValueParameter;
import za.co.sindi.sql.parameter.value.IntegerValueParameter;
import za.co.sindi.sql.parameter.value.LongValueParameter;
import za.co.sindi.sql.parameter.value.NCharacterStreamValueParameter;
import za.co.sindi.sql.parameter.value.NClobValueParameter;
import za.co.sindi.sql.parameter.value.NStringValueParameter;
import za.co.sindi.sql.parameter.value.NullValueParameter;
import za.co.sindi.sql.parameter.value.ObjectValueParameter;
import za.co.sindi.sql.parameter.value.RowIdValueParameter;
import za.co.sindi.sql.parameter.value.SQLXMLValueParameter;
import za.co.sindi.sql.parameter.value.ShortValueParameter;
import za.co.sindi.sql.parameter.value.StringValueParameter;
import za.co.sindi.sql.parameter.value.TimeValueParameter;
import za.co.sindi.sql.parameter.value.TimestampValueParameter;
import za.co.sindi.sql.parameter.value.URLValueParameter;

/**
 * @author Bienfait Sindi
 * @since 06 January 2013
 *
 */
public class CallableStatementParameters extends PreparedStatementParameters implements NamedParameters {

	private Map<String, ValueParameter<?>> namedValueParameters = Collections.synchronizedMap(new HashMap<String, ValueParameter<?>>());
	
	/* (non-Javadoc)
	 * @see za.co.sindi.sql.impl.BasicParameters#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		super.clear();
		namedValueParameters.clear();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setNull(java.lang.String, int)
	 */
	public void setNull(String parameterName, int sqlType)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new NullValueParameter(sqlType));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setBoolean(java.lang.String, boolean)
	 */
	public void setBoolean(String parameterName, boolean x)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new BooleanValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setByte(java.lang.String, byte)
	 */
	public void setByte(String parameterName, byte x)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new ByteValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setShort(java.lang.String, short)
	 */
	public void setShort(String parameterName, short x)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new ShortValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setInt(java.lang.String, int)
	 */
	public void setInt(String parameterName, int x)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new IntegerValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setLong(java.lang.String, long)
	 */
	public void setLong(String parameterName, long x)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new LongValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setFloat(java.lang.String, float)
	 */
	public void setFloat(String parameterName, float x)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new FloatValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setDouble(java.lang.String, double)
	 */
	public void setDouble(String parameterName, double x)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new DoubleValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setBigDecimal(java.lang.String, java.math.BigDecimal)
	 */
	public void setBigDecimal(String parameterName, BigDecimal x) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new BigDecimalValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setString(java.lang.String, java.lang.String)
	 */
	public void setString(String parameterName, String x)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new StringValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setBytes(java.lang.String, byte[])
	 */
	public void setBytes(String parameterName, byte[] x)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new BytesValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setDate(java.lang.String, java.sql.Date)
	 */
	public void setDate(String parameterName, Date x)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new DateValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setTime(java.lang.String, java.sql.Time)
	 */
	public void setTime(String parameterName, Time x)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new TimeValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setTimestamp(java.lang.String, java.sql.Timestamp)
	 */
	public void setTimestamp(String parameterName, Timestamp x) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new TimestampValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setAsciiStream(java.lang.String, java.io.InputStream, int)
	 */
	public void setAsciiStream(String parameterName, InputStream x, int length) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new AsciiStreamValueParameter(x, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setBinaryStream(java.lang.String, java.io.InputStream, int)
	 */
	public void setBinaryStream(String parameterName, InputStream x, int length) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new BinaryStreamValueParameter(x, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setObject(java.lang.String, java.lang.Object, int)
	 */
	public void setObject(String parameterName, Object x, int targetSqlType) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new ObjectValueParameter(x, targetSqlType));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setObject(java.lang.String, java.lang.Object)
	 */
	public void setObject(String parameterName, Object x)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new ObjectValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setCharacterStream(java.lang.String, java.io.Reader, int)
	 */
	public void setCharacterStream(String parameterName, Reader reader, int length)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new CharacterStreamValueParameter(reader, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setBlob(java.lang.String, java.sql.Blob)
	 */
	public void setBlob(String parameterName, Blob x)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new BlobValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setClob(java.lang.String, java.sql.Clob)
	 */
	public void setClob(String parameterName, Clob x)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new ClobValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setDate(java.lang.String, java.sql.Date, java.util.Calendar)
	 */
	public void setDate(String parameterName, Date x, Calendar cal) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new DateValueParameter(x, cal));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setTime(java.lang.String, java.sql.Time, java.util.Calendar)
	 */
	public void setTime(String parameterName, Time x, Calendar cal) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new TimeValueParameter(x, cal));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setTimestamp(java.lang.String, java.sql.Timestamp, java.util.Calendar)
	 */
	public void setTimestamp(String parameterName, Timestamp x, Calendar cal) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new TimestampValueParameter(x, cal));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setNull(java.lang.String, int, java.lang.String)
	 */
	public void setNull(String parameterName, int sqlType, String typeName) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new NullValueParameter(sqlType, typeName));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setURL(java.lang.String, java.net.URL)
	 */
	public void setURL(String parameterName, URL x)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new URLValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setRowId(java.lang.String, java.sql.RowId)
	 */
	public void setRowId(String parameterName, RowId x)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new RowIdValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setNString(java.lang.String, java.lang.String)
	 */
	public void setNString(String parameterName, String value) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new NStringValueParameter(value));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setNCharacterStream(java.lang.String, java.io.Reader, long)
	 */
	public void setNCharacterStream(String parameterName, Reader value, long length)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new NCharacterStreamValueParameter(value, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setNClob(java.lang.String, java.sql.NClob)
	 */
	public void setNClob(String parameterName, NClob value)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new NClobValueParameter(value));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setClob(java.lang.String, java.io.Reader, long)
	 */
	public void setClob(String parameterName, Reader reader, long length) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new ClobValueParameter(reader, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setBlob(java.lang.String, java.io.InputStream, long)
	 */
	public void setBlob(String parameterName, InputStream inputStream, long length)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new BlobValueParameter(inputStream, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setNClob(java.lang.String, java.io.Reader, long)
	 */
	public void setNClob(String parameterName, Reader reader, long length) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new NClobValueParameter(reader, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setSQLXML(java.lang.String, java.sql.SQLXML)
	 */
	public void setSQLXML(String parameterName, SQLXML xmlObject) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new SQLXMLValueParameter(xmlObject));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setObject(java.lang.String, java.lang.Object, int, int)
	 */
	public void setObject(String parameterName, Object x, int targetSqlType, int scaleOrLength)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new ObjectValueParameter(x, targetSqlType, scaleOrLength));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setAsciiStream(java.lang.String, java.io.InputStream, long)
	 */
	public void setAsciiStream(String parameterName, InputStream x, long length) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new AsciiStreamValueParameter(x, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setBinaryStream(java.lang.String, java.io.InputStream, long)
	 */
	public void setBinaryStream(String parameterName, InputStream x, long length) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new BinaryStreamValueParameter(x, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setCharacterStream(java.lang.String, java.io.Reader, long)
	 */
	public void setCharacterStream(String parameterName, Reader reader, long length)  {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new CharacterStreamValueParameter(reader, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setAsciiStream(java.lang.String, java.io.InputStream)
	 */
	public void setAsciiStream(String parameterName, InputStream x) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new AsciiStreamValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setBinaryStream(java.lang.String, java.io.InputStream)
	 */
	public void setBinaryStream(String parameterName, InputStream x) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new BinaryStreamValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setCharacterStream(java.lang.String, java.io.Reader)
	 */
	public void setCharacterStream(String parameterName, Reader reader) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new CharacterStreamValueParameter(reader));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setNCharacterStream(java.lang.String, java.io.Reader)
	 */
	public void setNCharacterStream(String parameterName, Reader value) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new NCharacterStreamValueParameter(value));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setClob(java.lang.String, java.io.Reader)
	 */
	public void setClob(String parameterName, Reader reader) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new ClobValueParameter(reader));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setBlob(java.lang.String, java.io.InputStream)
	 */
	public void setBlob(String parameterName, InputStream inputStream) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new BlobValueParameter(inputStream));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#setNClob(java.lang.String, java.io.Reader)
	 */
	public void setNClob(String parameterName, Reader reader) {
		// TODO Auto-generated method stub
		namedValueParameters.put(parameterName, new NClobValueParameter(reader));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.NamedParameters#visit(java.sql.CallableStatement)
	 */
	public void visit(CallableStatement statement) throws SQLException  {
		// TODO Auto-generated method stub
		super.visit(statement);
		if (statement != null) {
			for (Entry<String, ValueParameter<?>> entry : namedValueParameters.entrySet()) {
				entry.getValue().set(entry.getKey(), statement);
			}
		}
	}
}
