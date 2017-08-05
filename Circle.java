package sptember;

public class Circle
{
	double pi=3.14;
	double r;
	void set(/*double rr*/)
	{
		//r=rr;
		r=Math.random()*100;
	}
	public double area()
	{
		double area=r*r*pi;
		return area;
	}
	/*double pi=3.14,;
	public double area(double r)
	{
		double area;
		area=r*r*pi;
		return area;
	}
	public double set()
	{
		double r;
		r=Math.random()*100;
		return r;
	}*/
	public static void main(String[] args) 
	{
		Circle CIRCLE1=new Circle();
		double area;
		//CIRCLE1.set(10);
		CIRCLE1.set();
		area=CIRCLE1.area();
		System.out.println("The radius is:"+CIRCLE1.r);
		System.out.println("The area of this circle is:"+area);
	}
}
