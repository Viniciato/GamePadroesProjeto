
public class PlayerAlive implements PlayerState{

	@Override
	public PlayerState dead() {
		System.out.println("Voce foi morto :(");
		return new PlayerDead();
	}	
}
