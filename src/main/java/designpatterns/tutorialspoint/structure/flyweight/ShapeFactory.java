package designpatterns.tutorialspoint.structure.flyweight;

import java.util.HashMap;

public class ShapeFactory {

	// Uncomment the compiler directive line and
	// javac *.java will compile properly.
	// @SuppressWarnings("unchecked")
	private static final HashMap<String, Circle> circleMap = new HashMap<String, Circle>();

	public static Shape getCircle(String color) {
		Circle circle = ShapeFactory.circleMap.get(color);
		if (circle == null) {
			circle = new Circle(color);
			ShapeFactory.circleMap.put(color, circle);
			System.out.println("Creating circle of color : {" + color + "}");
		}
		return circle;
	}
}
