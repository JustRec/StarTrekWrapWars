import java.awt.Color;
import enigma.core.Enigma;

public class Initialize {
	private static char[][] map;

	public static void main(String[] args) throws InterruptedException {
		enigma.console.Console cn = Enigma.getConsole("Game", 90, 30, 15);
		EnigmaWrapper wrapper = new EnigmaWrapper(cn);
		Player player = new Player(wrapper); //Player methods
		wrapper.consoleColor(Color.orange, Color.black);
		
		/*
		while(true){ //Game start button, will be changed
			int cn_size_x = cn.getTextWindow().getColumns();
			int cn_size_y = cn.getTextWindow().getRows();
			

			cn.getTextWindow().setCursorPosition(tex, tey);
			System.out.println("███████╗████████╗ █████╗ ██████╗ ████████╗██╗");
			cn.getTextWindow().setCursorPosition(tex, tey+1);
			System.out.println("██╔════╝╚══██╔══╝██╔══██╗██╔══██╗╚══██╔══╝██║");
			cn.getTextWindow().setCursorPosition(tex, tey+2);
			System.out.println("███████╗   ██║   ███████║██████╔╝   ██║   ██║");
			cn.getTextWindow().setCursorPosition(tex, tey+3);
			System.out.println("╚════██║   ██║   ██╔══██║██╔══██╗   ██║   ╚═╝");
			cn.getTextWindow().setCursorPosition(tex, tey+4);
			System.out.println("███████║   ██║   ██║  ██║██║  ██║   ██║   ██╗");
			cn.getTextWindow().setCursorPosition(tex, tey+5);
			System.out.println("╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚═╝");
			
			if(wrapper.getMousepr()==1){
				if(wrapper.getMousex() < tex+45 && wrapper.getMousex() > tex){
					if (wrapper.getMousey() < tey+5 && wrapper.getMousey() > tey){break;}}}
			}

		}
		*/
		
		
		wrapper.clearConsole();
		map = Mechanics.createMap(Mechanics.createArray("map.txt")); //Create and print the map array 
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[1].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println("");
		}
		Backpack.printBackpack();
		boolean energy2x = false;
		ItemQueue.writeFirstTimeQueue(map, wrapper);
		player.addCharacter(map, Color.cyan, "P");
		ItemQueue.writeItemQueue(cn);
		
		//Main game
		try {
			Game.start(map, wrapper);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
