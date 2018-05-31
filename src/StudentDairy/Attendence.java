package StudentDairy;

import java.io.*;

public class Attendence implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String sem;
	public String atten;
	public String id;
	public String subj;
	public Attendence(String id,String sem,String atten,String subj)
	{
		this.id = id;
		this.sem = sem;
		this.atten = atten;
		this.subj = subj;
	}
	public Attendence()
	{
		this.id = " ";
		this.sem = " ";
		this.atten = " ";
	}
	public String toString()
	{
		return "id: " + this.id + " sem: " + this.sem + " attendence: " + this.atten;
	}
}
