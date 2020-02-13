package gabywald.revisions.designpatterns.gof.creation.samples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BuilderFluent {

	public static void main(String[] args) {
		BuilderFluently bf = new BuilderFluently();
		
		for (int i = 0 ; i < 42 ; i++) {
			bf.addParameter("param" + i, UUID.randomUUID().toString());
		}
		
		for (int i = 0 ; i < 42 ; i++) {
			bf.addParameter("integer" + i, i);
		}
		
		bf.addParameter("BooleanTrue", true);
		bf.addParameter("BooleanFalse", false);
		
		System.out.println(bf.build());
	}
}

/** 
 * NOTE => http://zetcode.com/lang/java/datatypes/
 * NOTE => https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
 */
enum AttemptedType {
	BOOLEAN, CHAR, BYTE, SHORT, INT, LONG, FLOAT, DOUBLE, ARRAY, CLASS, INTERFACE, String;
}

class BuiltObjectFluent {
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

class BuilderFluently {
	/** id/name + type + value */
	private Map<String, Pair<AttemptedType, String> > map = new HashMap<String, Pair<AttemptedType, String> >();
	
	// TODO BuilderFluently ?? ARRAY, OBJECT
	// TODO BuilderFluently ?? specific for String ??
	
	public Pair<AttemptedType, String> addParameter(String key, String val) {
		return this.map.put(key, Pair.of(AttemptedType.String, val));
	}
	
	public Pair<AttemptedType, String> addParameter(String key, Boolean val) {
		return this.map.put(key, Pair.of(AttemptedType.BOOLEAN, val.toString()));
	}
	
	public Pair<AttemptedType, String> addParameter(String key, Character val) {
		return this.map.put(key, Pair.of(AttemptedType.CHAR, val.toString()));
	}
	
	public Pair<AttemptedType, String> addParameter(String key, Byte val) {
		return this.map.put(key, Pair.of(AttemptedType.BYTE, val.toString()));
	}
	
	public Pair<AttemptedType, String> addParameter(String key, Short val) {
		return this.map.put(key, Pair.of(AttemptedType.SHORT, val.toString()));
	}
	
	public Pair<AttemptedType, String> addParameter(String key, Integer val) {
		return this.map.put(key, Pair.of(AttemptedType.INT, val.toString()));
	}
	
	public Pair<AttemptedType, String> addParameter(String key, Long val) {
		return this.map.put(key, Pair.of(AttemptedType.LONG, val.toString()));
	}
	
	public Pair<AttemptedType, String> addParameter(String key, Float val) {
		return this.map.put(key, Pair.of(AttemptedType.FLOAT, val.toString()));
	}
	
	public Pair<AttemptedType, String> addParameter(String key, Double val) {
		return this.map.put(key, Pair.of(AttemptedType.DOUBLE, val.toString()));
	}
	

	public BuiltObjectFluent build() {
		BuiltObjectFluent bof = new BuiltObjectFluent();
		for (String key : this.map.keySet()) {
			Pair<AttemptedType, String> pair = this.map.get(key);
			StringBuilder sb = new StringBuilder();
			sb.append("\"").append(key).append("\" : ");
			switch(pair.first) {
			case BOOLEAN:
				sb.append(pair.second.equals(Boolean.TRUE.toString())?"true":"false");
				break;
			case CHAR:
			case BYTE:
			case SHORT:
			case INT:
			case LONG:
			case FLOAT:
			case DOUBLE:
				sb.append(pair.second);
				break;
			case String:
				sb.append("\"").append(pair.second).append("\"");
				break;
			case ARRAY:
				// TODO BuiltObjectFluent.build Array ...
				break;
			case CLASS:
				// TODO BuiltObjectFluent.build Class ...
				break;
			case INTERFACE:
				// TODO BuiltObjectFluent.build Interface ...
				break;
			}
			bof.add( sb.toString() );
		}
		return bof;
	}
	
}












/** Pair class 
 * see https://www.techiedelight.com/implement-pair-class-java/
 */
class Pair<U, V> {
	/** First field of a Pair */
	public final U first;
	/** Second field of a Pair */
	public final V second; 

	/** Constructs a new Pair with specified values. */
	Pair(U first, V second) {
		this.first = first;
		this.second = second;
	}

	/**
	 * Checks specified object is "equal to" current object or not
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) 
			{ return true; }

		if ( (o == null) || (this.getClass() != o.getClass()) )
			{ return false; }

		Pair<?, ?> pair = (Pair<?, ?>) o;

		// Call equals() method of the underlying objects
		if (!first.equals(pair.first))
			{ return false; }
		return second.equals(pair.second);
	}

	/**
	 * Computes hash code for an object to support hash tables. 
	 */
	@Override
	public int hashCode() {
		// Use hash codes of the underlying objects
		return 31 * this.first.hashCode() + this.second.hashCode();
	}

	@Override
	public String toString() {
		return "(" + this.first + ", " + this.second + ")";
	}

	/** Factory method for creating a Typed Pair immutable instance. */
	public static <U, V> Pair <U, V> of(U a, V b) {
		// Calls private constructor
		return new Pair<>(a, b);
	}
}