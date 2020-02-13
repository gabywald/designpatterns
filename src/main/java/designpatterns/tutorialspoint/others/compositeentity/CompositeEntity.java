package designpatterns.tutorialspoint.others.compositeentity;

public class CompositeEntity {
	
	private CoarseGrainedObject cgo = new CoarseGrainedObject();

	public void setData(String data1, String data2) {
		this.cgo.setData(data1, data2);
	}

	public String[] getData() {
		return this.cgo.getData();
	}
}
