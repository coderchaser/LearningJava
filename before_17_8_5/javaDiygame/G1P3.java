package javdiygame;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class G1P3 extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int width=900,height=650;
	double p1speed=0.5,p2speed=0.5;//p1speed=.5?
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
	public G1P3()
	{
		super("Radical Racing");
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Move1 m1=new Move1();
		Move2 m2=new Move2();
		m1.start();
		m2.start();
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
	public static void main(String args[])
	{
		new G1P3();
	}
}
