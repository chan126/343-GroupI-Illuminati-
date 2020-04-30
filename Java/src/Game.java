import java.util.Scanner;
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
			System.out.println("Added " + username + " to the game!");
		}
		else if(choice == 2)
		{
			System.out.println("\nCurrent Player List: " + Arrays.toString(players.toArray()));
			System.out.print("Enter the player number to remove: ");
			int indexRemove = in.nextInt();
			String username = players.get(indexRemove - 1).toString();
			players.remove(indexRemove - 1);
			System.out.println("Removed " + username + " from the game!");
		}
	}
	
	public static void exit()
	{
		System.out.println("Thanks for playing!");
	}
	
	public static void sequenceOfPlay(ArrayList<Player> players)
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
	
	public static void main(String[] args)
	{
		ArrayList<Player> players = new ArrayList<Player>();
		welcome(players);
		int choice = menu(players);
		
		while(choice == 1 || choice == 2 || choice == 3)
		{
			if(choice == 1)
				sequenceOfPlay(players);
			else if(choice == 2)
				settings(players);
			else if(choice == 3)
			{
				exit();
				break;
			}
			choice = menu(players);
		}
		
		System.out.println("\nPlayer List: " + Arrays.toString(players.toArray()));
	}
}
