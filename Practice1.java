package sptember;
//在这个例子中我创建了b，c两个实例，调用b.set( Practice1 a)即b.set(c)时b的a还是12，c的a却变成了9
//说明了形参a和c都指向同一个a个实例
public class Practice1
{
	public  int a=12;
	public  void set(Practice1 a)
	{
		a.a=9;
	}
	public void set(int n)
	{
		this.a=n;
	}
	public static void main(String[] args)
	{
		Practice1 b=new Practice1();
		Practice1 c=new Practice1();
		b.set(c);
		System.out.println(b.a);
		System.out.println(c.a);
	}
}