package gabywald.revisions.designpatterns.gof.structure.samples;

import java.util.ArrayList;
import java.util.List;

public class CompositeTree {
	
	public static void main(String[] args) {
		CompositeBranch root = new CompositeBranch();
		
		CompositeBranch cb1 = new CompositeBranch();
		CompositeBranch cb2 = new CompositeBranch();
		CompositeBranch cb3 = new CompositeBranch();
		CompositeBranch cb4 = new CompositeBranch();
		CompositeBranch cb5 = new CompositeBranch();
		
		root.add(new Leaf());
		
		root.add(cb1);
		root.add(cb2);
		root.add(cb3);
		cb1.add(new Leaf());
		cb2.add(new Leaf());cb2.add(new Leaf());
		cb3.add(new Leaf());cb3.add(new Leaf());cb3.add(new Leaf());
		cb3.add(cb4);
		cb3.add(cb5);
		
		for (int i = 0 ; i < 5 ; i++) {
			cb4.add(new Leaf());
			cb5.add(new Leaf());
		}
		
		CompositeBranch cb6 = new CompositeBranch();
		CompositeBranch cb7 = new CompositeBranch();
		cb6.add(new Leaf());
		cb7.add(new Leaf());
		
		root.add(cb6);
		root.add(cb7);
		
		
		root.printElement(0);
	}

	public static String generateTabs(int tabs) {
		// return new String(new char[tabs]).replace("\0", "\t");
		return CompositeTree.generate(tabs, "\t");
	}
	
	public static String generate(int tabs, CharSequence c) {
		return new String(new char[tabs]).replace("\0", c);
	}
}

interface TreeElement {
	public void printElement(int tabs);
}

class CompositeBranch implements TreeElement {
	
	private static int BRANCH_LENGTH = 8;

	private List<TreeElement> listTE = new ArrayList<TreeElement>();
	
	@Override
	public void printElement(int tabs) {
		tabs++;
		System.out.println( CompositeTree.generate(tabs, CompositeTree.generate(CompositeBranch.BRANCH_LENGTH, "-") ) );
		for (TreeElement te : listTE) {
			te.printElement(tabs);
		}
		System.out.println( CompositeTree.generate(tabs, CompositeTree.generate(CompositeBranch.BRANCH_LENGTH, "-") ) );
	}
	
	public void add(TreeElement te) {
		this.listTE.add(te);
	}
	
	public boolean remove (TreeElement te) {
		return this.listTE.remove(te);
	}
	
}

class Leaf implements TreeElement {

	@Override
	public void printElement(int tabs) {
		System.out.println( CompositeTree.generateTabs(tabs) + "Leaf");		
	}
	
}


