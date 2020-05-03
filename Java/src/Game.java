import java.util.Scanner;

import cards.Card;
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
import java.util.HashMap;

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
		System.out.print("Player List: ");
		for(int i = 0; i < players.size(); i++)
		{
			System.out.print(players.get(i));
			if(i < players.size() - 1)
				System.out.print(", ");
		}
		System.out.println();
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
	
	public static void playGame(ArrayList<Player> players)
	{
		System.out.println("\nSTARTING GAME");
		Scanner in = new Scanner(System.in);
		
		IlluminatiCards illuminati = new IlluminatiCards(); // declares and instantiates the 8 Illuminati cards
		Bank bank = new Bank(); // declares and instantiates the Bank that has a total of 1106 MB
		FaceDownCards faceDown = new FaceDownCards(); // contains all game cards (Group and Special)
		UncontrolledGroups uncontrolled = new UncontrolledGroups(); // the uncontrolled deck, starts off empty
		
// 		Remove the eight Illuminati cards from the deck; they
//		have dark backs to make them easy to find. Place them facedown on the table. Each player draws an Illuminati card,
//		places it face-up before him, and draws its indicated Income
//		from the bank, placing it on the card. 
		for(Player player : players)
		{
			System.out.println("\n" + player + ", please choose your Illuminati group.");
			int i = 0;
			for(IlluminatiCard card : illuminati.getCards()) // displays all available Illuminati cards
			{
				System.out.println(i+1 + ") " + card);
				i++;
			}
			int choice = in.nextInt();
			IlluminatiCard myCard = illuminati.remove(choice-1); // removes the chosen Illuminati card from the deck
			player.setIlluminati(myCard);			     // and sets it as the Player's Illumninati card
			
			System.out.println(player.toString().toUpperCase() + " has selected " 
					+ myCard.toString().toUpperCase() + "!");
			
			player.collectIncome(myCard, bank); // collects the Illuminati's income amount from the bank
			System.out.println("Collecting $" + myCard.getIncome() + " from the Bank...");
		}
		System.out.println("\nAll players have selected their Illuminati groups.");
		for(Player player : players) // once all players choose their Illuminati, they are printed out
			System.out.println(player + ": " + player.getIlluminati());
		
//		Shuffle the remaining cards (including Specials) and
//		place them face-down in the center of the table.
		System.out.println("\nShuffling cards...");
		faceDown.shuffle();
		
//		Turn four cards face-up and place them in the center of the table.
//		These four Groups are the original “uncontrolled Groups".
		System.out.println("\nDrawing four cards from the face-down deck...");
		for(int i = 0; i < 4; i++)
		{
			if(faceDown.getCard(i) instanceof SpecialCard) // Special cards are discarded at the beginning of the game
			{					       // when drawing the 4 Original Uncontrolled Groups
				faceDown.addCard(faceDown.removeCard(i));
				i--;
			}
			else
				uncontrolled.addGroup((GroupCard)faceDown.removeCard(i));
		}
		System.out.println("\nThe 4 Original Uncontrolled Groups are:");
		for(int i = 0; i < uncontrolled.getSize(); i++)
			System.out.println(i+1 + ") " + uncontrolled.getCard(i));
		System.out.println();
		
//		Each player rolls two dice; the player with the highest
//		roll plays first.
		Dice dice = new Dice();
		ArrayList<Integer> rolls = new ArrayList<>(); // keeps track of each player's dice rolls
		for(int i = 0; i < players.size(); i++)
		{
			int roll = dice.roll(); // a random number from 1-12
			System.out.println(players.get(i) + " rolls " + roll);
			rolls.add(roll);
		}
		int indexOfMax = rolls.indexOf(Collections.max(rolls)); // gets the index of the highest roll in the rolls ArrayList
		Collections.swap(players, indexOfMax, 0); //moves the player with the highest roll to the front of the list		
		System.out.println("\n" + players.get(0).toString().toUpperCase() + " will go first!");
		
		System.out.print("Player order: "); //displasy the order of play
		for(int i = 0; i < players.size(); i++)
		{
			System.out.print(players.get(i));
			if(i < players.size() - 1)
				System.out.print(", ");
		}
		System.out.println("\n");
		
		
		sequenceOfPlay(players, bank, faceDown, uncontrolled); 
	}
	
	public static void sequenceOfPlay(ArrayList<Player> players, Bank bank, FaceDownCards faceDown, UncontrolledGroups uncontrolled)
	{
//		Play goes counter-clockwise around the table.
		for(Player player : players)
		{
			System.out.println("It is now " + player.toString().toUpperCase() + "'s turn.");
//			1. Collect income on all cards that have an Income number.
			bank.withdraw(player.illuminati);
			System.out.println(player.illuminati + " collects $" + player.illuminati.getIncome() + " from the bank.");
			for(GroupCard group : player.groupCards)
			{
				bank.withdraw(group);
				System.out.println(group + " collects $" + group.getIncome() + " from the bank.");
			}
			
//			2. Draw a card. If it is a Special card, the player keeps it.
//			If the card is a Group, it is placed face-up in the uncontrolled area.
			Card drawn = faceDown.removeCard(0);
			if(drawn instanceof SpecialCard)
			{
				System.out.println("\nYou drew a Special Card!");
				System.out.println("Adding " + drawn + " to your Special Card deck...");
				player.addSpecialCard((SpecialCard)drawn);
			}
			else
			{
				System.out.println("\nYou drew a Group Card - " + drawn + "!");
				System.out.println("Adding " + drawn + " to the Uncontrolled Groups...");
				uncontrolled.addGroup((GroupCard)drawn);
			}
			
			System.out.println("-----------------------------------------------------------------------");
			System.out.println(uncontrolled);
			System.out.println("-----------------------------------------------------------------------");
			
//			3. Take two “actions.” See list, below.
//			4. Take any “free actions.” These do not count against the two actions allowed during each turn. 
//			They may be taken before, between, or after the two regular actions. See below for list.
//			5. Transfer money. Part or all of any Group’s money
//			may be moved to an adjacent Group. Two money
//			transfers are allowed per turn.
//			6. Take special-power actions.
			System.out.println("\n" + player + ", take two actions. ");
			for(int i = 0; i < 2; i++)
			{
				int choice = actionMenu();
				switch(choice) 
				{
				  case 1:
				      attackGroup(player, players, uncontrolled);
				      break;
				  case 2:
				      transferMoney(player);
				      break;
				  case 3:
					  moveGroup(player);
				      break;
				  case 4:
					  giveGroup();
					  break;
				  case 5:
					  dropGroup(player);
					  i--;
					  break;
				  case 6: 
					  giveMoneyOrSpecials(player, players);
					  i--;
					  break;
				  case 7:
					  useSpecial(player);
					  i--;
					  break;
				  case 8:
					  passTurn(player, bank);
					  i = 2;
					  break;
			      default:
			    	  break;
				}
			}
			
//			7. Add targets. Draw cards until there are two uncontrolled Groups. Discard any Specials drawn.
			while(uncontrolled.getSize() < 2)
			{
				System.out.println("There are less than two uncontrolled Groups. Adding to pile...");
				drawn = faceDown.removeCard(0);
				if(drawn instanceof GroupCard)
				{
					System.out.println("You drew a Group Card - " + drawn + "!");
					System.out.println("Adding " + drawn + " to the Uncontrolled Groups...");
					uncontrolled.addGroup((GroupCard)drawn);
				}
			}
			System.out.println(player + "'s turn is over.\n");
		}
	}
	
	public static int actionMenu()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("\nREGULAR ACTIONS:"
				+ "\n1) Attack a Group" //PARTIALLY COMPLETE
				+ "\n2) Transfer Money"
				+ "\n3) Move a Group"
				+ "\n4) Give a Group away"
				+ "\nFREE ACTIONS:"
				+ "\n5) Drop a Group" //COMPLETE
				+ "\n6) Give away money or Specials" //COMPLETE
				+ "\n7) Use a Special card" //PARTIALLY COMPLETE
				+ "\n8) PASS [and collect 5MB]"); //COMPLETE
		return in.nextInt();
	}
	
	public static void attackGroup(Player player, ArrayList<Player> players, UncontrolledGroups uncontrolled)
	{
		Scanner in = new Scanner(System.in);
		
		Dice dice = new Dice();
		System.out.println("1) Attack to Control"
				+ "\n2) Attack to Neutralize"
				+ "\n3) Attack to Destroy");
		int attackType = in.nextInt();
		
		switch(attackType) 
		{
		  case 1:
		      attackToControl(player, players, uncontrolled);
		      break;
		  case 2:
			  attackToNeutralize(player, players);
		      break;
		  case 3:
			  attackToDestroy(player, players);
		      break;
	      default:
	    	  break;
		}
	}
	
	public static void attackToControl(Player player, ArrayList<Player> players, UncontrolledGroups uncontrolled)
	{
		Scanner in = new Scanner(System.in);
		Dice dice = new Dice();
		HashMap<Integer, GroupCard> cardID = new HashMap<>();
		HashMap<Integer, Player> playerID = new HashMap<>();
		
		System.out.println("-------------------- ATTACK TO CONTROL --------------------");
		
		System.out.println("Which group of yours is attacking?");
		System.out.println("1) "+ player.illuminati);
		for(int i = 0; i < player.groupCards.size(); i++)
			System.out.println(i+2 + ") " + player.groupCards.get(i));
		
		int attacker = in.nextInt();
		Card attackingGroup;
		if(attacker == 1)
			attackingGroup = player.illuminati;
		else
			attackingGroup = player.groupCards.get(attacker - 2);
		
		System.out.println("\n" + uncontrolled); //display the uncontrolled groups
		for(int i = 0; i < uncontrolled.getSize(); i++)
			cardID.put(i+1, uncontrolled.getCard(i));
		
		int key = uncontrolled.getSize() + 1;		
		for(Player attackee : players) //display all the players' available groups
		{
			System.out.println(attackee.toString().toUpperCase() + "'S UNCONTROLLED GROUPS:");
			for(GroupCard group : attackee.groupCards)
			{
				if(group.getOut() > 0)
				{
					cardID.put(key, group);
					playerID.put(key, player);
					System.out.println("\n" + key + ") " + group);
					key++;
				}
			}
		}
		System.out.print("Enter the group to attack: ");
		int attack = in.nextInt();
		Player attackeePlayer = playerID.get(attack);
		GroupCard attackeeGroup = cardID.get(attack);
		
		System.out.println("\n" + attackingGroup + " will attempt to control " + attackeeGroup + ".");
		
		int requiredRoll = attackingGroup.getAttackPower() - attackeeGroup.getResistance();
		System.out.println(attackingGroup + "'s attack power: " + attackingGroup.getAttackPower());
		System.out.println(attackeeGroup + "'s resistance: " + attackeeGroup.getResistance());
		System.out.println("Required roll: " + requiredRoll);
		
		int attackRoll = dice.roll();
		if(attackRoll == 11 || attackRoll == 12)
		{
			System.out.println("You rolled " + attackRoll + " - AUTOMATIC FAILURE");
		}
		else if(attackRoll <= requiredRoll)
		{
			System.out.println("You rolled " + attackRoll + " - SUCCESS!");
			//attackeePlayer.groupCards.remove(attackeeGroup);
			//player.addGroupCard(attackeeGroup);
		}
		else if(attackRoll > requiredRoll)
		{
			System.out.println("You rolled " + attackRoll + " - The attack failed!");
		}
		
	}
	
	public static void attackToNeutralize(Player player, ArrayList<Player> players)
	{
		System.out.println("-------------------- ATTACK TO NEUTRALIZE --------------------");
	}
	
	public static void attackToDestroy(Player player, ArrayList<Player> players)
	{
		System.out.println("-------------------- ATTACK TO DESTROY --------------------");
	}
	
	public static void transferMoney(Player player)
	{
		
	}
	
	public static void moveGroup(Player player)
	{
		
	}
	
	public static void giveGroup()
	{
		
	}
	
	public static void dropGroup(Player player)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Choose a group to drop: ");
		for(int i = 0; i < player.groupCards.size(); i++)
			System.out.println(i+1 + ") " + player.groupCards.get(i));
		int index = in.nextInt();
		GroupCard removed = player.groupCards.remove(index); //remove card
		for(GroupCard puppet : removed.puppets)
			player.removeGroupCard(puppet); //removing the puppets as well
	}
	
	public static void giveMoneyOrSpecials(Player player, ArrayList<Player> players)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Choose a player to make the transfer to: ");
		for(int i = 0; i < players.size(); i++)
			System.out.println(i+1 + ") " + players.get(i));
		int recipientIndex  = in.nextInt() - 1;
		
		System.out.println("What would you like to transfer?"
				+ "\n1) Special card"
				+ "\n2) Money");
		int transferChoice = in.nextInt();
		if(transferChoice == 1)
		{
			System.out.println("Choose the Special card you would like to transfer.");
			for(int i = 0; i < player.specialCards.size(); i++)
				System.out.println(i+1 + ") " + player.specialCards.get(i));
			int cardIndex = in.nextInt();
			SpecialCard special = player.specialCards.remove(cardIndex - 1); //remove from player
			players.get(recipientIndex).addSpecialCard(special); //transfer to new player
			
			System.out.println("Transferred " + special + " to " + players.get(recipientIndex) + "!");
		}
		else if(transferChoice == 2)
		{
			System.out.print("Enter the amount you would like to transfer: $");
			int amount = in.nextInt();
			player.illuminati.removeFromBalance(amount);
			players.get(recipientIndex).illuminati.addToBalance(amount);
			
			System.out.println("Transferred $" + amount + " to " + players.get(recipientIndex) + "!");
		}
	}
	
	public static void useSpecial(Player player)
	{		
		if(player.specialCards.size() > 0)
		{
			Scanner in = new Scanner(System.in);
			System.out.println("Which Special card would you like to use?");
			for(int i = 0; i < player.specialCards.size(); i++)
				System.out.println(i+1 + ") " + player.specialCards.get(i));
			int specialIndex = in.nextInt() - 1;
			
			System.out.println("You have chosen " + player.specialCards.get(specialIndex) + "!\n");
		}
		else
			System.out.println("You have no Special cards to use...\n");
	}
	
	public static void passTurn(Player player, Bank bank)
	{
		System.out.println("You have chosen to pass this turn.");
		System.out.println("Collecting 5 MB from the bank...");
		bank.withdraw(player.illuminati);
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
