//package pack;

import java.util.ArrayList;

public class UncontrolledGroups
{
	public ArrayList<GroupCard> uncontrolled;
	
	public UncontrolledGroups()
	{
		uncontrolled = new ArrayList<GroupCard>();
		setGroups();
	}
	
	public void setGroups()
	{
		// add all 83 groups here
		GroupCard AAA = new GroupCard("American Autoduel Association", "");
		AAA.setAttackPower(1);
		AAA.setResistance(5);
		AAA.setIncome(1);
		AAA.addAlignment("Violent");
		AAA.addAlignment("Weird");
		uncontrolled.add(AAA);
		
		GroupCard ANA = new GroupCard("Anti-Nuclear Activists", 
				"+2 on any attempt to destroy Nuclear Power Companies.");
		ANA.setAttackPower(2);
		ANA.setResistance(5);
		ANA.setIncome(1);
		ANA.addAlignment("Liberal");
		uncontrolled.add(ANA);
		
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
		
		GroupCard MAFIA = new GroupCard("THe Mafia", "+3 for direct control of any Criminal group");
		MAFIA.setAttackPower(7);
		MAFIA.setResistance(7);
		MAFIA.setIncome(6);
		MAFIA.addAlignment("Criminal");
		MAFIA.addAlignment("Violent");
		
		GroupCard MIB = new GroupCard("THe Men in Black");
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
