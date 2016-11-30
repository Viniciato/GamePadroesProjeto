
public class PlayerMemento {
	private PlayerPrototype player;
	
	public PlayerMemento(PlayerPrototype player){
		this.player = player.clonar(player.getName());
	}
	
	public PlayerPrototype getPlayerSave(){
		return this.player;
	}
}
