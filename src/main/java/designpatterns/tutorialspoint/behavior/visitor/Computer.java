package designpatterns.tutorialspoint.behavior.visitor;

public class Computer implements ComputerPart {

	private ComputerPart[] parts;

	public Computer() {
		this.parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};		
	} 

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		for (int i = 0; i < this.parts.length; i++) {
			this.parts[i].accept(computerPartVisitor);
		}
		computerPartVisitor.visit(this);
	}
}
