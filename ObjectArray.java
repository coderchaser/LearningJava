package examplefromtextbook;

import sptember.MyDate;
import sptember.Person;
import sptember.Student;

public class ObjectArray 
{
	public static void print(Object value[])
	{
		if(value!=null)
			for(int i=0;i<value.length;i++)
				if(value[i]!=null)
					System.out.println(value[i].toString());//������Բ���toString?
	}
	public static Object[] concat(Object value1[],Object value2[])
	{
		if(value1==null)
			return value2;
		if(value2==null)
			return value1;
		Object temp[]=new Object[value1.length+value2.length];
		int i=0,j=0;
		for(j=0;j<value1.length;j++)
			temp[i++]=value1[j];
		for(j=0;j<value2.length;j++)
			temp[i++]=value2[j];
		return temp;
	}
	public static void print(Object value[],Object key)
	{
		if(value!=null&&key!=null)
			for(int i=0;i<value.length;i++)
				if(value[i]!=null&&key.equals(value[i]))
					System.out.println(value[i].toString());
	}
	public static void main(String[] args)
	{
		Person p=new Person("������",new MyDate(1992,3,15),"��","����","��ɳ");
		Person pvalue[]={p,new Student(p,"�����","�������ѧ����","001",true)};
		Student svalue[]={new Student("����",new MyDate(1992,4,3),"Ů","����","�人","���ù���","��Ϣ����","031",true),new Student("��С��",new MyDate(1991,3,12),"Ů","�㶫","����","ͨ��","ͨ�Ź���","014",true)};
		Object value[]=concat(pvalue,svalue);
		svalue[1].name=svalue[1].name.substring(0, 2);
		print(value);
		Person key=new Person(p);
		System.out.println("����: "+key.toString()+",���: ");
		print(value,key);
		key=new Student((Student)pvalue[1]);
		System.out.println("���ң� "+key.toString()+"�����  ");
		print(value,key);
		Student.howmany();
	}
}
