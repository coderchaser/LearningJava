package com.bobliao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculator extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JTextField display= new JTextField();
	private JButton reset= new JButton("CE");
	private String initNumber="";
	double number=0.0;
	private String operator="=";
	private double result=0.0;
	private String[] buttonStr={
		"7","8","9","/",
		"4","5","6","*",		
		"1","2","3","-",
		".","0","=","+",
	};
	private JButton[] buttons= new JButton[buttonStr.length];
	public Calculator(){
		initPanel();
		initAction();
	}
	private void initPanel(){
		JPanel pnl1= new JPanel();
		JPanel pnl2= new JPanel();
		pnl1.setLayout(new BorderLayout());
		pnl1.add(this.display, BorderLayout.CENTER);
		pnl1.add(this.reset,BorderLayout.EAST);
		
		pnl2.setLayout(new GridLayout(4, 4, 2, 2));
		//不能用下面方式访问数组内部元素，因为for each不会改变数组本身的值，虽然也能出现面板
		//但是加入的不是buttons里面的变量，因此后面无法加入actionListener，还是得用下标访问。
//		for(JButton b : buttons){
//			b=new JButton(buttonStr[i]);
//			pnl2.add(b);
//			i++;
//		}
		for(short i=0;i<this.buttonStr.length;i++){
			buttons[i]= new JButton(this.buttonStr[i]);
			pnl2.add(buttons[i]);
		}
		this.setTitle("Simpe Calculator Demo");
		this.setSize(new Dimension(400,300));
		this.getContentPane().setLayout(new BorderLayout(5,5));
		this.getContentPane().add("North",pnl1);
		this.getContentPane().add("Center",pnl2);
		this.setVisible(true);
	}
	private void initAction() {
		this.reset.addActionListener(this);
		this.display.addActionListener(this);
		for(int i=0;i<this.buttonStr.length;i++){
			this.buttons[i].addActionListener(this);
		}
	}
	public void actionPerformed(ActionEvent e){
		Object source=e.getSource();
		String cmd=e.getActionCommand();
		if(source==this.reset) handleReset();
		else if (source==this.display) {
			this.handleJtextField(cmd);
		}
		else if ("1234567890.".indexOf(cmd)>-1) {
			this.handleNumberPoint(cmd);
		}
		else {
			this.handleOperator(cmd);
		}
	}
	private void handleReset(){
		this.initNumber="";
		this.result=0.0;
		this.operator="=";
		this.number=0.0; 
		this.display.setText(this.initNumber);
	}
	private void handleNumberPoint(String cmd){
		this.initNumber+=cmd;
		this.display.setText(this.initNumber);
	}
	private void handleJtextField(String cmd){
	
	}
	private void handleOperator(String cmd){
		this.number=Double.parseDouble(this.initNumber);
		switch (this.operator) {
		case "+":
			this.result+=number;
			break;
		case "-":
			this.result-=number;
			break;
		case "*":
			this.result*=number;
			break;
		case "/":
			this.result/=number;
			break;
		case "=" : 
			this.result=number;
		default:
			break;
		
		}
		this.operator=cmd;
		this.display.setText(String.valueOf(this.result));
		this.initNumber="";
	}
	public static void main(String args[]) {
		new Calculator();
	}
}
