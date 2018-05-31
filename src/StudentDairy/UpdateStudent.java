package StudentDairy;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UpdateStudent {

	public String[] arr = {"name","class","sem","course","branch","mobile","years","enrollment type","email"};
	public ArrayList<Student> al = new ArrayList<Student>();
	
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
		System.out.println("hello");
		try
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
		catch(Exception e)
		{
			try
			{
				int i;
				Student s = al.get(0);
				for(i=1;s.id.equals(id);i++)
				{
					s = al.get(i);
				}
				if( value == 1)
					al.get(i).name = upv;
				else if(value == 2)
					al.get(i).class1 = upv;
				else if(value == 3)
					al.get(i).sem = upv;
				else if(value == 4)
					al.get(i).course = upv;
				else if(value == 5)
					al.get(i).branch = upv;
				else if(value == 6)
					al.get(i).mobile = upv;
				else if(value == 7)
					al.get(i).years = upv;
				else if(value == 8)
					al.get(i).enrollmentstatus = upv;
				else if(value == 9)
					al.get(i).email = upv;
				else
					System.out.println("plese enter a valid input");
				System.out.println(al.get(i));
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.ser"));
					for(i=0;i<al.size();i++)
					{	
						Student n1 = al.get(i);
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
