
public class Main {
	public static void main(String[] args) {
		Game game = GameProxy.getInstance();
		PlayerArqueiroPrototype arqueiro = new PlayerArqueiroPrototype();
		PlayerPrototype player = arqueiro.clonar("Vinicius");
		game.inityGame(player);
	}
}
