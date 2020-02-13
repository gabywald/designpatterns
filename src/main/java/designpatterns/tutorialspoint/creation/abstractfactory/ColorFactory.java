package designpatterns.tutorialspoint.creation.abstractfactory;

import java.util.HashMap;
import java.util.Map;

public class ColorFactory extends AbstractFactory {

	@Override
	public Shape getShape(String shapeType) {
		return null;
	}

	@Override
	Color getColor(String color) {
		if (color == null) {
			return null;
		}		

		if (color.equalsIgnoreCase("RED")) {
			return new Red();
		} else if (color.equalsIgnoreCase("GREEN")) {
			return new Green();

		} else if (color.equalsIgnoreCase("BLUE")) {
			return new Blue();
		}

		return null;
	}
	
	public Color getColor(ColorType shapeType) {
		switch(shapeType) {
		case RED:
			return new Red();
		case GREEN:
			return new Green();
		case BLUE:
			return new Blue();
		// default:
		// 	return null;
		}
		return null;
	}
	
	// DONE "command variation" / Polymorphism / sOlid to replace Switch
	private Map<ColorType, CmdColor> map2cmdColor = null;
	public Color getShapeCmd(ColorType colorType) {
		if (this.map2cmdColor == null) {
			this.map2cmdColor = new HashMap<ColorType, CmdColor>();
			this.map2cmdColor.put(ColorType.RED, new CmdColor() {
				@Override
				public Color getColor() {
					return new Red();
				}
			});
			this.map2cmdColor.put(ColorType.GREEN, new CmdColor() {
				@Override
				public Color getColor() {
					return new Green();
				}
			});
			this.map2cmdColor.put(ColorType.BLUE, new CmdColor() {
				@Override
				public Color getColor() {
					return new Blue();
				}
			});
		}
		
		if (this.map2cmdColor.containsKey(colorType)) {
			return this.map2cmdColor.get(colorType).getColor();
		}
		
		return null;
	}
	
}

enum ColorType {
	RED, GREEN, BLUE;
}

interface CmdColor {
	public Color getColor();
}
