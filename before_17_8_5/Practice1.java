package october;

import java.io.*;// ‰»Î ‰≥ˆ¡˜—µ¡∑

public class Practice1 
{
	public static void main(String args[])
	{
		try
		{
			File inFile=new File("E:\\Code\\java\\classjava\\src\\october\\file1.txt");
			File outFile=new File("E:\\Code\\java\\classjava\\src\\october\\file2.txt");
			File repeaterFile=new File("E:\\Code\\java\\classjava\\src\\october\\file3.txt");
			FileInputStream fis=new FileInputStream(inFile);
			FileInputStream fis1=new FileInputStream(outFile);
			FileOutputStream fos=new FileOutputStream(repeaterFile,true);
			int c;
			while((c=fis.read())!=-1)
				fos.write(c);
			fis.close();
			while((c=fis1.read())!=-1)
				fos.write(c);
			fis1.close();
			fos.close();
		}catch(FileNotFoundException e)
		{
			System.out.println("FileStreamsTest: "+e);
		}
		catch(IOException e)
		{
			System.err.println("FileStreamTest: "+e);
		}		
	}
}
