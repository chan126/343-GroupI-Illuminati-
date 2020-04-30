package cards;
import java.util.ArrayList;

public class IlluminatiCard extends Card
{
	ArrayList<GroupCard> neighbors;
	
	public IlluminatiCard(String name, String description)
	{
		this.name = name;
		this.description = description;
		neighbors = new ArrayList<GroupCard>();
	}
	
	
	
}
