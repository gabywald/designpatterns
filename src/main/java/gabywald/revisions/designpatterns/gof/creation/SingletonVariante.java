package gabywald.revisions.designpatterns.gof.creation;

public class SingletonVariante {
	private static final SingletonVariante INSTANCE = new SingletonVariante();
	
	private SingletonVariante() { ; }
	
	public synchronized static SingletonVariante getInstance() {
		return SingletonVariante.INSTANCE;
	}
}
