package StudentDairy;

import java.io.*;
import java.util.*;

public class OtherAchievements implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String Scholorship;
	public ArrayList<String> achieve = new ArrayList<String>();
	public int i=0;
	public String id;
	
	public OtherAchievements(String scholorship ,ArrayList<String> al,String id)
	{
		this.id = id;
		this.Scholorship = scholorship;
		this.achieve.addAll(al);
	}
	public OtherAchievements(String scholor,String id)
	{
		this.id = id;
		this.Scholorship = scholor;
	}
	public String toString()
	{
		return "id " + this.id + " achievements " + achieve.get(0);
	}
}
