package october;
public class Practice 
{
	private int[] a;
	public Practice(int[] array)
	{
		this.a=array;
	}
	public static boolean equals(int a[],int b[])
	{
		boolean equal=false;
		if(a.length==b.length)
		{
			for(int i=0;i<a.length;i++)
			{
				if(a[i]==b[i])
					equal=true;
				else
				{
					equal=false;
					break;
				}
			}
		}
		return equal;
	}
	public static double pow(double x,double y)
	{
		if(y==0)
			return 1;
		else 
			return x*Math.pow(x, y-1);
	}
	public static void main(String args[])
	{
		int a[]={1,2,3,4},b[]={1,2,3,4};
		//Practice array1=new Practice(a);
		//Practice array2=new Practice(b);
		System.out.println(equals(a, b));
		int y=-1;
		int x=2;
		System.out.println(pow(x,y));
		String d="d";
		String e="e";
		System.out.println(d.compareTo(e));
	}
}
