package courseraJavaDesign;
//想测试字段在不同类中权限相同会不会有二义性
//EARTH和Planet.EARTH完全一样却不提示二义性
public enum TestPlanet {
	EARTH (5.976E+24,6.37184E6);
	private final double mass; //in Kilograms
	private final double radius;//in meters
	TestPlanet(double mass,double radius)
	{
		this.mass=mass;
		this.radius=radius;
	}
}
