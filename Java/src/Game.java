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
	/**
	 * Sets up the players and their usernames.
	 * @param players - holds the Player objects; initially empty when called in MAIN
	 */
	public static void welcome(ArrayList<Player> players)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("WELCOME TO ILLUMINATI");
		
		// each player enters their username
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
		
		// once all players have been entered, display the list
		System.out.print("Player List: ");
		for(int i = 0; i < players.size(); i++)
		{
			System.out.print(players.get(i));
			if(i < players.size() - 1)
				System.out.print(", ");
		}
		System.out.println();
	}
	
	/**
	 * Main menu displays 3 main options to choose from
	 * @return 1, 2, or 3 decides Start Game, Settings, or Exit Game, respectively
	 */
	public static int menu()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("\nMAIN MENU");
		System.out.println("1) Start Game");
		System.out.println("2) Settings");
		System.out.println("3) Exit Game");
		
		return in.nextInt();
	}
	
	/**
	 * Settings of Illuminati
	 * Players can be added or removed
	 * @param players - the game's list of players
	 */
	public static void settings(ArrayList<Player> players)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("\nSETTINGS");
		System.out.println("1) Add players");
		System.out.println("2) Remove players");
		
		int choice = in.nextInt();
		
		if(choice == 1) // add a player
		{
			System.out.println("\nCurrent Player List: " + Arrays.toString(players.toArray()));
			System.out.print("Enter the player to add: ");
			String username = in.next();
			Player newPlayer = new Player(username);
			players.add(newPlayer);
			System.out.println("Added " + username.toUpperCase() + " to the game!");
		}
		else if(choice == 2) // remove a player
		{
			System.out.println("\nCurrent Player List: " + Arrays.toString(players.toArray()));
			System.out.print("Enter the player number to remove: ");
			int indexRemove = in.nextInt();
			String username = players.get(indexRemove - 1).toString();
			players.remove(indexRemove - 1);
			System.out.println("Removed " + username.toUpperCase() + " from the game!");
		}
	}

	/**
	 * simply prints out an exit statement that lets the players know that the game has exited
	 */
	public static void exit()
	{
		System.out.println("\nThanks for playing!");
	}
	
	/**
	 * sets up the game: choosing Illuminati groups, shuffling the face-down cards, 
	 * drawing 4 and adding them to the uncontrolled deck, deciding which player goes first by rolling the dice
	 * @param players - the ArrayList that holds the Players playing the game
	 */
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
		
		System.out.print("Player order: "); //display the order of play
		for(int i = 0; i < players.size(); i++)
		{
			System.out.print(players.get(i));
			if(i < players.size() - 1)
				System.out.print(", ");
		}
		System.out.println("\n");
		
		
		sequenceOfPlay(players, bank, faceDown, uncontrolled); 
	}
	
	/**
	 * goes through each player's turn until the game is over
	 * @param players - the ArrayList of Players participating in the game
	 * @param bank - the Bank that controls the economy
	 * @param faceDown - holds the Group and Special cards that have yet to be revealed
	 * @param uncontrolled - the cards that have been drawn from the face-down pile of cards
	 */
	public static void sequenceOfPlay(ArrayList<Player> players, Bank bank, FaceDownCards faceDown, UncontrolledGroups uncontrolled)
	{
//		Play goes counter-clockwise around the table.
		for(Player player : players)
		{
			System.out.println("It is now " + player.toString().toUpperCase() + "'s turn.");
			
//			1. Collect income on all cards that have an Income number.
			bank.withdraw(player.illuminati);
			System.out.println(player.illuminati + " collects $" + player.illuminati.getIncome() + " from the bank.");
			for(GroupCard group : player.groupCards) // collect income from each of the Player's Groups
			{
				bank.withdraw(group);
				System.out.println(group + " collects $" + group.getIncome() + " from the bank.");
			}
			
//			2. Draw a card. If it is a Special card, the player keeps it.
//			If the card is a Group, it is placed face-up in the uncontrolled area.
			Card drawn = faceDown.removeCard(0);
			if(drawn instanceof SpecialCard) // Special cards go to the Player who drew it
			{
				System.out.println("\nYou drew a Special Card!");
				System.out.println("Adding " + drawn + " to your Special Card deck...");
				player.addSpecialCard((SpecialCard)drawn);
			}
			else // Group cards go to the uncontrolled deck
			{
				System.out.println("\nYou drew a Group Card - " + drawn + "!");
				System.out.println("Adding " + drawn + " to the Uncontrolled Groups...");
				uncontrolled.addGroup((GroupCard)drawn);
			}
			
			System.out.println("-----------------------------------------------------------------------");
			System.out.println(uncontrolled); // display the current uncontrolled groups
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
				switch(choice)  // 
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
					  dropGroup(player); // FREE ACTION
					  i--; // this allows the action to count as a free action during the loop
					  break;
				  case 6: 
					  giveMoneyOrSpecials(player, players); // FREE ACTION
					  i--; // this allows the action to count as a free action during the loop
					  break;
				  case 7:
					  useSpecial(player); // FREE ACTION
					  i--; // this allows the action to count as a free action during the loop
					  break;
				  case 8:
					  passTurn(player, bank); // skip both turns and just collect 5 MB
					  i = 2; // immediately causes the loop to end
					  break;
			      default:
			    	  break;
				}
			}
			
//			7. Add targets. Draw cards until there are two uncontrolled Groups. Discard any Specials drawn.
			while(uncontrolled.getSize() < 2) // if there are less than 2 uncontrolled groups, continue drawing until there are at least 2
			{
				System.out.println("There are less than two uncontrolled Groups. Adding to pile...");
				drawn = faceDown.removeCard(0);
				if(drawn instanceof GroupCard) // ignores Special cards
				{
					System.out.println("You drew a Group Card - " + drawn + "!");
					System.out.println("Adding " + drawn + " to the Uncontrolled Groups...");
					uncontrolled.addGroup((GroupCard)drawn);
				}
				else
					faceDown.addCard(drawn); // Special cards get added back to the face-down pile
			}
			System.out.println(player + "'s turn is over.\n");
		}
	}
	
	/**
	 * the menu that asks the Player to perform an action
	 * @return an integeer from 1-8, that will perform its respective action
	 */
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
	
	/**
	 * a player decides to attack an uncontrolled group or a Player's group
	 * @param player - the player who is attacking
	 * @param players - the ArrayList of players
	 * @param uncontrolled - the pile of uncontrolled groups
	 */
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
			  attackToNeutralize(player, players, uncontrolled);
		      break;
		  case 3:
			  attackToDestroy(player, players, uncontrolled);
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
		
		// ask which group of the Player is attacking
		System.out.println("Which group of yours is attacking?");
		System.out.println("1) "+ player.illuminati);
		for(int i = 0; i < player.groupCards.size(); i++)
			System.out.println(i+2 + ") " + player.groupCards.get(i));
		
		int attacker = in.nextInt();
		Card attackingGroup;
		if(attacker == 1)
			attackingGroup = player.illuminati; // the attacking group can either be the Player's Illuminati, 
		else
			attackingGroup = player.groupCards.get(attacker - 2); // or it can be a Group
		
		System.out.println("\n" + uncontrolled); //display the uncontrolled groups
		for(int i = 0; i < uncontrolled.getSize(); i++)
			cardID.put(i+1, uncontrolled.getCard(i));
		
		int key = uncontrolled.getSize() + 1;		
		for(Player attackee : players) //display all the players' available groups
		{
			System.out.println(attackee.toString().toUpperCase() + "'S UNCONTROLLED GROUPS:"); 
			for(GroupCard group : attackee.groupCards) // display all the available groups to control
			{
				if(group.getOut() > 0)				   // doesn't display the cards whose arrows are all accupied (out variable = 0)
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
		Player attackeePlayer = playerID.get(attack); // identify the player being attacked
		GroupCard attackeeGroup = cardID.get(attack); // identify the group being attacked
		
		System.out.println("\n" + attackingGroup + " will attempt to control " + attackeeGroup + ".");
		
		// roll the dice and display the result
		int requiredRoll = attackingGroup.getAttackPower() - attackeeGroup.getResistance();
		System.out.println(attackingGroup + "'s attack power: " + attackingGroup.getAttackPower());
		System.out.println(attackeeGroup + "'s resistance: " + attackeeGroup.getResistance());
		System.out.println("Required roll: " + requiredRoll);
		
		int attackRoll = dice.roll();
		if(attackRoll == 11 || attackRoll == 12) // rolling 11 or 12 are automatic failures
		{
			System.out.println("You rolled " + attackRoll + " - AUTOMATIC FAILURE");
		}
		else if(attackRoll <= requiredRoll) // the roll must be at most the required roll to be successful
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
	
	public static void attackToNeutralize(Player player, ArrayList<Player> players, UncontrolledGroups uncontrolled)
	{
		System.out.println("-------------------- ATTACK TO NEUTRALIZE --------------------");
	}
	
	public static void attackToDestroy(Player player, ArrayList<Player> players, UncontrolledGroups uncontrolled)
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
	
	/**
	 * drops a group and its puppets from a Player's power structure
	 * @param player
	 */
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
	
	/**
	 * a player can choose to give away money or a Special card of theirs
	 * @param player - the player who wants to give away money or a Special card
	 * @param players - the list of players playing
	 */
	public static void giveMoneyOrSpecials(Player player, ArrayList<Player> players)
	{
		Scanner in = new Scanner(System.in);
		
		// choose the recipient
		System.out.println("Choose a player to make the transfer to: ");
		for(int i = 0; i < players.size(); i++)
			System.out.println(i+1 + ") " + players.get(i));
		int recipientIndex  = in.nextInt() - 1;
		
		// choose what is being transferred
		System.out.println("What would you like to transfer?"
				+ "\n1) Special card"
				+ "\n2) Money");
		int transferChoice = in.nextInt();
		if(transferChoice == 1) // transfer a Special card
		{
			System.out.println("Choose the Special card you would like to transfer.");
			for(int i = 0; i < player.specialCards.size(); i++)
				System.out.println(i+1 + ") " + player.specialCards.get(i));
			int cardIndex = in.nextInt();
			SpecialCard special = player.specialCards.remove(cardIndex - 1); //remove from player
			players.get(recipientIndex).addSpecialCard(special); //transfer to new player
			
			System.out.println("Transferred " + special + " to " + players.get(recipientIndex) + "!");
		}
		else if(transferChoice == 2) // transfer money
		{
			System.out.print("Enter the amount you would like to transfer: $");
			int amount = in.nextInt();
			player.illuminati.removeFromBalance(amount);
			players.get(recipientIndex).illuminati.addToBalance(amount);
			
			System.out.println("Transferred $" + amount + " to " + players.get(recipientIndex) + "!");
		}
	}
	
	/**
	 * uses a Special card of the player's choice
	 * @param player - the player using the Special card
	 */
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
	
	/**
	 * a player can choose to skip their turn and instead collect 5 MB
	 * @param player - the player skipping their turn
	 * @param bank - gives the player 5 MB
	 */
	public static void passTurn(Player player, Bank bank)
	{
		System.out.println("You have chosen to pass this turn.");
		System.out.println("Collecting 5 MB from the bank...");
		bank.withdraw(player.illuminati);
	}
	
	/**
	 * MAIN METHOD
	 */
	public static void main(String[] args)
	{
		ArrayList<Player> players = new ArrayList<Player>();
		welcome(players); // sets up the players and their usernames
		int choice = menu(); // Play Game, Settings, or Exit Game
		
		while(choice == 1 || choice == 2 || choice == 3)
		{
			if(choice == 1) // Play Game
			{
				playGame(players);
				break;
			}
			else if(choice == 2) // Settings
				settings(players);
			else if(choice == 3) // Exit Game
			{
				break;
			}
			choice = menu();
		}	
		exit();
	}
}
