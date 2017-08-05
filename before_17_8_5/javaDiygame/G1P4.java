package javdiygame;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.applet.AudioClip;
import java.applet.AudioClip.*;

public class G1P4 extends JFrame
{
	URL url1=null,url2=null,url3=null,url4=null,url5=null,url6=null,url7=null,url8=null;
	Image img1,img2,img3,img4,img5,img6,img7,img8;
	URL URLt=null;
	Image title=null;
	final int width=900,height=650;
	boolean winnerChosen=false;
	double p1speed=.5,p2speed=.5;
	int p1Laps=0,p2Laps=0;
	final int up=0,Right=1,down=2,Left=3;
	int p1direction=up;
	int p2direction=up;
	Rectangle left=new Rectangle(0,0,width/9,height);
	Rectangle right=new Rectangle((width/9)*18,0,width/9,height);
	Rectangle top=new Rectangle(0,0,width,height/9);
	Rectangle bottom=new Rectangle(0,(height/9)*8,(width/9)*9,height/9);
	Rectangle center=new Rectangle((int)((width/9)*2.5),(int)((height/9)*2.5),(int)((width/9)*5),(height/9)*4);
	Rectangle obstacle=new Rectangle(width/2,(int)((height/9)*7),width/10,height/9);
	Rectangle obstacle2=new Rectangle(width/3,(int)((height/9)*5),width/10,height/4);
	Rectangle obstacle3=new Rectangle(2*(width/3),(int)((height/9)*5),width/10,height/4);
	Rectangle obstacle4=new Rectangle(width/3,height/9,width/30,height/9);
	Rectangle obstacle5=new Rectangle(width/2,(int)((height/9)*1.5),width/30,height/4);
	Rectangle finish=new Rectangle(width/9,height/2-height/9,(int)((width/9)*1.5),height/70);
	Rectangle p1=new Rectangle(width/9,height/2,width/30,width/30);
	Rectangle p2=new Rectangle(((width/9)+(int)((width/9)*1.5/2)),(height/2)+(height/10),width/30,width/30);
	public G1P4()
	{
		super("Radical Racing");
		super.setSize(width,height);//super.��this.ò�������ﶼ����.
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setVisible(true);
		try
		{
			url1=this.getClass().getResource("G1P4Img1.jpg");
			url2=this.getClass().getResource("G1P4Img2.jpg");
			url3=this.getClass().getResource("G1P4Img3.jpg");
			url4=this.getClass().getResource("G1P4Img4.jpg");
			url5=this.getClass().getResource("G1P4Img5.jpg");
			url6=this.getClass().getResource("G1P4Img6.jpg");
			url7=this.getClass().getResource("G1P4Img7.jpg");
			url8=this.getClass().getResource("G1P4Img8.jpg");
			URLt=this.getClass().getResource("title.png");
		}catch (Exception e){}
		img1=Toolkit.getDefaultToolkit().getImage(url1);
		img2=Toolkit.getDefaultToolkit().getImage(url2);
		img3=Toolkit.getDefaultToolkit().getImage(url3);
		img4=Toolkit.getDefaultToolkit().getImage(url4);
		img5=Toolkit.getDefaultToolkit().getImage(url5);
		img6=Toolkit.getDefaultToolkit().getImage(url6);
		img7=Toolkit.getDefaultToolkit().getImage(url7);
		img8=Toolkit.getDefaultToolkit().getImage(url8);
		title=Toolkit.getDefaultToolkit().getImage(URLt);
		JOptionPane.showMessageDialog(null, "welcome to radical racing! \n\n"+"Game:2 players racing\n"+"Global:Complete 3 full laps before your opponent\n"
		+ "Controls:\n"+"Plyaer1:\n"+"(Blue car)WASD directional,speed is automatic\n"+"Player2:\n"+"(Redcar)IJKL directional"
				+ ",speed is automatic\n"+"also,be sure to avoid the green grass.It is slick\n"+"and might make you spin out!\n\n"+"Click OK to start");
		Move1 m1=new Move1();
		Move2 m2=new Move2();
		m1.start();
		m2.start();
		try
		{
			URL eng = this.getClass().getResource("engine.wav");
			AudioClip snd=JApplet.newAudioClip(eng);
			snd.loop();
		}
		catch(Exception e){}
		}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.green);
		Rectangle line0=new Rectangle(width/9,height/2,(int)((width/9)*1.5)/2,height/140);
		//Rectangle line1=new Rectangle(((width/9)+((int)((width/9)*1.5)/2)),(height/2+height/10),(int)((width/9)*1.5)/2,height/140);
		Rectangle line1=new Rectangle(((width/9)+((int)((width/9)*1.5)/2)),(height/2)+(height/10),(int)((width/9)*1.5)/2,height/140);
		g.fillRect(left.x, left.y, left.width, left.height);
		g.fillRect(right.x, right.y, right.width, right.height);
		g.fillRect(bottom.x, bottom.y, bottom.width, bottom.height);
		g.fillRect(top.x, top.y, top.width, top.height);
		g.fillRect(center.x, center.y, center.width, center.height);
		g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
		g.fillRect(obstacle2.x, obstacle2.y, obstacle2.width, obstacle2.height);
		g.fillRect(obstacle3.x, obstacle3.y, obstacle3.width, obstacle3.height);
		g.fillRect(obstacle4.x, obstacle4.y, obstacle4.width, obstacle4.height);
		g.fillRect(obstacle5.x, obstacle5.y, obstacle5.width, obstacle5.height);
		g.setColor(Color.white);
		g.fillRect(line0.x, line0.y, line0.width, line0.height);
		g.fillRect(line1.x, line1.y, line1.width, line1.height);
		g.setColor(Color.yellow);
		g.fillRect(finish.x, finish.y, finish.width, finish.height);
		g.drawImage(title, center.x+10, center.y+10, this);
		if(p1direction==up)
			g.drawImage(img5, p1.x, p1.y, this);
		if(p1direction==Left)
			g.drawImage(img8, p1.x, p1.y, this);
		if(p1direction==down)
			g.drawImage(img7, p1.x, p1.y, this);
		if(p2direction==Right)
			g.drawImage(img6, p1.x, p2.y, this);
		if(p2direction==up)
			g.drawImage(img1, p2.x, p2.y, this);
		if(p2direction==Left)
			g.drawImage(img4, p2.x, p2.y, this);
		if(p2direction==down)
			g.drawImage(img3, p2.x, p2.y, this);
		if(p2direction==Right)
			g.drawImage(img2, p2.x, p2.y, this);
		g.setColor(Color.blue);
		g.fill3DRect(p1.x, p1.y, p1.width, p1.height,true);
		g.setColor(Color.red);
		g.fill3DRect(p2.x, p2.y, p2.width, p2.height, true);
		
	}
	private class Move1 extends Thread implements KeyListener
	{
		public void run()
		{
			addKeyListener(this);
			while(true)
			{
				try
				{
					repaint();
					if(p1.intersects(left)||p1.intersects(right)||p1.intersects(top)||p1.intersects(bottom)||p1.intersects(obstacle)||p1.intersects(obstacle2)||p1.intersects(obstacle3)||p1.intersects(obstacle4)||p1.intersects(obstacle5))
						p1speed=-4;
					if(p1.intersects(center))
						p1speed=-2.5;
					if(p1.intersects(finish)&&p1direction==up)
						p1Laps++;
					if(p1Laps>=24)
					{
						if(!winnerChosen)
						{
							winnerChosen=true;
							JOptionPane.showMessageDialog(null, "Player1(blue)wins!!!");
							break;
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Player2(blue):loses!!!1;(\n"+"Player2(red):wins!!!:D");
							break;
						}
					}
					if(p1speed<=5)
						p1speed+=2;
					if(p1direction==up)
						p1.y-=(int)p1speed;
					if(p1direction==down)
						p1.y+=(int)p1speed;
					if(p1direction==Left)
						p1.x-=(int)p1speed;
					if(p1direction==Right)
						p1.x+=(int)p1speed;
					Thread.sleep(75);//��Ϊ���75msԵ����
				}catch (Exception e)
								{
									break;
								}
			}
		}
		public void keyPressed(KeyEvent event){}
		public void keyReleased(KeyEvent event){}
		public void keyTyped(KeyEvent event)
		{
			if(event.getKeyChar()=='a')
				p1direction=Left;
			if(event.getKeyChar()=='s')
				p1direction=down;
			if(event.getKeyChar()=='d')
				p1direction=Right;
			if(event.getKeyChar()=='w')
				p1direction=up;
		}
	}
	private class Move2 extends Thread implements KeyListener
	{
		public void run()
		{
			addKeyListener(this);
			while(true)
			{
				try
				{
					repaint();
					if(p2.intersects(left)||p2.intersects(right)||p2.intersects(top)||p2.intersects(bottom)||p2.intersects(obstacle)||p2.intersects(obstacle2)||p2.intersects(obstacle3)||p2.intersects(obstacle4)||p2.intersects(obstacle5))
						p2speed=-4;
					if(p2.intersects(center))
						p2speed=-2.5;
					if(p2.intersects(finish)&&p2direction==up)
						p2Laps++;
					if(p2Laps>=32)
					{
						if(!winnerChosen)
						{
							winnerChosen=true;
							JOptionPane.showMessageDialog(null, "Player2(red)wins!!!");
							break;
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Player2(red):loses!!!1;(\n"+"Player1(blue):wins!!!:D");
							break;
						}
					}
					if(p2speed<=5)
						p2speed+=2;
					if(p2direction==up)
						p2.y-=(int)p2speed;
					if(p2direction==down)
						p2.y+=(int)p2speed;
					if(p2direction==Left)
						p2.x-=(int)p2speed;
					if(p2direction==Right)
						p2.x+=(int)p2speed;
					Thread.sleep(75);
				}catch (Exception e)
								{
									break;
								}
			}
		}
		public void keyPressed(KeyEvent event){}
		public void keyReleased(KeyEvent event){}
		public void keyTyped(KeyEvent event)
		{
			if(event.getKeyChar()=='j')
				p2direction=Left;
			if(event.getKeyChar()=='k')
				p2direction=down;
			if(event.getKeyChar()=='k')
				p2direction=Right;
			if(event.getKeyChar()=='l')
				p2direction=up;
		}
	}
	public static void main(String[] args)
	{
		new G1P4();
	}

}
