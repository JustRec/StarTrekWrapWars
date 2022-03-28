import java.awt.Color;
import java.util.Random;

import enigma.core.Enigma;

public class Game {
	private static char[][] map;
	public static void main(String[] args) throws InterruptedException {
		final int screenx = 120, screeny = 40, tex = (screenx-45)/2, tey = screeny/2;
		enigma.console.Console cn = Enigma.getConsole("Game", screenx, screeny, 15);
		EnigmaWrapper wrapper = new EnigmaWrapper(cn);
		Random random = new Random();
		Player player = new Player(wrapper);

		wrapper.consoleColor(Color.orange, Color.black); //Set a random console color.

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
					if (wrapper.getMousey() < tey+5){
						if(wrapper.getMousey() > tey){
							break;
						}						
					}
				}
			}
		}

		wrapper.clearConsole();
		map = Mechanics.createMap(Mechanics.createArray("map.txt")); //Create and print the map array 
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[1].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println("");
		}
		boolean energy2x = false;
		while(true){ //Main game loop
			player.addP(map);
			try {
				Movement moment = new Movement(map, energy2x, wrapper);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
