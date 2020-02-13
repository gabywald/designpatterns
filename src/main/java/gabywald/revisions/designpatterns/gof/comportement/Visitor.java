package gabywald.revisions.designpatterns.gof.comportement;

public interface Visitor {
	void visit(ObjetPere objet);
}

interface ObjetPere {
	void accept(Visitor v);
}
