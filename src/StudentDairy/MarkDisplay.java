package StudentDairy;

import java.io.*;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MarkDisplay {
	
	public String id;	
	public MarkDisplay(String id)
	{
		this.id = id;
	}
	public Student get()
	{
		try
		{
			@SuppressWarnings("resource")
			ObjectInputStream out = new ObjectInputStream(new FileInputStream("student.ser"));
			Student s = (Student)out.readObject();
			while(s.id.equals(id))
			{
				s = (Student)out.readObject();
				break;
			}
			return s;
		}
		catch(Exception e)
		{
			Student s = null;
			return s;
		}
	}
	public void display(String s)
	{
		try
		{
			Scanner si = new Scanner(System.in);
			Student ss = get();
			String var = "sem"  + ss.sem + ".ser";
			ObjectInputStream out = new ObjectInputStream(new FileInputStream(var));
			Mark m;
			while(true)
			{
				m = (Mark)out.readObject();
				if(m.id.equals(id))
				{
					break;
				}
			}
			JSONParser parser = new JSONParser(); 
			Object obj = parser.parse(new FileReader("material.json"));
			JSONObject jsonObject = (JSONObject)obj;
			 JSONObject compose = (JSONObject) jsonObject.get("b-tech");
			 JSONObject compose2 = (JSONObject) compose.get("sem"+ ss.sem);
			 JSONObject compose3 = (JSONObject) compose2.get("cse");
			 String str1 = "subj";
			 System.out.println("Enter type of mark to be printed");
			 String exam = si.next();
			 int mn=0,n=0;
			 if(exam.equals("p1"))
			 {
				 mn = 0;
				 n = 6;
			 }
			 else if(exam.equals("p2"))
			 {
				 mn = 6;
				 n = 12;
			 }
			 else if(exam.equals("ce"))
			 {
				 mn = 12;
				 n = 18;
				 
			 }
			 else if(exam.equals("endsem"))
			 {
				 mn = 18;
				 n = 24;
			 }
			 int l=0;
			 for(int i=mn;i<n;i++)
				{
					l = l + 1;
					String strx = str1 + l;
					System.out.print(compose3.get(strx) + ":");
					System.out.println(m.p1.get(i).toString());
				}
			 si.close();
			 out.close();
		}
		catch(Exception e){}
	}
}
