package designpatterns.tutorialspoint.creation.bridge;

public class Circle extends Shape {
	private int x, y, radius;

	public Circle(int x, int y, int radius, DrawAPI drawAPI) {
		super(drawAPI);
		this.x		= x;  
		this.y		= y;  
		this.radius	= radius;
	}

	public void draw() {
		this.drawAPI.drawCircle(this.radius, this.x, this.y);
	}
}
