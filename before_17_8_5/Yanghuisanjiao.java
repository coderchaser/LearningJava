package sptember;

public class Yanghuisanjiao 
{
	public static void main(String[] args) 
	{
		int i,j,n;
		n=20;
		int mat[][]=new int[n][];
		for(i=0;i<n;i++)
		{
			mat[i]=new int[i];
			for(j=0;j<i;j++)
			{
				if(j==0||j==i-1)
					mat[i][j]=1;
				else
				{
					mat[i][j]=mat[i-1][j-1]+mat[i-1][j];
				}
				System.out.print(" "+mat[i][j]);
				if(j==mat[i].length-1)
					System.out.println();
			}
		}
	}

}
