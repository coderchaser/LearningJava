package examplefromtextbook;

import java.util.*;

import sptember.MyDate;

import java.text.*;

public class MonthlyCalendar 
{
	public static void main(String args[])
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd�� E a hh ʱ mm �� ss ��");
		System.out.println(sdf.format(new Date()));
		long lg=System.currentTimeMillis();
		sdf=new SimpleDateFormat("yyyy�� MM �� dd �� E");
		System.out.println(", ������"+sdf.format(new Date(lg+24*60*60*1000)));
		MonthlyCalendar.print(new GregorianCalendar());
				
	}
	public static void print(Calendar calendar)
	{
		int year=calendar.get(Calendar.YEAR);
		int month=calendar.get(Calendar.MONTH);
		calendar.set(year, month-1, 1);
		int week =calendar.getMaximum(Calendar.DAY_OF_WEEK)-1;
		System.out.println(year+"��"+month+"�µ�����\n        ��       һ       ��        ��        ��        ��        ��");
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
