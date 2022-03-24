import enigma.core.Enigma;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Moment {
   public enigma.console.Console cn = Enigma.getConsole("");
   public KeyListener klis; 

   // ------ Standard variables for mouse and keyboard ------
   public int keypr;   // key pressed?
   public int rkey;    // key   (for press/release)
   // ----------------------------------------------------
   public char[][] map;
   public boolean energy2x;
   
   Moment(char[][] map, boolean energy2x) throws Exception {   // --- Contructor
      this.map=map;
      this.energy2x=energy2x;
      klis=new KeyListener() {
         public void keyTyped(KeyEvent e) {}
         public void keyPressed(KeyEvent e) {
            if(keypr==0) {
               keypr=1;
               rkey=e.getKeyCode();
            }
         }
         public void keyReleased(KeyEvent e) {}
      };
      cn.getTextWindow().addKeyListener(klis);
      // ----------------------------------------------------
      

      while(true) {
         
         if(keypr==1) {    // if keyboard button pressed
            if(rkey==KeyEvent.VK_LEFT && Player.findPx(map) > 0 && map[Player.findPy(map)][Player.findPx(map) - 1] != '#') {
                int cursorx = cn.getTextWindow().getCursorX();
                int cursory = cn.getTextWindow().getCursorY();
                
                map[cursory][cursorx] = ' ';
                map[cursory][cursorx - 1] = 'P';

                System.out.println(" "); //delete P

                cn.getTextWindow().setCursorPosition(cursorx - 1, cursory);
                System.out.println("P");
                cn.getTextWindow().setCursorPosition(cursorx - 1, cursory);

            }
            if(rkey==KeyEvent.VK_RIGHT && Player.findPx(map) < map[0].length - 1 && map[Player.findPy(map)][Player.findPx(map) + 1] != '#') {
                int cursorx = cn.getTextWindow().getCursorX();
                int cursory = cn.getTextWindow().getCursorY();
                
                map[cursory][cursorx] = ' ';
                map[cursory][cursorx + 1] = 'P';
                
                System.out.println(" "); //delete P

                cn.getTextWindow().setCursorPosition(cursorx + 1, cursory);
                System.out.println("P");
                cn.getTextWindow().setCursorPosition(cursorx + 1, cursory);
            }
            if(rkey==KeyEvent.VK_UP && Player.findPy(map) > 0 && map[Player.findPy(map) - 1][Player.findPx(map)] != '#') {
                int cursorx = cn.getTextWindow().getCursorX();
                int cursory = cn.getTextWindow().getCursorY();
                
                map[cursory][cursorx] = ' ';
                map[cursory - 1][cursorx] = 'P';

                System.out.println(" "); //delete P

                cn.getTextWindow().setCursorPosition(cursorx, cursory - 1);
                System.out.println("P");
                cn.getTextWindow().setCursorPosition(cursorx, cursory - 1);
            }
            if(rkey==KeyEvent.VK_DOWN && Player.findPy(map) < map.length - 1 && map[Player.findPy(map) + 1][Player.findPx(map)] != '#') {
                int cursorx = cn.getTextWindow().getCursorX();
                int cursory = cn.getTextWindow().getCursorY();
                
                map[cursory][cursorx] = ' ';
                map[cursory + 1][cursorx] = 'P';
                
                System.out.println(" "); //delete P

                cn.getTextWindow().setCursorPosition(cursorx, cursory + 1);
                System.out.println("P");
                cn.getTextWindow().setCursorPosition(cursorx, cursory + 1);
            }
            if(rkey==KeyEvent.VK_W) {
               
            }
            if(rkey==KeyEvent.VK_S) {
               
            }
            if(rkey==KeyEvent.VK_A) {
               
            }
            if(rkey==KeyEvent.VK_D) {
               
            }

            if(rkey==KeyEvent.VK_SPACE) {
               break;
            }
            
            keypr=0;    // last action  
         }
         if(energy2x)
            Thread.sleep(250);
         else 
            Thread.sleep(500);
      }
   }
}
