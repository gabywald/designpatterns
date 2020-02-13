package designpatterns.tutorialspoint.structure.command;

public class BuyStock implements Order {
	private Stock abcStock;

	public BuyStock(Stock abcStock) {
		this.abcStock = abcStock;
	}

	public void execute() {
		this.abcStock.buy();
	}
}
