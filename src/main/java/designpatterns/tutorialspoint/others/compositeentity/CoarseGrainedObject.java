package designpatterns.tutorialspoint.others.compositeentity;

public class CoarseGrainedObject {
	DependentObject1 do1 = new DependentObject1();
	DependentObject2 do2 = new DependentObject2();

	public void setData(String data1, String data2) {
		this.do1.setData(data1);
		this.do2.setData(data2);
	}

	public String[] getData() {
		return new String[] { this.do1.getData(), this.do2.getData() };
	}
}
