
public class Safe extends Item {
	private boolean open;
	private boolean opened;

	public Safe(String name) {
		super(name, true);
		open = false;
		opened = false;
	}
	
	@Override
	public void open() {
		if (!opened) {
			Game.currentRoom.addItem(new Notebook("Notebook"));
			((Notebook) Game.currentRoom.getItem("notebook")).setText("Demo notebook text!");
		}
		if (!open) {
			this.open = true;
			this.opened = true;
		}
		
	}
	
	@Override
	public void close() {
		if (open) {
			this.open = false;
		}
	}

}
