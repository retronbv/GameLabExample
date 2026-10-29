
public class World {
	public static Room buildWorld() {
		Room livingRoom = new Room("Living Room");
		
		Room office = new Room("Office");
		
		Room kitchen = new Room("Kitchen");
				
		Room bedroom = new Room("Bedroom");
		
		Room attic = new Room("Attic");
		
		Room garage = new Room("Garage");
		
		livingRoom.addExit(bedroom, 2);
		livingRoom.addExit(kitchen, 0);
		livingRoom.addExit(office, 1);
		
		office.addExit(livingRoom, 0);
		
		kitchen.addExit(livingRoom, 1);
		kitchen.addExit(garage, 3);
		
		bedroom.addExit(livingRoom, 3);
		bedroom.addExit(attic, 4);
		
		office.setLocked(true);
		attic.setLocked(true);
		garage.setLocked(true);
		
		Key officeKey = new Key("Office Key", "Office");
		livingRoom.addItem(officeKey);
		
		return livingRoom;
	}
}
