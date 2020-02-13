package designpatterns.tutorialspoint.behavior;

public class StatePatternDemo {
	public static void main(String[] args) {
		ContextState context = new ContextState();

		StartState startState = new StartState();
		startState.doAction(context);

		System.out.println(context.getState().toString());

		StopState stopState = new StopState();
		stopState.doAction(context);

		System.out.println(context.getState().toString());
	}
}

interface State {
	public void doAction(ContextState context);
}

class StartState implements State {

	public void doAction(ContextState context) {
		System.out.println("Player is in start state");
		context.setState(this);	
	}

	public String toString() {
		return "Start State";
	}
}

class StopState implements State {

	public void doAction(ContextState context) {
		System.out.println("Player is in stop state");
		context.setState(this);	
	}

	public String toString() {
		return "Stop State";
	}
}

class ContextState {
	private State state;

	public ContextState() {
		this.state = null;
	}

	public void setState(State state) {
		this.state = state;		
	}

	public State getState() {
		return this.state;
	}
}
