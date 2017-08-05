package courseraJavaDesign;

//Interface: gate in and out process function
interface GateInOut {
	public void enterGate();
	public void exitGate();
}

//Abstract class as car, to be extended later
abstract class Car {
	int plate_no;		// Plate number
	String owner;		// Owner/driver of this car
	String permission;	// Permission to entry gate
	// abstract method
	abstract public void getPermission();
	abstract public void setPermission();
	// Constructor
	Car (int plate_no, String owner) {
		this.plate_no = plate_no;
		this.owner = owner;
		this.permission = "";
	}
}

//Guest car class
class GuestCar extends Car implements GateInOut {
	// Description of this class
	static final String desc = "This is a guest car";
	// Which building this guest is going to visit
	int visit_building;
	// Constructor
	GuestCar(int plate_no, String owner, int visit_building) {
		super(plate_no, owner);
		this.visit_building = visit_building;
		System.out.println(GuestCar.desc);
	}
	@Override
	public void enterGate() {
		System.out.println("Visitor: " + this.owner + " visits building" + this.visit_building);
	}
	@Override
	public void exitGate() {
		System.out.println("Visitor: " + this.owner + " leaves building" + this.visit_building);
	}
	@Override
	public void getPermission() {
		System.out.println("Permission: " + this.permission);
	}
	@Override
	public void setPermission() {
		this.permission = "VISITOR";
	}
}

//Resident car class
class ResidentCar extends Car implements GateInOut {
	// Description
	static final String desc = "This is a resident car";
	// Which building the residence is living
	int live_building;
	// Constructor
	ResidentCar(int plate_no, String owner, int live_building) {
		super(plate_no, owner);
		this.live_building = live_building;
		System.out.println(ResidentCar.desc);
	}
	@Override
	public void enterGate() {
		System.out.println("Residence: " + this.owner + " comes back home at building " + this.live_building);
	}
	@Override
	public void exitGate() {
		System.out.println("Residence: " + this.owner + " leaves home from building " + this.live_building);
	}
	@Override
	public void getPermission() {
		System.out.println("Permission: " + this.permission);
	}
	@Override
	public void setPermission() {
		this.permission = "Residence";
	}
}

public class GateEntry {
	public static void main(String args[]) {
		// Simulation work flow
		GuestCar guest_car = new GuestCar(1234, "Peter", 1);
		ResidentCar resident_car = new ResidentCar(2345, "Mary", 2);
		// Gate entry work flow here
		System.out.println("Gate entry simulation 1");
		// Set permission
		resident_car.setPermission();
		guest_car.setPermission();
		
		resident_car.enterGate();
		resident_car.getPermission();
		
		guest_car.enterGate();
		guest_car.getPermission();
		resident_car.exitGate();
		guest_car.exitGate();
		
		guest_car = new GuestCar(1234, "Jack", 1);
		resident_car = new ResidentCar(2345, "Tom", 2);
		// Gate entry work flow here
		System.out.println("Gate entry simulation 2");
		// Set permission
		resident_car.setPermission();
		guest_car.setPermission();
		guest_car.enterGate();
		guest_car.getPermission();
		guest_car.exitGate();
		resident_car.enterGate();
		resident_car.getPermission();
		resident_car.exitGate();
	}
}