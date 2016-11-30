
public class Game {
	private GameCareTaker careTaker;
	private static Game instance = new Game();
	private Player player;
	private String fase;
	
	private Game(){
		careTaker = new GameCareTaker();
		fase = "Fase 1";
	}
	
	public void inityGame(Player player){
		this.player = player;
		System.out.println("Jogo RPG Tiubia Iniciado :D");
		System.out.println("Jogador "+player.getName()+" iniciou o jogo!!");
		loadSaveGame();
		System.out.println("Voce esta na fase: "+fase);
		
	}
	
	public static Game getInstance(){
		return instance;
	}
	
	private void saveGame(){
		careTaker.addMemento(new GameMemento(this));
	}
	
	private void loadSaveGame(){
		instance = careTaker.getLastSave().getGameSave();
	}
	
	public Player getPlayer() {
		return player;
	}
	
}
