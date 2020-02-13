package gabywald.revisions.designpatterns.gof.creation.samples.factory;

/**
 * Usine abstraite qui sert de base aux usines concrètes.
 * @author gchandesris
 */
public abstract class UsineV2 {
	/** Méthode qui permet de former les unités. */
	public Unite formerUnite(TypeUnite type) {
		Unite unite = this.creerUnite(type);
		unite.consommerRessource();
		unite.equiper();
		return unite;
	}

	/** La création d'une unité est déléguée aux sous classes. */
	public abstract Unite creerUnite(TypeUnite type);

	public static void main(String[] args) {
		UsineV2 usineExtraterrestre = new UsineExtraterrestre();
		Unite unite = usineExtraterrestre.formerUnite(TypeUnite.SOLDAT);
		System.out.println(unite);
	}
}

/** 
 * Usine humaine.
 * @author gchandesris
 */
class UsineHumain extends UsineV2 {
	/** Méthode qui permet de créer des unités humaines. */
	public Unite creerUnite(TypeUnite type) {
		Unite unite = null;;
		switch(type) {
		case SOLDAT:unite = new SoldatHumain();break;
		case COMMANDANT:unite = new CommandantHumain();break;
		}
		return unite;
	}
}

/** 
 * Usine extraterrestre.
 * @author gchandesris
 */
class UsineExtraterrestre extends UsineV2 {
	/** Méthode qui permet de créer des unités extraterrestres. */
	public Unite creerUnite(TypeUnite type) {
		Unite unite = null;;
		switch(type) {
		case SOLDAT:unite = new SoldatExtraterrestre();break;
		case COMMANDANT:unite = new CommandantExtraterrestre();break;
		}
		return unite;
	}
}