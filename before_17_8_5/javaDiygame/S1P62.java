package javdiygame;
import javax.swing.*;
import java.util.*;//这是S1P6和S1P7合体
public class S1P62 
{
	public static void main(String[] args) 
	{
		ArrayList<String> games=new ArrayList<String>();//这里使用ArrayList时我将Objiect转为String类型，后面add方法不用加String类型了。
		boolean cont=false;
		do
		{
			cont=false;
			int choice=Integer.parseInt(JOptionPane.showInputDialog("Enter\n"+"1 to add a new game\n"+"2 to access games"));
			if (choice==1)
			{
				String name;
				name=JOptionPane.showInputDialog("Game name?");
				games.add(name);
			}
			if(choice==2)
			{
				int element=Integer.parseInt(JOptionPane.showInputDialog("Which element?"));
				String output="The name of the game is:\n";
				output+=(games.get(element));
				JOptionPane.showMessageDialog(null, output);
			}
			String repeat=JOptionPane.showInputDialog("Again? :yes or no");
			if(repeat.equals("yes"))
				cont=true;
		}while(cont);
			
	}
}
