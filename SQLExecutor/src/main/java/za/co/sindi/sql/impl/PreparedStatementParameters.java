/**
 * 
 */
package za.co.sindi.sql.impl;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.Ref;
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

import za.co.sindi.sql.Parameters;
import za.co.sindi.sql.parameter.ValueParameter;
import za.co.sindi.sql.parameter.value.ArrayValueParameter;
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
import za.co.sindi.sql.parameter.value.RefValueParameter;
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
public class PreparedStatementParameters implements Parameters {

	private Map<Integer, ValueParameter<?>> indexedValueParameters = Collections.synchronizedMap(new HashMap<Integer, ValueParameter<?>>());
	
	private void checkParameterIndex(int parameterIndex) {
		if (parameterIndex < 0) {
			throw new IllegalArgumentException("JDBC Parameter index must be greater than 0.");
		}
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Clearable#clear()
	 */
	public void clear() {
		// TODO Auto-generated method stub
		indexedValueParameters.clear();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setNull(int, int)
	 */
	public void setNull(int parameterIndex, int sqlType) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new NullValueParameter(sqlType));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setBoolean(int, boolean)
	 */
	public void setBoolean(int parameterIndex, boolean x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new BooleanValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setByte(int, byte)
	 */
	public void setByte(int parameterIndex, byte x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new ByteValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setShort(int, short)
	 */
	public void setShort(int parameterIndex, short x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new ShortValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setInt(int, int)
	 */
	public void setInt(int parameterIndex, int x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new IntegerValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setLong(int, long)
	 */
	public void setLong(int parameterIndex, long x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new LongValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setFloat(int, float)
	 */
	public void setFloat(int parameterIndex, float x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new FloatValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setDouble(int, double)
	 */
	public void setDouble(int parameterIndex, double x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new DoubleValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setBigDecimal(int, java.math.BigDecimal)
	 */
	public void setBigDecimal(int parameterIndex, BigDecimal x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new BigDecimalValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setString(int, java.lang.String)
	 */
	public void setString(int parameterIndex, String x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new StringValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setBytes(int, byte[])
	 */
	public void setBytes(int parameterIndex, byte[] x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new BytesValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setDate(int, java.sql.Date)
	 */
	public void setDate(int parameterIndex, Date x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new DateValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setTime(int, java.sql.Time)
	 */
	public void setTime(int parameterIndex, Time x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new TimeValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setTimestamp(int, java.sql.Timestamp)
	 */
	public void setTimestamp(int parameterIndex, Timestamp x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new TimestampValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setAsciiStream(int, java.io.InputStream, int)
	 */
	public void setAsciiStream(int parameterIndex, InputStream x, int length) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new AsciiStreamValueParameter(x, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setBinaryStream(int, java.io.InputStream, int)
	 */
	public void setBinaryStream(int parameterIndex, InputStream x, int length) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new BinaryStreamValueParameter(x, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setObject(int, java.lang.Object, int)
	 */
	public void setObject(int parameterIndex, Object x, int targetSqlType) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new ObjectValueParameter(x, targetSqlType));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setObject(int, java.lang.Object)
	 */
	public void setObject(int parameterIndex, Object x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new ObjectValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setCharacterStream(int, java.io.Reader, int)
	 */
	public void setCharacterStream(int parameterIndex, Reader reader, int length) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new CharacterStreamValueParameter(reader, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setRef(int, java.sql.Ref)
	 */
	public void setRef(int parameterIndex, Ref x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new RefValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setBlob(int, java.sql.Blob)
	 */
	public void setBlob(int parameterIndex, Blob x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new BlobValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setClob(int, java.sql.Clob)
	 */
	public void setClob(int parameterIndex, Clob x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new ClobValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setArray(int, java.sql.Array)
	 */
	public void setArray(int parameterIndex, Array x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new ArrayValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setDate(int, java.sql.Date, java.util.Calendar)
	 */
	public void setDate(int parameterIndex, Date x, Calendar cal) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new DateValueParameter(x, cal));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setTime(int, java.sql.Time, java.util.Calendar)
	 */
	public void setTime(int parameterIndex, Time x, Calendar cal) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new TimeValueParameter(x, cal));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setTimestamp(int, java.sql.Timestamp, java.util.Calendar)
	 */
	public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new TimestampValueParameter(x, cal));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setNull(int, int, java.lang.String)
	 */
	public void setNull(int parameterIndex, int sqlType, String typeName) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new NullValueParameter(sqlType, typeName));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setURL(int, java.net.URL)
	 */
	public void setURL(int parameterIndex, URL x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new URLValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setRowId(int, java.sql.RowId)
	 */
	public void setRowId(int parameterIndex, RowId x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new RowIdValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setNString(int, java.lang.String)
	 */
	public void setNString(int parameterIndex, String value) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new NStringValueParameter(value));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setNCharacterStream(int, java.io.Reader, long)
	 */
	public void setNCharacterStream(int parameterIndex, Reader value, long length) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new NCharacterStreamValueParameter(value, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setNClob(int, java.sql.NClob)
	 */
	public void setNClob(int parameterIndex, NClob value) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new NClobValueParameter(value));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setClob(int, java.io.Reader, long)
	 */
	public void setClob(int parameterIndex, Reader reader, long length) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new ClobValueParameter(reader, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setBlob(int, java.io.InputStream, long)
	 */
	public void setBlob(int parameterIndex, InputStream inputStream, long length) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new BlobValueParameter(inputStream, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setNClob(int, java.io.Reader, long)
	 */
	public void setNClob(int parameterIndex, Reader reader, long length) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new NClobValueParameter(reader, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setSQLXML(int, java.sql.SQLXML)
	 */
	public void setSQLXML(int parameterIndex, SQLXML xmlObject) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new SQLXMLValueParameter(xmlObject));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setObject(int, java.lang.Object, int, int)
	 */
	public void setObject(int parameterIndex, Object x, int targetSqlType, int scaleOrLength) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new ObjectValueParameter(x, targetSqlType, scaleOrLength));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setAsciiStream(int, java.io.InputStream, long)
	 */
	public void setAsciiStream(int parameterIndex, InputStream x, long length) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new AsciiStreamValueParameter(x, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setBinaryStream(int, java.io.InputStream, long)
	 */
	public void setBinaryStream(int parameterIndex, InputStream x, long length) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new BinaryStreamValueParameter(x, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setCharacterStream(int, java.io.Reader, long)
	 */
	public void setCharacterStream(int parameterIndex, Reader reader, long length) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new CharacterStreamValueParameter(reader, length));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setAsciiStream(int, java.io.InputStream)
	 */
	public void setAsciiStream(int parameterIndex, InputStream x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new AsciiStreamValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setBinaryStream(int, java.io.InputStream)
	 */
	public void setBinaryStream(int parameterIndex, InputStream x) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new BinaryStreamValueParameter(x));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setCharacterStream(int, java.io.Reader)
	 */
	public void setCharacterStream(int parameterIndex, Reader reader) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new CharacterStreamValueParameter(reader));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setNCharacterStream(int, java.io.Reader)
	 */
	public void setNCharacterStream(int parameterIndex, Reader value) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new NCharacterStreamValueParameter(value));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setClob(int, java.io.Reader)
	 */
	public void setClob(int parameterIndex, Reader reader) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new ClobValueParameter(reader));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setBlob(int, java.io.InputStream)
	 */
	public void setBlob(int parameterIndex, InputStream inputStream) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new BlobValueParameter(inputStream));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#setNClob(int, java.io.Reader)
	 */
	public void setNClob(int parameterIndex, Reader reader) {
		// TODO Auto-generated method stub
		checkParameterIndex(parameterIndex);
		indexedValueParameters.put(parameterIndex, new NClobValueParameter(reader));
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.Parameters#visit(java.sql.PreparedStatement)
	 */
	public void visit(PreparedStatement ps) throws SQLException {
		// TODO Auto-generated method stub
		if (ps != null) {
			for (Entry<Integer, ValueParameter<?>> entry : indexedValueParameters.entrySet()) {
				entry.getValue().set(entry.getKey(), ps);
			}
		}
	}
}
