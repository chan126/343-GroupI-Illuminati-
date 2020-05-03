package cards;
import java.util.ArrayList;

public class IlluminatiCard extends Card
{	
	public IlluminatiCard(String name, String description)
	{
		super(name, description);
		out = 4;
	}
	
	public void addSubject(GroupCard subject)
	{
		if(puppets.size() < out)
			puppets.add(subject);
		else
			System.out.println("ERROR: You already have 4 subjects under your Illuminati group!");
	}
}
