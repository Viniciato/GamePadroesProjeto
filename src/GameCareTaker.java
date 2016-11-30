import java.util.ArrayList;

public class GameCareTaker {
	private ArrayList<GameMemento> gameStates;
	
	public GameCareTaker(){
		gameStates = new ArrayList<>();
	}
	
	public void addMemento(GameMemento game){
		gameStates.add(game);
	}
	
	public GameMemento getLastSave(){
		if(gameStates.isEmpty())
			return null;
		GameMemento game = gameStates.get(gameStates.size()-1);
		return game;
	}
}
