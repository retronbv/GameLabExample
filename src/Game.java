import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Game {
	public static Room currentRoom = World.buildWorld();
	private static ArrayList<Item> items = new ArrayList<>();
	public static HashMap<String, String> roomDescriptions = new HashMap<>();
	
	public static void scanFile() {
		try {
			Scanner scan = new Scanner(new File("room_descriptions.txt"));
			while (scan.hasNextLine()) {
				String roomName = scan.nextLine();
				StringBuilder descriptionBuilder = new StringBuilder();
				
				String next = scan.nextLine();
				while (scan.hasNextLine() && !next.equals("#")) {
					descriptionBuilder.append(next);
					next = scan.nextLine();
				}
				roomDescriptions.put(roomName, descriptionBuilder.toString());
			}
			scan.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		runGame();
	}
	
	public static void runGame() {
		Scanner input = new Scanner(System.in);
		Game.scanFile();
		
		Game.print("Welcome to the game! You are currently in the " + currentRoom.toString());
		
		System.out.print("What do you want to do? ");
		String commands = input.nextLine().toLowerCase();
		
		String[] commandArray = commands.split(" ");
		
		while (!commands.equals("exit")) {
			commandArray = commands.split(" ");
			switch (commandArray[0]) {
			case "go":
				if (commandArray.length > 1) {
					move(commandArray[1]);
				} else {
					Game.print("You did not specify a direction!");
				}
				break;
			case "i":
				if (Game.items.size() == 0) {
					Game.print("You are carrying nothing!");
				} else {
					Game.print("You are carrying:");
					for (Item i : Game.items) {
						Game.print(i);
					}
				}
				break;
			case "take":
				if (commandArray.length > 1) {
					takeItem(commandArray[1]);
				} else {
					Game.print("You did not specify an item to take!");
				}
				break;
			case "use": 
				for (Item item : Game.items) {
					if (item.getName().equals(commandArray[1])) {
						item.use();
						return;
					}
				}
				Game.print("Error: You dont have a "+commandArray[1]);
			default:
				Game.print("Error: not a valid command.");
			}
			
			System.out.println(); // spacing
			
			Game.print("You are currently in " + currentRoom.toString());
			System.out.print("What do you want to do? ");
			commands = input.nextLine().toLowerCase();
		}
		
		Game.print("Farewell, thanks for playing!");
		input.close();
	}
	
	public static void print(Object obj) {
		System.out.println(obj);
	}
	
	public static void move(String dir) {
		String[] dirArray = {"east", "west", "north", "south", "up", "down"};
		int dirIndex = Arrays.asList(dirArray).indexOf(dir);
		
		if (dirIndex == -1) {
			Game.print("Error: invalid direction.");
			return;
		}
		
		if (currentRoom.getExit(dirIndex) != null) {
			if (currentRoom.getExit(dirIndex).getLocked()) {
				Game.print("Error: That door is locked!");
			} else {
				currentRoom = currentRoom.getExit(dirIndex);
			}
		}
		else Game.print("Error: cannot currently move in that direction.");
	}
	
	public static void takeItem(String itemName) {
		if (currentRoom.getItem(itemName) == null) {
			Game.print("There is no " + itemName + " in this room.");
		} else {
			if (currentRoom.getItem(itemName).getHeavy()) {
				Game.print("You can't lift the "+itemName+"!");
			} else {
				Game.items.add(currentRoom.removeItem(itemName));
				Game.print("You take the " + itemName + " and carry it with you!");
			}
		}
	}
}