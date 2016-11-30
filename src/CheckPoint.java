public class CheckPoint {
	private int position;
	private String name;
	
	public CheckPoint(int position, String name) {
		this.position=position;
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPosition() {
		return position;
	}
}
