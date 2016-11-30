
public abstract class PlayerPrototype {
	protected PlayerState state;
	protected String name;
	protected String type;
	protected int position;
	
	public PlayerPrototype() {
		this.position=0;
		state = new PlayerAlive();
	}
	
	public abstract PlayerPrototype clonar(String name);
	
	public abstract void act();
	
	protected boolean checkState(){
		if(position<0){
			state = state.dead();
			return true;
		}
		return false;
	}
	
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
	
	public PlayerState getState() {
		return state;
	}
	
}
