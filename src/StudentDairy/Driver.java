package StudentDairy;

import java.util.*;

public class Driver {

	public static void main(String[] args)
	{
		try
		{
			System.out.println("needed 'json simple' jar file to be added to project inorder to run json content");
			System.out.println("as subjects in mark classes are parsed in form of json content");
			System.out.println("username: ram , password: asdf123");
			Scanner s = new Scanner(System.in);
			System.out.print("username: ");
			String u = s.next();
			System.out.print("password: ");
			String p = s.next();
			Login l = new Login(u,p);
			l.validate();
			s.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	}
/*

		
		*/
