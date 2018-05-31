package StudentDairy;

import java.io.*;

public class Teacherin{

	public void enter()
	{
		Teacher t1 = new Teacher("ram","asdf123","12345","ram@gmail","16149-16167","2015");
		Teacher t2 = new Teacher("ram1","asdf123","12345","ram@gmail","16149-16167","2016");
		Teacher t3 = new Teacher("ra2","asdf123","12345","ram@gmail","16149-16167","2017");
		Teacher t4 = new Teacher("ra3","asdf123","12345","ram@gmail","16149-16167","2018");
		Teacher t5 = new Teacher("ram4","asdf123","12345","ram@gmail","16149-16167","2019");
		
		try
		{
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Teacher.ser"));
			out.writeObject(t1);
			out.writeObject(t2);
			out.writeObject(t3);
			out.writeObject(t4);
			out.writeObject(t5);
			out.close();
			System.out.println("success");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
