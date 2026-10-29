
public class Item {
	private String name;
	private boolean heavy = false;
	
	public Item(String name) {
		this.name = name;
	}
	
	public Item(String name, boolean heavy) {
		this.name = name;
		this.heavy = heavy;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getHeavy() {
		return this.heavy;
	}
	
	public String toString() {
		return this.name;
	}
	
	public void use() {
		Game.print("You cannot use this item");
	}
}
