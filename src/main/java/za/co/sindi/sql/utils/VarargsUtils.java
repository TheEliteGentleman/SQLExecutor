/**
 * 
 */
package za.co.sindi.sql.utils;

/**
 * @author Bienfait Sindi
 * @since 03 January 2013
 *
 */
public class VarargsUtils {

	/**
	 * 
	 */
	private VarargsUtils() {
		// TODO Auto-generated constructor stub
	}

	@SafeVarargs
	public static <V> V[] toArray(V... values) {
		return values;
	}
}
