package sptember;

public class divisor 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int a=9,b=99,c=9,i;//输入三个整数
		int divisor=0;
		int max=a;
		if(a<=b)
			max=b;
		if(max<=c)
			max=c;
		/*if(a>=b)
		{
			int temp1;
			temp1=a;
			a=b;
			b=temp1;
		}
			
		else
			if(b>=c)
			{
				int temp2;
				temp2=b;
				b=c;
				c=temp2;
			}
		System.out.printf("%d %d %d",a,b,c);
		int s[]=new int[c];*/
		for(i=1;i<=max;i++)
		{
			if(a%i==0&&b%i==0&&c%i==0)
				divisor=i;
		}
		System.out.println("最大公约数是"+divisor);//输出最大公约数
	}

}
