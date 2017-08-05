package courseraJavaDesign;

public class MultiChartTen {
	public int n;
	private static String test="ss";//这里这个test和Practice.test为什么可以直接区分开来？
	public MultiChartTen(int n)
	{
		MultiChartTen.print(n);
	}
	public static void print(int n)
	{
		int i,j;
		for(i=1;i<n;i++)
		{
			for(j=1;j<=i;j++)
			{
				System.out.print(j+"*"+i+"="+i*j);
				System.out.print("  ");
			}
			System.out.println();
		}
	}
	public static void main(String args[])
	{
		new MultiChartTen(10);
		//System.out.println(Practice.test==test);//这里输入test只提示MultiChart的test。。。。
	}
}
