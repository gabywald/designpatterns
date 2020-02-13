package designpatterns.tutorialspoint.creation.abstractfactory;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory extends AbstractFactory {
	// Use getShape method to get object of type shape 
	public Shape getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		} else if(shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		} else if(shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}

		return null;
	}
	
	public Shape getShape(ShapeType shapeType) {
		switch(shapeType) {
		case CIRCLE:
			return new Circle();
		case RECTANGLE:
			return new Rectangle();
		case SQUARE:
			return new Square();
		// default:
		// 	return null;
		}
		return null;
	}

	@Override
	Color getColor(String color) {
		return null;
	}
	
	// DONE "command variation" / Polymorphism / sOlid to replace Switch
	private Map<ShapeType, CmdShape> map2cmdShape = null;
	public Shape getShapeCmd(ShapeType shapeType) {
		if (this.map2cmdShape == null) {
			this.map2cmdShape = new HashMap<ShapeType, CmdShape>();
			this.map2cmdShape.put(ShapeType.CIRCLE, new CmdShape() {
				@Override
				public Shape getShape() {
					return new Circle();
				}
			});
			this.map2cmdShape.put(ShapeType.RECTANGLE, new CmdShape() {
				@Override
				public Shape getShape() {
					return new Rectangle();
				}
			});
			this.map2cmdShape.put(ShapeType.SQUARE, new CmdShape() {
				@Override
				public Shape getShape() {
					return new Square();
				}
			});
		}
		
		if (this.map2cmdShape.containsKey(shapeType)) {
			return this.map2cmdShape.get(shapeType).getShape();
		}
		
		return null;
	}
	
}

enum ShapeType {
	CIRCLE, RECTANGLE, SQUARE;
}

interface CmdShape {
	public Shape getShape();
}