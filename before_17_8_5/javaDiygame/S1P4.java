package javdiygame;
import javax.swing.*;
public class S1P4 
{
	public static void main(String[] args) throws Exception 
	{
		int difficulty;
		difficulty=Integer.parseInt(JOptionPane.showInputDialog("How good are you\n"+"1=devil genius...\n"+"10=devil.but not a genius"));
		boolean cont=false;
		do
		{
			cont=false;
			double num1=(int)(Math.round(Math.random()*10));
			double num2;
			do{
				num2=(int)(Math.round(Math.random()*10));
			}while(num2==0.0);
			int sign=(int)(Math.round(Math.random()*10));
			double answer;
			System.out.println("\n\n******");
			if (sign==0)
			{
				System.out.println(num1+" * "+num2);
				answer=num1*num2;
			}
			else if(sign==1)
			{
				System.out.println(num1+"/"+num2);
				answer=num1/num2;
			}
			else if(sign==2)
			{
				System.out.println(num1+"+"+num2);
				answer=num1+num2;
			}
			else if(sign==3)
			{
				System.out.println(num1+"-"+num2);
				answer=num1-num2;
			}
			else
			{
				System.out.println(num1+"%"+num2);
				answer=num1%num2;
			}
			System.out.println("******\n");
			for(int i=difficulty;i>=0;i--)
			{
				System.out.println(i+".....");
				Thread.sleep(500);
			}
			System.out.println("Answer:"+answer);
			String again;
			again=JOptionPane.showInputDialog("Play again");
			if(again.equals("yes"))
				cont=true;
		}while(cont);
	}
}
