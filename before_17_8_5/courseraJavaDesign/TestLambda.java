package courseraJavaDesign;

interface Fun{double fun(double x);}

public class TestLambda 
{
	public double fun(Fun a,double b)
	{
		return a.fun(b);
	}
	public double print()
	{
		double d=fun(x->x*2,1);
		return d;
	}
	public static void main(String args[])
	{
		TestLambda aa=new TestLambda();
		System.out.println(aa.print());
	}
}
