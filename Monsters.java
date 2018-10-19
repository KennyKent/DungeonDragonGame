
public class Monsters extends Personnage {
	
	// Les Life Points du Monstre seront aléatoire entre 50 et 30 pour le niveau 1, et évolueront en fonction de son lvl 
	private int higherLifePoint = 50;
	private int lowerLifePoint = 30;
	private int lifePoint = (int)(Math.random() * (higherLifePoint-lowerLifePoint)) + lowerLifePoint;

	// Les points d'attaque du Monstre seront aléatoire entre 50 et 30 pour le niveau 1, et évolueront en fonction de son lvl 
	private int higherAttack = 50;
	private int lowerAttack = 30;
	private int attack = (int)(Math.random() * (higherAttack-lowerAttack)) + lowerAttack;
	
	private int compteur = 1;
	
	public Monsters(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	
	public int getAttack()
	{
		return attack;
	}
	
	public int setAttack()
	{
		return attack;
	}
	
	public int getLifePoint()
	{
		return lifePoint;
	}
	
	// Prendra en paramètres le getAttack() du Player
	public void setLifePoint(int attack)
	{
		lifePoint = lifePoint - attack;
	}
	
	public void setHigherAndLowerLifePoint(int lvl)
	{
		if(lvl > compteur)
		{
			higherLifePoint += 20;
			lowerLifePoint += 20;
			compteur += 1;
		}
	}
	
	public void setHigherAndLowerAttack(int lvl)
	{
		if(lvl > compteur)
		{
			higherAttack += 20;
			lowerAttack += 20;
			compteur += 1;
		}
	}
}
