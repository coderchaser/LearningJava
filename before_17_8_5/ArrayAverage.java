package october;

public class ArrayAverage 
{
	public static void print(int value[])
	{
		for(int i=0;i<value.length;i++)
			System.out.print(" "+value[i]);
		System.out.println();
	}
	public static double weightedAverage(int value[],int weight[])
	{
		if(value.length==0)
			return 0.0;
		double sum=0;
		int i=0;
		if(weight!=null&&weight.length!=0)
		{
			int minlen=value.length<weight.length?value.length:weight.length;
			for(i=0;i<minlen;i++)
			{
				sum+=weight[i]*value[i];
			}
			for(;i<value.length;i++)
				sum+=value[i];
		}
		return sum/value.length;
	}
	public static int[] toIntArray(String str[])
	{
		if(str==null||str.length==0)
			return null;
		int temp[]=new int[str.length];
		int count=0,i=0;
		while(i<str.length)
		{
			try
			{
				temp[count]=Integer.parseInt(str[i],16);
				count++;
			}
			catch(NumberFormatException ex)
			{
				try
				{
					temp[count]=Integer.parseInt(str[i], 16);
					count++;
				}
				catch(NumberFormatException nfex)
				{
					System.out.println("\""+str[i]+"\""+"can not transferred into Int"+nfex.toString());
				}
			}
			catch(Exception ex) {ex.printStackTrace();}
			finally
			{
				i++;
			}
		}
		if(count==temp.length)
			return temp;
		int value[]=new int[count];
		System.arraycopy(temp, 0, value, 0, count);
		return value;
	}
	public static void main(String[] args) 
	{
		String valuestr[]={"10","20","30","40","x"};
		String weightstr[]={"a","b","c"};
		int value[]=toIntArray(valuestr);
		System.out.print("value[] array=:");
		print(value);
		int weight[]=toIntArray(weightstr);
		System.out.print("weight[] array=:");
		print(weight);
		System.out.println("weightedAverage(value,weight)="+weightedAverage(value,weight));
		System.out.println("weightedAverage(value,weight)="+weightedAverage(value,null));
	}

}
