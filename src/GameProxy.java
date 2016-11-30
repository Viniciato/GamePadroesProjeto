
public class GameProxy extends Game{
	private static GameProxy instance = new GameProxy();
	protected String user, pass;
	
	private GameProxy(){}
	
	public void setCredentials(String user, String pass){
		this.user=user;
		this.pass=pass;
	}

	
	public static GameProxy getInstance(){
		return instance;
	}
	
	@Override
	public CheckPoint getCurrentCheckPoint() {
		if(havePermission())
			return super.getCurrentCheckPoint();
		return null;
	}
	
	@Override
	protected void setPlayer(PlayerPrototype player) {
		if(havePermission())
			super.setPlayer(player);
	}
	
	@Override
	public PlayerPrototype getPlayer() {
		if(havePermission())
			return super.getPlayer();
		return null;
	}
	
	private boolean havePermission(){
		if(user.equals("adm") && pass.equals("123"))
			return true;
		return false;
	}
}
