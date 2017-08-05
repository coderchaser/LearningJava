package october;

import java.io.*;

public class KeyWordSort1 {
	private String filename;
	private String answer[]={"int","double","boolean"};
	public KeyWordSort1(String filename)
	{
		this.filename=filename;
	}
	public String[] readFromFile() throws IOException
	{
		FileReader fin=new FileReader(this.filename);
		BufferedReader bin=new BufferedReader(fin);
		System.out.println("readfromfile:"+this.filename);
		String aline[]={"","",""};
		int i=0;
		while(bin.readLine()!=null)
		{
			aline[i] =bin.readLine();
			System.out.println(aline[i]);
			i++;
		}
		bin.close();
		fin.close();
		return aline;
	}
	public static void main(String[] args) throws IOException
	{
		KeyWordSort1 afile=new KeyWordSort1("E:\\Code\\java\\classjava\\src\\october\\Keywordtest1.txt");
		String[] a=afile.readFromFile();
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<afile.answer.length;i++)
			{
				if(a[i].equals(afile.answer[j]))
				{
					System.out.println("word from line"+(i+1)+"is a keyword");
					//break;
				}
				else
					System.out.println("word from line"+(i+1)+" isn't a key word");
			}
		}
	}
}
