package jigsaw;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.sun.org.apache.bcel.internal.generic.NEW;



public class JigSaw {
	static final int RC=4;
	final int N=RC*RC;
	//private int[] blockList=new int[N];
	private JFrame frame=new JFrame();
	private JPanel panel1=new JPanel();
	private JPanel panel2=new JPanel();
	private JButton startButton=new JButton("开始游戏");
	private JButton[] buttons=new JButton[N];
	public JigSaw(){
		this.setInitState();
		this.panel2.add(startButton);
		this.frame.setLayout(new BorderLayout());
		this.frame.add(panel1,BorderLayout.CENTER);
		this.frame.add(panel2,BorderLayout.SOUTH);
		frame.setSize(350, 400);
		frame.setLocation(400, 200);
		frame.setTitle("数字拼图游戏");
		frame.setVisible(true);
		this.startButton.addActionListener((e) -> {
			startButtonClicked();
		});
	}
	private void startButtonClicked() {
		//打乱块之间的顺序
		
	}
	private void setInitState() {
		this.panel1.setLayout(new GridLayout(RC, RC, 5, 5));
		this.panel1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		for(int i=0;i<this.N;i++){
			buttons[i]=new JButton(String.valueOf(i+1));
			this.panel1.add(buttons[i]);
		}
		buttons[N-1].setVisible(false);
	}
	
	public static void main(String args[]) {
		new JigSaw();
	}
}
