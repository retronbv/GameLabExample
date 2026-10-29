
public class Key extends Item {
	private boolean usedKey;
	private String room;
	public Key(String name, String room) {
		super(name);
		usedKey = false;
		this.room = room;
	}
	
	@Override
	public void use() {
		if (Game.currentRoom.getName().equals(room)) {
			if (usedKey) {
				Game.print("You already opened the "+room.toLowerCase()+" door!");
			} else {
				for (int i = 0; i < 6; i++) {
					if (Game.currentRoom.getExit(i).getName().equals(room)) {
						Game.currentRoom.getExit(i).setLocked(false);
						usedKey = true;
						Game.print("Using the key, you are able to unlock the room!");
						return;
					}
				}
				Game.print("The "+room+"is not here!");
				
			}
		} else Game.print("You don't see any way to use the tool…");
	}
}
