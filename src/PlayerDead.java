
public class PlayerDead implements PlayerState{

	@Override
	public PlayerState dead() {
		System.out.println("Se voce estivesse vivo voce estava morto de volta!");
		return this;
	}
	
}
