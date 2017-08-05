package sptember;
public class Arrayparse 
{
	public static void print(int value[][])
	{
		for(int i=0;i<value.length;i++)
		{
			for(int j=0;j<value[i].length;j++)
			{
				System.out.print(" "+value[i][j]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args)
	{
		int a[]={7,4,8,9,1,5};
		int b[][]=new int[a.length][a.length];
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<b[i].length;j++)
			{
				if(j+i<b[i].length)
					b[i][j+i]=a[j];
				else
					b[i][j+i-b[i].length]=a[j];
			}
		}
		print(b);
	}
}
