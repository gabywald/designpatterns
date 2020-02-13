package gabywald.revisions.designpatterns.gof.creation.samples.factory;

import java.util.ArrayList;

/**
 * Classe abstraite dont toutes les unités du jeu hériteront.
 * @author gchandesris
 */
public abstract class Unite {
	/** Nom de l'unité. */
	protected String nom;
	/** Coût de construction de l'unité. */
	protected int coutConstruction;
	/** Précision de l'attaque de l'unité. */
	protected int precisionAttaque;
	/** Faculté d'esquiver une attaque de l'unité. */
	protected int esquiveDefense;
	/** Tableau des équipements de l'unité. */
	protected ArrayList<String> equipements;

	/** 
	 * Méthode qui consomme les ressources pour créer une unité.
	 */
	public void consommerRessource() {
		System.out.println("Consomme " + this.coutConstruction + " ressources pour la création de l'unité.");
	}

	/**
	 * Méthode abstraite qui permet d'équiper l'unité.
	 */
	public abstract void equiper();

	/**
	 * Méthode générique pour l'affichage de l'unité.
	 */
	public String toString() {
		String str = "Nom : " + this.nom + "\n";
		str += "Coût de construction : "	+ this.coutConstruction+"\n";
		str += "Précision d'attaque : "		+ this.precisionAttaque+"\n";
		str += "Esquive en défense : "		+ this.esquiveDefense+"\n";
		str += "Equipements : ";
		for (int i = 0 ; i < this.equipements.size() ; i++) {
			str += this.equipements.get(i)+" ";
		}
		return str;
	}
}
