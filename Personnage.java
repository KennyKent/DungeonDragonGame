
public class Personnage {
	
	private String persoName;
	private int Level = 1;

	public Personnage(String name) {
		// TODO Auto-generated constructor stub
		persoName = name; 
	}
	
	public String GetPlayerName()
	{
		return persoName;
	}

	public int getLevel() {
		return Level;
	}

	public void setLevel(int level, int xp) {
		this.Level = level;
	}
}
