package StudentDairy;

import java.util.*;
import java.io.*;

public class Displaycgpa {
	
	public void insert()
	{
		Cgpa c = new Cgpa();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter id of student");
		c.id = s.next();
		System.out.println("Enter cgpa of student");
		c.cgpa = s.next();
		System.out.println("Enter sem of student");
		c.sem = s.next();
		s.close();
		ArrayList<Cgpa> al = new ArrayList<Cgpa>();
		try
		{
			@SuppressWarnings("resource")
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("cgpa.ser"));
			Cgpa cg;
			while(true)
			{
				cg = (Cgpa)in.readObject();
				al.add(cg);
			}
		}
		catch(Exception e)
		{
			al.add(c);
			try
			{
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cgpa.ser"));
				for(int i=0;i<al.size();i++)
					out.writeObject(al.get(i));
				out.close();
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
			System.out.println("Student cgpa got successfully inserted");
		}
		
	}
	public void display()
	{
		String id,sem;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter id of student");
		id = s.next();
		System.out.println("Enter sem of student");
		sem = s.next();
		s.close();
		Cgpa cg = new Cgpa();
		try
		{
			@SuppressWarnings("resource")
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("cgpa.ser"));
			while(true)
			{
				cg = (Cgpa)in.readObject();
				if(cg.id.equals(id) && cg.sem.equals(sem))
					break;
			}
			System.out.println(cg.toStirng());
		}
		catch(Exception e2)
		{
			System.out.println("There is no student cgpa found as per given requirements");
		}
	}
}
