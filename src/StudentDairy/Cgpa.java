package StudentDairy;

import java.io.*;

public class Cgpa implements Serializable , Cgpas {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public String id;
	public String cgpa;
	public String sem;
	
	public Cgpa(String id,String cgpa,String sem)
	{
		this.id = id;
		this.cgpa = cgpa;
	}
	public Cgpa()
	{
		this.id = " ";
		this.cgpa = " ";
		this.sem = " ";
	}
	public void setcgpa(String cgpa)
	{
		this.cgpa = cgpa;
	}
	public void setid(String id)
	{
		this.id = id;
	}
	public String toStirng()
	{
		return "id " + this.id + " sem: " + this.sem + " cgpa: " + this.cgpa; 
	}
}
