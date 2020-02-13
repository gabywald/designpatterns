package designpatterns.tutorialspoint.behavior.template;

public abstract class Game {
	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();

	// Template method
	public final void play() {
		// Initialize the game
		this.initialize();
		// Start game
		this.startPlay();
		// End game
		this.endPlay();
	}
}
