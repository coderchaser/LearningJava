package sptember;
public class JosephusProblem //约瑟夫圆环问题
{	
	public static void main(String[] args) 
	{
		int n=5,s,d,count=1,number=0,last=0;
		int a[]=new int[n];
		for(int i=0;i<a.length;i++)
			a[i]=1;
		s=1;
		d=2;
		while(number!=1)
		{
			if(s<a.length)
			{
				a[s+d-2]=0;
				s+=d;
			}
			else
			{
				s=s-1-count*n;
				a[s-1+d*(n-s)/d]=0;
				count++;
			}
			for(int k=0;k<a.length;k++)
			{
				if(a[k]==1)
				{
					number++;
					last=k;
				}
			}
		}
		System.out.println(last);
	}
}
