package gabywald.designpatterns.usage;

public class BuilderBOF extends BuilderFluently<BuiltObjectFluent> {
	
	@Override
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
