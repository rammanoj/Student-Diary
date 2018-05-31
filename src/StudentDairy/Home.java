package StudentDairy;

import java.util.*;

public class Home implements Homepage {
	
	public String id;
	public String[] navs = {"Student details  -1","Marks  -2","Attendence  -3","Logout -4"};
	public String[] nav1 = {"Register student  -1","update student  -2","Achievements and Other works  -3","update achievements and other works  -4","View Details  -5","View Achievements  -6","back  -7"};
	public String[] nav2 = {"insert cgpa -1","current CGPA view -2","Insert marks -3","View marks -4","back -5"};
	public String[] nav3 = {"View Attendence -1","Update Attendence -2","view Attendence -3","back -4"};
	public Home(String id)
	{
		this.id = id;
	}
	public void display(String[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
	public void display_home()
	{
		Scanner s = new Scanner(System.in);
		display(navs);
		int n = s.nextInt();
		if(n == 1)
		{
			display_nav1();
		}
		else if(n == 2)
		{
			display_nav2();
		}
		else if(n == 3)
		{
			display_nav3();
		}
		else if( n == 4)
		{
			System.out.println("Logout successfully");
			System.exit(-1);
		}
		else
		{
			System.out.println("please enter a valid input");
			display_home();
		}
		s.close();
	}
	public void display_nav1()
	{
		Scanner s = new Scanner(System.in);
		display(nav1);
		int n = s.nextInt();
		if(n == 1)
		{
			InsertStudent i = new InsertStudent(id);
			i.insert();
		}
		else if(n == 2)
		{
			UpdateStudent up = new UpdateStudent();
			up.update();
		}
		else if(n == 3)
		{
			OtherDetails d = new OtherDetails();
			d.load();
		}
		else if(n == 4)
		{
			OtherDetailUpdate ot = new OtherDetailUpdate();
			ot.update();
		}
		else if(n == 5)
		{
			System.out.println("enter the id of student");
			String sc = s.next();
			DisplayStudent d = new DisplayStudent(sc);
			d.display();
		}
		else if(n == 6)
		{
			System.out.println("enter the id of student");
			String sc = s.next();
			AchieveDisplay a = new AchieveDisplay(sc);
			a.display();
		}
		else if(n == 7)
		{
			display_home(); 
		}
		else
		{
			System.out.println("please enter a valid input");
			display_nav1();
		}
		s.close();
	}
	public void display_nav2()
	{
		Scanner s = new Scanner(System.in);
		display(nav2);
		int n = s.nextInt();
		if(n == 1)
		{
			Displaycgpa d = new Displaycgpa();
			d.insert();
		}
		else if(n == 2)
		{
			Displaycgpa d = new Displaycgpa();
			d.display();
		}
		else if(n == 3)
		{
			System.out.println("Enter id of the student: ");
			String id = s.next();
			Markinsert mi = new Markinsert(id);
			mi.insert();
		}
		else if(n == 4)
		{
			System.out.println("Enter id");
			String id = s.next();
			MarkDisplay mi = new MarkDisplay(id);
			mi.display(id);
		}
		else if(n == 5)
		{
			display_home();
		}
		else
		{
			System.out.println("please enter a valid input");
			display_nav2();
		}
		s.close();
	}
	public void display_nav3()
	{
		Scanner s = new Scanner(System.in);
		display(nav3);
		int n = s.nextInt();
		if(n == 1)
		{
			AttendenceInsert at = new AttendenceInsert();
			at.insert();
		}
		else if(n == 2)
		{
			AttendenceUpdate au = new AttendenceUpdate();
			au.update();
		}
		else if(n == 3)
		{
			AttendenceDisplay ad = new AttendenceDisplay();
			ad.display();
		}
		else if(n == 4)
		{
			display_home();
		}
		else
		{
			System.out.println("please enter a valid input");
			display_nav3();
		}
		s.close();
	}
}