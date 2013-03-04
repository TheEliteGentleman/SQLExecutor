/**
 * 
 */
package za.co.sindi.sql;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * A {@link Map} where the key is of type {@link String} and value is parameterized.
 * The key string is case insensitive, i.e., key like "Code"/"code" are considered equal.
 * <br />A null or empty key string is not permitted, but a null value is permitted.
 * <p /><b>This map is not synchronized.</b>
 * 
 * @author Bienfait Sindi
 * @since 01 March 2013
 *
 */
public class CaseInsensitiveMap<V> implements Map<java.lang.String, V> {

	private Set<Entry<String, V>> entrySet = new LinkedHashSet<Entry<String, V>>();
	
	/* (non-Javadoc)
	 * @see java.util.Map#size()
	 */
	public int size() {
		// TODO Auto-generated method stub
		return entrySet.size();
	}

	/* (non-Javadoc)
	 * @see java.util.Map#isEmpty()
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return entrySet.isEmpty();
	}

	/* (non-Javadoc)
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		if (key != null && key instanceof String) {
			String sKey = (String) key;
			for (Entry<String, V> entry : entrySet()) {
				if (entry.getKey().equalsIgnoreCase(sKey)) {
					return true;
				}
			}
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		for (Entry<String, V> entry : entrySet()) {
			if (entry.getValue() == null) {
				if (value == null) {
					return true;
				}
			} else if (entry.getValue().equals(value)) {
				return true;
			}
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#get(java.lang.Object)
	 */
	public V get(Object key) {
		// TODO Auto-generated method stub
		V value = null;
		if (key != null && key instanceof String) {
			String sKey = (String)key;
			for (Entry<String, V> entry : entrySet()) {
				if (entry.getKey().equalsIgnoreCase(sKey)) {
					value = entry.getValue();
					break;
				}
			}
		}
		
		return value;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	public V put(String key, V value) {
		// TODO Auto-generated method stub
		if (key == null || key.isEmpty()) {
			return null;
		}
		
		for (Entry<String, V> entry : entrySet()) {
			if (entry.getKey().equalsIgnoreCase(key)) {
				return entry.setValue(value);
			}
		}
		
		entrySet.add(new CaseInsensitiveMapEntry<V>(key, value));
		return value;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	public V remove(Object key) {
		// TODO Auto-generated method stub
		V value = null;
		if (key != null && key instanceof String) {
			String sKey = (String)key;
			
			Iterator<Entry<String, V>> iterator = entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, V> entry = iterator.next();
				if (entry.getKey().equalsIgnoreCase(sKey)) {
					value = entry.getValue();
					iterator.remove();
					break;
				}
			}
		}
		
		return value;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	public void putAll(Map<? extends String, ? extends V> m) {
		// TODO Auto-generated method stub
		if (m != null && !m.isEmpty()) {
			for (Entry<? extends String, ? extends V> entry : m.entrySet()) {
				put(entry.getKey(), entry.getValue());
			}
		}
	}

	/* (non-Javadoc)
	 * @see java.util.Map#clear()
	 */
	public void clear() {
		// TODO Auto-generated method stub
		entrySet.clear();
	}

	/* (non-Javadoc)
	 * @see java.util.Map#keySet()
	 */
	public Set<String> keySet() {
		// TODO Auto-generated method stub
		Set<String> keySet = new LinkedHashSet<String>();
		if (entrySet != null && !entrySet.isEmpty()) {
			for (Entry<String, V> entry : entrySet()) {
				keySet.add(entry.getKey());
			}
		}
		
		return keySet;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#values()
	 */
	public Collection<V> values() {
		// TODO Auto-generated method stub
		Collection<V> valueList = new ArrayList<V>();
		if (entrySet != null && !entrySet.isEmpty()) {
			for (Entry<String, V> entry : entrySet()) {
				valueList.add(entry.getValue());
			}
		}
		
		return valueList;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#entrySet()
	 */
	public Set<java.util.Map.Entry<String, V>> entrySet() {
		// TODO Auto-generated method stub
		return entrySet;
	}
	
	private static final class CaseInsensitiveMapEntry<V> implements Entry<String, V> {
		
		private String key;
		private V value;
		
		/**
		 * @param key
		 */
		@SuppressWarnings("unused")
		public CaseInsensitiveMapEntry(String key) {
			this(key, null);
		}
		
		/**
		 * @param key
		 * @param value
		 */
		public CaseInsensitiveMapEntry(String key, V value) {
			super();
			this.key = key;
			setValue(value);
		}
		
		/* (non-Javadoc)
		 * @see java.util.Map.Entry#getKey()
		 */
		public String getKey() {
			// TODO Auto-generated method stub
			return key;
		}
		
		/* (non-Javadoc)
		 * @see java.util.Map.Entry#getValue()
		 */
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}
		
		/* (non-Javadoc)
		 * @see java.util.Map.Entry#setValue(java.lang.Object)
		 */
		public V setValue(V value) {
			// TODO Auto-generated method stub
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}
	}
}
