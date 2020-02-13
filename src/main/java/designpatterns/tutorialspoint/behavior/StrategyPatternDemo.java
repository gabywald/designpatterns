package designpatterns.tutorialspoint.behavior;

public class StrategyPatternDemo {
	public static void main(String[] args) {
		ContextStategy context = new ContextStategy(new OperationAdd());		
		System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

		context = new ContextStategy(new OperationSubstract());		
		System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

		context = new ContextStategy(new OperationMultiply());		
		System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
	}
}

interface Strategy {
	public int doOperation(int num1, int num2);
}

class OperationAdd implements Strategy{
	@Override
	public int doOperation(int num1, int num2) {
		return num1 + num2;
	}
}

class OperationSubstract implements Strategy{
	@Override
	public int doOperation(int num1, int num2) {
		return num1 - num2;
	}
}

class OperationMultiply implements Strategy{
	@Override
	public int doOperation(int num1, int num2) {
		return num1 * num2;
	}
}

class ContextStategy {
	private Strategy strategy;

	public ContextStategy(Strategy strategy){
		this.strategy = strategy;
	}

	public int executeStrategy(int num1, int num2){
		return this.strategy.doOperation(num1, num2);
	}
}