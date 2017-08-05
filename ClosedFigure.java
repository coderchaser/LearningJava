package examplefromtextbook;

public abstract class ClosedFigure extends Figure
{
	protected String shape;
	protected ClosedFigure(Point point,String shape)
	{
		super(point);
		this.shape=shape;
	}
	protected ClosedFigure()
	{
		this(new Point(),"未知");
	}
	public abstract double permieter();
	public abstract double area();
	public void print()
	{
		System.out.println(this.toString()+",周长"+String.format("%1.2f,面积%1.2f", this.permieter(),this.area()));
	}
	public static void main(String[] atgs)
	{
		Point p1=new Point(100,100);
		ClosedFigure fig=new Triangle(p1,new Point(100,130),new Point(140,130));
		fig.print();
	}
}

