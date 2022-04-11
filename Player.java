import java.util.Random;
import enigma.core.Enigma;
import java.awt.Color;

public class Player {
    private EnigmaWrapper wrapper;
    public static int Px, Py;
    public Player(EnigmaWrapper wrapper) {
        this.wrapper = wrapper;
    }
    public void addCharacter(char[][] map, Color color, String str) {
        int cursorx = Enigma.getConsole().getTextWindow().getCursorX();
        int cursory = Enigma.getConsole().getTextWindow().getCursorY();
        Random random = new Random();
        int x = random.nextInt(1, 55);
        int y = random.nextInt(1, 23);

        while (true)
            if (map[y][x] == ' ') {
                Enigma.getConsole().getTextWindow().setCursorPosition(x, y);
                Game.new_robot_location[0] = x;
                Game.new_robot_location[1] = y;
                wrapper.printInColor(Color.orange, color, str);
                map[y][x] = str.charAt(0);
                if (str.equalsIgnoreCase("P")) {
                    Enigma.getConsole().getTextWindow().setCursorPosition(x, y);
                    Px = x; Py = y;
                	}
                else {
                    Enigma.getConsole().getTextWindow().setCursorPosition(cursorx, cursory);
                    }
                break;
            }
        else {
            x = random.nextInt(1, 55);
            y = random.nextInt(1, 23);
        }
    }
    public static int findPx(char[][] map) {
        for (int a = 1; a < map.length; a++) {
            for (int b = 1; b < map[a].length; b++) {
                if (map[a][b] == 'P') return b;
            }
        }
        return 0;
    }
    public static int findPy(char[][] map) {
        for (int a = 1; a < map.length; a++) {
            for (int b = 1; b < map[a].length; b++) {
                if (map[a][b] == 'P') return a;
            }
        }
        return 0;
    }

}
