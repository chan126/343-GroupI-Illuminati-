import java.util.Scanner;

import cards.FaceDownCards;
import cards.GroupCard;
import cards.IlluminatiCard;
import cards.IlluminatiCards;
import cards.SpecialCard;
import cards.UncontrolledGroups;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
		System.out.println("\nThanks for playing!");
	}
	
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
		
// 		Remove the eight Illuminati cards from the deck; they
//		have dark backs to make them easy to find. Place them facedown on the table. Each player draws an Illuminati card,
//		places it face-up before him, and draws its indicated Income
//		from the bank, placing it on the card. 
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
		
		System.out.println("\nShuffling cards...");
//		Shuffle the remaining cards (including Specials) and
//		place them face-down in the center of the table.
		faceDown.shuffle();
		
//		Turn four cards face-up and place them in the center of the table.
//		These four Groups are the original “uncontrolled Groups".
		System.out.println("Drawing four cards from the face-down deck...");
		for(int i = 0; i < 4; i++)
		{
			if(faceDown.getCard(i) instanceof SpecialCard)
			{
				faceDown.addCard(faceDown.removeCard(i));
				i--;
			}
			else
				uncontrolled.addGroup((GroupCard)faceDown.removeCard(i));
		}
		System.out.println("The 4 Original Uncontrolled Groups are:");
		for(int i = 0; i < uncontrolled.getSize(); i++)
			System.out.println(i+1 + ") " + uncontrolled.getCard(i));
		System.out.println();
		
//		Each player rolls two dice; the player with the highest
//		roll plays first.
		Dice dice = new Dice();
		ArrayList<Integer> rolls = new ArrayList<>();
		for(int i = 0; i < players.size(); i++)
		{
			int roll = dice.roll();
			System.out.println(players.get(i) + " rolls " + roll);
			rolls.add(roll);
		}
		int indexOfMax = rolls.indexOf(Collections.max(rolls));
		Collections.swap(players, indexOfMax, 0); //moves the player with the highest roll to the front of the list		
		System.out.println(players.get(0).toString().toUpperCase() + " will go first!");
		
		sequenceOfPlay(players, bank, faceDown, uncontrolled);
	}
	
	public static void swap(ArrayList<Player> players)
	{
		
	}
	
	public static void main(String[] args)
	{
		ArrayList<Player> players = new ArrayList<Player>();
		welcome(players);
		int choice = menu(players);
		
		while(choice == 1 || choice == 2 || choice == 3)
		{
			if(choice == 1)
			{
				playGame(players);
				break;
			}
			else if(choice == 2)
				settings(players);
			else if(choice == 3)
			{
				break;
			}
			choice = menu(players);
		}	
		exit();
	}
}
