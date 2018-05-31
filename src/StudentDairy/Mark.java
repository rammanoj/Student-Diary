package StudentDairy;

import java.io.Serializable;
import java.util.ArrayList;


public class Mark implements Serializable , Marks {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
class P1 implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4325153467736131447L;
	public String mark;
	
	public P1(String mark)
	{
		this.mark = mark;
	}
	public void set(String mark)
	{
		this.mark = mark;
	}
	public String toString()
	{
		return mark;
	}
}

	public ArrayList<P1> p1 = new ArrayList<P1>();
	public String id;
	
	public void setid(String id)
	{
		this.id = id;
	}
}
