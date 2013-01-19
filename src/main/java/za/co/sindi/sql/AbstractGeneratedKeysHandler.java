/**
 * 
 */
package za.co.sindi.sql;


/**
 * @author Bienfait Sindi
 * @since 07 January 2013
 *
 */
public abstract class AbstractGeneratedKeysHandler<K> implements GeneratedKeysHandler<K> {

	private int[] columnIndexes;
	private String[] columnNames;
	
	/**
	 * 
	 */
	protected AbstractGeneratedKeysHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param columnIndexes
	 */
	protected AbstractGeneratedKeysHandler(int[] columnIndexes) {
		super();
		this.columnIndexes = columnIndexes;
	}

	/**
	 * @param columnNames
	 */
	protected AbstractGeneratedKeysHandler(String[] columnNames) {
		super();
		this.columnNames = columnNames;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.GeneratedKeysHandler#getColumnIndexes()
	 */
	public int[] getColumnIndexes() {
		// TODO Auto-generated method stub
		return columnIndexes;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.sql.GeneratedKeysHandler#getColumnNames()
	 */
	public String[] getColumnNames() {
		// TODO Auto-generated method stub
		return columnNames;
	}
}
