package designpatterns.tutorialspoint.structure.proxy;

public class RealImage implements Image {

	private String fileName;

	public RealImage(String fileName){
		this.fileName = fileName;
		this.loadFromDisk(fileName);
	}

	@Override
	public void display() {
		System.out.println("Displaying {" + this.fileName + "}");
	}

	private void loadFromDisk(String fileName) {
		System.out.println("Loading {" + fileName + "}");
	}
}
