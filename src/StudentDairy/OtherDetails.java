package StudentDairy;

import java.io.*;
import java.util.*;

public class OtherDetails {

	public void load()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("please enter id: ");
		String id = s.next();
		System.out.println("enter if a student is eligible for scholorship: ");
		String scho = s.next();
		System.out.println("Enter if student has any achievements  'yes or no'");
		String n = s.next();
		 ArrayList<String> arr = new ArrayList<String>();
		if(n.equals("yes"))
		{
			System.out.println("Enter length of achievements");
			int len = s.nextInt();
			System.out.println("Enter the achievements");
			for(int l=0;l<len;l++)
				arr.add(s.nextLine());
		}
		OtherAchievements o  = new OtherAchievements(scho,arr,id);
		insert(id,scho,arr,o);
		s.close();
	}
	public void insert(String id, String scho,ArrayList<String> arr,OtherAchievements o)
	{
		ArrayList<OtherAchievements> al = new ArrayList<OtherAchievements>();
		try
		{
			File f = new File("details.ser");
			if(f.exists())
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
		}
		catch(Exception e){

			try
			{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("details.ser"));
			out.writeObject(o);
			for(int i=0;i<al.size();i++)
			{
				OtherAchievements n = al.get(i);
				out.writeObject(n);
			}
			out.flush();
			out.close();
			}
			catch(Exception e1){}
		}
	}
}
