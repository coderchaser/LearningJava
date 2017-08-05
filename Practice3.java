package october;

import java.io.*;

public class Practice3 
{
	public static void main(String args[]) 
	{
		try
		{
			 
			File dir=new File(".","");
			File f1=new File(dir,"test.txt");
			FileOutputStream fos=new FileOutputStream(f1);
			fos.write(12);
			fos.close();
			System.out.println(dir);
			System.out.println(f1.getPath());
			System.out.println(f1.getAbsolutePath());
			System.out.println(f1.getName());
			System.out.println(f1.getParentFile());
			System.out.println(f1.exists());
			System.out.println(f1.lastModified());
			System.out.println(f1.canWrite());
			//f1.delete();
			f1.createNewFile();
			}
			catch(IOException e)
			{
				
			}
	}
}
