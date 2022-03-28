import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;
import enigma.core.Enigma;

public class Game {
	private static char[][] map;
	public static int screenx, screeny, tex, tey;

	public static void main(String[] args) throws InterruptedException {
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		screeny = (int)dim.getHeight() / 19; screenx = (int)dim.getWidth() / 10; tex = (int)(screenx-45)/2; tey = screeny/2;
		enigma.console.Console cn = Enigma.getConsole("Game", screenx, screeny, 15);
		EnigmaWrapper wrapper = new EnigmaWrapper(cn);
		Random random = new Random();
		Player player = new Player(wrapper);
		wrapper.consoleColor(Color.orange, Color.black); //Set a random console color.
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
		player.addP(map);
		ItemQueue.writeItemQueue(cn);
		while(true){ //Main game loop
			
			try {
				Movement movement = new Movement(map, energy2x, wrapper);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
}
