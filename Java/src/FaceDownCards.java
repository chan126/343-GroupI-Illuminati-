package pack;

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
		
		GroupCard AA = new GroupCard("Antiwar Activist");
		//AA.setAttackPower(0);
		AA.setResistance(3);
		AA.setIncome(1);
		AA.addAlignment("Peaceful");
		AA.addAlignment("Liberal");
		faceDown.add(AA);
		
		GroupCard BM = new GroupCard("Big Media");
		BM.setAttackPower(4);
		BM.setTransferPower(3);
		BM.setResistance(6);
		BM.setIncome(3);
		BM.addAlignment("Liberal");
		BM.addAlignment("Straight");
		faceDown.add(BM);
		
		GroupCard BS = new GroupCard("Boy Sprouts");
		BM.setResistance(3);
		BM.setIncome(1);
		BM.addAlignment("Straight");
		BM.addAlignment("Peaceful");
		faceDown.add(BS);
		
		GroupCard CALI = new GroupCard("California");
		CALI.setAttackPower(5);
		CALI.setResistance(4);
		CALI.setIncome(5);
		CALI.addAlignment("Liberal");
		CALI.addAlignment("weird");
		CALI.addAlignment("Government");
		faceDown.add(CALI);
		
		GroupCard CA = new GroupCard("CFL-AIO");
		CA.setAttackPower(6);
		CA.setResistance(5);
		CA.setIncome(3);
		CA.addAlignment("Liberal");
		faceDown.add(CA);
		
		GroupCard CCD = new GroupCard("Chinese Campaign Donors", 
				"Treat this group as Government when it attempts to control a Government group.");
		CCD.setAttackPower(3);
		CCD.setResistance(2);
		CCD.setIncome(3);
		CCD.addAlignment("Communist");
		faceDown.add(CCD);
		
		GroupCard CIA = new GroupCard("C.I.A.");
		CIA.setAttackPower(6);
		CIA.setTransferPower(4);
		CIA.setIncome(0);
		CIA.addAlignment("Government");
		CIA.addAlignment("Violent");
		faceDown.add(CIA);
		
		GroupCard CLA = new GroupCard("Clone Arrangers");
		CLA.setAttackPower(6);
		CLA.setTransferPower(2);
		CLA.setResistance(6);
		CLA.setIncome(1);
		CLA.addAlignment("Violent");
		CLA.addAlignment("Communist");
		CLA.addAlignment("Criminal");
		faceDown.add(CLA);
		
		GroupCard COB = new GroupCard("Comin Books");
		COB.setAttackPower(1);
		COB.setResistance(1);
		COB.setIncome(2);
		COB.addAlignment("Weird");
		COB.addAlignment("Violent");
		faceDown.add(COB);
		
		GroupCard COW = new GroupCard("Congressional Wives");
		COW.setAttackPower(1);
		COW.setResistance(4);
		COW.setIncome(1);
		COW.addAlignment("Conservative");
		COW.addAlignment("Straight");
		faceDown.add(COW);
		
		GroupCard COS = new GroupCard("Convenience Stores");
		COS.setAttackPower(1);
		COS.setResistance(4);
		COS.setIncome(3);
		COS.addAlignment("Straight");
		faceDown.add(COS);
		
		GroupCard COPSH = new GroupCard("Copy Shops");
		COPSH.setAttackPower(1);
		COPSH.setResistance(3);
		COPSH.setIncome(4);
		COPSH.addAlignment("Peaceful");
		faceDown.add(COPSH);
		
		GroupCard CG = new GroupCard("Cycle Gangs");
		CG.setResistance(4);
		CG.setIncome(0);
		CG.addAlignment("Violent");
		CG.addAlignment("Weird");
		
		GroupCard DEM = new GroupCard("Democrats");
		DEM.setAttackPower(5);
		DEM.setResistance(4);
		DEM.setIncome(3);
		DEM.addAlignment("Liberal");
		faceDown.add(DEM);
		
		GroupCard ECOG = new GroupCard("Eco-Guerrillas");
		ECOG.setResistance(6);
		ECOG.setIncome(1);
		ECOG.addAlignment("Liberal");
		ECOG.addAlignment("Violent");
		ECOG.addAlignment("Weird");
		faceDown.add(ECOG);
		
		GroupCard EV = new GroupCard("Empty Vee");
		EV.setAttackPower(3);
		EV.setResistance(3);
		EV.setIncome(4);
		faceDown.add(EV);
		
		GroupCard EGF = new GroupCard("Evil Geniuses for a Better Tomorrow", 
				"+4 for any attempt to control, neutralize, or destroy the Orbital Mind Control Lasers");
		EGF.setAttackPower(0);
		EGF.setTransferPower(2);
		EGF.setResistance(6);
		EGF.setIncome(3);
		EGF.addAlignment("Violent");
		EGF.addAlignment("Weird");
		faceDown.add(EGF);
		
		GroupCard FFC = new GroupCard("Fast Food Chains");
		FFC.setAttackPower(2);
		FFC.setResistance(4);
		FFC.setIncome(3);
		FFC.addAlignment("Straight");
		faceDown.add(FFC);
		
		GroupCard FBI = new GroupCard("F.B.I.");
		FBI.setAttackPower(4);
		FBI.setTransferPower(2);
		FBI.setIncome(0);
		FBI.addAlignment("Government");
		FBI.addAlignment("Straight");
		faceDown.add(FBI);
		
		GroupCard FED = new GroupCard("Federal Reserve");
		FED.setAttackPower(5);
		FED.setTransferPower(3);
		FED.setResistance(7);
		FED.setIncome(6);
		FED.addAlignment("Government");
		faceDown.add(FED);
		
		GroupCard FEM = new GroupCard("Feminists");
		FEM.setAttackPower(2);
		FEM.setResistance(2);
		FEM.setIncome(1);
		FEM.addAlignment("Liberal");
		faceDown.add(FEM);
		
		GroupCard FF = new GroupCard("Fiendish Fluoridators");
		FF.setAttackPower(3);
		FF.setResistance(5);
		FF.setIncome(1);
		FF.addAlignment("Communist");
		FF.addAlignment("Fanatic");
		faceDown.add(FF);
		
		GroupCard FE = new GroupCard("Flat Earthers");
		FE.setAttackPower(1);
		FE.setResistance(2);
		FE.setIncome(1);
		FE.addAlignment("Weird");
		FE.addAlignment("Conservative");
		faceDown.add(FE);
		
		GroupCard FMC = new GroupCard("Fnord Motor Company");
		FMC.setAttackPower(2);
		FMC.setResistance(4);
		FMC.setIncome(2);
		FMC.addAlignment("Peaceful");
		faceDown.add(FMC);
		
		GroupCard FO = new GroupCard("Fraternal Orders");
		FO.setAttackPower(3);
		FO.setResistance(5);
		FO.setIncome(2);
		FO.addAlignment("Conservative");
		faceDown.add(FO);
		
		GroupCard GM = new GroupCard("Girlie Magazines");
		GM.setAttackPower(2);
		GM.setResistance(2);
		GM.setIncome(3);
		GM.addAlignment("Liberal");
		faceDown.add(GM);
		
		GroupCard GF = new GroupCard("Goldfish Fanciers");
		GF.setResistance(4);
		GF.setIncome(1);
		GF.addAlignment("Peaceful");
		GF.addAlignment("Fanatic");
		faceDown.add(GF);
		
		GroupCard GUL = new GroupCard("Gun Lobby", "Normal Resistance3; against any Liberal, Communist, or Weird group, resistance 10");
		GUL.setAttackPower(1);
		GUL.setResistance(10); 
		GUL.setIncome(1);
		GUL.addAlignment("Conservative");
		GUL.addAlignment("Violent");
		faceDown.add(GUL);
		
		GroupCard HACK = new GroupCard("Hackers", "+3 on any attempt to neutralize any group");
		HACK.setAttackPower(1);
		HACK.setTransferPower(1);
		HACK.setIncome(2);
		HACK.addAlignment("Weird");
		HACK.addAlignment("Fanatic");
		faceDown.add(HACK);
		
		GroupCard HFS = new GroupCard("Health Food Stores");
		HFS.setAttackPower(1);
		HFS.setResistance(3);
		HFS.setIncome(2);
		HFS.addAlignment("Liberal");
		faceDown.add(HFS);
		
		GroupCard HWD = new GroupCard("Hollywood");
		HWD.setAttackPower(2);
		HWD.setResistance(0);
		HWD.setIncome(5);
		HWD.addAlignment("Liberal");
		faceDown.add(HWD);
		
		GroupCard INTEL = new GroupCard("Intellectuals");
		INTEL.setAttackPower(3);
		INTEL.setIncome(1);
		INTEL.addAlignment("Weird");
		INTEL.addAlignment("Fanatic");
		faceDown.add(INTEL);
		
		GroupCard ICS = new GroupCard("International Cocaine Smugglers","+4 on any attempt to control Punk Rockers, Cycle Gangs, or Hollywood.");
		ICS.setAttackPower(3);
		ICS.setResistance(5);
		ICS.setIncome(5);
		ICS.addAlignment("Criminal");
		faceDown.add(ICS);
		
		GroupCard ICC = new GroupCard("International Communist Conspiracy", "+3 on any attempt to control and Communist group");
		ICC.setAttackPower(7);
		ICC.setResistance(8);
		ICC.setIncome(6);
		ICC.addAlignment("Communist");
		faceDown.add(ICC);
		
		GroupCard IRS = new GroupCard("I.R.S", "Ownin player may tax each oppenoent 2MB on his own income phase. Tax may come from any group. If a player has no money, he owes no tax");
		IRS.setAttackPower(5);
		IRS.setTransferPower(3);
		IRS.setResistance(5);
		IRS.setIncome(2);
		faceDown.add(IRS);
		
		GroupCard JM = new GroupCard("Junk Mail", "+4 on any attempt to control the Post Office");
		JM.setAttackPower(1);
		JM.setResistance(3);
		JM.setIncome(2);
		JM.addAlignment("Criminal");
		faceDown.add(JM);
		
		GroupCard KGB = new GroupCard("KGB", "+2 on any attempt to destroy any group");
		KGB.setAttackPower(2);
		KGB.setTransferPower(2);
		KGB.setIncome(0);
		KGB.addAlignment("Communist");
		KGB.addAlignment("Violent");
		faceDown.add(KGB);
		
		GroupCard KKK = new GroupCard("KKK");
		KKK.setAttackPower(2);
		KKK.setResistance(5);
		KKK.setIncome(1);
		KKK.addAlignment("Conservative");
		KKK.addAlignment("Violent");
		faceDown.add(KKK);
		
		GroupCard L4S = new GroupCard("L-4 Society","+4 for direct control, neutralization, or destruction of Orbital Mind Control Lasers");
		L4S.setAttackPower(1);
		L4S.setResistance(2);
		L4S.setIncome(0);
		L4S.addAlignment("Weird");
		faceDown.add(L4S);
	
		GroupCard LIB = new GroupCard("Libertarians");
		LIB.setAttackPower(1);
		LIB.setResistance(4);
		LIB.setIncome(1);
		LIB.addAlignment("Fanatic");
		faceDown.add(LIB);
		
		GroupCard LOS = new GroupCard("Loan Sharks");
		LOS.setAttackPower(5);
		LOS.setResistance(5);
		LOS.setIncome(6);
		LOS.addAlignment("Criminal");
		LOS.addAlignment("Violent");
		faceDown.add(LOS);
		
		GroupCard LPD = new GroupCard("Local Police Departments");
		LPD.setAttackPower(4);
		LPD.setIncome(1);
		LPD.addAlignment("Conservative");
		LPD.addAlignment("Straight");
		LPD.addAlignment("Violent");
		faceDown.add(LPD);
		
		GroupCard MA = new GroupCard("Madison Avenue");
		MA.setAttackPower(3);
		MA.setResistance(3);
		MA.setIncome(2);
		MA.addAlignment("Criminal");
		MA.addAlignment("Violent");
		faceDown.add(MA);
		
		GroupCard MAFIA = new GroupCard("THe Mafia", "+3 for direct control of any Criminal group");
		MAFIA.setAttackPower(7);
		MAFIA.setResistance(7);
		MAFIA.setIncome(6);
		MAFIA.addAlignment("Criminal");
		MAFIA.addAlignment("Violent");
		faceDown.add(MAFIA);
		
		GroupCard MIB = new GroupCard("The Men in Black");
		MIB.setAttackPower(0);
		MIB.setResistance(2);
		MIB.setIncome(1);
		MIB.addAlignment("Criminal");
		MIB.addAlignment("Weird");
		faceDown.add(MIB);
		
		GroupCard MIL = new GroupCard("Malitia");
		MIL.setAttackPower(2);
		MIL.setResistance(4);
		MIL.setIncome(2);
		MIL.addAlignment("Conservative");
		MIL.addAlignment("Violent");
		faceDown.add(MIL);
		
   		//...
	}

	public void shuffle()
	{
		int x,y;
		Random rand = new Random();
		for(int i = 0; i < 1000; i++)
		{
			x = rand.nextInt(faceDown.size());
			y = rand.nextInt(faceDown.size());
			Card temp;
			temp = faceDown.get(x);
			faceDown.set(x, faceDown.get(y));
			faceDown.set(y,  temp);
		}
	}
	
	public Card removeCard(int index)
	{
		return faceDown.remove(index);
	}
	
	public Card getCard(int index)
	{
		return faceDown.get(index);
	}
	
	public void addCard(Card card)
	{
		faceDown.add(card);
	}
}
