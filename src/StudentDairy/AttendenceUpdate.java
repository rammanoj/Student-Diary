package StudentDairy;

import java.io.*;
import java.util.*;

public class AttendenceUpdate {

	public void update()
	{
		String id,atten,sem,subj;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter id of student");
		id = s.next();
		System.out.println("Enter attendence of student");
		atten = s.next();
		System.out.println("Enter sem of student");
		sem = s.next();
		System.out.println("Enter subject of student");
		subj = s.next();
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
			try
			{
				int i=0;
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("attendence.ser"));
				for( i=0;i<al.size();i++)
				{
					if(al.get(i).id.equals(id) && al.get(i).sem.equals(sem) && al.get(i).subj.equals(subj))
					{
						break;
					}
				}
				al.get(i).atten = atten;
				for(i=0;i<al.size();i++)
					out.writeObject(al.get(i));
				System.out.println("Attendence got successfully updated");
				out.close();
			}
			catch(Exception e2)
			{
				System.out.println("there is an internal error in updating please try again later");
			}
		}
	}
}
