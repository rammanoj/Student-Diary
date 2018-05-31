package StudentDairy;

import java.io.*;
import java.util.*;

public class InsertStudent {

	public String id;
	public ArrayList<Student> al = new ArrayList<Student>();
	
	public InsertStudent(String s)
	{
		this.id = s;
	}
	public void insert()
	{
		Scanner s = new Scanner(System.in);
		System.out.print("Student id: ");
		String n = s.next();
		System.out.print("Student name: ");
		String n1 = s.next();
		System.out.print("Student class: ");
		String n2 = s.next();
		System.out.print("Student sem: ");
		String n3 = s.next();
		System.out.print("Student course: ");
		String n4 = s.next();
		System.out.print("Student branch: ");
		String n5 = s.next();
		System.out.print("Student mobile: ");
		String n6 = s.next();
		System.out.print("Student enrollment: ");
		String n7 = s.next();
		System.out.print("Student years of study: ");
		String n8 = s.next();
		System.out.print("Student enrollment type : ");
		String n9 = s.next();
		System.out.print("Student email: ");
		String n10 = s.next();
		Student s1 = new Student(n,n10,n1,n2,n3,n4,n5,n6,n7,n8,n9);
		s.close();
		insertin("student.ser",s1);
	}
	public void insertin(String file,Student s)
	{
		try
		{
			
			File f = new File(file);
			if(f.exists())
			{
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.ser"));
				Student a;
				while(true)
				{
					a = (Student)in.readObject();
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
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.ser"));

			out.writeObject(s);
			for(int i=0;i<al.size();i++)
			{
				Student n = al.get(i);
				out.writeObject(n);
			}
			out.flush();
			out.close();
			System.out.println("student got inserted");
			}
			catch(Exception e1){}
		}
	}
}
