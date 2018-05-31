package StudentDairy;

import java.io.*;

public class AchieveDisplay {

	public String id;
	
	public AchieveDisplay(String id)
	{
		this.id = id;
	}
	public void display()
	{
		try
		{
			ObjectInputStream out = new ObjectInputStream(new FileInputStream("details.ser"));
			OtherAchievements s;
			while(true)
			{
				s = (OtherAchievements)out.readObject();
				if(s.id.equals(id))
				{
					break;
				}
			}
			System.out.println("present scholorships:" + s.Scholorship);
			System.out.println("Student Achievements");
			for(int i=0;i<s.achieve.size();i++)
				System.out.println(s.achieve.get(i));
			out.close();
		}
		catch(Exception e)
		{
			System.out.println("there is no student as per given id");
		}
	}
}
