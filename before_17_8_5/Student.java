package sptember;

public class Student extends Person 
{
	public String department,speciality,number;
	public boolean member;
	private static int count=0;
	public Student(String name,MyDate birthday,String sex,String province,String city,
			String department,String speciality,String number,boolean member)
	{
		super(name,birthday,sex,province,city);
		this.set(department,speciality,number,member);
		count++;
	}
	public Student()
	{
		this("",new MyDate(),"","","","","","",false);//?深拷贝？
	}
	public Student(Person p,String department,String speciality,String number,boolean member)
	{
		this(p.name,new MyDate(p.birthday),p.sex,p.province,p.city,department,speciality,number,member);
	}
	public Student(Student s)
	{
		this(s.name,new MyDate(s.birthday),s.sex,s.province,s.city,s.department,s.speciality,s.number,s.member);
	}
	public void finalize()
	{
		super.finalize();
		count--;//Student.count--;
	}
	public static void howmany()
	{
		Person.howMany();
		System.out.println(count+"个Student对象");//Student.count?
	}
	public void set(String department,String speciality,String number,boolean member)
	{
		this.department=department==null?"":department;
		this.speciality=speciality=speciality==null?"":speciality;
		this.number=number==null?"":number;
		this.member=member;
	}
	public boolean equals(Student s)
	{
		return this==s||s!=null&&(this.member&s.member)&&this.number.equals(s.number)&&this.speciality.equals(s.speciality)&&this.department.equals(s.department);
		//这里member已经是布尔量了，貌似不能用equals。
	}
	public boolean equals(Object obj)
	{
		if(this==obj)
			return true;
		if(obj instanceof Student)
		{
			Student s=(Student)obj;
			return this.member&s.member&&this.number.equals(s.number)&&this.speciality.equals(s.speciality)&&this.department.equals(s.department);
		}
		return false;
	}
	public String toString()
	{
		return super.toString()+","+department+","+speciality+","+number+(member?",团员":"");
	}
	public static void main(String[] args)
	{
		Person p1=new Person("廖茂生",new MyDate(1995,3,12),"男","河南省","信阳市");
		Student s1=new Student(p1,"机电工程及其自动化","机械工程","13120710",true);
		Student s2=new  Student(s1);
		s2.set("张小丽", new MyDate(1992,4,3), "女", "湖北省", "武汉市");
		s2.set("经济管理系", "信息管理专业", "13120713", true);
		Student.howmany();//静态调用Student.howmany()，貌似s1.howmany()也一样。
		System.out.println(count);
		System.out.println("p1: "+p1.toString()+"\ns1: "+s1.toString()+"\ns2: "+s2);
		s2.finalize();
		Student.howmany();
		System.out.println(count);
		System.out.println(p1.getClass().getName());
		System.out.println(s1.getClass().getName());
		Student s3=(Student)p1;
		//System.out.println(p1.getClass().getName());
	}
}
