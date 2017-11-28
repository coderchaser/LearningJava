package jigsaw;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


import java.util.Collections;
import java.util.Iterator;



public class JigSaw {
	static final int RC=4;
	final int N=RC*RC;
	private int[] blockList={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
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
			this.startButton.setEnabled(false);
		});
	}
	private void startButtonClicked() {
		//打乱块之间的顺序
		ArrayList<Integer> blockList1=new ArrayList<Integer>(); 
		for (int i:this.blockList){
			blockList1.add(i);
		}
		Collections.shuffle(blockList1);
		Iterator ite=blockList1.iterator();
		for(int i=0;i<N;i++){
			this.buttons[i].setText(""+ite.next());
			if(!ite.hasNext()) break;
		}
		int i=findblank(blockList1);
		this.buttons[i].setVisible(false);
	}
	private int findblank(ArrayList<Integer> blockList1) {
		return blockList1.indexOf(N);
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
