package uchidb;


/**
 * @author aelmore
 */
public class HW0Runner {

	// NOTE: Asked Kevin Zen to help me conceptualize Singletons and explain the relationship 
	// between HW0Runner and MyContainers in terms of a factory producing singletons 
	private static MyContainers<Integer,String> instance = null;
	
	// This class is a factory for a singleton containers class.
	// reference: https://www.tutorialspoint.com/java/java_using_singleton.htm
	// reference: https://en.wikipedia.org/wiki/Factory_(object-oriented_programming)
	public static Containers<Integer, String> getContainers() {
		if (instance == null) {
			instance = new MyContainers<Integer,String>();
      	}
      	return instance;
	}

	public static void main(String[] args){
		
	}
}
