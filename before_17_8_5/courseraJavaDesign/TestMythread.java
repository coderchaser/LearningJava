package courseraJavaDesign;
//Ïß³Ì£¿
import java.util.Date;

public class TestMythread extends Thread
{
	public static void main(String args[]) {
		Thread t=new Mythread();
		t.setDaemon(true);
		t.start();
		
		System.out.println("main--"+new Date());
		try{ Thread.sleep(500);}
		catch (InterruptedException ex) {
			System.out.println("main end");// TODO: handle exception
		}
	}

}
class Mythread extends Thread
{
	public void run() {
		for(int i=0;i<10;i++)
		{
			System.out.println(i+"--"+new Date());
			try{ Thread.sleep(100);}
			catch (InterruptedException ex) {
				// TODO: handle exception
			}
		}
	}
}
