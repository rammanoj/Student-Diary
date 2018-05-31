package StudentDairy;

import java.io.*;
import java.util.*;

public class OtherDetailUpdate {
	public String[] arr = {"scholorship","Achievements"};
	public ArrayList<OtherAchievements> al = new ArrayList<OtherAchievements>();
	
	public void update()
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the value to get updated");
		int n = s.nextInt();
		s.nextLine();
		System.out.println("Enter the id of the student");
		String i = s.nextLine();
		System.out.print("enter the updated value: ");
		String m = s.nextLine();
		updatevalue(n,m,i);
		s.close();
	}
	public void updatevalue(int value, String upv ,String id)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("details.ser"));
			OtherAchievements a;
				while(true)
				{
					a = (OtherAchievements)in.readObject();
					if(a  == null)
						break;
					al.add(a);
				}
				in.close();
		}
		catch(Exception e)
		{
			try
			{
				int i;
				OtherAchievements s = al.get(0);
				for(i=1;s.id.equals(id);i++)
				{
					System.out.println("qw");
					s = al.get(i);
				}
				if( value == 1)
					al.get(i).Scholorship = upv;
				else if(value == 2)
				{
					al.get(i).achieve.add(upv);
					System.out.println("as");
				}
				else
					System.out.println("plese enter a valid input");
				System.out.println(al.get(i) + upv);
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("details.ser"));
					for(i=0;i<al.size();i++)
					{	
						OtherAchievements n1 = al.get(i);
						out.writeObject(n1);
					}
			out.flush();
			out.close();
			}
			catch(Exception e1)
			{

			}
		}
	}

}
