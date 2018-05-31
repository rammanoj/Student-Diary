package StudentDairy;

import java.io.*;

public class DisplayStudent {

	public String id;
	
	public DisplayStudent(String id)
	{
		this.id = id;
	}
	public void display()
	{
		try
		{
			ObjectInputStream out = new ObjectInputStream(new FileInputStream("student.ser"));
			Student s;
			while(true)
			{
				s = (Student)out.readObject();
				if(s.id.equals(id))
				{
					break;
				}
			}
			System.out.println("Name: "+s.name);
			System.out.println("id: "+s.id);
			System.out.println("class: "+s.class1);
			System.out.println("sem: "+s.sem);
			System.out.println("course: "+s.course);
			System.out.println("branch: "+s.branch);
			System.out.println("mobile: "+s.mobile);
			System.out.println("year: "+s.years);
			System.out.println("email: "+s.email);
			out.close();
		}
		catch(Exception e)
		{
			System.out.println("there is no student as per given id");
		}
	}
}
