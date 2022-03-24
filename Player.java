import java.util.Random;
import enigma.core.Enigma;

public class Player {
      public static void addP(char[][] map) {
        Random random = new Random();
        int x = random.nextInt(1,55);
        int y = random.nextInt(1,23);
  
        while(true)
            if(map[y][x] != '#'){
                Enigma.getConsole().getTextWindow().setCursorPosition(x, y);
                System.out.println("P");
                map[y][x] = 'P';
                Enigma.getConsole().getTextWindow().setCursorPosition(x, y);
                break;
            }
            else {
                x = random.nextInt(1,55);
                y = random.nextInt(1,23);
            }
      }
      public static int findPx(char[][] map){
        for(int a = 1; a < map.length; a++){
            for(int b = 1; b < map[a].length; b++){
                if(map[a][b] == 'P') return b;
            }
        }
        return 0;
      }
      public static int findPy(char[][] map){
        for(int a = 1; a < map.length; a++){
            for(int b = 1; b < map[a].length; b++){
                if(map[a][b] == 'P') return a;
            }
        }
        return 0;
      }

      
}
