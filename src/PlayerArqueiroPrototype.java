import java.util.Random;

public class PlayerArqueiroPrototype extends PlayerPrototype{

	protected PlayerArqueiroPrototype(PlayerArqueiroPrototype player){
		this.name = player.getName();
	}
	
	public PlayerArqueiroPrototype() {
		type = "Arqueiro";
	}

	@Override
	public void act() {
		Random rd = new Random();
		int x = rd.nextInt(5);
		int action = rd.nextInt(10);
		if (action==1)
			x=-1;
		if (action==9)
			x=-10000;
		position+=x;
	}

	@Override
	public PlayerPrototype clonar(String name) {
		PlayerArqueiroPrototype arqueiro = new PlayerArqueiroPrototype();
		arqueiro.name=name;
		return arqueiro;
	}
}
