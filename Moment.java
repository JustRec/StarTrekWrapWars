import enigma.core.Enigma;
import java.awt.event.KeyEvent;

public class Moment {
    public enigma.console.Console cn = Enigma.getConsole("");
    public EnigmaWrapper wrapper;

    public char[][] map;
    public boolean energy2x;

    Moment(char[][] map, boolean energy2x, EnigmaWrapper wrapper) throws Exception { // --- Contructor
        this.map = map;
        this.energy2x = energy2x;
        this.wrapper = wrapper;

        while (true) {

            if (wrapper.getKeypr() == 1) { // if keyboard button pressed
                if (wrapper.getRkey() == KeyEvent.VK_LEFT && Player.findPx(map) > 0 && map[Player.findPy(map)][Player.findPx(map) - 1] != '#') {
                    int cursorx = cn.getTextWindow().getCursorX();
                    int cursory = cn.getTextWindow().getCursorY();

                    map[cursory][cursorx] = ' ';
                    map[cursory][cursorx - 1] = 'P';

                    System.out.println(" "); //delete P

                    cn.getTextWindow().setCursorPosition(cursorx - 1, cursory);
                    System.out.println("P");
                    cn.getTextWindow().setCursorPosition(cursorx - 1, cursory);

                }
                if (wrapper.getRkey() == KeyEvent.VK_RIGHT && Player.findPx(map) < map[0].length - 1 && map[Player.findPy(map)][Player.findPx(map) + 1] != '#') {
                    int cursorx = cn.getTextWindow().getCursorX();
                    int cursory = cn.getTextWindow().getCursorY();

                    map[cursory][cursorx] = ' ';
                    map[cursory][cursorx + 1] = 'P';

                    System.out.println(" "); //delete P

                    cn.getTextWindow().setCursorPosition(cursorx + 1, cursory);
                    System.out.println("P");
                    cn.getTextWindow().setCursorPosition(cursorx + 1, cursory);
                }
                if (wrapper.getRkey() == KeyEvent.VK_UP && Player.findPy(map) > 0 && map[Player.findPy(map) - 1][Player.findPx(map)] != '#') {
                    int cursorx = cn.getTextWindow().getCursorX();
                    int cursory = cn.getTextWindow().getCursorY();

                    map[cursory][cursorx] = ' ';
                    map[cursory - 1][cursorx] = 'P';

                    System.out.println(" "); //delete P

                    cn.getTextWindow().setCursorPosition(cursorx, cursory - 1);
                    System.out.println("P");
                    cn.getTextWindow().setCursorPosition(cursorx, cursory - 1);
                }
                if (wrapper.getRkey() == KeyEvent.VK_DOWN && Player.findPy(map) < map.length - 1 && map[Player.findPy(map) + 1][Player.findPx(map)] != '#') {
                    int cursorx = cn.getTextWindow().getCursorX();
                    int cursory = cn.getTextWindow().getCursorY();

                    map[cursory][cursorx] = ' ';
                    map[cursory + 1][cursorx] = 'P';

                    System.out.println(" "); //delete P

                    cn.getTextWindow().setCursorPosition(cursorx, cursory + 1);
                    System.out.println("P");
                    cn.getTextWindow().setCursorPosition(cursorx, cursory + 1);
                }
                if (wrapper.getRkey() == KeyEvent.VK_W) {

                }
                if (wrapper.getRkey() == KeyEvent.VK_S) {

                }
                if (wrapper.getRkey() == KeyEvent.VK_A) {

                }
                if (wrapper.getRkey() == KeyEvent.VK_D) {

                }

                if (wrapper.getRkey() == KeyEvent.VK_SPACE) {
                    break;
                }

                wrapper.setKeypr(0); // last action  
            }
            if (energy2x)
                Thread.sleep(250);
            else
                Thread.sleep(500);
        }
    }
}