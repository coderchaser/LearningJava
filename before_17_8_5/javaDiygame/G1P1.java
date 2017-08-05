package javdiygame;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class G1P1 extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int WIDTH=900,HEIGHT=650;
	Rectangle left=new Rectangle(0,0,WIDTH/9,HEIGHT);
	Rectangle right=new Rectangle((WIDTH/9)*9,0,WIDTH/9,HEIGHT);
	Rectangle top=new Rectangle(0,0,WIDTH,HEIGHT/9);
	Rectangle bottom=new Rectangle(0,(HEIGHT/9)*9,(WIDTH/9)*10,HEIGHT/9);
	Rectangle center=new Rectangle((int)((WIDTH/9)*2.5),(int)((HEIGHT/9)*7),(int)((WIDTH/9)*5),(HEIGHT/9)*4);
	Rectangle obstacle=new Rectangle(WIDTH/2,(int)((HEIGHT/7)*5),WIDTH/10,HEIGHT/4);
	Rectangle obstacle2=new Rectangle(WIDTH/3,(int)((HEIGHT/9)*5),WIDTH/10,HEIGHT/4);
	Rectangle obstacle3=new Rectangle(2*WIDTH/3,(int)((HEIGHT/9)*5),WIDTH/10,HEIGHT/4);//mark1 bracket removed
	Rectangle obstacle4=new Rectangle(WIDTH/3,HEIGHT/9,WIDTH/30,HEIGHT/9);
	Rectangle obstacle5=new Rectangle(WIDTH/2,(int)((HEIGHT/9)*1.5),WIDTH/30,HEIGHT/4);
	Rectangle finish=new Rectangle(WIDTH/9,(HEIGHT/2)-HEIGHT/9,(int)((WIDTH/9)*1.5),HEIGHT/70);
	Rectangle line0=new Rectangle(WIDTH/9,HEIGHT/2,(int)((WIDTH/9)*1.5)/2,HEIGHT/140);
	Rectangle line1=new Rectangle(((WIDTH/9)+((int)((WIDTH/9)*1.5)/2)),(HEIGHT/2)+(HEIGHT/10),(int)((WIDTH/9)*1.5)/2,HEIGHT/140);
	public G1P1()
	{
		super("Radical Racing");
		setSize(WIDTH/9*10,HEIGHT/9*10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.blue);
		g.fillRect(left.x, left.y, left.width, left.height);
		g.fillRect(right.x, right.y, right.width, right.height);
		g.fillRect(top.x,top.y, top.width,top.height);
		g.fillRect(bottom.x, bottom.y, bottom.width, bottom.height);
		g.fillRect(center.x, center.y, center.width, center.height);
		g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
		g.fillRect(obstacle2.x, obstacle2.y, obstacle2.width, obstacle2.height);
		g.fillRect(obstacle3.x, obstacle3.y, obstacle3.width, obstacle.height);
		g.fillRect(obstacle4.x, obstacle4.y, obstacle4.width, obstacle4.height);
		g.fillRect(obstacle5.x, obstacle5.y, obstacle5.width, obstacle5.height);
		g.setColor(Color.white);
		g.fillRect(line0.x, line0.y, line0.width, line0.height);
		g.fillRect(line1.x, line1.y, line1.width, line1.height);
		g.setColor(Color.yellow);
		g.fillRect(finish.x, finish.y, finish.width, finish.height);
	}
	public static void main(String[] args) 
	{
		new G1P1();
	}
}
