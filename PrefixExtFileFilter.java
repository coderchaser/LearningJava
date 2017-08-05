package october;//ÎÄ¼þ¹ýÂËÆ÷filter

import java.io.*;

public class PrefixExtFileFilter implements FileFilter
{
	private String prefix="";
	private String extension="";
	public PrefixExtFileFilter(String filterstr)
	{
		filterstr=filterstr.toLowerCase();
		int i=filterstr.indexOf('*');
		if(i>0)
			this.prefix=filterstr.substring(0, i);
		i=filterstr.lastIndexOf('.');
		if(i>0)
		{
			this.extension=filterstr.substring(i+1);
			if(this.extension.equals("*"))
				this.extension="";
		}
	}
	public PrefixExtFileFilter()
	{
		this("");
	}
	public boolean accept(File file)
	{
		if(!file.isFile())
			return false;
		String filename=file.getName().toLowerCase();
		return filename.startsWith(this.prefix)&&filename.endsWith(this.extension);
	}
	public static void main(String args[])
	{
		File menu=new File("E:\\Code\\java\\classjava\\src\\october\\file");
		PrefixExtFileFilter filter=new PrefixExtFileFilter("*.txt");
		File[] exist=menu.listFiles(filter);
		for(int i=0;i<exist.length;i++)
			System.out.println(exist[i]);
		filter.accept(menu);
		System.out.println(filter.accept(menu));
		File[] test=menu.listFiles(filter);
		for(int i=0;i<test.length;i++)
			System.out.println(test[i]);
	}
}
