package october;

import java.io.*;

public class KeyWordSort 
{
	public static void main(String[] args) throws IOException
	{
		String test;
		FileOutputStream fos=new FileOutputStream("E:\\Code\\java\\classjava\\src\\october\\Keywordtest.txt");
		DataOutputStream dos=new DataOutputStream(fos);
		FileInputStream fis=new FileInputStream("E:\\Code\\java\\classjava\\src\\october\\Keywordtest.txt");
		DataInputStream dis=new DataInputStream(fis);
		//File f1=new File("E:\\Code\\java\\classjava\\src\\october\\Keywordtest.txt");
		try
		{
			dos.writeUTF("main");
		}
		finally
		{
			dos.close();
		}
		try
		{
			test=dis.readUTF();
			System.out.println(test.equals("int")||test.equals("double")||test.equals("String")||test.equals("char"));
		}
		finally
		{
			dis.close();
		}
	}
}
