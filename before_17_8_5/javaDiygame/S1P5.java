package javdiygame;
import javax.swing.*;
import java.io.*;
public class S1P5
{	
	private static BufferedReader buffer;

	public static void main(String[] args) throws Exception
	{
		String input;
		input=JOptionPane.showInputDialog("1 to set password,\n"+"2 to unlock the message");
		File file=new File("password.psswrd");
		if(input.equals("1"))
		{
			String p=JOptionPane.showInputDialog("Enter the password to set");
			FileOutputStream outStream=new FileOutputStream(file);
			PrintWriter out=new PrintWriter(outStream);
			out.println(p);
			out.flush();
			out.close();
			outStream.close();
		}
		else
		{
			FileReader fr=new FileReader(file);
			buffer = new BufferedReader(fr);
			String password=buffer.readLine();
			String userPass;
			userPass=JOptionPane.showInputDialog("Enter your guess...");
			if(password.equals(userPass))
			{
				JOptionPane.showMessageDialog(null,"CORRECT!!!");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"WRONG=(");
			}
		}
	}
}
