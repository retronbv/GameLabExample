
public class Notebook extends Item {
	private String text;
	private boolean hasBeenRead;

	public Notebook(String name) {
		super(name);
		hasBeenRead = false;
		// TODO Auto-generated constructor stub
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public void read() {
		Game.print(text);
		if (hasBeenRead == false) {
			Game.items.add(new Item("password"));
			hasBeenRead = true;
		}
	}

}
