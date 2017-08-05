package examplefromtextbook;

import java.util.*;

import sptember.MyDate;

import java.text.*;

public class MonthlyCalendar 
{
	public static void main(String args[])
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 E a hh 时 mm 分 ss 秒");
		System.out.println(sdf.format(new Date()));
		long lg=System.currentTimeMillis();
		sdf=new SimpleDateFormat("yyyy年 MM 月 dd 日 E");
		System.out.println(", 明天是"+sdf.format(new Date(lg+24*60*60*1000)));
		MonthlyCalendar.print(new GregorianCalendar());
				
	}
	public static void print(Calendar calendar)
	{
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH);
		calendar.set(year, month-1, 1);
		int week =calendar.getMaximum(Calendar.DAY_OF_WEEK)-1;
		System.out.println(year+"年"+month+"月的日历\n        日       一       二        三        四        五        六");
		if(week>0)
			System.out.print(String.format("%"+4*week+"c", ' '));
		int days=MyDate.daysOfMonth(year, month);
		for(int i=1;i<=days;i++)
		{
			System.out.print(String.format("%4d", i));
			if((week+i)%7==0)
				System.out.println();
		}
		System.out.println();
	}
}
