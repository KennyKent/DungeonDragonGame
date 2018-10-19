import java.util.Scanner;

public class Chateau {
	
	private String name;
	private String answer;
	private String giveUp = "No";
	private Scanner sc = new Scanner(System.in);
	private Player playerCreate = new Player(name);
	private Boolean IsCreate = false;
	private int compteur = 1;
	
	public Chateau()
	{
		ChooseAndCreateYourCharacter();
		
		while(playerCreate.getLifePoint() > 0 && playerCreate.getMoney() < 500 && giveUp.equals("No"))
		{
			CreateCouloir();
			CreateSalle();
		}
		
		if(playerCreate.getMoney() == 500)
		{
			System.out.println("Vous avez gagné la partie !!! Vous sortez de ce donjon et vous êtes riche !!!!");
		}
		
		if(playerCreate.getLifePoint() < 0)
		{
			System.out.println("Vous êtes mort ! Vous êtes un looser !!!");
		}
		
		if(giveUp.equals("Yes"))
		{
			System.out.println("Vous avez abandonné ! Vous êtes un looser !!!");
		}
	}
	
	public void ChooseAndCreateYourCharacter()
	{
		System.out.println("Vous êtes quelqu'un de courageux, vous avez décidé de commencer une partie. Préférez-vous être un Héros ou un Vilain ? H / V");
		
		System.out.println("Héros : +30 de vie / +10 Attack / +10 money");
		System.out.println("Villain : +15 de vie / +20 Attack / +20 money");
		answer = sc.nextLine();
		
		if(answer.equals("H"))
		{
			System.out.print("Veuillez saisir un nom pour votre personnage : ");
			name = sc.nextLine();
			
			Player player = new Heros(name);
			playerCreate = player;
			
			playerCreate.setLifePoint(30);
			playerCreate.setAttack(15);
			playerCreate.setMoney(10);
			IsCreate = true;
		}
		else if(answer.equals("V"))
		{
			System.out.print("Veuillez saisir un nom pour votre personnage : ");
			name = sc.nextLine();
			
			Villain player = new Villain(name);
			playerCreate = player;
			
			playerCreate.setLifePoint(15);
			playerCreate.setAttack(20);
			playerCreate.setMoney(20);
			IsCreate = true;
		}
		else
		{
			System.out.println(" Vous n'avez pas saisi les valeurs qu'il fallait ");
			System.out.println(" C'est votre chance numéro " + compteur + " saississez la bonne valeur ou vous serez banni !");
			compteur++;
			if(compteur > 2)
			{
				while(compteur < 1000)
				{
					System.out.println(" CHATIMENT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ");
				}
			}
			else {
				ChooseAndCreateYourCharacter();
			}
		}
		
		if(IsCreate && answer.equals("H"))
		{
			System.out.println("Votre personnage se prénomme " + playerCreate.GetPlayerName() + ", vous êtes un Héros et vous allez dès à présent partir à l'aventure dans le Donjon.");
			System.out.println("Voici les caractéristiques de votre personnage : Level : " + playerCreate.getLevel() + 
					", Life Points : " + playerCreate.getLifePoint() + ", Argent : " + playerCreate.getMoney() + ", Attack : " + playerCreate.getAttack());
		}
		else
		{
			System.out.println("Votre personnage se prénomme " + playerCreate.GetPlayerName() + ", vous êtes un Villain et vous allez dès à présent partir à l'aventure dans le Donjon.");
			System.out.println("Voici les caractéristiques de votre personnage : Level : " + playerCreate.getLevel() + 
					", Life Points : " + playerCreate.getLifePoint() + ", Argent : " + playerCreate.getMoney() + ", Attack : " + playerCreate.getAttack());
		}
	}
	
	public void CreateSalle()
	{
		int higher = 12;
		int lower = 0;
		int random = (int)(Math.random() * (higher-lower)) + lower;
		switch(random)
		{
			case 0:
				Monsters Exorcist = new Monsters("L'Exorciste");
				Piece Amityville = new SalleMonsters("Amityville", "Vous entrez dans la salle AmityVille, " + Exorcist.GetPlayerName() +  " vous attaque.");
				System.out.println(Amityville.GetDescription());
				System.out.println("");
				System.out.println("Voici les caractérisques de " + Exorcist.GetPlayerName() + ", Level : " + Exorcist.getLevel() + " , LifePoint : " 
				+ Exorcist.getLifePoint() + ", Attack : " + Exorcist.getAttack());
				
				System.out.println(" Que le COMBAT COMMENCE !!!!!!!!!!!!!!!!!!!!!!!!!!!! ");
				System.out.println("");
				
				
				while(Exorcist.getLifePoint() > 0)
				{
					System.out.println(" Vous attaquez ! ");
					System.out.println("");
					Exorcist.setLifePoint(playerCreate.getAttack());
					System.out.println(" Attaque efficace !"+ " Voici les vies de " + Exorcist.GetPlayerName() + " : " + Exorcist.getLifePoint());
					System.out.println("");
					
					if(Exorcist.getLifePoint() < 0)
					{
						System.out.println("Vous venez de tuer " + Exorcist.GetPlayerName());

						System.out.println("Vous regagniez 25 Lifes Points");
						playerCreate.setLifePoint(25);
						System.out.println("Voici vos lifes points : " + playerCreate.getLifePoint());
						System.out.println("");
						System.out.println(" Voulez-vous abandonner ? Yes / No" );
						giveUp = sc.nextLine();
						
						if(!giveUp.equals("Yes") || !giveUp.equals("No"))
						{
							while(!giveUp.equals("Yes") || !giveUp.equals("No"))
							{
								System.out.println("Vous n'avez pas saisi la bonne valeur !");
								System.out.println(" Voulez-vous abandonner ? Yes / No" );
								giveUp = sc.nextLine();
							}
						}
						System.out.println("");
						break;
					}
					System.out.println(Exorcist.GetPlayerName() + " vous attaque ! ");
					System.out.println("");
					playerCreate.beAttacked(Exorcist.getAttack());
					System.out.println("Voici vos life points : " + playerCreate.getLifePoint());
					System.out.println("");
				}
				break;
			case 2:
				Monsters TueurMasqué = new Monsters("un Tueur Masqué");
				Piece Scream = new SalleMonsters("Scream", "Vous entrez dans la salle Scream, " + TueurMasqué.GetPlayerName() + " vous attaque.");
				System.out.println(Scream.GetDescription());
				System.out.println("");
				System.out.println("Voici les caractérisques de " + TueurMasqué.GetPlayerName() + ", Level : " + TueurMasqué.getLevel() + " , LifePoint : " 
						+ TueurMasqué.getLifePoint() + ", Attack : " + TueurMasqué.getAttack());
				System.out.println("");
				
				while(TueurMasqué.getLifePoint() > 0)
				{
					System.out.println(" Vous attaquez ! ");
					System.out.println("");
					TueurMasqué.setLifePoint(playerCreate.getAttack());
					System.out.println(" Attaque efficace !"+ " Voici les vies de " + TueurMasqué.GetPlayerName() + " : " + TueurMasqué.getLifePoint());
					System.out.println("");
					
					if(TueurMasqué.getLifePoint() < 0)
					{
						System.out.println("Vous venez de tuer " + TueurMasqué.GetPlayerName());
						System.out.println("Vous regagniez 25 Lifes Points");
						playerCreate.setLifePoint(25);
						System.out.println("Voici vos lifes points : " + playerCreate.getLifePoint());
						System.out.println("");
						System.out.println(" Voulez-vous abandonner ? Yes / No" );
						giveUp = sc.nextLine();
						
						if(!giveUp.equals("Yes") || !giveUp.equals("No"))
						{
							while(!giveUp.equals("Yes") || !giveUp.equals("No"))
							{
								System.out.println("Vous n'avez pas saisi la bonne valeur !");
								System.out.println(" Voulez-vous abandonner ? Yes / No" );
								giveUp = sc.nextLine();
							}
						}
						System.out.println("");
						break;
					}
					System.out.println(TueurMasqué.GetPlayerName() + " vous attaque ! ");
					System.out.println("");
					playerCreate.beAttacked(TueurMasqué.getAttack());
					System.out.println("Voici vos life points : " + playerCreate.getLifePoint());
					System.out.println("");
				}
				break;
			case 3:
				Monsters Spiders = new Monsters("Spiders");
				Piece Scary = new SalleMonsters("Scary", "Vous entrez dans la salle Scary, " + Spiders.GetPlayerName() + " vous attaque.");
				System.out.println(Scary.GetDescription());
				System.out.println("Voici les caractérisques de " + Spiders.GetPlayerName() + ", Level : " + Spiders.getLevel() + " , LifePoint : " 
						+ Spiders.getLifePoint() + ", Attack : " + Spiders.getAttack());
				
				while(Spiders.getLifePoint() > 0)
				{
					System.out.println(" Vous attaquez ! ");
					Spiders.setLifePoint(playerCreate.getAttack());
					System.out.println(" Attaque efficace !"+ " Voici les vies de " + Spiders.GetPlayerName() + " : " + Spiders.getLifePoint());
					
					if(Spiders.getLifePoint() < 0)
					{
						System.out.println("Vous venez de tuer " + Spiders.GetPlayerName());
						System.out.println("Vous regagniez 25 Lifes Points");
						playerCreate.setLifePoint(25);
						System.out.println("Voici vos lifes points : " + playerCreate.getLifePoint());
						System.out.println("");
						System.out.println(" Voulez-vous abandonner ? Yes / No" );
						giveUp = sc.nextLine();
						
						if(!giveUp.equals("Yes") || !giveUp.equals("No"))
						{
							while(!giveUp.equals("Yes") || !giveUp.equals("No"))
							{
								System.out.println("Vous n'avez pas saisi la bonne valeur !");
								System.out.println(" Voulez-vous abandonner ? Yes / No" );
								giveUp = sc.nextLine();
							}
						}
						System.out.println("");
						break;
					}
					
					System.out.println(Spiders.GetPlayerName() + " vous attaque ! ");
					playerCreate.beAttacked(Spiders.getAttack());
					System.out.println("Voici vos life points : " + playerCreate.getLifePoint());
					System.out.println("");
				}
				break;
			case 4:
				Monsters HHH = new Monsters("HHH");
				Piece HellinTheCell = new SalleMonsters("HellinTheCell", "Vous entrez dans la salle HellinTheCell" + ", un Monstre vous attaque.");
				System.out.println(HellinTheCell.GetDescription());
				System.out.println("Voici les caractérisques de " + HHH.GetPlayerName() + ", Level : " + HHH.getLevel() + " , LifePoint : " 
						+ HHH.getLifePoint() + ", Attack : " + HHH.getAttack());
				
				while(HHH.getLifePoint() > 0)
				{
					System.out.println(" Vous attaquez ! ");
					HHH.setLifePoint(playerCreate.getAttack());
					System.out.println(" Attaque efficace !"+ " Voici les vies de " + HHH.GetPlayerName() + " : " + HHH.getLifePoint());

					if(HHH.getLifePoint() < 0)
					{
						System.out.println("Vous venez de tuer " + HHH.GetPlayerName());
						System.out.println("Vous regagniez 25 Lifes Points");
						playerCreate.setLifePoint(25);
						System.out.println("Voici vos lifes points : " + playerCreate.getLifePoint());
						System.out.println("");
						System.out.println(" Voulez-vous abandonner ? Yes / No" );
						giveUp = sc.nextLine();
						
						if(!giveUp.equals("Yes") || !giveUp.equals("No"))
						{
								System.out.println("Vous n'avez pas saisi la bonne valeur !");
								System.out.println(" Voulez-vous abandonner ? Yes / No" );
								giveUp = sc.nextLine();
						}
						System.out.println("");
						break;
					}
					
					System.out.println(HHH.GetPlayerName() + " vous attaque ! ");
					playerCreate.beAttacked(HHH.getAttack());

					System.out.println("Voici vos life points : " + playerCreate.getLifePoint());
					System.out.println("");
				}
				break;
			case 5:
				Piece SpaceX = new SalleNull("SpaceX", "Vous entrez dans la salle SpaceX" + ", désolé mais cette salle est vide.");
				System.out.println(SpaceX.GetDescription());
				System.out.println("");
				System.out.println(" Voulez-vous abandonner ? Yes / No" );
				giveUp = sc.nextLine();
				
				if(!giveUp.equals("Yes") || !giveUp.equals("No"))
				{
					System.out.println("Vous n'avez pas saisi la bonne valeur !");
					System.out.println(" Voulez-vous abandonner ? Yes / No" );
					giveUp = sc.nextLine();
				}
				System.out.println("");
				break;
			case 6:
				Piece Space9 = new SalleNull("Space9", "Vous entrez dans la salle Space9" + ", désolé mais cette salle est vide.");
				System.out.println(Space9.GetDescription());
				System.out.println("");
				System.out.println(" Voulez-vous abandonner ? Yes / No" );
				giveUp = sc.nextLine();
				
				if(!giveUp.equals("Yes") || !giveUp.equals("No"))
				{
						System.out.println("Vous n'avez pas saisi la bonne valeur !");
						System.out.println(" Voulez-vous abandonner ? Yes / No" );
						giveUp = sc.nextLine();
				}
				System.out.println("");
				break;
			case 7:
				Piece Inception = new SalleNull("Inception", "Vous entrez dans la salle Inception" + ", désolé mais cette salle est vide.");
				System.out.println(Inception.GetDescription());
				System.out.println("");
				System.out.println(" Voulez-vous abandonner ? Yes / No" );
				giveUp = sc.nextLine();
				
				if(!giveUp.equals("Yes") || !giveUp.equals("No"))
				{
						System.out.println("Vous n'avez pas saisi la bonne valeur !");
						System.out.println(" Voulez-vous abandonner ? Yes / No" );
						giveUp = sc.nextLine();
				}
				System.out.println("");
				break;
			case 8:
				Piece Interstellar = new SalleNull("Interstellar", "Vous entrez dans la salle Interstellar" + ", désolé mais cette salle est vide.");
				System.out.println(Interstellar.GetDescription());
				System.out.println("");
				System.out.println(" Voulez-vous abandonner ? Yes / No" );
				giveUp = sc.nextLine();
				
				if(!giveUp.equals("Yes") || !giveUp.equals("No"))
				{
						System.out.println("Vous n'avez pas saisi la bonne valeur !");
						System.out.println(" Voulez-vous abandonner ? Yes / No" );
						giveUp = sc.nextLine();
				}
				System.out.println("");
				break;
			case 9:
				Piece Shazam = new SalleTresor("Shazam", "Vous entrez dans la salle Shazam" + ", vous gagnez 30 pièces.");
				System.out.println(Shazam.GetDescription());
				playerCreate.setMoney(30);
				System.out.println("Votre argent est de " + playerCreate.getMoney() + " pièces");
				System.out.println("");
				System.out.println(" Voulez-vous abandonner ? Yes / No" );
				giveUp = sc.nextLine();
				
				if(!giveUp.equals("Yes") || !giveUp.equals("No"))
				{
						System.out.println("Vous n'avez pas saisi la bonne valeur !");
						System.out.println(" Voulez-vous abandonner ? Yes / No" );
						giveUp = sc.nextLine();
				}
				System.out.println("");
				break;
			case 10:				
				Piece HarryPotter = new SalleTresor("HarryPotter", "Vous entrez dans la salle HarryPotter" + ", vous gagnez 20 pièces.");
				System.out.println(HarryPotter.GetDescription());
				playerCreate.setMoney(20);
				System.out.println("Votre argent est de " + playerCreate.getMoney() + " pièces");
				System.out.println("");
				System.out.println(" Voulez-vous abandonner ? Yes / No" );
				giveUp = sc.nextLine();
				
				if(!giveUp.equals("Yes") || !giveUp.equals("No"))
				{
						System.out.println("Vous n'avez pas saisi la bonne valeur !");
						System.out.println(" Voulez-vous abandonner ? Yes / No" );
						giveUp = sc.nextLine();
				
				}
				System.out.println("");
				break;
			case 11:
				Piece MarcusKing = new SalleTresor("MarcusKing", "Vous entrez dans la salle MarcusKing" + ", vous gagnez 60 pièces.");
				System.out.println(MarcusKing.GetDescription());
				playerCreate.setMoney(60);
				System.out.println("Votre argent est de " + playerCreate.getMoney() + " pièces");
				System.out.println("");
				System.out.println(" Voulez-vous abandonner ? Yes / No" );
				giveUp = sc.nextLine();
				
				if(!giveUp.equals("Yes") || !giveUp.equals("No"))
				{
						System.out.println("Vous n'avez pas saisi la bonne valeur !");
						System.out.println(" Voulez-vous abandonner ? Yes / No" );
						giveUp = sc.nextLine();
					
				}
				System.out.println("");
				break;
			case 12:				
				Piece MichaelJackson = new SalleTresor("MichaelJackson", "Vous entrez dans la salle MichaelJackson" + ", vous gagnez 200 pièces.");
				System.out.println(MichaelJackson.GetDescription());
				playerCreate.setMoney(200);
				System.out.println("Votre argent est de " + playerCreate.getMoney() + " pièces");
				System.out.println("");
				System.out.println(" Voulez-vous abandonner ? Yes / No" );
				giveUp = sc.nextLine();
				
				if(!giveUp.equals("Yes") || !giveUp.equals("No"))
				{
						System.out.println("Vous n'avez pas saisi la bonne valeur !");
						System.out.println(" Voulez-vous abandonner ? Yes / No" );
						giveUp = sc.nextLine();
				}
				System.out.println("");
				break;
			default:
				break;
		}
	}
	
	public void CreateCouloir() 
	{
		int higher2 = 5;
		int lower2 = 0;
		int random2 = (int)(Math.random() * (higher2-lower2)) + lower2;
		
		switch(random2)
		{
			case 0:
				Piece couloir = new Couloir("Couloir", "Vous arrivez dans un couloir, vous vous approchez d'une salle ! Faites attention aux Monstres !");
				System.out.println(couloir.GetDescription());
				break;
			case 1:
				Piece couloir2 = new Couloir("Couloir", "Vous arrivez dans un couloir, vous vous approchez d'une salle ! Vous pouvez toucher le gros lot !");
				System.out.println(couloir2.GetDescription());
				break;
			case 2:
				Piece couloir3 = new Couloir("Couloir", "Vous arrivez dans un couloir, vous vous approchez d'une salle ! L'odeur du sang est proche !");
				System.out.println(couloir3.GetDescription());
				break;
			case 3:
				Piece couloir4 = new Couloir("Couloir", "Vous arrivez dans un couloir, vous vous approchez d'une salle ! Vous allez peut être devenir riche !");
				System.out.println(couloir4.GetDescription());
				break;
			case 4:
				Piece couloir5 = new Couloir("Couloir", "Vous arrivez dans un couloir, vous vous approchez d'une salle ! Je vous déconseille d'y entrer !");
				System.out.println(couloir5.GetDescription());
				break;
			case 5:
				Piece couloir6 = new Couloir("Couloir", "Vous arrivez dans un couloir, vous vous approchez d'une salle ! La Mort vient vous chercher !");
				System.out.println(couloir6.GetDescription());
				break;
			default:
				break;
		}
	}
}
