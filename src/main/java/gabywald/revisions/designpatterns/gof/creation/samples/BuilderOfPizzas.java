package gabywald.revisions.designpatterns.gof.creation.samples;

public class BuilderOfPizzas {

	/** NOTE : exemple pas très pertinent ?? ... */
	
	public static void main(String[] args) {
		/** Un client commandant une pizza. */
		Serveur serveur = new Serveur();
		MonteurPizza monteurPizzaHawaii		= new MonteurPizzaHawaii();
		MonteurPizza monteurPizzaPiquante	= new MonteurPizzaPiquante();

		serveur.setMonteurPizza(monteurPizzaHawaii);
		serveur.construirePizza();

		Pizza pizzas = serveur.getPizza();
	}
}

/** Produit */
class Pizza {
	private String pate			= "";
	private String sauce		= "";
	private String garniture	= "";

	public void setPate(String pate)			{ this.pate			= pate; }
	public void setSauce(String sauce)			{ this.sauce		= sauce; }
	public void setGarniture(String garniture)	{ this.garniture	= garniture; }
}


/** Monteur */
abstract class MonteurPizza {
	protected Pizza pizza;

	public Pizza getPizza()				{ return this.pizza; }
	public void creerNouvellePizza()	{ this.pizza = new Pizza(); }

	public abstract void monterPate();
	public abstract void monterSauce();
	public abstract void monterGarniture();
}

/** MonteurConcret */
class MonteurPizzaHawaii extends MonteurPizza {
	public void monterPate()		{ this.pizza.setPate("croisée"); }
	public void monterSauce()		{ this.pizza.setSauce("douce"); }
	public void monterGarniture()	{ this.pizza.setGarniture("jambon+ananas"); }
}

/** MonteurConcret */
class MonteurPizzaPiquante extends MonteurPizza {
	public void monterPate()		{ this.pizza.setPate("feuilletée"); }
	public void monterSauce()		{ this.pizza.setSauce("piquante"); }
	public void monterGarniture()	{ this.pizza.setGarniture("pepperoni+salami"); }
}

/** Directeur */
class Serveur {
	private MonteurPizza monteurPizza;

	public void setMonteurPizza(MonteurPizza mp)	{ this.monteurPizza = mp; }
	public Pizza getPizza()							{ return this.monteurPizza.getPizza(); }

	public void construirePizza() {
		this.monteurPizza.creerNouvellePizza();
		this.monteurPizza.monterPate();
		this.monteurPizza.monterSauce();
		this.monteurPizza.monterGarniture();
	}
}
