package gabywald.revisions.designpatterns.gof.comportement.samples;

import java.util.ArrayList;

class Originator {
	private String state;
 
	public void set(String state) { 
		System.out.println("Originator: état affecté à: " + state);
		this.state = state; 
	}
 
	public Object saveToMemento() { 
		System.out.println("Originator: sauvegarde dans le memento.");
		return new Memento(this.state); 
	}
	
	public void restoreFromMemento(Object m) {
		if (m instanceof Memento) {
			Memento memento	= (Memento)m; 
			this.state		= memento.getSavedState(); 
			System.out.println("Originator: Etat après restauration: " + this.state);
		}
	}
 
	private static class Memento {
		private String state;
 
		public Memento(String stateToSave) 
			{ this.state = stateToSave; }
		
		public String getSavedState() 
			{ return this.state; }
	}
 }
 
 class Caretaker {
	private ArrayList<Object> savedStates = new ArrayList<Object>();
 
	public void addMemento(Object m) 
		{ this.savedStates.add(m); }
	
	public Object getMemento(int index) 
		{ return this.savedStates.get(index); }
 }   
 
 public class MementoExample {
	public static void main(String[] args) {
		Caretaker caretaker = new Caretaker();
 
		Originator originator = new Originator();
		originator.set("State1");
		originator.set("State2");
		caretaker.addMemento( originator.saveToMemento() );
		originator.set("State3");
		caretaker.addMemento( originator.saveToMemento() );
		originator.set("State4");
 
		originator.restoreFromMemento( caretaker.getMemento(1) );
	}
 }
