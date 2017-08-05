package courseraJavaDesign;

import java.util.*;
import java.text.SimpleDateFormat;

public class Stringtoken 
{
	public static void main(String args[])
	{
		Calendar d1=Calendar.getInstance();
		SimpleDateFormat dd1=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(dd1.format(d1.getTime()));
		System.out.println(d1.getTime());
		
	}
}
