package cards;
import java.util.ArrayList;

public class IlluminatiCard extends Card
{
	ArrayList<GroupCard> subjects;
	
	public IlluminatiCard(String name, String description)
	{
		this.name = name;
		this.description = description;
		subjects = new ArrayList<GroupCard>();
	}
	
	public void addSubject(GroupCard subject)
	{
		subjects.add(subject);
	}
}
