package com.bobliao;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import java.util.Collections;
import java.util.Iterator;



public class JigSaw {
	static final int RC=4;
	final int N=RC*RC;
	private int step=0;
	private int[] blockList={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
	private JFrame frame=new JFrame();
	private JPanel panel1=new JPanel();
	private JPanel panel2=new JPanel();
	private JButton startButton=new JButton("开始游戏");
	private JButton gameAgain= new JButton("再来一次");
	private JButton[] buttons=new JButton[N];
	public JigSaw(){
		this.setInitState();
		//��ʼ��
		this.panel2.add(startButton);
		this.panel2.add(gameAgain);
		this.frame.setLayout(new BorderLayout());
		this.frame.add(panel1,BorderLayout.CENTER);
		this.frame.add(panel2,BorderLayout.SOUTH);
		frame.setSize(350, 400);
		frame.setLocation(400, 200);
		frame.setTitle("����ƴͼ��Ϸ");
		frame.setVisible(true);
		this.startButton.addActionListener((e) -> {
			startButtonClicked();
			this.startButton.setEnabled(false);
		});
		this.gameAgain.addActionListener((e) ->{
			this.frame.dispose();
			new JigSaw();
		});
		for(int i=0;i<this.N;i++){
			this.buttons[i].addActionListener((e) -> {
				JButton ebutton=(JButton)e.getSource();
				int j =Integer.parseInt(ebutton.getText());
				buttonClicked(ebutton,j);
			});
		}
	}
	private void buttonClicked(JButton bt,int j){
		//TODO ÿ���챻���µ���Ӧ
		int pose=getPose(bt);
		int blankPose=getBlankPose();
		if (blankPose==pose-1 | blankPose==pose+1 | blankPose== pose+4 | blankPose== pose-4) {
		this.buttons[blankPose].setText(""+j);
		this.buttons[blankPose].setVisible(true);
		this.buttons[pose].setText(""+this.N);
		this.buttons[pose].setVisible(false);
		}
		step++;
		if(checkEnd()){
			//�走���Һ����治����󰡣�׽�����������Ͳ���ϸд��~~
			String message= String.format("��ϲ��ƴͼ��ɣ��������һ�μ�������һ�Σ���һ������ %d����",this.step);
			JOptionPane.showMessageDialog(null,message);
		}
	}
	private int getPose(JButton bt){
		for(int i=0;i<this.N;i++){
			if(this.buttons[i]==bt) return i;
		}
		return -1;
	}
	private int getBlankPose() {
		for(int i=0;i<this.N;i++){
			String tmp=this.buttons[i].getText();
			if(tmp.equals("16")) return i;
		}
		return -1;
	}
	private boolean checkEnd() {
		for(int i=0;i<this.N-1;i++){
			if(!this.buttons[i+1].getText().equals(this.buttons[i].getText())) return false;
		}
		return true;
	}
	private void startButtonClicked() {
		//���ҿ�֮���˳��
		ArrayList<Integer> blockList1=new ArrayList<Integer>();
		for (int i:blockList){
			blockList1.add(i);
		}
		Collections.shuffle(blockList1);
		Iterator<Integer> ite=blockList1.iterator();
		for(int i=0;i<N;i++){
			this.buttons[i].setText(""+ite.next());
			if(!ite.hasNext()) break;
		}
		int i=findblank(blockList1);
		this.buttons[i].setVisible(false);
		this.buttons[15].setVisible(true);
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
