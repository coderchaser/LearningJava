package examplefromtextbook;
public class Line extends Figure
{
	public Point point2;
	public Line (Point point1,Point point2)
	{
		super(point1);
		this.point2=point2;
	}
	public Line(int x1,int y1,int x2,int y2)
	{
		this(new Point(x1,y1),new Point(x2,y2));
	}
	public Line()
	{
		this(new Point(0,0),new Point(0,0));
	}
	public static double length(Point point1,Point point2)
	{
		int a=point2.x-point1.x;
		int b=point2.y-point1.y;
		return Math.sqrt(a*a+b*b);
	}
	public double length()
	{
		return Line.length(this.point, this.point2);
	}
	public String toString()
	{
		return this.getClass().getName()+"9"+this.point.toString()+",length()="+String.format("%1.2f", this.length());
	}
	public static void main(String args[])
	{
		
	}
}
/*public class Line 
{
	public Point start,end;
	public Line(Point start,Point end)
	{
		this.start=start;
		this.end=end;
	}
	public String toString()
	{
		return this.getClass().getName()+"("+this.start.toString()+","+this.end.toString()+")";
	}
	public static void main(String args[])
	{
		Point start=new Point(100,100);
		Point end=new Point(100,200);
		System.out.println(new Line(start,end).toString());
	}
}*/
