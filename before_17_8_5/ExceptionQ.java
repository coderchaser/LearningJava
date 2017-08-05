package october;

//异常观察
public class ExceptionQ {

	public static void main(String[] args)
	{
		//int a[]=null;
		///a[0]=0;  //空对象异常
		//String str=null;  //空对象异常
		//System.out.println(str.length());
		//int b[]=new int [-1];  //负数组长度异常
		Object obj=new Object();
		String str1=(String)obj;  //类型强制转换异常
	}

}
