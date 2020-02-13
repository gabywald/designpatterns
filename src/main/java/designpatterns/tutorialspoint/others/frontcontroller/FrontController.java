package designpatterns.tutorialspoint.others.frontcontroller;

public class FrontController {

	private Dispatcher dispatcher;

	public FrontController() {
		this.dispatcher = new Dispatcher();
	}

	private boolean isAuthenticUser() {
		System.out.println("User is authenticated successfully.");
		return true;
	}

	private void trackRequest(String request) {
		System.out.println("Page requested: {" + request + "}");
	}

	public void dispatchRequest(String request) {
		// Log each request
		this.trackRequest(request);

		// Authenticate the user
		if (this.isAuthenticUser()) {
			this.dispatcher.dispatch(request);
		}	
	}
}