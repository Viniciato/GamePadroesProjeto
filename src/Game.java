import java.util.ArrayList;

public class Game {
	private GameCareTaker careTaker;
	private static Game instance = new Game();
	private PlayerPrototype player;
	private CheckPoint currentCheckPoint;
	private ArrayList<CheckPoint> checkPoints = new ArrayList<>();
	private Boolean flag = true;
	
	private Game(){
		careTaker = new GameCareTaker();
		CheckPoint initial = new CheckPoint(0, "Inicio de Jogo");
		CheckPoint phase1 = new CheckPoint(7, "CheckPoint Fase 1");
		CheckPoint questOne = new CheckPoint(23, "CheckPoint Quest Fase 1");
		CheckPoint bossOne = new CheckPoint(37, "CheckPoint BossFinal 1");	
		checkPoints.add(initial);
		checkPoints.add(phase1);
		checkPoints.add(questOne);
		checkPoints.add(bossOne);
		currentCheckPoint = initial;
	}
	
	public void inityGame(PlayerPrototype player){
		this.player = player;
		System.out.println("Jogo RPG Tiubia Iniciado :D");
		System.out.println("Jogador "+player.getName()+" da classe: "+player.getType()+" iniciou o jogo!!");
		saveGame();
		loadSaveGame();
		while(flag){
			System.out.println("Ultimo CheckPoint: "+currentCheckPoint.getName());
			System.out.println("Voce esta na posicao "+instance.getPlayer().getPosition());
			player.act();
			checkAct();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Erro na thread "+e.getMessage());
			}
		}
	}
	
	public static Game getInstance(){
		return instance;
	}
	
	private void saveGame(){
		careTaker.addMemento(new GameMemento(instance));
	}
	
	private void loadSaveGame(){
		GameMemento memento = careTaker.getLastSave();
		instance = memento.getGameSave();
		player.setPosition(currentCheckPoint.getPosition());
	}
	
	private void checkAct(){
		if(player.getPosition()<0){
			System.out.println("Voce morreu :(");
			if(careTaker.getLastSave().getGameSave().getCurrentCheckPoint() == checkPoints.get(0))
				System.out.println("Voce nao tem nenhum save game!! Seu jogo ira reiniciar do zero");
			else
				System.out.println("Voce ira continuar do ultimo saveGame!!");
			loadSaveGame();
		}
		else
			checkCheckPoints();
	}
	
	private void checkCheckPoints(){
			int pPostion = player.getPosition();
			int lastSavePositon = currentCheckPoint.getPosition();
			if(pPostion > lastSavePositon){
				int checkPosition = checkPoints.indexOf(currentCheckPoint);
				for (int i = checkPosition+1; i < checkPoints.size(); i++) {
					if(pPostion >= checkPoints.get(i).getPosition()){
						currentCheckPoint = checkPoints.get(i);
						saveGame();
						System.out.println("Salvou");
					}
				}
				if(pPostion>=checkPoints.get(checkPoints.size()-1).getPosition()){
					System.out.println("Fim de jogo!!");
					flag = false;
				}
			}
	}
	
	public PlayerPrototype getPlayer() {
		return player;
	}
	
	public CheckPoint getCurrentCheckPoint() {
		return currentCheckPoint;
	}
	
}
