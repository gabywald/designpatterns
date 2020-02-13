package gabywald.revisions.designpatterns.gof.creation.samples.factory;

/**
 * Classe usine qui représente un bâtiment capable de construire des unités.
 * @author gchandesris
 */
public class UsineV1 {
	/** Attribut contenant la fabrique simple. */
	private SimpleFabrique simpleFabrique;

	/** Le constructeur permet de sélectionner la fabrique à utiliser. */
	public UsineV1() {
		this.simpleFabrique = new SimpleFabrique();
	}

	/** Méthode qui permet de construire l'ensemble des unités. */
	public Unite formerUnite(TypeUnite type) {
		Unite unite = this.simpleFabrique.creerUnite(type);
		unite.consommerRessource();
		unite.equiper();
		return unite;
	}


	public static void main(String[] args) {
		UsineV1 usine = new UsineV1();
		Unite unite = usine.formerUnite(TypeUnite.SOLDAT);
		System.out.println(unite);
	}
}
