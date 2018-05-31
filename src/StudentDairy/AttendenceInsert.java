package StudentDairy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class AttendenceInsert {
	
	public void insert()
	{
		Attendence c = new Attendence();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter id of student");
		c.id = s.next();
		System.out.println("Enter attendence of student");
		c.atten = s.next();
		System.out.println("Enter sem of student");
		c.sem = s.next();
		System.out.println("Enter subject of student");
		c.subj = s.next();
		s.close();
		ArrayList<Attendence> al = new ArrayList<Attendence>();
		try
		{
			@SuppressWarnings("resource")
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("attendence.ser"));
			Attendence cg;
			while(true)
			{
				cg = (Attendence)in.readObject();
				al.add(cg);
			}
		}
		catch(Exception e)
		{
			al.add(c);
			try
			{
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("attendence.ser"));
				for(int i=0;i<al.size();i++)
					out.writeObject(al.get(i));
				out.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			System.out.println("Student attendence got successfully inserted");
		}
	}
}
