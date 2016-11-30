
public abstract class PlayerPrototype {
	protected String name;
	protected String type;
	protected int position;
	
	public PlayerPrototype() {
		this.position=0;
	}
	
	public abstract PlayerPrototype clonar(String name);
	
	public abstract void act();
	
	public String getName() {
		return name;
	}
	
	public int getPosition() {
		return position;
	}
	
	public String getType() {
		return type;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
}
