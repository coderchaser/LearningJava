package october;

import java.io.*;

public class Random_file
{
	public static void main(String args[]) 
	{
		int data_arr[]={12,31,56,23,27,1,43,65,4,99};
		try
		{
			RandomAccessFile randf=new RandomAccessFile("test.txt","rw");
			for(int i=0;i<data_arr.length;i++)
				randf.write(data_arr[i]);
			for(int i=data_arr.length-1;i>=0;i--)
			{
				//randf.seek(i*4L);
				System.out.println(randf.readInt());
			}
			randf.close();
		}
		catch(IOException e)
		{
			System.out.println("File access error"+e);
		}
	}
}
