/**
 * 
 */
package za.co.sindi.sql;

/**
 * @author Bienfait Sindi
 * @since 30 December 2012
 *
 */
public class DatabaseExecutionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7059190024029133526L;

//	/**
//	 * 
//	 */
//	public DatabaseExecutionException() {
//		// TODO Auto-generated constructor stub
//	}

	/**
	 * @param message
	 */
	public DatabaseExecutionException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public DatabaseExecutionException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DatabaseExecutionException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
