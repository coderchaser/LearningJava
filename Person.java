package sptember;
//import sptember.MyDate;
public class Person implements Comparable<Person>
{
	public String name;
	public MyDate birthday;
	public String sex,province,city;
	private  static int count=0;//change this type to private?
	public Person(String name,MyDate birthday,String sex,String province,String city)
	{
		this.set(name,birthday,sex,province,city);
		count++;
	}
	public Person(String name,MyDate birthday)
	{
		this(name,birthday,"","","");
	}
	public Person()
	{
		this("",null);//null differ with ""?
	}
	public Person(Person p)
	{
		this(p.name,new MyDate(p.birthday),p.sex,p.province,p.city);
	}
	public void finalize()
	{
		System.out.println(" Õ∑≈("+this.toString()+")");
		Person.count--;
	}
	public static void howMany()
	{
		System.out.println(Person.count+"objects");
	}
	public void set(String name,MyDate birthday,String sex,String province,String city)
	{
		this.name=name==null?"":name;
		this.birthday=birthday;
		this.sex=sex==null?"":sex;
		this.province=province==null?"":province;
		this.city=city==null?"":city;
	}
	public boolean equals(Person p)
	{
		return this==p||p!=null&&this.name.equals(p.name)&&this.birthday.equals(p.birthday)&&this.sex.equals(p.sex)&&this.province.equals(p.province)&&this.city.equals(p.city);
	}
	public boolean equals(Object obj)
	{
		if(this==obj)
			return true;
		if(obj instanceof Person)
		{
			Person p=(Person)obj;
			return this.name.equals(p.name)&&this.birthday.equals(p.birthday)&&this.sex.equals(p.sex)&&this.province.equals(p.province)&&this.city.equals(p.city);
		}
		return false;
	}
	public String toString()
	{
		return name+","+(birthday==null?"":birthday.toString())+","+sex+","+province+","+city;
	}
	public int compareTo(Person p)
	{
		return this.name.compareTo(p.name);
	}
	public static void main(String[] args) 
	{
		Person p1=new Person("Xiaoming Li",new MyDate(1994,3,15));
		Person p2=new Person(p1);
		Person.howMany();
		System.out.println("p1: "+p1+"; p2"+p2+"\np1==p2?"+(p1==p2)+"; p1.name=p2.name?"+(p1.name==p2.name)+", p1.birthday=p2.birthday?"+(p1.birthday==p2.birthday));
		p2.name="Zhang"+p2.name.substring(1);
		MyDate d=p2.birthday;
		d.set(d.getYear(), d.getMonth(), d.getDay());
		System.out.println("p1: "+p1+"; p2:"+p2);
		p1.finalize();
		Person.howMany();
		Comparable<String> scom="abc";
		Comparable<Person> pcom=new Person("Bob",null);
		Person ppcom=new Person("Kate",null);
		System.out.println(pcom.compareTo(ppcom));
	}

}
