package courseraJavaDesign;

import java.math.BigDecimal;
public class ExactCalculation {
	public static void  main(String args[]) {
		System.out.println(0.05+0.01);
		System.out.println(ExactCalculation.add(0.05, 0.01));
	}
	public static double add(double a,double b)
	{
		BigDecimal aBigDecimal=new BigDecimal(Double.toString(a));
		BigDecimal bBigDecimal=new BigDecimal(Double.toString(b));
		return bBigDecimal.add(aBigDecimal).doubleValue();
	}
}
