package examplefromtextbook;

public class Triangle extends ClosedFigure
{
	public Point point2,point3;
	protected double a,b,c;
	public Triangle(Point p1,Point p2,Point p3)
	{
		super(p1,"三角形");
		this.point2=p2;
		this.point3=p3;
		this.a=Line.length(p1, p2);
		this.b=Line.length(p2, p3);
		this.c=Line.length(p1, p3);
	}
	public Triangle(Point p1,double a,double b,double c)
	{
		super(p1,"三角形");
		this.point2=this.point3=null;
		this.a=a;
		this.b=b;
		this.c=c;
	}
	public String toString()
	{
		return this.getClass().getName()+this.shape+",三点坐标"+this.point+","+(this.point2==null?"null":this.point2.toString())+","+(this.point3==null?"null":this.point3.toString())+"三边各长"+String.format("%1.2f,%1.2f,%1.2f", this.a,this.b,this.c);
	}
	public double permieter()
	{
		return a+b+c;
	}
	public double area()
	{
		double s=(a+b+c)/2;
		return Math.sqrt(s*(s-a)*(s-b)*(s-c));
	}
	public static double area(Point p1,Point p2,Point p3)
	{
		return new Triangle(p1,p2,p3).area();
	}
}
