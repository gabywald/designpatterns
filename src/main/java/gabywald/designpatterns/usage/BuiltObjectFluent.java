package gabywald.designpatterns.usage;

import java.util.ArrayList;
import java.util.List;

public class BuiltObjectFluent {
	private List<String> values = new ArrayList<String>();
	
	public void add(String val) {
		this.values.add(val);
	}
	
	public String toString() {
		StringBuilder toReturn = new StringBuilder();
		toReturn.append("{");
		for (String toAdd : this.values) {
			toReturn.append(toAdd).append(", ");
		}
		toReturn.delete(toReturn.length()-2, toReturn.length())
				.append("}");
		return toReturn.toString();
	}
}