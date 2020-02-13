package gabywald.revisions.designpatterns.gof.creation.samples;

public class BuilderBase {

	public static void main(String[] args) {
		BuilderNumeric bn	= new BuilderNumeric();
		Director dirBN		= new Director(bn);
		dirBN.makeBuild();
		System.out.println(bn.getResult());
		
		BuilderAlphabetic ba	= new BuilderAlphabetic();
		Director dirBA			= new Director(ba);
		dirBA.makeBuild();
		System.out.println(ba.getResult());
	}
}

class BuiltObject {
	private StringBuilder value = new StringBuilder();
	
	public void add(String val) {
		this.value.append(val);
	}
	
	public String toString() {
		return this.value.toString();
	}
}

//enum BuildType {
//	NUMERIC, 
//	ALPHABETIC;
//}

interface Builder {
	public void reset();
	
	public void stepFirst();
	public void stepSecond();
	public void stepThird();
	
//	public void stepA();
//	public void stepB();
//	public void stepC();
//
//	public void step1();
//	public void step2();
//	public void step3();
	
	public BuiltObject getResult();
}

class Director {
	
	private Builder builder;
	
	public Director (Builder b) {
		this.builder = b;
	}
	
	public void makeBuild() { // BuildType type
//		switch(type) {
//		case NUMERIC:
//			this.builder.step1();
//			this.builder.step2();
//			this.builder.step3();
//			break;
//		case ALPHABETIC:
//			this.builder.stepA();
//			this.builder.stepB();
//			this.builder.stepC();
//			break;
//		}
		this.builder.reset();
		this.builder.stepFirst();
		this.builder.stepSecond();
		this.builder.stepThird();
	}
}

class BuilderNumeric implements Builder {
	private BuiltObject bo = null;

	@Override
	public void reset() {
		this.bo = new BuiltObject();
	}

	@Override
	public void stepFirst() {
		if (this.bo != null) 
			{ this.bo.add("1"); }
	}

	@Override
	public void stepSecond() {
		if (this.bo != null) 
			{ this.bo.add("2"); }		
	}

	@Override
	public void stepThird() {
		if (this.bo != null) 
			{ this.bo.add("3"); }
	}

	@Override
	public BuiltObject getResult() {
		return this.bo;
	}
}

class BuilderAlphabetic implements Builder {
	private BuiltObject bo = null;

	@Override
	public void reset() {
		this.bo = new BuiltObject();
	}

	@Override
	public void stepFirst() {
		if (this.bo != null) 
			{ this.bo.add("A"); }
	}

	@Override
	public void stepSecond() {
		if (this.bo != null) 
			{ this.bo.add("B"); }		
	}

	@Override
	public void stepThird() {
		if (this.bo != null) 
			{ this.bo.add("C"); }
	}

	@Override
	public BuiltObject getResult() {
		return this.bo;
	}
}


