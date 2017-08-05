package sptember;
import java.io.*;
public class KeyboardInput 
{
	public static void main(String[] args) throws IOException
	{
		System.out.print("input:");
		byte buffer[]=new byte[512];
		int count=System.in.read(buffer);
		System.out.println("output:");
		for(int i=0;i<count;i++)
			System.out.print(" "+buffer[i]);
		System.out.println();
		for(int i=0;i<count;i++)
			System.out.print((char)buffer[i]);
		System.out.println("count:"+count);
	}
}
