package StudentDairy;

import java.io.*;

public class Student implements Serializable , Students
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String id;
	public String name;
	public String class1;
	public String sem;
	public String course;
	public String branch;
	public String mobile;
	public String enrollmentstatus;
	public String years;
	public String type;
	public String email;

	public Student(String id,String email,String name, String class1, String sem, String course, String branch, String mobile, String enroll, String years, String type)
	{
		this.name = name;
		this.class1 = class1;
		this.sem = sem;
		this.course = course;
		this.branch = branch;
		this.mobile = mobile;
		this.enrollmentstatus = enroll;
		this.years = years;
		this.type = type;
		this.email = email;
		this.id = id;
	}
	public void setname(String name)
	{
		this.name = name;
	}
	public void setclass(String class1)
	{
		this.class1 = class1;
	}
	public void setsem(String sem)
	{
		this.sem = sem;
	}
	public void setcourse(String course)
	{
		this.course = course;
	}
	public void setbranch(String branch)
	{
		this.branch = branch;
	}
	public void setmobile(String mobile)
	{
		this.mobile = mobile;
	}
	public void setemail(String email)
	{
		this.email = email;
	}
	public String toString()
	{
		return "name "+ this.name + "id " + this.id + "sem " + this.sem;
	}
}
