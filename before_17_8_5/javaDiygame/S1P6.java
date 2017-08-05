package javdiygame;
import javax.swing.*;
public class S1P6 
{
	public static void main(String[] args) 
	{
		boolean cont=false;
		do
		{
			cont=false;
			String names[]={"Define:\"Games\"","Old Wang","Reginoal Math-a-thon","National Math-a-tgon"};
			int element=Integer.parseInt(JOptionPane.showInputDialog("Which element?"));
			String output="The name of the game is:\n";
			output+=names[element];
			JOptionPane.showMessageDialog(null, output);
			String repeat=JOptionPane.showInputDialog("Again");
			if(repeat.equals("yes"))
				cont=true;
		}while(cont);
	}
}
