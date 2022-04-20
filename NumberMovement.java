import java.awt.Color;
import java.util.Random;

import enigma.core.Enigma;

public class NumberMovement {
    private static enigma.console.Console cn = Enigma.getConsole("");
    private static int[][] wayregister = new int[23][55];
    private static double time = 0;

    public static char[][] randomMovement(char[][] map, double time_, EnigmaWrapper wp) {
        time += time_;
        if (time >= 1) {
            time = 0;
            char[][] temp = new char[map.length][map[0].length];
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    temp[i][j] = map[i][j];
                }
            }
            Random rand = new Random();
            int cursorx, cursory, way;
            
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    switch (map[i][j]) {
                        case '4':
                            while (true) {
                                if (wayregister[i][j] == 1) {
                                    if (temp[i-1][j] == ' ') {
                                        wayregister[i-1][j] = 1;
                                        temp[i][j] = ' ';
                                        temp[i-1][j] = '4';
                                        cursorx = cn.getTextWindow().getCursorX();
                                        cursory = cn.getTextWindow().getCursorY();
                                        cn.getTextWindow().setCursorPosition(j, i);
                                        System.out.print(" ");
                                        cn.getTextWindow().setCursorPosition(j, i - 1);
                                        wp.printInColor(Color.ORANGE, Color.MAGENTA, "4");
                                        cn.getTextWindow().setCursorPosition(cursorx, cursory);
                                        break;
                                    }
                                    else {
                                        wayregister[i][j] = 0;
                                    }
                                }
                                else if (wayregister[i][j] == 2) {
                                    if (temp[i+1][j] == ' ') {
                                        wayregister[i+1][j] = 2;
                                        temp[i][j] = ' ';
                                        temp[i+1][j] = '4';
                                        cursorx = cn.getTextWindow().getCursorX();
                                        cursory = cn.getTextWindow().getCursorY();
                                        cn.getTextWindow().setCursorPosition(j, i);
                                        System.out.print(" ");
                                        cn.getTextWindow().setCursorPosition(j, i + 1);
                                        wp.printInColor(Color.ORANGE, Color.MAGENTA, "4");
                                        cn.getTextWindow().setCursorPosition(cursorx, cursory);
                                        break;
                                    }
                                    else {
                                        wayregister[i][j] = 0;
                                    }
                                }
                                else if (wayregister[i][j] == 3) {
                                    if (temp[i][j-1] == ' ') {
                                        wayregister[i][j-1] = 3;
                                        temp[i][j] = ' ';
                                        temp[i][j-1] = '4';
                                        cursorx = cn.getTextWindow().getCursorX();
                                        cursory = cn.getTextWindow().getCursorY();
                                        cn.getTextWindow().setCursorPosition(j, i);
                                        System.out.print(" ");
                                        cn.getTextWindow().setCursorPosition(j - 1, i);
                                        wp.printInColor(Color.ORANGE, Color.MAGENTA, "4");
                                        cn.getTextWindow().setCursorPosition(cursorx, cursory);
                                        break;
                                    }
                                    else {
                                        wayregister[i][j] = 0;
                                    }
                                }
                                else if (wayregister[i][j] == 4) {
                                    if (temp[i][j+1] == ' ') {
                                        wayregister[i][j+1] = 4;
                                        temp[i][j] = ' ';
                                        temp[i][j+1] = '4';
                                        cursorx = cn.getTextWindow().getCursorX();
                                        cursory = cn.getTextWindow().getCursorY();
                                        cn.getTextWindow().setCursorPosition(j, i);
                                        System.out.print(" ");
                                        cn.getTextWindow().setCursorPosition(j + 1, i);
                                        wp.printInColor(Color.ORANGE, Color.MAGENTA, "4");
                                        cn.getTextWindow().setCursorPosition(cursorx, cursory);
                                        break;
                                    }
                                    else {
                                        wayregister[i][j] = 0;
                                    }
                                }
                                else if (wayregister[i][j] == 0) {
                                    way = rand.nextInt(1, 5);
                                    switch (way) {
                                        case 1:
                                            if (temp[i-1][j] == ' ') {
                                                wayregister[i-1][j] = 1;
                                                temp[i][j] = ' ';
                                                temp[i-1][j] = '4';
                                                cursorx = cn.getTextWindow().getCursorX();
                                                cursory = cn.getTextWindow().getCursorY();
                                                cn.getTextWindow().setCursorPosition(j, i);
                                                System.out.print(" ");
                                                cn.getTextWindow().setCursorPosition(j, i - 1);
                                                wp.printInColor(Color.ORANGE, Color.MAGENTA, "4");
                                                cn.getTextWindow().setCursorPosition(cursorx, cursory);
                                                break;
                                            }
                                            else continue;
                                        case 2:
                                            if (temp[i+1][j] == ' ') {
                                                wayregister[i+1][j] = 2;
                                                temp[i][j] = ' ';
                                                temp[i+1][j] = '4';
                                                cursorx = cn.getTextWindow().getCursorX();
                                                cursory = cn.getTextWindow().getCursorY();
                                                cn.getTextWindow().setCursorPosition(j, i);
                                                System.out.print(" ");
                                                cn.getTextWindow().setCursorPosition(j, i + 1);
                                                wp.printInColor(Color.ORANGE, Color.MAGENTA, "4");
                                                cn.getTextWindow().setCursorPosition(cursorx, cursory);
                                                break;
                                            }
                                            else continue;
                                        case 3:
                                            if (temp[i][j-1] == ' ') {
                                                wayregister[i][j-1] = 3;
                                                temp[i][j] = ' ';
                                                temp[i][j-1] = '4';
                                                cursorx = cn.getTextWindow().getCursorX();
                                                cursory = cn.getTextWindow().getCursorY();
                                                cn.getTextWindow().setCursorPosition(j, i);
                                                System.out.print(" ");
                                                cn.getTextWindow().setCursorPosition(j - 1, i);
                                                wp.printInColor(Color.ORANGE, Color.MAGENTA, "4");
                                                cn.getTextWindow().setCursorPosition(cursorx, cursory);
                                                break;
                                            }
                                            else continue;
                                        case 4:
                                            if (temp[i][j+1] == ' ') {
                                                wayregister[i][j+1] = 4;
                                                temp[i][j] = ' ';
                                                temp[i][j+1] = '4';
                                                cursorx = cn.getTextWindow().getCursorX();
                                                cursory = cn.getTextWindow().getCursorY();
                                                cn.getTextWindow().setCursorPosition(j, i);
                                                System.out.print(" ");
                                                cn.getTextWindow().setCursorPosition(j + 1, i);
                                                wp.printInColor(Color.ORANGE, Color.MAGENTA, "4");
                                                cn.getTextWindow().setCursorPosition(cursorx, cursory);
                                                break;
                                            }
                                            else continue;
                                    }
                                    break;  
                                }
                            }
                            break;
                        case '5':
                            while (true) {
                                if (wayregister[i][j] == 1) {
                                    if (temp[i-1][j] == ' ') {
                                        wayregister[i-1][j] = 1;
                                        temp[i][j] = ' ';
                                        temp[i-1][j] = '5';
                                        cursorx = cn.getTextWindow().getCursorX();
                                        cursory = cn.getTextWindow().getCursorY();
                                        cn.getTextWindow().setCursorPosition(j, i);
                                        System.out.print(" ");
                                        cn.getTextWindow().setCursorPosition(j, i - 1);
                                        wp.printInColor(Color.ORANGE, Color.MAGENTA, "5");
                                        cn.getTextWindow().setCursorPosition(cursorx, cursory);
                                        break;
                                    }
                                    else {
                                        wayregister[i][j] = 0;
                                    }
                                }
                                else if (wayregister[i][j] == 2) {
                                    if (temp[i+1][j] == ' ') {
                                        wayregister[i+1][j] = 2;
                                        temp[i][j] = ' ';
                                        temp[i+1][j] = '5';
                                        cursorx = cn.getTextWindow().getCursorX();
                                        cursory = cn.getTextWindow().getCursorY();
                                        cn.getTextWindow().setCursorPosition(j, i);
                                        System.out.print(" ");
                                        cn.getTextWindow().setCursorPosition(j, i + 1);
                                        wp.printInColor(Color.ORANGE, Color.MAGENTA, "5");
                                        cn.getTextWindow().setCursorPosition(cursorx, cursory);
                                        break;
                                    }
                                    else {
                                        wayregister[i][j] = 0;
                                    }
                                }
                                else if (wayregister[i][j] == 3) {
                                    if (temp[i][j-1] == ' ') {
                                        wayregister[i][j-1] = 3;
                                        temp[i][j] = ' ';
                                        temp[i][j-1] = '5';
                                        cursorx = cn.getTextWindow().getCursorX();
                                        cursory = cn.getTextWindow().getCursorY();
                                        cn.getTextWindow().setCursorPosition(j, i);
                                        System.out.print(" ");
                                        cn.getTextWindow().setCursorPosition(j - 1, i);
                                        wp.printInColor(Color.ORANGE, Color.MAGENTA, "5");
                                        cn.getTextWindow().setCursorPosition(cursorx, cursory);
                                        break;
                                    }
                                    else {
                                        wayregister[i][j] = 0;
                                    }
                                }
                                else if (wayregister[i][j] == 4) {
                                    if (temp[i][j+1] == ' ') {
                                        wayregister[i][j+1] = 4;
                                        temp[i][j] = ' ';
                                        temp[i][j+1] = '5';
                                        cursorx = cn.getTextWindow().getCursorX();
                                        cursory = cn.getTextWindow().getCursorY();
                                        cn.getTextWindow().setCursorPosition(j, i);
                                        System.out.print(" ");
                                        cn.getTextWindow().setCursorPosition(j + 1, i);
                                        wp.printInColor(Color.ORANGE, Color.MAGENTA, "5");
                                        cn.getTextWindow().setCursorPosition(cursorx, cursory);
                                        break;
                                    }
                                    else {
                                        wayregister[i][j] = 0;
                                    }
                                }
                                else if (wayregister[i][j] == 0) {
                                    way = rand.nextInt(1, 5);
                                    switch (way) {
                                        case 1:
                                            if (temp[i-1][j] == ' ') {
                                                wayregister[i-1][j] = 1;
                                                temp[i][j] = ' ';
                                                temp[i-1][j] = '5';
                                                cursorx = cn.getTextWindow().getCursorX();
                                                cursory = cn.getTextWindow().getCursorY();
                                                cn.getTextWindow().setCursorPosition(j, i);
                                                System.out.print(" ");
                                                cn.getTextWindow().setCursorPosition(j, i - 1);
                                                wp.printInColor(Color.ORANGE, Color.MAGENTA, "5");
                                                cn.getTextWindow().setCursorPosition(cursorx, cursory);
                                                break;
                                            }
                                            else continue;
                                        case 2:
                                            if (temp[i+1][j] == ' ') {
                                                wayregister[i+1][j] = 2;
                                                temp[i][j] = ' ';
                                                temp[i+1][j] = '5';
                                                cursorx = cn.getTextWindow().getCursorX();
                                                cursory = cn.getTextWindow().getCursorY();
                                                cn.getTextWindow().setCursorPosition(j, i);
                                                System.out.print(" ");
                                                cn.getTextWindow().setCursorPosition(j, i + 1);
                                                wp.printInColor(Color.ORANGE, Color.MAGENTA, "5");
                                                cn.getTextWindow().setCursorPosition(cursorx, cursory);
                                                break;
                                            }
                                            else continue;
                                        case 3:
                                            if (temp[i][j-1] == ' ') {
                                                wayregister[i][j-1] = 3;
                                                temp[i][j] = ' ';
                                                temp[i][j-1] = '5';
                                                cursorx = cn.getTextWindow().getCursorX();
                                                cursory = cn.getTextWindow().getCursorY();
                                                cn.getTextWindow().setCursorPosition(j, i);
                                                System.out.print(" ");
                                                cn.getTextWindow().setCursorPosition(j - 1, i);
                                                wp.printInColor(Color.ORANGE, Color.MAGENTA, "5");
                                                cn.getTextWindow().setCursorPosition(cursorx, cursory);
                                                break;
                                            }
                                            else continue;
                                        case 4:
                                            if (temp[i][j+1] == ' ') {
                                                wayregister[i][j+1] = 4;
                                                temp[i][j] = ' ';
                                                temp[i][j+1] = '5';
                                                cursorx = cn.getTextWindow().getCursorX();
                                                cursory = cn.getTextWindow().getCursorY();
                                                cn.getTextWindow().setCursorPosition(j, i);
                                                System.out.print(" ");
                                                cn.getTextWindow().setCursorPosition(j + 1, i);
                                                wp.printInColor(Color.ORANGE, Color.MAGENTA, "5");
                                                cn.getTextWindow().setCursorPosition(cursorx, cursory);
                                                break;
                                            }
                                            else continue;
                                    }
                                    break;
                                }
                            }
                        break;
                    }
                }
            }
            map = temp;
            return map;
        }
        return map;
    }
}
