package courseraJavaDesign;
//������ֶ��ڲ�ͬ����Ȩ����ͬ�᲻���ж�����
//EARTH��Planet.EARTH��ȫһ��ȴ����ʾ������
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
