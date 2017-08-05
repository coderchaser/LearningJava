package examplefromtextbook;
public class Point
{
	public int x,y;
	public Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public Point()
	{
		this(0,0);
	}
	public Point(Point p)
	{
		this.x=p.x+1;
		this.y=p.y+1;
	}
	public String toString()
	{
		return "Point("+this.x+","+this.y+")";
	}
	public static void main(String args[])
	{
		Point p1=new Point(100,100);
		System.out.println(p1);
	}
}
