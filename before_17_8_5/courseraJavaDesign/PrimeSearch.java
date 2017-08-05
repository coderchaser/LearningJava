package courseraJavaDesign;

/*运用埃氏筛选法寻找2~1000内所有素数*/

public class PrimeSearch 
{
	/*******判断一个数是否为素数******/
	public static boolean isPrime(int number)
	{
		int i=2;
		if(number==2)
			return true;
		else
		{
			for(;i<Math.sqrt((double)number);i++)
			{
				if(number%i==0)
					break;
			}
			if(i>Math.sqrt((double)number))
					return true;
			else
				return false;
		}
	}
	/*埃氏筛选法具体实现*/
	public static int[] primeFeedback(int startNumber,int endNumber)
	{
		boolean number[]=new boolean[endNumber];
		int prime[]=new int[10000];
		int count=0;
		for(int i=0;i<number.length;i++)
			number[i]=false;
		for(int i=startNumber;i<number.length;i++)
		{
			if(!isPrime(i))
				continue;
			prime[count++]=i;
			for(int j=i*i;j<number.length;j+=i)
				number[j]=false;
		}
		int prime1[]=new int[count];
		//把prime数组里为true的项挪到prime1里面
		for(int k=0;k<count;k++)
			prime1[k]=prime[k];
		return prime1;
	}
	public static void print(int value[])
	{
		for(int i=0;i<value.length;i++)
		{
			System.out.print(" "+value[i]);
			if((i+1)%20==0)
				System.out.println();
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		int m=2;
		int n=10000;
		print(primeFeedback(m,n));
	}
}
