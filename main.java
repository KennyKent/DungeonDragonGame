import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// D�veloppement d'un jeu Donjon et Dragon
		// Un personnage qui explore un Donjon
		// Il visite diff�rentes pi�ces
		
		String answer;
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" =========== Bonjour, bienvenue dans Dungeon & Dragon =========== ");
		
		System.out.println("Vous voulez commencer la partie ? Yes/No ?");
		answer = sc.nextLine();
		
		if(answer.equals("Yes") || answer.equals("yes") || answer.equals("y")  || answer.equals("Y"))
		{
			new Chateau();
		}
		else
		{
			System.out.println("Vous n'avez pas taper la bonne valeur, veuillez r�essayer : Y / N");
			answer = sc.nextLine();
			
			if(answer.equals("Yes") || answer.equals("yes") || answer.equals("y")  || answer.equals("Y"))
			{
				new Chateau();
			}
			else
			{
				System.out.println(" GAME OVER NOOB !!! ");
			}
		}
	}

}
