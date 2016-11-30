
public class Main {
	public static void main(String[] args) {
		Game game = Game.getInstance();
		PlayerArqueiroPrototype playerArqueiro = new PlayerArqueiroPrototype();
		PlayerPrototype player = playerArqueiro.clonar("Vinicius");
		game.inityGame(player);
	}
}
