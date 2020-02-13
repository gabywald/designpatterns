package gabywald.revisions.designpatterns.gof.creation.samples;

/** AbstractFactory: GUIFactory Example */
public abstract class GUIFactory {
	
	public static GUIFactory getFactory() {
		String sys = System.getProperty("OS_TYPE");

		if (sys == null)
			{ return(new WinFactory()); }

		return(new OSXFactory());
	}
	
	public abstract Button createButton();
	
	
	public static void main(String[] args) {
		GUIFactory aFactory = GUIFactory.getFactory();
		Button aButton = aFactory.createButton();
		aButton.setCaption("Play A");
		aButton.paint();
		
		System.setProperty("OS_TYPE", "notnull");
		GUIFactory bFactory = GUIFactory.getFactory();
		Button bButton = bFactory.createButton();
		bButton.setCaption("Play B");
		bButton.paint();
	}

}

class WinFactory extends GUIFactory {
	public Button createButton() {
		return(new WinButton());
	}
}

class OSXFactory extends GUIFactory {
	public Button createButton() {
		return(new OSXButton());
	}
}

abstract class Button {
	private String caption;

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public abstract void paint();
}

class WinButton extends Button {
	public void paint() {
		System.out.println("I'm a WinButton: "+ getCaption());
	}
}

class OSXButton extends Button {
	public void paint() {
		System.out.println("I'm an OSXButton: "+ getCaption());
	}
}

