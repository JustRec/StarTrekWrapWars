import java.awt.Color;
import java.util.Random;

import enigma.core.Enigma;

public class Game {
	private static char[][] map;
	public static void main(String[] args) throws InterruptedException {
		enigma.console.Console cn = Enigma.getConsole("Game", 200, 50, 15);
		EnigmaWrapper wrapper = new EnigmaWrapper(cn);
		Random random = new Random();
		Color default_foreground = wrapper.hueCube(random.nextInt(180), 255, 165, 0);
		Player player = new Player(wrapper);

		wrapper.consoleColor(default_foreground, Color.black); //Set a random console color.

		while(true){ //Game start button, will be changed
			int cn_size_x = cn.getTextWindow().getColumns();
			int cn_size_y = cn.getTextWindow().getRows();

			cn.getTextWindow().setCursorPosition(75, 25);
			System.out.println("███████╗████████╗ █████╗ ██████╗ ████████╗██╗");
			cn.getTextWindow().setCursorPosition(75, 26);
			System.out.println("██╔════╝╚══██╔══╝██╔══██╗██╔══██╗╚══██╔══╝██║");
			cn.getTextWindow().setCursorPosition(75, 27);
			System.out.println("███████╗   ██║   ███████║██████╔╝   ██║   ██║");
			cn.getTextWindow().setCursorPosition(75, 28);
			System.out.println("╚════██║   ██║   ██╔══██║██╔══██╗   ██║   ╚═╝");
			cn.getTextWindow().setCursorPosition(75, 29);
			System.out.println("███████║   ██║   ██║  ██║██║  ██║   ██║   ██╗");
			cn.getTextWindow().setCursorPosition(75, 30);
			System.out.println("╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚═╝");
			
			if(wrapper.getMousepr()==1){
				if(wrapper.getMousex() < 121 && wrapper.getMousex() > 74){
					if (wrapper.getMousey() < 31){
						if(wrapper.getMousey() > 24){
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
				Moment moment = new Moment(map, energy2x, wrapper);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}