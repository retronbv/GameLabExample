import java.util.HashMap;

public class Room {
	private String name;
	private Room[] rooms;
	private HashMap<String, Item> items;
	private boolean locked;
	
	public Room(String name) {
		this.name = name;
		this.rooms = new Room[6];
		this.items = new HashMap<>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getLocked() {
		return this.locked;
	}
	
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String toString() {
		return this.name + "\n\n" + Game.roomDescriptions.get(this.name);
	}
	
	public void addExit(Room room, int dir) {
		this.rooms[dir] = room;
	}
	
	public Room getExit(int dir) {
		return this.rooms[dir];
	}
	
	public Item getItem(String name) {
		return this.items.get(name);
	}
	
	public void addItem(Item item) {
		this.items.put(item.getName().toLowerCase(), item);
	}
	
	public Item removeItem(String itemName) {
		return this.items.remove(itemName);
	}
}
