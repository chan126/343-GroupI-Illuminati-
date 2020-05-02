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
		//faceDown.add(AAA);
		
		GroupCard ANA = new GroupCard("Anti-Nuclear Activists", 
				"+2 on any attempt to destroy Nuclear Power Companies.");
		ANA.setAttackPower(2);
		ANA.setResistance(5);
		ANA.setIncome(1);
		ANA.addAlignment("Liberal");
		//faceDown.add(ANA);
		
		GroupCard AA = new GroupCard("Antiwar Activist");
		//AA.setAttackPower(0);
		AA.setResistance(3);
		AA.setIncome(1);
		AA.addAlignment("Peaceful");
		AA.addAlignment("Liberal");
		
		
		GroupCard BM = new GroupCard("Big Media");
		BM.setAttackPower(4);
		BM.setTransferPower(3);
		BM.setResistance(6);
		BM.setIncome(3);
		BM.addAlignment("Liberal");
		BM.addAlignment("Straight");
		
		
		GroupCard BS = new GroupCard("Boy Sprouts");
		BM.setResistance(3);
		BM.setIncome(1);
		BM.addAlignment("Straight");
		BM.addAlignment("Peaceful");
		
		GroupCard CALI = new GroupCard("California");
		CALI.setAttackPower(5);
		CALI.setResistance(4);
		CALI.setIncome(5);
		CALI.addAlignment("Liberal");
		CALI.addAlignment("weird");
		CALI.addAlignment("Government");
		
		GroupCard CA = new GroupCard("CFL-AIO");
		CA.setAttackPower(6);
		CA.setResistance(5);
		CA.setIncome(3);
		CA.addAlignment("Liberal");
		
		GroupCard CCD = new GroupCard("Chinese Campaign Donors", 
				"Treat this group as Government when it attempts to control a Government group.");
		CCD.setAttackPower(3);
		CCD.setResistance(2);
		CCD.setIncome(3);
		CCD.addAlignment("Communist");
		
		GroupCard CIA = new GroupCard("C.I.A");
		CIA.setAttackPower(6);
		CIA.setTransferPower(4);
		CIA.setIncome(0);
		CIA.addAlignment("Government");
		CIA.addAlignment("Violent");
		
		GroupCard CLA = new GroupCard("Clone Arrangers");
		CLA.setAttackPower(6);
		CLA.setTransferPower(2);
		CLA.setResistance(6);
		CLA.setIncome(1);
		CLA.addAlignment("Violent");
		CLA.addAlignment("Communist");
		CLA.addAlignment("Criminal");
		
		GroupCard COB = new GroupCard("Comin Books");
		COB.setAttackPower(1);
		COB.setResistance(1);
		COB.setIncome(2);
		COB.addAlignment("Weird");
		COB.addAlignment("Violent");
		
		GroupCard COW = new GroupCard("Congressional Wives");
		COW.setAttackPower(1);
		COW.setResistance(4);
		COW.setIncome(1);
		COW.addAlignment("Conservative");
		COW.addAlignment("Straight");
		
		GroupCard COS = new GroupCard("Convenience Stores");
		COS.setAttackPower(1);
		COS.setResistance(4);
		COS.setIncome(3);
		COS.addAlignment("Straight");
		
		GroupCard COPSH = new GroupCard("Copy Shops");
		COPSH.setAttackPower(1);
		COPSH.setResistance(3);
		COPSH.setIncome(4);
		COPSH.addAlignment("Peaceful");
		
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
		
		GroupCard ECOG = new GroupCard("Eco-Guerrillas");
		ECOG.setResistance(6);
		ECOG.setIncome(1);
		ECOG.addAlignment("Liberal");
		ECOG.addAlignment("Violent");
		ECOG.addAlignment("Weird");
		
		GroupCard EV = new GroupCard("Empty Vee");
		EV.setAttackPower(3);
		EV.setResistance(3);
		EV.setIncome(4);
		
		GroupCard EGF = new GroupCard("Evil Geniuses for a Better Tomorrow", 
				"+4 for any attempt to control, neutralize, or destroy the Orbital Mind Control Lasers");
		EGF.setAttackPower(0);
		EGF.setTransferPower(2);
		EGF.setResistance(6);
		EGF.setIncome(3);
		EGF.addAlignment("Violent");
		EGF.addAlignment("Weird");
		
		GroupCard FFC = new GroupCard("Fast Food Chains");
		FFC.setAttackPower(2);
		FFC.setResistance(4);
		FFC.setIncome(3);
		FFC.addAlignment("Straight");
		
		
		GroupCard FBI = new GroupCard("F.B.I");
		FBI.setAttackPower(4);
		FBI.setTransferPower(2);
		FBI.setIncome(0);
		FBI.addAlignment("Government");
		FBI.addAlignment("Straight");
		
		
		GroupCard FED = new GroupCard("Federal Reserve");
		FED.setAttackPower(5);
		FED.setTransferPower(3);
		FED.setResistance(7);
		FED.setIncome(6);
		FED.addAlignment("Government");
		
		GroupCard FEM = new GroupCard("Feminists");
		FEM.setAttackPower(2);
		FEM.setResistance(2);
		FEM.setIncome(1);
		FEM.addAlignment("Liberal");
		
		GroupCard FF = new GroupCard("Fiendish Fluoridators");
		FF.setAttackPower(3);
		FF.setResistance(5);
		FF.setIncome(1);
		FF.addAlignment("Communist");
		FF.addAlignment("Fanatic");
		
		GroupCard FE = new GroupCard("Flat Earthers");
		FE.setAttackPower(1);
		FE.setResistance(2);
		FE.setIncome(1);
		FE.addAlignment("Weird");
		FE.addAlignment("Conservative");
		
		GroupCard FMC = new GroupCard("Fnord Motor Company");
		FMC.setAttackPower(2);
		FMC.setResistance(4);
		FMC.setIncome(2);
		FMC.addAlignment("Peaceful");
		
		GroupCard FO = new GroupCard("Fraternal Orders");
		FO.setAttackPower(3);
		FO.setResistance(5);
		FO.setIncome(2);
		FO.addAlignment("Conservative");
		
		GroupCard GM = new GroupCard("Girlie Magazines");
		GM.setAttackPower(2);
		GM.setResistance(2);
		GM.setIncome(3);
		GM.addAlignment("Liberal");
		
		GroupCard GF = new GroupCard("Goldfish Fanciers");
		GF.setResistance(4);
		GF.setIncome(1);
		GF.addAlignment("Peaceful");
		GF.addAlignment("Fanatic");
		
		GroupCard GUL = new GroupCard("Gun Lobby", "Normal Resistance3; against any Liberal, Communist, or Weird group, resistance 10");
		GUL.setAttackPower(1);
		GUL.setResistance(10); 
		GUL.setIncome(1);
		GUL.addAlignment("Conservative");
		GUL.addAlignment("Violent");
		
		GroupCard HACK = new GroupCard("Hackers", "+3 on any attempt to neutralize any group");
		HACK.setAttackPower(1);
		HACK.setTransferPower(1);
		HACK.setIncome(2);
		HACK.addAlignment("Weird");
		HACK.addAlignment("Fanatic");
		
		GroupCard HFS = new GroupCard("Health Food Stores");
		HFS.setAttackPower(1);
		HFS.setResistance(3);
		HFS.setIncome(2);
		HFS.addAlignment("Liberal");
		
		GroupCard HWD = new GroupCard("Hollywood");
		HWD.setAttackPower(2);
		HWD.setResistance(0);
		HWD.setIncome(5);
		HWD.addAlignment("Liberal");
		
		GroupCard INTEL = new GroupCard("Intellectuals");
		INTEL.setAttackPower(3);
		INTEL.setIncome(1);
		INTEL.addAlignment("Weird");
		INTEL.addAlignment("Fanatic");
		
		GroupCard ICS = new GroupCard("International Cocaine Smugglers","+4 on any attempt to control Punk Rockers, Cycle Gangs, or Hollywood.");
		ICS.setAttackPower(3);
		ICS.setResistance(5);
		ICS.setIncome(5);
		ICS.addAlignment("Criminal");
		
		GroupCard ICC = new GroupCard("International Communist Conspiracy", "+3 on any attempt to control and Communist group");
		ICC.setAttackPower(7);
		ICC.setResistance(8);
		ICC.setIncome(6);
		ICC.addAlignment("Communist");
		
		GroupCard IRS = new GroupCard("I.R.S", "Ownin player may tax each oppenoent 2MB on his own income phase. Tax may come from any group. If a player has no money, he owes no tax");
		IRS.setAttackPower(5);
		IRS.setTransferPower(3);
		IRS.setResistance(5);
		IRS.setIncome(2);
		
		GroupCard JM = new GroupCard("Junk Mail", "+4 on any attempt to control the Post Office");
		IRS.setAttackPower(1);
		IRS.setResistance(3);
		IRS.setIncome(2);
		IRS.addAlignment("Criminal");
		
		GroupCard KGB = new GroupCard("KCB", "+2 on any attempt to destroy any group");
		KGB.setAttackPower(2);
		KGB.setTransferPower(2);
		KGB.setIncome(0);
		KGB.addAlignment("Communist");
		KGB.addAlignment("Violent");
		
		GroupCard KKK = new GroupCard("KKK");
		KKK.setAttackPower(2);
		KKK.setResistance(5);
		KKK.setIncome(1);
		KKK.addAlignment("Conservative");
		KKK.addAlignment("Violent");
		
		GroupCard L4S = new GroupCard("L-4 Society","+4 for direct control, neutralization, or destruction of Orbital Mind Control Lasers");
		L4S.setAttackPower(1);
		L4S.setResistance(2);
		L4S.setIncome(0);
		L4S.addAlignment("Weird");
	
		GroupCard LIB = new GroupCard("Libertarians");
		LIB.setAttackPower(1);
		LIB.setResistance(4);
		LIB.setIncome(1);
		LIB.addAlignment("Fanatic");
		
		GroupCard LOS = new GroupCard("Loan Sharks");
		LOS.setAttackPower(5);
		LOS.setResistance(5);
		LOS.setIncome(6);
		LOS.addAlignment("Criminal");
		LOS.addAlignment("Violent");	
		
		GroupCard LPD = new GroupCard("Local Police Departments");
		LOS.setAttackPower(4);
		LOS.setIncome(1);
		LOS.addAlignment("Conservative");
		LOS.addAlignment("Straight");
		LOS.addAlignment("Violent");
		
		GroupCard MA = new GroupCard("Madison Avenue");
		LOS.setAttackPower(3);
		LOS.setResistance(3);
		LOS.setIncome(2);
		LOS.addAlignment("Criminal");
		LOS.addAlignment("Violent");
		
		GroupCard MAFIA = new GroupCard("The Mafia", "+3 for direct control of any Criminal group");
		MAFIA.setAttackPower(7);
		MAFIA.setResistance(7);
		MAFIA.setIncome(6);
		MAFIA.addAlignment("Criminal");
		MAFIA.addAlignment("Violent");
		
		GroupCard MIB = new GroupCard("The Men in Black");
		MAFIA.setAttackPower(0);
		MAFIA.setResistance(2);
		MAFIA.setIncome(1);
		MAFIA.addAlignment("Criminal");
		MAFIA.addAlignment("Weird");
		
		GroupCard MIL = new GroupCard("Malitia");
		MAFIA.setAttackPower(2);
		MAFIA.setResistance(4);
		MAFIA.setIncome(2);
		MAFIA.addAlignment("Conservative");
		MAFIA.addAlignment("Violent");
		
		GroupCard MOON = new GroupCard("Moonis");
		MOON.setAttackPower(2);
		MOON.setResistance(4);
		MOON.setIncome(3);
		MOON.addAlignment("Peaceful");
		MOON.addAlignment("Fanatic");
		
		GroupCard MM = new GroupCard("Moral Minority");
		MM.setAttackPower(2);
		MM.setResistance(1);
		MM.setIncome(2);
		MM.addAlignment("Conservative");
		MM.addAlignment("Straight");
		MM.addAlignment("Fanatic");
		
		GroupCard MORT = new GroupCard("Morticians");
		MORT.setResistance(4);
		MORT.setIncome(1);
		MORT.addAlignment("Straight");
		MORT.addAlignment("Peaceful");
		
		GroupCard MOM = new GroupCard("Multinational Oil Companies");
		MOM.setAttackPower(6);
		MOM.setResistance(4);
		MOM.setIncome(8);
		
		GroupCard NOG = new GroupCard("Nephews of God");
		NOG.setResistance(4);
		NOG.setIncome(2);
		NOG.addAlignment("Conservative");
		NOG.addAlignment("Fanatic");
		
		
		GroupCard NY = new GroupCard("New York");
		MOON.setAttackPower(7);
		MOON.setResistance(8);
		MOON.setIncome(3);
		MOON.addAlignment("Violent");
		MOON.addAlignment("Criminal");
		MOON.addAlignment("Government");
		
		GroupCard NPC = new GroupCard("Neuclear Power Companies");
		NPC.setAttackPower(4);
		NPC.setResistance(4);
		NPC.setIncome(3);
		NPC.addAlignment("Conservative");
		
		GroupCard OMCL = new GroupCard("Orbital Mind Control Lasers", "On his turn, owner can add, remove, or revers an alignment of any one other group in play; change lasts for that turn only");
		OMCL.setAttackPower(4);
		OMCL.setTransferPower(2);
		OMCL.setResistance(5);
		OMCL.setIncome(0);
		OMCL.addAlignment("Communist");
		
		GroupCard PTA = new GroupCard("Parent/Teacher Agglomeration");
		PTA.setResistance(5);
		PTA.setIncome(1);
		PTA.addAlignment("Peaceful");
		PTA.addAlignment("Conversative");
		PTA.addAlignment("Straight");
		
		GroupCard PEN = new GroupCard("Pentagon");
		PEN.setAttackPower(6);
		PEN.setResistance(6);
		PEN.setIncome(2);
		PEN.addAlignment("Violent");
		PEN.addAlignment("Government");
		PEN.addAlignment("Straight");
		
		GroupCard TPC = new GroupCard("The Phone Company");
		TPC.setAttackPower(5);
		TPC.setTransferPower(2);
		TPC.setResistance(6);
		TPC.setIncome(3);
		
		GroupCard PP = new GroupCard("Phone Phreaks", "+3 on any attempt to control, neutralize, or destroy the Phone Company");
		PP.setAttackPower(7);
		PP.setResistance(8);
		PP.setIncome(3);
		PP.addAlignment("Criminal");
		PP.addAlignment("Liberal");
		
		GroupCard POS = new GroupCard("Post Office");
		POS.setAttackPower(4);
		POS.setResistance(3);
		POS.setIncome(-1);
		POS.addAlignment("Government");
		
		GroupCard PRS = new GroupCard("Professional Sports");
		PRS.setAttackPower(7);
		PRS.setResistance(8);
		PRS.setIncome(3);
		PRS.addAlignment("Violent");
		PRS.addAlignment("Fanatic");
		
		GroupCard PSY = new GroupCard("Psychiatrists");
		PSY.setResistance(6);
		PSY.setIncome(2);
		PSY.addAlignment("Weird");
		
		GroupCard PUR = new GroupCard("Punk Rockers");
		PUR.setResistance(4);
		PUR.setIncome(1);
		PUR.addAlignment("Weird");
		
		GroupCard REC = new GroupCard("Recyclers");
		REC.setAttackPower(2);
		REC.setResistance(2);
		REC.setIncome(3);
		REC.addAlignment("Liberal");
		
		GroupCard REP = new GroupCard("Republicans");
		REP.setAttackPower(4);
		REP.setResistance(4);
		REP.setIncome(4);
		REP.addAlignment("Conservative");
		
		GroupCard RSM = new GroupCard("Robot Sea Monsters");
		RSM.setResistance(6);
		RSM.setIncome(2);
		RSM.addAlignment("Violent");
		RSM.addAlignment("Communist");
		
		GroupCard SFF = new GroupCard("Science Fiction Fans", "+2 on any attempt to control any Weird group");
		SFF.setResistance(5);
		SFF.setIncome(1);
		SFF.addAlignment("Weird");
		
		GroupCard SLA = new GroupCard("Semiconscious Liberation Army", "+1 on any attempt to destroy any group");
		SLA.setResistance(8);
		SLA.setIncome(0);
		SLA.addAlignment("Violent");
		SLA.addAlignment("Criminal");
		SLA.addAlignment("Liberal");
		SLA.addAlignment("Weird");
		SLA.addAlignment("Communist");
		
		
		GroupCard SMOF = new GroupCard("S.M.O.F", "+ 5 for direct control of S.F Fans, or +2 for diect control of Trekkies");
		SMOF.setAttackPower(1);
		SMOF.setResistance(1);
		SMOF.setIncome(0);
		SMOF.addAlignment("Weird");
		
		GroupCard SFCA = new GroupCard("Society for Creative Anarchism");
		MOON.setResistance(4);
		MOON.setIncome(1);
		MOON.addAlignment("Violent");
		MOON.addAlignment("Weird");
		
		GroupCard SAN = new GroupCard("South American Nazis");
		MOON.setAttackPower(4);
		MOON.setResistance(6);
		MOON.setIncome(2);
		MOON.addAlignment("Violent");
		MOON.addAlignment("Weird");
		
		GroupCard SUR = new GroupCard("Survivalists", "+2 Resistance to all owner's other groups");
		SUR.setAttackPower(4);
		SUR.setResistance(6);
		SUR.setIncome(2);
		SUR.addAlignment("Conservative");
		SUR.addAlignment("Violent");
		SUR.addAlignment("Fanatic");
		
		GroupCard TAB = new GroupCard("Tabloids");
		TAB.setAttackPower(2);
		TAB.setResistance(3);
		TAB.setIncome(3);
		TAB.addAlignment("Weird");
		
		GroupCard TX = new GroupCard("Texas");
		TX.setAttackPower(6);
		TX.setResistance(6);
		TX.setIncome(4);
		TX.addAlignment("Violent");
		TX.addAlignment("Conservative");
		TX.addAlignment("Government");
		
		GroupCard TLC = new GroupCard("Tobacco & Liquor Companies");
		TLC.setAttackPower(4);
		TLC.setResistance(3);
		TLC.setIncome(3);
		TLC.addAlignment("Straight");
		
		GroupCard TREK = new GroupCard("Trekkies");
		TREK.setResistance(4);
		TREK.setIncome(3);
		TREK.addAlignment("Weird");
		TREK.addAlignment("Fanatic");
		
		GroupCard TC = new GroupCard("Triliberal Commission");
		TC.setAttackPower(5);
		TC.setResistance(6);
		TC.setIncome(3);
		TC.addAlignment("Liberal");
		TC.addAlignment("Straight");
		
		GroupCard TVP = new GroupCard("TV Preachers", "+3 for direct control of the Moral Minority");
		TVP.setAttackPower(3);
		TVP.setResistance(6);
		TVP.setIncome(4);
		TVP.addAlignment("Straight");
		TVP.addAlignment("Fanatic");
		
		GroupCard UUN = new GroupCard("Underground Newspapers");
		UUN.setAttackPower(1);
		UUN.setTransferPower(1);
		UUN.setResistance(5);
		UUN.setIncome(0);
		UUN.addAlignment("Communist");
		UUN.addAlignment("Liberal");
		
		GroupCard UN = new GroupCard("The United Nations");
		UN.setAttackPower(7);
		UN.setResistance(8);
		UN.setIncome(3);
		UN.addAlignment("Violent");
		UN.addAlignment("Criminal");
		UN.addAlignment("Government");
		
		GroupCard VG = new GroupCard("Video Games", "+3 for direct control of Convenience Stores.");
		UN.setAttackPower(2);
		UN.setResistance(3);
		UN.setIncome(7);
		
		GroupCard YUPPIES = new GroupCard("Yuppies");
		YUPPIES.setAttackPower(1);
		YUPPIES.setTransferPower(1);
		YUPPIES.setResistance(4);
		YUPPIES.setIncome(5);
		YUPPIES.addAlignment("Conservative");
		
		//add to array 
		GroupCard temp[] = {AAA,
				ANA,
				AA,
				BM,
				BS,
				CALI,
				CA,
				CCD,
				CIA,
				CLA,
				COB,
				COW,
				COS,
				COPSH,
				CG,
				DEM,
				ECOG,
				EV,
				EGF,
				FFC,
				FBI,
				FED,
				FEM,
				FF,
				FE,
				FMC,
				FO,
				GM,
				GF,
				GUL,
				HACK,
				HFS,
				HWD,
				INTEL,
				ICS,
				ICC,
				IRS,
				JM,
				KGB,
				KKK,
				L4S,
				LIB,
				LOS,
				LPD,
				MA,
				MAFIA,
				MIB,
				MIL,
				MOON,
				MM,
				MORT,
				MOM,
				NOG,
				NY,
				NPC,
				OMCL,
				PTA,
				PEN,
				TPC,
				PP,
				PRS,
				PSY,
				PUR,
				REC,
				REP,
				RSM,
				SFF,
				SLA,
				SMOF,
				SFCA,
				SAN,
				SUR,
				TAB,
				TX,
				TLC,
				TREK,
				TC,
				TVP,
				UUN,
				UN,
				VG,
				YUPPIES};
		
		for(int i = 0; i < temp.length; i++) {
			faceDown.add(temp[i]);
		}
		
    //...
	}

	public void shuffle()
	{
		// WRITE THIS FUNCTION
	}

	@Override
	public String toString() {
		return "FaceDownCards [faceDown=" + faceDown + "]";
	}
	
}
