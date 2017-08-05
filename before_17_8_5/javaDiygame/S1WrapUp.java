package javdiygame;
import javax.swing.*;
public class S1WrapUp
{
	public static void main(String[] args)
	{
		int guess=-1;
		int count=0;
		int num=(int)(Math.random()*100);
		do
		{
			guess=Integer.parseInt(JOptionPane.showInputDialog("Guess a number between 0 and 1001"));
			if(guess>num)
			{
				JOptionPane.showMessageDialog(null, "Too High");
			}
			if(guess<num)
				JOptionPane.showMessageDialog(null, "Too Low");
			count++;
		}while(num!=guess);
		JOptionPane.showMessageDialog(null, "you guessed the number-"+num+"-in "+count+"times");
	}

}
