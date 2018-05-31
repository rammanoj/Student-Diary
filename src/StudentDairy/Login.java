package StudentDairy;

import java.io.*;

public class Login {
	
	protected String username;
	protected String password;
	public String id = "empty";
	public Login(String username , String password)
	{
		this.username = username;
		this.password = password;
	}
	public void validate()
	{
		try
		{
			ObjectInputStream out = new ObjectInputStream(new FileInputStream("Teacher.ser"));
			Teacher t;
			while(true)
			{
				t = (Teacher)out.readObject();
				if(username.equals(t.name) && password.equals(t.password))
				{
					id = t.name;
					break;
				}
			 }
			out.close();
		}
		catch(Exception e)
		{ }
		if(id != "empty")
		{
			home();
		}
		else
			System.out.print("please enter correct credentials");
	}
	public void home()
	{
		Checker c = new Checker();
		c.setid(username);
		Home h = new Home(this.id);
		h.display_home();
	}
}
