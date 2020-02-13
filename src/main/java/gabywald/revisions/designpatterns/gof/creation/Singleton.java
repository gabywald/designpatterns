package gabywald.revisions.designpatterns.gof.creation;

public class Singleton {
	private static Singleton INSTANCE = null;
	
	private Singleton() {}
	
	public synchronized static Singleton getInstance() {
		if (Singleton.INSTANCE == null) {
			Singleton.INSTANCE = new Singleton();
		}
		return Singleton.INSTANCE;
	}
}
