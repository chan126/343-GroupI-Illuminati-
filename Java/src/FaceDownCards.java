package cards;

import java.util.ArrayList;

public class FaceDownCards
{
	public ArrayList<Card> faceDown;
	
	public FaceDownCards()
	{
		faceDown = new ArrayList<Card>();
		setGroups();
	}
	
	public void setGroups()
	{
		setSpecialCards();
		setGroupCards();
	}
	
	public void setSpecialCards()
	{
		// add all 15 Special Cards here
		SpecialCard Assassination = new SpecialCard("Assassination", 
				"Play this card immediately after the dice are rolled on any attempt (by any player) "
				+ "to destroy, control, or neutralize. That roll is immediately changed, retroactively, to a 2.");
		faceDown.add(Assassination);
		
		SpecialCard Bribery = new SpecialCard("Bribery", 
				"Play this card during your turn to automatically take control of any one uncontrolled group. "
				+ "Playing this card counts as an action.");
		faceDown.add(Bribery);
		
		SpecialCard Espionage = new SpecialCard("Computer Espionage", 
				"Play this card at any time to either count the money on any one group card OR "
				+ "examine all of one player's special cards.");
		faceDown.add(Espionage);
		
		SpecialCard Agent = new SpecialCard("Deep Agent", 
				"Play this card after privilege has been invoked. The privilege is totally abolished. "
				+ "That attack cannot be made privileged.");
		faceDown.add(Agent);
		
		SpecialCard Interference = new SpecialCard("Interference", 
				"You may interfere with one privileged attack. No other players may interfere.");
		faceDown.add(Interference);
		
		SpecialCard Interference2 = new SpecialCard("Interference", 
				"You may interfere with one privileged attack. No other players may interfere.");
		faceDown.add(Interference2);
		
		SpecialCard Manipulation = new SpecialCard("Market Manipulation", 
				"Play this card during your income phase to double all your groups' incomes, for that turn only. "
				+ "This card does not allow the I.R.S. to collect twice, or require the Post Office to pay twice.");
		faceDown.add(Manipulation);
		
		SpecialCard Media = new SpecialCard("Media Campaign", 
				"Play this card at any time to revive a group from the 'dead' pile. It becomes uncontrolled. "
				+ "(If the Servants of Cthulhu destroyed the group, it still counts as a destroyed group for victory. "
				+ "If they destroy it again, it counts again!)");
		faceDown.add(Media);
		
		SpecialCard Murphy = new SpecialCard("Murphy's Law", 
				"Play this card immediately after the dice are rolled on any attempt (by any player) "
				+ "to destroy, control, or neutralize. That roll is immediately changed, retroactively, "
				+ "to a 12.");
		faceDown.add(Murphy);
		
		SpecialCard Secrets = new SpecialCard("Secrets Man Was Not Meant To Know", 
				"Play this card when any other Special card is played, for ANY purpose. "
				+ "That card is immediately neutralized; it has no effect. Both cards are discarded.");
		faceDown.add(Secrets);
		
		SpecialCard Senate = new SpecialCard("Senate Investigating Committee", 
				"Play this card at the beginning of any other player's turn. That player loses "
				+ "his turn completely.");
		faceDown.add(Senate);
		
		SpecialCard Slush = new SpecialCard("Slush Fund", 
				"Exchange this card, at any time, for 15MB to be placed in your Illuminati treasury.");
		faceDown.add(Slush);
		
		SpecialCard Swiss = new SpecialCard("Swiss Bank Account", 
				"Exchange this card, at any time, for 25MB to be placed in your Illuminati treasury.");
		faceDown.add(Swiss);
		
		SpecialCard Whispering = new SpecialCard("Whispering Campaign", 
				"You may attempt to destroy a single group with Power 0. Roll attacking power vs. "
				+ "defending resistance, but a successful attack destroys the target. "
				+ "Playing this card is not an action, but the attack itself is an action.");
		faceDown.add(Whispering);
		
		SpecialCard White = new SpecialCard("White Collar Crime", 
				"Play this card at any time to reorganize all your money freely - that is, "
				+ "any amount(s) may be moved between any groups. You also get an extra 5MB which "
				+ "may be placed anywhere.");
		faceDown.add(White);
	}
	
	public void setGroupCards()
	{
		// add all 83 groups here
		GroupCard AAA = new GroupCard("American Autoduel Association", "");
		AAA.setAttackPower(1);
		AAA.setResistance(5);
		AAA.setIncome(1);
		AAA.addAlignment("Violent");
		AAA.addAlignment("Weird");
		faceDown.add(AAA);
		
		GroupCard ANA = new GroupCard("Anti-Nuclear Activists", 
				"+2 on any attempt to destroy Nuclear Power Companies.");
		ANA.setAttackPower(2);
		ANA.setResistance(5);
		ANA.setIncome(1);
		ANA.addAlignment("Liberal");
		faceDown.add(ANA);
    
    //...
	}

	public void shuffle()
	{
		// WRITE THIS FUNCTION
	}
}
