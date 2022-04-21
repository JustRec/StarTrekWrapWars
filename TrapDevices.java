import enigma.core.Enigma;

public class TrapDevices {
    private static enigma.console.Console cn = Enigma.getConsole("");
    private static double[][] timefortraps = new double[23][55];

    public static char[][] isTrapped(char[][] map) {
        int cursorx, cursory;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == '*') {
                    switch (map[i - 1][j]) {
                        case '1':
                            map[i - 1][j] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '2':
                            map[i - 1][j] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '3':
                            map[i - 1][j] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '4':
                            map[i - 1][j] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '5':
                            map[i - 1][j] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case 'C':
                            map[i - 1][j] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        default:
                            break;
                    }
                    switch (map[i + 1][j]) {
                        case '1':
                            map[i + 1][j] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '2':
                            map[i + 1][j] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '3':
                            map[i + 1][j] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '4':
                            map[i + 1][j] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '5':
                            map[i + 1][j] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case 'C':
                            map[i + 1][j] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        default:
                            break;
                    }
                    switch (map[i][j - 1]) {
                        case '1':
                            map[i][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '2':
                            map[i][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '3':
                            map[i][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '4':
                            map[i][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '5':
                            map[i][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case 'C':
                            map[i][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        default:
                            break;
                    }
                    switch (map[i][j + 1]) {
                        case '1':
                            map[i][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '2':
                            map[i][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '3':
                            map[i][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '4':
                            map[i][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '5':
                            map[i][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case 'C':
                            map[i][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        default:
                            break;
                    }
                    switch (map[i + 1][j + 1]) {
                        case '1':
                            map[i + 1][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '2':
                            map[i + 1][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '3':
                            map[i + 1][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '4':
                            map[i + 1][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '5':
                            map[i + 1][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case 'C':
                            map[i + 1][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        default:
                            break;
                    }
                    switch (map[i + 1][j - 1]) {
                        case '1':
                            map[i + 1][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '2':
                            map[i + 1][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '3':
                            map[i + 1][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '4':
                            map[i + 1][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '5':
                            map[i + 1][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case 'C':
                            map[i + 1][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i + 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        default:
                            break;
                    }
                    switch (map[i - 1][j + 1]) {
                        case '1':
                            map[i - 1][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '2':
                            map[i - 1][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '3':
                            map[i - 1][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '4':
                            map[i - 1][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '5':
                            map[i - 1][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case 'C':
                            map[i - 1][j + 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j + 1, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        default:
                            break;
                    }
                    switch (map[i - 1][j - 1]) {
                        case '1':
                            map[i - 1][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '2':
                            map[i - 1][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '3':
                            map[i - 1][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '4':
                            map[i - 1][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case '5':
                            map[i - 1][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        case 'C':
                            map[i - 1][j - 1] = ' ';
                            cursorx = cn.getTextWindow().getCursorX();
                            cursory = cn.getTextWindow().getCursorY();
                            cn.getTextWindow().setCursorPosition(j - 1, i - 1);
                            System.out.print(" ");
                            cn.getTextWindow().setCursorPosition(cursorx, cursory);
                            break;
                        default:
                            break;
                    }
                } else if (map[i][j] == '=') {
                    switch (map[i - 1][j]) {
                        case '4':
                            // stop bots
                            break;
                        case '5':
                            // stop bots
                            break;
                        case 'C':
                            // stop bots
                            break;
                        default:
                            break;
                    }
                    switch (map[i + 1][j]) {
                        case '4':
                            // stop bots
                            break;
                        case '5':
                            // stop bots
                            break;
                        case 'C':
                            // stop bots
                            break;
                        default:
                            break;
                    }
                    switch (map[i][j - 1]) {
                        case '4':
                            // stop bots
                            break;
                        case '5':
                            // stop bots
                            break;
                        case 'C':
                            // stop bots
                            break;
                        default:
                            break;
                    }
                    switch (map[i][j + 1]) {
                        case '4':
                            // stop bots
                            break;
                        case '5':
                            // stop bots
                            break;
                        case 'C':
                            // stop bots
                            break;
                        default:
                            break;
                    }
                    switch (map[i + 1][j + 1]) {
                        case '4':
                            // stop bots
                            break;
                        case '5':
                            // stop bots
                            break;
                        case 'C':
                            // stop bots
                            break;
                        default:
                            break;
                    }
                    switch (map[i + 1][j - 1]) {
                        case '4':
                            // stop bots
                            break;
                        case '5':
                            // stop bots
                            break;
                        case 'C':
                            // stop bots
                            break;
                        default:
                            break;
                    }
                    switch (map[i - 1][j + 1]) {
                        case '4':
                            // stop bots
                            break;
                        case '5':
                            // stop bots
                            break;
                        case 'C':
                            // stop bots
                            break;
                        default:
                            break;
                    }
                    switch (map[i - 1][j - 1]) {
                        case '4':
                            // stop bots
                            break;
                        case '5':
                            // stop bots
                            break;
                        case 'C':
                            // stop bots
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return map;
    }

    public static char[][] timeForTrap(char[][] map, double time) {
        int cursorx, cursory;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == '*') {
                    timefortraps[i][j] += time;
                    if (timefortraps[i][j] >= 25) {
                        map[i][j] = ' ';
                        cursorx = cn.getTextWindow().getCursorX();
                        cursory = cn.getTextWindow().getCursorY();
                        cn.getTextWindow().setCursorPosition(j, i);
                        System.out.print(" ");
                        cn.getTextWindow().setCursorPosition(cursorx, cursory);
                    }
                } else if (map[i][j] == '=') {
                    timefortraps[i][j] += time;
                    if (timefortraps[i][j] >= 25) {
                        map[i][j] = ' ';
                        cursorx = cn.getTextWindow().getCursorX();
                        cursory = cn.getTextWindow().getCursorY();
                        cn.getTextWindow().setCursorPosition(j, i);
                        System.out.print(" ");
                        cn.getTextWindow().setCursorPosition(cursorx, cursory);
                    }
                }
            }
        }
        return map;
    }
}
