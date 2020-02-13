package designpatterns.tutorialspoint.creation.builder;

import java.util.ArrayList;
import java.util.List;

public class Meal {
	private List<Item> items = new ArrayList<Item>();	

	public void addItem(Item item) {
		this.items.add(item);
	}

	public float getCost() {
		float cost = 0.0f;
		for (Item item : this.items) {
			cost += item.price();
		}		
		return cost;
	}

	public void showItems() {
		for (Item item : this.items) {
			System.out.print("Item : " + item.name());
			System.out.print(", Packing : " + item.packing().pack());
			System.out.println(", Price : " + item.price());
		}		
	}	
}
