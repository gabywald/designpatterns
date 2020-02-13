package designpatterns.tutorialspoint.others.compositeentity;

public class Client {
	private CompositeEntity compositeEntity = new CompositeEntity();

	public void printData() {
		for (int i = 0; i < this.compositeEntity.getData().length; i++) {
			System.out.println("Data: (" + this.compositeEntity.getData()[i] + ")");
		}
	}

	public void setData(String data1, String data2) {
		this.compositeEntity.setData(data1, data2);
	}
}
