package sptember;
public class Practice 
{
	public static String readLine() throws java.io.IOException
	{
		System.out.print("����һ���ַ������Իس����з�������");
		byte buffer[]=new byte[512];
		int count=System.in.read(buffer);
		System.in.close();
		return(count==-1)?null:new String(buffer,0,count-2);
	}
	public static void main(String[] args)throws java.io.IOException
	{
		String s=readLine();
		int value=Myinteger.parseInt(s);
		System.out.println("Myinteger.toString("+value+",2)="+Myinteger.toString(value,2));
		System.out.println("Myinteger.toString("+value+",16)="+Myinteger.toString(value,16));
	}
}
