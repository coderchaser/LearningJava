package sptember;

public class Saddlepoimt 
{
	//随机生成m行n列矩阵
	public static int[][] random(int m,int n,int max)
	{
		int value[][]=new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				value[i][j]=(int)(Math.random()*max);
		return value;
	}
	//输出矩阵
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
	//筛选鞍点
	public static int[] saddlepoint(int value[][])
	{
		int point[]=new int [value.length];
		for(int i=0;i<value.length;i++)
		{
			int max=value[i][0];
			int row=0,column=0,k=0;
			for(int j=0;j<value[i].length;j++)
			{
				//int min=value[0][j];
				if(max<=value[i][j])
				{
					max=value[i][j];
					column=j;
				}	
				/*for(k=0;k<value.length;k++)
				{
					if(min>=value[k][j])
					{
						min=value[k][j];
						row=k;
					}
				}*/
			}
			for(k=0;k<value.length;k++)
			{
				int min=value[0][column];
				if(min>=value[k][column])
				{
					min=value[k][column];
					row=k;
				}
			}
			if(row==i)
				point[row]=value[row][column];//将鞍点输出到point数组对应位置
		}
		return point;
	}
	//main函数
	public static void main(String[] args) 
	{
		int m,n,max;
		/*int a[][]=new int[3][3];
		a[0][0]=3;a[0][1]=4;a[0][2]=1;
		a[1][0]=3;a[1][1]=6;a[1][2]=1;
		a[2][0]=3;a[2][1]=7;a[2][2]=1;*/
		m=5;
		n=5;
		max=10;
		int mat[][]=random(m,n,max);
		int point[]=saddlepoint(mat);
		System.out.println("矩阵是:");
		print(mat);
		System.out.println("鞍点为：");
		for(int i=0;i<point.length;i++)
			System.out.print(" "+point[i]);
	}
}
