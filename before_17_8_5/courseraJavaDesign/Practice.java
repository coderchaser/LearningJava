package courseraJavaDesign;

import java.awt.print.Printable;

public class Practice 
{
	private static final float MINMONEY=0.01F;
	private static final float MAXMONEY=200F;
	
	private boolean isRight(float money,int count) {
		double avg=money/count;
		if(avg<MINMONEY)
		{
			return false;
		}
		else if (avg>MAXMONEY) {
			return false;
		}
		return true;
	}
	public static void main(String args[]) 
	{
		float num=10,N=(float)1.9;
		int people=10;
		for(int i=0;i<10;i++)
		{
			System.out.println("the number"+people+"can get"+num/people*N);
			num=num-num/people*N;
			people--;
		}
		System.out.println("threr remain"+num);
	}
}

