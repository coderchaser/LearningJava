package exercise;


public class Mb_binary_trans {
	//实现整数转换2进制
	/*public static   mb_binary(int i)
	{
	
	}*/
    private static String toFullBinaryString(int x) {
        int[] buffer = new int[Integer.SIZE];
        for (int i = (Integer.SIZE - 1); i >= 0; i--) {
            buffer[i] = x >> i & 1;
        }
        String s = "";
        for (int j = (Integer.SIZE - 1); j >= 0; j--) {
            s = s + buffer[j];
        }
        return s;
    }
	public static void main(String args[])
	{
		int x=10;
		System.out.println(Mb_binary_trans.toFullBinaryString(x));
	}
}
