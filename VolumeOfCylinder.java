package october;

public class VolumeOfCylinder implements SolidGraphics 
{
	public double pi=3.1415926;
	public double r;
	public double h;
	public VolumeOfCylinder(double r,double h)
	{
		this.h=h;
		this.r=r;
	}
	public double volume()
	{
		//return pi*r*r*h;
		return this.pi*this.r*this.r*this.h;
	}
	public static void main(String[] args) 
	{
		VolumeOfCylinder a=new VolumeOfCylinder(10,4);
		System.out.println(a.volume());
		System.out.println(TESTCONSTANT);
	}
}
