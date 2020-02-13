package gabywald.revisions.designpatterns.gof.comportement.samples;

/**
Classe de gestion de journalisation abstraite.
 */
public abstract class Logger {
	public static final int
		ERR = 0,
		NOTICE = 1,
		DEBUG = 2;
	
	protected int level;
	
	/** L'élément suivant dans la chaîne de responsabilité. */
	protected Logger next;
	
	protected Logger(int level) {
		this.level = level;
		this.next = null;
	}
	
	public Logger setNext(Logger l) {
		next = l;
		return l;
	}
	
	public void message(String msg, int priority) {
		if ( priority <= level )
			writeMessage( msg );
		if ( next != null )
			next.message( msg, priority );
	}
	protected abstract void writeMessage(String msg);
}
/**
Journalisation sur la sortie standard.
 */
class StdoutLogger extends Logger {
	
	public StdoutLogger(int level) 
		{ super(level); }
	
	protected void writeMessage(String msg) {
		System.out.println( "Writing to stdout: " + msg );
	}
}
/**
Journalisation par courriel.
 */
class EmailLogger extends Logger {
	
	public EmailLogger(int level) 
		{ super(level); }
	
	protected void writeMessage(String msg) {
		System.out.println( "Sending via email: " + msg );
	}
}
/**
Journalisation sur l'erreur standard.
 */
class StderrLogger extends Logger {
	
	public StderrLogger(int level) 
		{ super(level); }
	
	protected void writeMessage(String msg) {
		System.err.println( "Sending to stderr: " + msg );
	}
}

