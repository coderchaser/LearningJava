package courseraJavaDesign;

import courseraJavaDesign.TestPlanet;
public enum Planet {
	EARTH (5.976E+24,6.37184E6),
	MERCURY (3.02e+23,2.4397e6);
	private final double mass; //in Kilograms
	private final double radius;//in meters
	Planet(double mass,double radius)
	{
		this.mass=mass;
		this.radius=radius;
	}
	private double mass()
	{
		return mass;
	}
	private double radius()
	{
		return radius;
	}
	public static final double G=6.67300e-11;
	double surfaceGravity()
	{
		return G*mass/(radius*radius);
	}
	double surfaceWeight(double mass)
	{
		return mass*surfaceGravity();
	}
	public static void main(String atgs[]) {
		double earthWeight=44;
		double mass=earthWeight/EARTH.surfaceGravity();
		for(Planet p:Planet.values())
		{
			System.out.printf("your weight on %s is %f%n", p,p.surfaceWeight(mass));
		}
		System.out.println(TestPlanet.EARTH);
		System.out.println(EARTH);
	}
}
