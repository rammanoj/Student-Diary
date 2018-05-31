package StudentDairy;

import java.io.*;

public class Checker {

	public int id;
	public static String tid;
	
	public Checker()
	{
		this.id = 0;
	}
	public Checker(int id)
	{
		this.id = id;
	}
	public void set(int id)
	{
		this.id = id;
	}
	public void setid(String s)
	{
		tid = s;
	}
	public int check()
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Teacher.ser"));
			Teacher t = (Teacher)in.readObject();
			while(t.name.equals(tid))
			{
				t = (Teacher)in.readObject();
			}
			in.close();
			String stuid = t.students;
			String initial = stuid.charAt(3) + " " +stuid.charAt(3) +" " + stuid.charAt(3);
			String out = stuid.charAt(10) + " " +stuid.charAt(11) +" " + stuid.charAt(12);
			int less = Integer.parseInt(initial);
			int more = Integer.parseInt(out);
			return check_value(less,more);
		}
		catch(Exception e){
			return 0;
		}
	}
	public int check_value(int a , int b)
	{
		if(this.id >a && this.id < b)
		{
			return 1;
		}
		else 
		{
			return 0;
		}
	}
}
