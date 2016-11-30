import java.util.ArrayList;

public class PlayerCareTaker {
	private ArrayList<PlayerMemento> playerSaves;
	
	public PlayerCareTaker(){
		playerSaves = new ArrayList<>();
	}
	
	public void addMemento(PlayerMemento player){
		playerSaves.add(player);
	}
	
	public PlayerMemento getLastSave(){
		PlayerMemento player = playerSaves.get(playerSaves.size()-1);
		return player;
	}
}
