package StudentDairy;

import java.io.Serializable;

public class Teacher  implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
	public String password;
	public String mobile;
	public String email;
	public String students;
	public String doj;

	public Teacher()
	{
		
	}
	public Teacher(String name ,String password , String mobile , String email , String students , String doj )
	{
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		this.email = email;
		this.students = students;
		this.doj = doj;

	}
	public void setname(String name)
	{
		this.name = name;
	}
	public void setpassword(String password)
	{
		this.password = password;
	}
	public void setmobile(String mobile)
	{
		this.mobile = mobile;
	}
	public void setemail(String email)
	{
		this.email = email;
	}
	public void setstudents(String students)
	{
		this.students = students;
	}
	public void setdoj(String doj)
	{
		this.doj = doj;
	}
}