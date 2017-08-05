package courseraJavaDesign;

import java.io.File;

public class ListAllFiles {
	public static void main(String args[])
	{
		File a=new File("E:\\Ñ¸À×ÏÂÔØ");
		ListFiles(a);
	}
	public static void ListFiles(File dir) {
		if(!dir.exists()||!dir.isDirectory())
			return;
		String[] files=dir.list();
		for(int i=0;i<files.length;i++)
		{
			File file=new File(dir,files[i]);
			if (file.isFile()) {
				System.out.println(dir+"\\"+file.getName()+"\t"+file.length());
			}
			else
			{
				System.out.println(dir+"\\"+file.getName()+"\t<dir>"
						);
				ListFiles(file);
			}
		}
	}
}
