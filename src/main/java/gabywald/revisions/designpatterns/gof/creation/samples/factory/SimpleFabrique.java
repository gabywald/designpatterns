package gabywald.revisions.designpatterns.gof.creation.samples.factory;

/**
 * Classe permettant de fabriquer une unité.
 * @author gchandesris
 */
public class SimpleFabrique {
	/**
	 * La création d'une unité en fonction de son type est encapsulée dans la fabrique.
	 * @param type
	 * @return
	 */
	public Unite creerUnite(TypeUnite type) {
		Unite unite = null;;
		switch(type)
		{
		case SOLDAT:unite = new SoldatHumain();break;
		case COMMANDANT:unite = new CommandantHumain();break;
		}
		return unite;
	}
}

/**
 * Enumération des types d'unités.
 * @author gchandesris
 */
enum TypeUnite 
{
	SOLDAT,
	COMMANDANT
}
