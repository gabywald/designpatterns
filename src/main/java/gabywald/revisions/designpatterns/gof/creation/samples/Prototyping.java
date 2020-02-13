package gabywald.revisions.designpatterns.gof.creation.samples;

import java.util.UUID;

public class Prototyping {

	public static void main(String[] args) { 
		Cookie			tempCookie	=  null; 
		Cookie			prot		= new CoconutCookie(); 
		CookieMachine	cm			= new CookieMachine(prot); 

		for (int i = 0 ; i < 100 ; i++) {
			tempCookie = cm.makeCookie();
			System.out.println(tempCookie);
		}
	}
	
}

/** Prototype Class */
abstract class Cookie implements Cloneable {
	private UUID uuid = UUID.randomUUID();
	
	@Override
	public Cookie clone() {
		try {
			Cookie copy = (Cookie)super.clone();
			
			// Dans une implémentation réelle de ce patron de conception, il faudrait
			// créer la copie en dupliquant les objets contenus et en attribuant des
			// valeurs valides (exemple : un nouvel identificateur unique pour la copie).
			
			copy.uuid = UUID.randomUUID();
			
			return copy;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	public String toString() {
		StringBuilder toReturn = new StringBuilder();
		
		toReturn.append("Cookie{").append(this.uuid.toString()).append("}");
		
		return toReturn.toString();
	}
}

/** Concrete Prototypes to clone */
class CoconutCookie extends Cookie {
	
	public String toString() {
		StringBuilder toReturn = new StringBuilder();
		
		toReturn.append(super.toString()).append("[coconut]");
		
		return toReturn.toString();
	}
}

/** Client Class */
class CookieMachine {
	
	/** Aurait pu être "private Cloneable cookie;" */
	private Cookie cookie;

	public CookieMachine(Cookie cookie) { 
		this.cookie = cookie; 
	}

	public Cookie makeCookie() {
		return cookie.clone(); 
	}

}

