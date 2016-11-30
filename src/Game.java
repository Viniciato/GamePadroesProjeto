import java.util.ArrayList;

public class Game {
	private PlayerCareTaker careTaker;
	private PlayerPrototype player;
	private CheckPoint currentCheckPoint;
	private ArrayList<CheckPoint> checkPoints = new ArrayList<>();
	private Boolean flag = true;
	
	public Game(){
		careTaker = new PlayerCareTaker();
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
		System.out.println("Jogador "+player.getName()+" da classe: "+this.player.getType()+" iniciou o jogo!!");
		saveGame();
		while(flag){
			System.out.println("Ultimo CheckPoint: "+currentCheckPoint.getName());
			System.out.println("Voce esta na posicao "+this.player.getPosition());
			this.player.act();
			checkAct();
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				System.out.println("Erro na thread "+e.getMessage());
			}
		}
	}
	
	private void saveGame(){
		careTaker.addMemento(new PlayerMemento(player));
	}
	
	private void loadSaveGame(){
		PlayerMemento memento = careTaker.getLastSave();
		this.player = memento.getPlayerSave();
		this.player.setPosition(currentCheckPoint.getPosition());
	}
	
	private void checkAct(){
		if(player.checkState()){
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
	
	protected void setPlayer(PlayerPrototype player) {
		this.player = player;
	}
}
