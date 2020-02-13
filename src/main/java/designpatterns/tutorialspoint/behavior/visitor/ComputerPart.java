package designpatterns.tutorialspoint.behavior.visitor;

public interface ComputerPart {
	public void accept(ComputerPartVisitor computerPartVisitor);
}
