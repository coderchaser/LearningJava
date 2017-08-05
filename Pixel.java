package examplefromtextbook;

import sptember.Myinteger;

public class Pixel extends Point 
{
	private Color color;
	public static interface ColorConstant
	{
		int BLACK=0XFF000000;
		int RED=0XFFFF0000;
		int GREEn=0XFF00FF00;
		int BLUE=0XFF0000FF;
		int WHITE=0XFFFFFFF;
	}
	public static class Color extends Object implements ColorConstant
	{
		private int value;
		public Color(int value)
		{
			this.value=value;
		}
		public Color(int red,int green,int blue)
		{
			this.value=0xff000000|((red&0xff)<<16)|((green&0xff)<<8)|blue&0xff;
		}
		public Color()
		{
			this(BLACK);
		}
		private String toRGBString()
		{
			return "RGB("+((this.value>>16)&0xff)+","+((this.value>>8)&0xff)+","+(this.value&0xff)+"),0x"+Myinteger.toString(this.value, 16);
		}
	}
	public Pixel(Point p,Color color)
	{
		super(p);
		this.color=color;
	}
	public Pixel()
	{
		this(new Point(),ColorConstant.BLACK);
	}
	public Pixel(Point p,int colorvalue)
	{
		this(p,new Color(colorvalue));
	}
	public String toString()
	{
		return this.getClass().getName()+"ÏñËØ,×ø±ê"+super.toString()+",ÑÕÉ«"+this.color.toRGBString();
	}
	public static void main(String args[])
	{
		System.out.println(new Point().toString());
		Point p=new Point(100,100);
		Pixel pixel=new Pixel(p,Pixel.ColorConstant.RED);
		System.out.println(pixel.toString());
		System.out.println(p.getClass().getName());
	}
}
