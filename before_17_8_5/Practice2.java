package october;
//数据输入输出流测试
import java.io.*;

public class Practice2 
{
	public static void main(String[] args) throws IOException
	{
		FileOutputStream fos=new FileOutputStream("E:\\Code\\java\\classjava\\src\\october\\a.txt");
		DataOutputStream dos=new DataOutputStream(fos);
		FileInputStream fis=new FileInputStream("E:\\Code\\java\\classjava\\src\\october\\a.txt");
		DataInputStream dis=new DataInputStream(fis);
		try
		{
			dos.writeBoolean(true);
			dos.writeByte((byte)123);
			dos.writeInt(123323);
			dos.writeDouble(123.11);
			dos.writeChar('a');
			dos.writeShort((short)11223);
		}
		finally
		{
			dos.close();
		}
		try
		{
			System.out.println("\t"+dis.readBoolean());//制表符
			System.out.println("\t"+dis.readByte());
			System.out.println("\""+dis.readInt()+"\"");//双引号
			System.out.println(dis.readDouble());
			System.out.println(dis.readChar());
			System.out.println(dis.readShort());
		}
		finally
		{
			fis.close();
		}
	}

}
