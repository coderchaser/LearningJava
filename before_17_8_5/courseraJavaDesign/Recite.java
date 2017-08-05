package courseraJavaDesign;//coursera上唐大仕老师的课

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Recite extends JFrame
{
	JLabel lblword =new JLabel("word");
	JLabel lblMeaning =new JLabel("meaning");
	public void init() {
		setSize(400,100);
		setLayout(new FlowLayout());
		getContentPane().add(lblword);
		getContentPane().add(lblMeaning);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String args[])
	{
		
	}
}
