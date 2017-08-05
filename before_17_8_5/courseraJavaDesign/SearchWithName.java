package courseraJavaDesign;

import java.awt.*;
import javax.swing.*;


import java.util.*;
import java.awt.event.*;

public class SearchWithName extends JFrame implements ActionListener
{
	private String[] name={"毛志超","王佳禄","雷志刚","钟魁松"};
	private int age[]={21,100,21,22};
	private Button button_name,button_retrieve;
	private TextField text_age,text_name;
	public SearchWithName() {
		super("年龄查询");
		this.setBounds(300, 400, 400, 90);
		this.setLayout(new GridLayout(2, 3, 5, 5));
		this.setBackground(Color.blue);
		this.add(new Label("姓名",Label.CENTER));
		text_name=new TextField(10);
		this.add(text_name);
		button_name =new Button("查询");
		button_name.addActionListener(this);
		this.add(button_name);
		//this.add();
		this.add(new Label("年龄",Label.RIGHT));
		//this.add(new Label("年龄",Label.RIGHT));
		text_age=new TextField(10);
		this.add(text_age);
		button_retrieve=new Button("撤销");
		button_retrieve.addActionListener(this);
		this.add(button_retrieve);
		this.addWindowListener(new WinClose());
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==button_name) {
			String input=text_name.getText();
			int i;
			if(input.equals(""))
				text_age.setText("Error:Name is null");
			else
			{
			for(i=0;i<name.length;i++)
			{
				if(input.equals(name[i]))
				{
					text_age.setText(""+age[i]);
					break;
				}
			}
			if(i>=name.length)
			{
				text_age.setText("Error:Not the Guy");
			}
			}
		}
		if (e.getSource()==button_retrieve) {
			text_name.setText("");
			text_age.setText("");
		}
	}
	public static void main(String args[]) {
		new SearchWithName();
	}
	class WinClose implements WindowListener
	{
		public void windowClosing(WindowEvent ev)
		{
			System.exit(0);
		}
		public void windowOpened(WindowEvent ev){}
		public void windowActivated(WindowEvent ev){}
		public void windowDeactivated(WindowEvent ev){}
		public void windowClosed(WindowEvent ev){}
		public void windowIconified(WindowEvent ev){}
		public void windowDeiconified(WindowEvent ev){}
	}
}
