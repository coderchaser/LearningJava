package courseraJavaDesign;

public class MultiChartTen {
	public int n;
	private static String test="ss";//�������test��Practice.testΪʲô����ֱ�����ֿ�����
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
		//System.out.println(Practice.test==test);//��������testֻ��ʾMultiChart��test��������
	}
}
