package gabywald.revisions.designpatterns.gof.creation.samples.factory;

import java.util.ArrayList;

/**
 * Classe représentant un soldat extraterrestre.
 * @author gchandesris
 */
public class SoldatExtraterrestre extends Unite 
{
	/** Constructeur pour un soldat extraterrestre. */
	public SoldatExtraterrestre() {
		this.nom = "Alien";
		this.coutConstruction = 6;
		this.precisionAttaque = 2;
		this.esquiveDefense = 1;
		this.equipements = new ArrayList<String>();
	}

	/** Equiper un soldat extraterrestre. */
	public void equiper() {
		this.equipements.add("Acide");
		this.equipements.add("Peau");
		System.out.println("Equipement d'un soldat extraterrestre (Acide, Peau).");
	}
}
