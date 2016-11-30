import java.util.Random;

public class Player {
	private String name;
	private String type;
	private int position;
	
	public Player(String name, String type){
		this.name=name;
		this.type=type;
		position=0;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void act(){
		Random rd = new Random();
		int x = rd.nextInt(5);
		int action = rd.nextInt(10);
		if (action==1)
			x=-1;
		if (action==9)
			x=-10000;
		position+=x;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
}
