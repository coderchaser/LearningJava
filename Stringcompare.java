 package sptember;
public class Stringcompare 
{
	public static String maxsubstring(String str1,String str2)
	{
		String maxsubstring="";
		if(str1.equals(str2))
			System.out.println(str1);
		else
		{
			for(int i=0;i<=str1.length();i++)
			{
				for(int j=0;j<=str2.length();j++)
				{
					if(str2.substring(i, j)==str1.substring(i,j))
					{
						maxsubstring=str1.substring(i, j);
					}
				}
			}
		}
		return maxsubstring;
	}
	public static void main(String[] args) 
	{
		String str1="qwerabcdtyuiop";
		String str2="xcabcdvbn";
		System.out.println(maxsubstring(str1,str2));
	}

}
