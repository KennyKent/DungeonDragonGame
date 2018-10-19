
public class Player extends Personnage {
	
	private int Money;
	private int XP;
	private int lifePoint = 100;
	private int attack = 10;
	
	public Player(String name)
	{
		super(name);
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int BoostAttack) {
		attack += BoostAttack ;
	}
	
	public void setLifePoint(int boostLifePoint)
	{
		lifePoint = lifePoint + boostLifePoint;
	}
	
	// Mettre en paramètres l'attaque du ou des Monstres
	public void beAttacked(int hurt)
	{
		lifePoint = lifePoint - hurt;
	}
	
	public int getLifePoint()
	{
		return lifePoint;
	}
	
	public void setMoney(int tresor)
	{
		Money = Money + tresor;
	}
	
	public int getMoney()
	{
		return Money;
	}
	
	public void setXp(int boostXP)
	{
		XP += boostXP;
	}
}
