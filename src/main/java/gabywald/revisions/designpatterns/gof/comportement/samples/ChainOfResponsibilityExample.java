package gabywald.revisions.designpatterns.gof.comportement.samples;

/**
 * Classe principale de l'application.
 */
public class ChainOfResponsibilityExample {
	public static void main( String[] args ) {
		// Construire la chaîne de responsabilité
		// StdoutLogger -> EmailLogger -> StderrLogger
		Logger l, l1;
		l1 = l = new StdoutLogger( Logger.DEBUG );
		l1 = l1.setNext(new EmailLogger( Logger.NOTICE ));
		l1 = l1.setNext(new StderrLogger( Logger.ERR ));
		// Traité par StdoutLogger
		l.message( "Entering function y.", Logger.DEBUG );
		// Traité par StdoutLogger et EmailLogger
		l.message( "Step1 completed.", Logger.NOTICE );
		// Traité par les trois loggers
		l.message( "An error has occurred.", Logger.ERR );
	}
}
