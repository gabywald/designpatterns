package designpatterns.tutorialspoint.creation;

public class SingletonPatternDemo {
	public static void main(String[] args) {
		// ***** Illegal construct
		// Compile Time Error: The constructor SingleObject() is not visible
		// SingleObject object = new SingleObject();

		// Get the only object available
		SingleObject object = SingleObject.getInstance();

		// Show the message
		object.showMessage();
	}
}

class SingleObject {

	// Create an object of SingleObject
	private static SingleObject instance = new SingleObject();

	// Make the constructor private so that this class cannot be instantiated
	private SingleObject(){}

	// Get the only object available
	public static SingleObject getInstance() {
		return SingleObject.instance;
	}

	public void showMessage() {
		System.out.println("Hello World!");
	}
}
