package StudentDairy;

import org.json.simple.*;
import org.json.simple.parser.*;
import java.util.*;
import java.io.*;

public class Markinsert extends Mark {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id;
	
	public Markinsert(String s)
	{
		this.id = s;
	}
	/* need json simple jar file to compile json file*/
	/*json file has names of all the subjects of all the semesters and all courses so that it could parse them when required */
	/*all the values are stored in material.json file */
	public void insert()
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the type of exam or mark to be entered");
		String sc = s.next();
		if(sc.equals("p1"))
		{
			System.out.println("Enter the type of exam or mark to be entered");
			insertp1();
		}
		else if(sc.equals("p2"))
		{
			insertp2();
		}
		else if(sc.equals("ce"))
		{
			insertp3();
		}
		else if(sc.equals("es"))
		{
			insertp4();
		}
		else
		{
			System.out.println("please enter a valid exam type");
		}
		s.close();
	}
	public Student readstudent(String ids)
	{
		Student s;
		try
		{
			ObjectInputStream out = new ObjectInputStream(new FileInputStream("student.ser"));
			s = (Student)out.readObject();
			while(s.id.equals(ids))
			{
				s = (Student)out.readObject();
			}
			out.close();
			return s;
		}
		catch(Exception e){
			s = null;
			return s;
		}
	}
	public void insertp1()
	{
		Student ss = readstudent(id);
		Mark m = new Mark();
		m.id = id;
		Scanner s = new Scanner(System.in);
		try
		{
			String sem  = "sem" + ss.sem;
			JSONParser parser = new JSONParser(); 
			Object obj = parser.parse(new FileReader("material.json"));
			JSONObject jsonObject = (JSONObject)obj;
			 JSONObject compose = (JSONObject) jsonObject.get(ss.course);
			 JSONObject compose2 = (JSONObject) compose.get(sem);
			 JSONObject compose3 = (JSONObject) compose2.get(ss.branch);
			 String str = "subj";
			for(int i=0;i<6;i++)
			{
				int j = i+ 1;
				String strx = str + j;
				System.out.print(compose3.get(strx) + ":");
				String n  =s.next();
				Mark.P1 p = m.new P1(n);
				m.p1.add(p);
			}
			enterto(m,id,ss);
			s.close();
		}
		catch(Exception e){}
	}
	public void insertp2()
	{
		Student ss = readstudent(id);
		Mark m = new Mark();
		m.id = id;
		Scanner s = new Scanner(System.in);
		try
		{
			String sem  = "sem" + ss.sem;
			JSONParser parser = new JSONParser(); 
			Object obj = parser.parse(new FileReader("material.json"));
			JSONObject jsonObject = (JSONObject)obj;
			 JSONObject compose = (JSONObject) jsonObject.get(ss.course);
			 JSONObject compose2 = (JSONObject) compose.get(sem);
			 JSONObject compose3 = (JSONObject) compose2.get(ss.branch);
			 String str = "subj";
			for(int i=0;i<6;i++)
			{
				int j = i+ 1;
				String strx = str + j;
				System.out.print(compose3.get(strx) + ":");
				String n  =s.next();
				Mark.P1 p2 = m.new P1(n);
				m.p1.add(p2);
			}
			enterto(m,id,ss);
			s.close();
		}
		catch(Exception e){}
	}
	public void insertp3()
	{
		Student ss = readstudent(id);
		Mark m = new Mark();
		m.id = id;
		Scanner s = new Scanner(System.in);
		try
		{
			String sem  = "sem" + ss.sem;
			System.out.println("cd");
			JSONParser parser = new JSONParser(); 
			Object obj = parser.parse(new FileReader("material.json"));
			JSONObject jsonObject = (JSONObject)obj;
			 JSONObject compose = (JSONObject) jsonObject.get(ss.course);
			 JSONObject compose2 = (JSONObject) compose.get(sem);
			 JSONObject compose3 = (JSONObject) compose2.get(ss.branch);
			 String str = "subj";
			for(int i=0;i<6;i++)
			{
				int j = i+ 1;
				String strx = str + j;
				System.out.print(compose3.get(strx) + ":");
				String n  =s.next();
				Mark.P1 cont = m.new P1(n);
				m.p1.add(cont);
			}
			enterto(m,id,ss);
			s.close();
		}
		catch(Exception e){}
	}
	public void insertp4()
	{
		Student ss = readstudent(id);
		Mark m = new Mark();
		m.id = id;
		Scanner s = new Scanner(System.in);
		try
		{
			String sem  = "sem" + ss.sem;
			System.out.println("cd");
			JSONParser parser = new JSONParser(); 
			Object obj = parser.parse(new FileReader("material.json"));
			JSONObject jsonObject = (JSONObject)obj;
			 JSONObject compose = (JSONObject) jsonObject.get(ss.course);
			 JSONObject compose2 = (JSONObject) compose.get(sem);
			 JSONObject compose3 = (JSONObject) compose2.get(ss.branch);
			 String str = "subj";
			for(int i=0;i<6;i++)
			{
				int j = i+ 1;
				String strx = str + j;
				System.out.print(compose3.get(strx) + ":");
				String n  =s.next();
				Mark.P1 p = m.new P1(n);
				m.p1.add(p);
			}
			enterto(m,id,ss);
			s.close();
		}
		catch(Exception e){}
	}
	public void enterto(Mark m,String n,Student s)
	{
		ArrayList<Mark> al = new ArrayList<Mark>();
		try
		{
			String file = "sem"  + s.sem + ".ser";
			File f = new File(file);
			if(f.exists())
			{
				ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
				Mark a;
				while(true)
				{
					a = (Mark)in.readObject();
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
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("sem" + s.sem + ".ser"));
				int i;
				for(i=0;i<al.size();i++){
					if (al.get(i).id.equals(id)){
						break;
					}
				}
				if(i >= al.size())
				{
					al.add(m);
				}
				else {
					al.get(i).p1.addAll(m.p1);
				}
				for(int j=0;j<al.size();j++)
				{
					Mark mn = al.get(j);
					out.writeObject(mn);
				}
				out.flush();
				out.close();
				System.out.println("student mark got inserted");
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
	}
}
