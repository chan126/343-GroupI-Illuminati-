import java.util.Scanner;

import cards.FaceDownCards;
import cards.IlluminatiCard;
import cards.IlluminatiCards;
import cards.UncontrolledGroups;

import java.util.ArrayList;
import java.util.Arrays;

public class Game
{
	public static void welcome(ArrayList<Player> players)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("WELCOME TO ILLUMINATI");
		
		System.out.println("Please enter the usernames of the people who will be playing: ");
		int playerCount = 1;
		System.out.print("Player " + playerCount + ": ");
		String username;
		while(!(username = in.nextLine()).isEmpty())
		{
			playerCount++;
			System.out.print("Player " + playerCount + ": ");
			players.add(new Player(username));
		}
		System.out.println("Player List: " + Arrays.toString(players.toArray()));
	}
	
	public static int menu(ArrayList<Player> players)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("\nMAIN MENU");
		System.out.println("1) Start Game");
		System.out.println("2) Settings");
		System.out.println("3) Exit Game");
		
		return in.nextInt();
	}
	
	public static void settings(ArrayList<Player> players)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("\nSETTINGS");
		System.out.println("1) Add players");
		System.out.println("2) Remove players");
		
		int choice = in.nextInt();
		
		if(choice == 1)
		{
			System.out.println("\nCurrent Player List: " + Arrays.toString(players.toArray()));
			System.out.print("Enter the player to add: ");
			String username = in.next();
			Player newPlayer = new Player(username);
			players.add(newPlayer);
			System.out.println("Added " + username.toUpperCase() + " to the game!");
		}
		else if(choice == 2)
		{
			System.out.println("\nCurrent Player List: " + Arrays.toString(players.toArray()));
			System.out.print("Enter the player number to remove: ");
			int indexRemove = in.nextInt();
			String username = players.get(indexRemove - 1).toString();
			players.remove(indexRemove - 1);
			System.out.println("Removed " + username.toUpperCase() + " from the game!");
		}
	}
	
	public static void exit()
	{
		System.out.println("Thanks for playing!");
	}
	
	// one player's turn
	public static void sequenceOfPlay(ArrayList<Player> players, Bank bank, FaceDownCards faceDown, UncontrolledGroups uncontrolled)
	{
//		Play goes counter-clockwise around the table.
//		1. Collect income on all cards that have an Income
//		number.
		
		
//		2. Draw a card. If it is a Special card, the player keeps
//		it. If the card is a Group, it is placed face-up in the
//		uncontrolled area.
		
//		3. Take two “actions.” See list, below.
		
//		4. Take any “free actions.” These do not count against
//		the two actions allowed during each turn. They may
//		be taken before, between, or after the two regular
//		actions. See below for list.
		
//		5. Transfer money. Part or all of any Group’s money
//		may be moved to an adjacent Group. Two money
//		transfers are allowed per turn.
		
//		6. Take special-power actions.
		
//		7. Add targets. Draw cards until there are two uncontrolled Groups. Discard any Specials drawn.
	}
	
	public static void playGame(ArrayList<Player> players)
	{
		Scanner in = new Scanner(System.in);
		
		//each player chooses their Illuminati card
		IlluminatiCards illuminati = new IlluminatiCards();
		Bank bank = new Bank();
		FaceDownCards faceDown = new FaceDownCards(); // contains all game cards (Group and Special)
		UncontrolledGroups uncontrolled = new UncontrolledGroups();
		
		for(Player player : players)
		{
			System.out.println("\n" + player + ", please choose your Illuminati group.");
			int i = 0;
			for(IlluminatiCard card : illuminati.getCards())
			{
				System.out.println(i+1 + ") " + card);
				i++;
			}
			int choice = in.nextInt();
			IlluminatiCard myCard = illuminati.remove(choice-1);
			player.setIlluminati(myCard);
			
			System.out.println(player.toString().toUpperCase() + " has selected " 
					+ myCard.toString().toUpperCase() + "!");
			
			player.collectIncome(myCard, bank);
			System.out.println("Collecting $" + myCard.getIncome() + " from the Bank...");
		}
		System.out.println("\nAll players have selected their Illuminati groups.");
		for(Player player : players)
		{
			System.out.println(player + ": " + player.getIlluminati());
		}
		
		faceDown.shuffle(); // WRITE THIS METHOD
		
		// DRAW FOUR CARDS FROM FACEDOWN AND MOVE THEM TO UNCONTROLLED
		// IF SPECIAL CARD IS DRAWN, RETURN TO FACEDOWN AND DRAW AGAIN
		
		for(Player player : players)
		{
			sequenceOfPlay(players, bank, faceDown, uncontrolled);
		}
	}
	
	public static void main(String[] args)
	{
		ArrayList<Player> players = new ArrayList<Player>();
		welcome(players);
		int choice = menu(players);
		
		while(choice == 1 || choice == 2 || choice == 3)
		{
			if(choice == 1)
				playGame(players);
			else if(choice == 2)
				settings(players);
			else if(choice == 3)
			{
				exit();
				break;
			}
			choice = menu(players);
		}		
	}
}
