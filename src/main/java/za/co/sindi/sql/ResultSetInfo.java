/**
 * 
 */
package za.co.sindi.sql;

/**
 * @author Bienfait Sindi
 * @since 07 January 2013
 *
 */
public class ResultSetInfo {

	private int resultSetType;
	private int resultSetConcurrency; 
    private int resultSetHoldability;
    
	/**
	 * @param resultSetType
	 * @param resultSetConcurrency
	 */
	public ResultSetInfo(int resultSetType, int resultSetConcurrency) {
		super();
		this.resultSetType = resultSetType;
		this.resultSetConcurrency = resultSetConcurrency;
	}

	/**
	 * @param resultSetType
	 * @param resultSetConcurrency
	 * @param resultSetHoldability
	 */
	public ResultSetInfo(int resultSetType, int resultSetConcurrency, int resultSetHoldability) {
		super();
		this.resultSetType = resultSetType;
		this.resultSetConcurrency = resultSetConcurrency;
		this.resultSetHoldability = resultSetHoldability;
	}

	/**
	 * @return the resultSetType
	 */
	public int getResultSetType() {
		return resultSetType;
	}

	/**
	 * @return the resultSetConcurrency
	 */
	public int getResultSetConcurrency() {
		return resultSetConcurrency;
	}

	/**
	 * @return the resultSetHoldability
	 */
	public int getResultSetHoldability() {
		return resultSetHoldability;
	}
}
