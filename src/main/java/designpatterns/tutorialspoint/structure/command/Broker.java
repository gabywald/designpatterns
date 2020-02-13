package designpatterns.tutorialspoint.structure.command;

import java.util.ArrayList;
import java.util.List;

/** Command Invoker */
public class Broker {
	private List<Order> orderList = new ArrayList<Order>(); 

	public void takeOrder(Order order) {
		this.orderList.add(order);		
	}

	public void placeOrders() {
		for (Order order : this.orderList) {
			order.execute();
		}
		this.orderList.clear();
	}
}
