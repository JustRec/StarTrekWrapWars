import java.util.Random;
import enigma.core.Enigma;
import java.awt.Color;

public class Player {
    private EnigmaWrapper wrapper;

    public Player(EnigmaWrapper wrapper) {
        this.wrapper = wrapper;
    }
    public void addP(char[][] map) {
        Random random = new Random();
        int x = random.nextInt(1, 55);
        int y = random.nextInt(1, 23);

        while (true)
            if (map[y][x] != '#') {
                Enigma.getConsole().getTextWindow().setCursorPosition(x, y);
                wrapper.printInColor(Color.orange, Color.blue, "P");
                map[y][x] = 'P';
                Enigma.getConsole().getTextWindow().setCursorPosition(x, y);
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