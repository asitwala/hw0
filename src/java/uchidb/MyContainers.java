/**
 * 
 */
package uchidb;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet; 
import java.util.HashMap; 

/**
 * @author aelmore
 * A simple interface to wrap some basic Java containers
 * This class uses:
 * - generics (T and S) https://en.wikipedia.org/wiki/Generics_in_Java
 * - containers (sets, lists, and maps) http://beginnersbook.com/2015/01/difference-between-list-set-and-map-in-java/
 * - overloaded functions
 */

// NOTE: Asked Kevin Zen to help me conceptualize Singletons and explain the relationship 
// between HW0Runner and MyContainers in terms of a factory producing singletons 
public class MyContainers<T,S> implements Containers<T,S> {


	// constructor for instance -- needed to implement singleton 
	public MyContainers() {}


	// initialize local, stored map to an empty map 
	// Referenced from Malika Aubakirova in order to prevent error posted on Piazza:
	// https://piazza.com/class/ixhw9gvaif150j?cid=23
	private Map<S,T> map = new HashMap<S,T>(); 


	// Create and return a set that stores the array of T objects
	// You do not need to create your own set implementation and 
 	// can use an existing set class.
	public Set<T> initSet(T[] tArray) {
		Set<T> set = new HashSet<T>(Arrays.asList(tArray));
		return set; 
	}

	
	// Create and return a list that stores the array of T objects
	// You do not need to create your own list implementation and 
	// can use an existing list class.
	public List<T> initList(T[] tArray) {
		// reference: https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html
		return Arrays.asList(tArray);
	}

	
	// Create and return an empty map that will use type S as keys, and T as values
	// You do not need to create your own map implementation and 
	// can use an existing map class.
	public Map<S,T> initEmptyMap(){
		return map;
	}

	
	// Store the map in a local field variable -- often called a setter 
	public void storeMap(Map<S,T> mapToStoreInClass) {
		// essentially like an instance variable in Python 
		this.map = mapToStoreInClass;
	}
	

	// Add a key value to the stored/local map with a boolean indicating whether to overwrite existing value
	// The return value indicates if you added the key value pair to the map
	// You do not need to check if the value changed or not (e.g. no need to compare values)
	public boolean addToMap(S key, T value, boolean overwriteExistingKey) {
		boolean added = false; 
		boolean contains_key = this.map.containsKey(key);

		// if key NOT in map OR (key in map and have to overwrite existing key)
		// ! F -> true or (false and true) -> true 
		// ! F -> true or (false and false) -> true 
		// ! T -> false or (true and true) -> true 
		// ! T -> false or (true and false) -> false 
		if (!(contains_key) || (contains_key && overwriteExistingKey)) {
			// reference: https://docs.oracle.com/javase/7/docs/api/java/util/Map.html
			// "If the map previously contained a mapping for the key,
			// the old value is replaced by the specified value
			this.map.put(key, value); 
			added = true;
		}

		return added; 
	}
	

	// Return a value from the stored/local map based on the key
	public T getValueFromMap(S key){
		return this.map.get(key);
	}
	

	// An overloaded function to get a value from the stored/local map, but with a default value
 	// if the key is not present in the map.
	public T getValueFromMap(S key, T defaultValue) {
		// first check if map contains key 
		if (this.map.containsKey(key)) {
			return this.map.get(key);
		}
		else {
			return defaultValue; 
		}
	}
}
