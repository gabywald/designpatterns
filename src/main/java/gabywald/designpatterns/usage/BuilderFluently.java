package gabywald.designpatterns.usage;

import java.util.HashMap;
import java.util.Map;

public abstract class BuilderFluently<T> {
	/** id/name + type + value */
	protected Map<String, Pair<AttemptedType, String> > map = new HashMap<String, Pair<AttemptedType, String> >();
	
	// TODO BuilderFluently ?? ARRAY, OBJECT
	// TODO BuilderFluently ?? specific for String ??
	
	public BuilderFluently<T> addParameter(String key, String val) {
		this.map.put(key, Pair.of(AttemptedType.String, val));
		return this;
	}
	
	public BuilderFluently<T> addParameter(String key, Boolean val) {
		this.map.put(key, Pair.of(AttemptedType.BOOLEAN, val.toString()));
		return this;
	}
	
	public BuilderFluently<T> addParameter(String key, Character val) {
		this.map.put(key, Pair.of(AttemptedType.CHAR, val.toString()));
		return this;
	}
	
	public BuilderFluently<T> addParameter(String key, Byte val) {
		this.map.put(key, Pair.of(AttemptedType.BYTE, val.toString()));
		return this;
	}
	
	public BuilderFluently<T> addParameter(String key, Short val) {
		this.map.put(key, Pair.of(AttemptedType.SHORT, val.toString()));
		return this;
	}
	
	public BuilderFluently<T> addParameter(String key, Integer val) {
		this.map.put(key, Pair.of(AttemptedType.INT, val.toString()));
		return this;
	}
	
	public BuilderFluently<T> addParameter(String key, Long val) {
		this.map.put(key, Pair.of(AttemptedType.LONG, val.toString()));
		return this;
	}
	
	public BuilderFluently<T> addParameter(String key, Float val) {
		this.map.put(key, Pair.of(AttemptedType.FLOAT, val.toString()));
		return this;
	}
	
	public BuilderFluently<T> addParameter(String key, Double val) {
		this.map.put(key, Pair.of(AttemptedType.DOUBLE, val.toString()));
		return this;
	}
	
	public abstract T build();
	
	public BuiltObjectFluent buildBOF() {
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
				// TODO BuiltObjectFluently.build Array ...
				break;
			case CLASS:
				// TODO BuiltObjectFluently.build Class ...
				break;
			case INTERFACE:
				// TODO BuiltObjectFluently.build Interface ...
				break;
			}
			bof.add( sb.toString() );
		}
		return bof;
	}
}
