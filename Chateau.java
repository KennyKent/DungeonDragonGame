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
			System.out.println("Vous avez gagn� la partie !!! Vous sortez de ce donjon et vous �tes riche !!!!");
		}
		
		if(playerCreate.getLifePoint() < 0)
		{
			System.out.println("Vous �tes mort ! Vous �tes un looser !!!");
		}
		
		if(giveUp.equals("Yes"))
		{
			System.out.println("Vous avez abandonn� ! Vous �tes un looser !!!");
		}
	}
	
	public void ChooseAndCreateYourCharacter()
	{
		System.out.println("Vous �tes quelqu'un de courageux, vous avez d�cid� de commencer une partie. Pr�f�rez-vous �tre un H�ros ou un Vilain ? H / V");
		
		System.out.println("H�ros : +30 de vie / +10 Attack / +10 money");
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
			System.out.println(" C'est votre chance num�ro " + compteur + " saississez la bonne valeur ou vous serez banni !");
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
			System.out.println("Votre personnage se pr�nomme " + playerCreate.GetPlayerName() + ", vous �tes un H�ros et vous allez d�s � pr�sent partir � l'aventure dans le Donjon.");
			System.out.println("Voici les caract�ristiques de votre personnage : Level : " + playerCreate.getLevel() + 
					", Life Points : " + playerCreate.getLifePoint() + ", Argent : " + playerCreate.getMoney() + ", Attack : " + playerCreate.getAttack());
		}
		else
		{
			System.out.println("Votre personnage se pr�nomme " + playerCreate.GetPlayerName() + ", vous �tes un Villain et vous allez d�s � pr�sent partir � l'aventure dans le Donjon.");
			System.out.println("Voici les caract�ristiques de votre personnage : Level : " + playerCreate.getLevel() + 
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
				System.out.println("Voici les caract�risques de " + Exorcist.GetPlayerName() + ", Level : " + Exorcist.getLevel() + " , LifePoint : " 
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
				Monsters TueurMasqu� = new Monsters("un Tueur Masqu�");
				Piece Scream = new SalleMonsters("Scream", "Vous entrez dans la salle Scream, " + TueurMasqu�.GetPlayerName() + " vous attaque.");
				System.out.println(Scream.GetDescription());
				System.out.println("");
				System.out.println("Voici les caract�risques de " + TueurMasqu�.GetPlayerName() + ", Level : " + TueurMasqu�.getLevel() + " , LifePoint : " 
						+ TueurMasqu�.getLifePoint() + ", Attack : " + TueurMasqu�.getAttack());
				System.out.println("");
				
				while(TueurMasqu�.getLifePoint() > 0)
				{
					System.out.println(" Vous attaquez ! ");
					System.out.println("");
					TueurMasqu�.setLifePoint(playerCreate.getAttack());
					System.out.println(" Attaque efficace !"+ " Voici les vies de " + TueurMasqu�.GetPlayerName() + " : " + TueurMasqu�.getLifePoint());
					System.out.println("");
					
					if(TueurMasqu�.getLifePoint() < 0)
					{
						System.out.println("Vous venez de tuer " + TueurMasqu�.GetPlayerName());
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
					System.out.println(TueurMasqu�.GetPlayerName() + " vous attaque ! ");
					System.out.println("");
					playerCreate.beAttacked(TueurMasqu�.getAttack());
					System.out.println("Voici vos life points : " + playerCreate.getLifePoint());
					System.out.println("");
				}
				break;
			case 3:
				Monsters Spiders = new Monsters("Spiders");
				Piece Scary = new SalleMonsters("Scary", "Vous entrez dans la salle Scary, " + Spiders.GetPlayerName() + " vous attaque.");
				System.out.println(Scary.GetDescription());
				System.out.println("Voici les caract�risques de " + Spiders.GetPlayerName() + ", Level : " + Spiders.getLevel() + " , LifePoint : " 
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
				System.out.println("Voici les caract�risques de " + HHH.GetPlayerName() + ", Level : " + HHH.getLevel() + " , LifePoint : " 
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
				Piece SpaceX = new SalleNull("SpaceX", "Vous entrez dans la salle SpaceX" + ", d�sol� mais cette salle est vide.");
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
				Piece Space9 = new SalleNull("Space9", "Vous entrez dans la salle Space9" + ", d�sol� mais cette salle est vide.");
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
				Piece Inception = new SalleNull("Inception", "Vous entrez dans la salle Inception" + ", d�sol� mais cette salle est vide.");
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
				Piece Interstellar = new SalleNull("Interstellar", "Vous entrez dans la salle Interstellar" + ", d�sol� mais cette salle est vide.");
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
				Piece Shazam = new SalleTresor("Shazam", "Vous entrez dans la salle Shazam" + ", vous gagnez 30 pi�ces.");
				System.out.println(Shazam.GetDescription());
				playerCreate.setMoney(30);
				System.out.println("Votre argent est de " + playerCreate.getMoney() + " pi�ces");
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
				Piece HarryPotter = new SalleTresor("HarryPotter", "Vous entrez dans la salle HarryPotter" + ", vous gagnez 20 pi�ces.");
				System.out.println(HarryPotter.GetDescription());
				playerCreate.setMoney(20);
				System.out.println("Votre argent est de " + playerCreate.getMoney() + " pi�ces");
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
				Piece MarcusKing = new SalleTresor("MarcusKing", "Vous entrez dans la salle MarcusKing" + ", vous gagnez 60 pi�ces.");
				System.out.println(MarcusKing.GetDescription());
				playerCreate.setMoney(60);
				System.out.println("Votre argent est de " + playerCreate.getMoney() + " pi�ces");
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
				Piece MichaelJackson = new SalleTresor("MichaelJackson", "Vous entrez dans la salle MichaelJackson" + ", vous gagnez 200 pi�ces.");
				System.out.println(MichaelJackson.GetDescription());
				playerCreate.setMoney(200);
				System.out.println("Votre argent est de " + playerCreate.getMoney() + " pi�ces");
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
				Piece couloir4 = new Couloir("Couloir", "Vous arrivez dans un couloir, vous vous approchez d'une salle ! Vous allez peut �tre devenir riche !");
				System.out.println(couloir4.GetDescription());
				break;
			case 4:
				Piece couloir5 = new Couloir("Couloir", "Vous arrivez dans un couloir, vous vous approchez d'une salle ! Je vous d�conseille d'y entrer !");
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
