package gabywald.revisions.designpatterns.gof.comportement.samples;

import java.util.ArrayList;
import java.util.Stack;

interface Expression {
	public void interpret(Stack<Integer> s);
}

class TerminalExpressionNumber implements Expression {
	private int number;

	public TerminalExpressionNumber(int number)
		{ this.number = number; }

	public void interpret(Stack<Integer> s)
		{ s.push(number); }
}

class TerminalExpressionPlus implements Expression {
	public void interpret(Stack<Integer> s)
		{ s.push( s.pop() + s.pop() ); }
}

class TerminalExpressionMinus implements Expression {
	public void interpret(Stack<Integer> s)
		{ s.push( - s.pop() + s.pop() ); }
}

class Parser {
	private ArrayList<Expression> parseTree =
			new ArrayList<Expression>(); // only one NonTerminal Expression here

	public Parser(String s) {
		for (String token : s.split(" ")) {
			if (token.equals("+")) {
				this.parseTree.add( new TerminalExpressionPlus() );
			}
			else if (token.equals("-")) {
				this.parseTree.add( new TerminalExpressionMinus() );
			}
			// ...
			else {
				this.parseTree.add( new TerminalExpressionNumber(Integer.parseInt(token)) );
			}
		}
	}

	public int evaluate() {
		Stack<Integer> context = new Stack<Integer>();
		for (Expression e : this.parseTree) {
			e.interpret(context);
		}
		return context.pop();
	}
}

public class InterpreterExample {
	public static void main(String[] args) {
		String expression = "42 4 2 - +";
		Parser p = new Parser(expression);
		System.out.println("'" + expression +"' equals " + p.evaluate());
	}
}
