package exercise;

import sptember.MyDate;

public class BankAccount 
{
	public String account,name=null,id;
	int deposit;
	public MyDate date;
	public int income[]=new int[10];
	public int outcome[]=new int[10];
	public int i=0,j=0;
	public BankAccount(String account, String name,String id,int deposit,MyDate date)
	{
		this.createAccount(account, name);
		this.id=id;
		this.deposit=deposit;
		this.date=new MyDate(date);//要用深拷贝吗？
	}
	public void createAccount(String account,String name)
	{
		this.account=account;
		this.name=name;
	}
	public void deposit(int money)
	{
		this.deposit+=money;
		income[i]=money;
		i++;
	}
	public void getMoneyOut(int money)
	{
		this.deposit-=money;
		outcome[j]=money;
		j++;
	}
	public static void print(int value[])
	{
		for(int i=0;i<value.length;i++)
			System.out.print(" "+value[i]);
		System.out.println();
	}
	public void consult()
	{
		System.out.println("account: "+account+"\n"+"name: "+name+"\n"+"depsoit: "+deposit);
		System.out.println("开户日期： "+date);//date?
		System.out.println("收入明细： ");
		print(income);
		System.out.println("支出明细： ");
		print(outcome);
	}
	public void finalize()
	{
		
	}
	public static void main(String atgs[])
	{
		BankAccount a=new BankAccount("信用卡","廖茂生","411523199503123812",2000,new MyDate(2005,3,12));
		BankAccount b=new BankAccount("信用卡","廖林森","411523199503123812",2000,new MyDate(2004,3,12));
		a.deposit(1000);
		a.getMoneyOut(500);
		a.consult();
		b.deposit(15000);
		b.consult();
		b.getMoneyOut(5000);
		b.consult();
	}
}
