package sptember;
//������������Ҵ�����b��c����ʵ��������b.set( Practice1 a)��b.set(c)ʱb��a����12��c��aȴ�����9
//˵�����β�a��c��ָ��ͬһ��a��ʵ��
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