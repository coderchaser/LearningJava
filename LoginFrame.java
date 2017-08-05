package examplefromtextbook;

import java.awt.*;

public class LoginFrame extends Frame
{
	public LoginFrame()
	{
		super("User Login"); 
		this.setSize(400,200);
		this.setLocation(300,240);
		this.setBackground(Color.lightGray);
		this.setLayout(new FlowLayout());
		this.add(new Label("用户ID"));
		this.add(new TextField("user1",10));
		this.add(new Label("用户密码"));
		this.add(new TextField(10));
		this.add(new Button("OK"));
		this.add(new Button("cancel"));
		this.setVisible(true);
	}
	public static void main(String args[])
	{
		new LoginFrame();
	}
}
