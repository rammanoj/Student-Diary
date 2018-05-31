package StudentDairy;

import java.util.*;
import java.io.*;

public class AttendenceDisplay {

	public void display()
	{
		String id,sem,subj;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter id of student");
		id = s.next();
		System.out.println("Enter sem of student");
		sem = s.next();
		System.out.println("Enter subject of student");
		subj = s.next();
		s.close();
		try
		{
			@SuppressWarnings("resource")
			ObjectInputStream out = new ObjectInputStream(new FileInputStream("attendence.ser"));
			Attendence at = (Attendence)out.readObject();
			while(true)
			{
				at = (Attendence)out.readObject();
				if(at.id.equals(id) && at.sem.equals(sem) && at.subj.equals(subj))
					break;
			}
			System.out.println(at.toString());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
