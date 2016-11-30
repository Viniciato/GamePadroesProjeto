
public class GameMemento {
	private Game game;
	
	public GameMemento(Game game){
		this.game = game;
	}
	
	public Game getGameSave(){
		return this.game;
	}
}
