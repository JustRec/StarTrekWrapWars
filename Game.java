import enigma.core.Enigma;
import java.awt.Color;

public class Game {
	private static int prevAction = 1;
  	private static char[][] map;
  	private static enigma.console.Console cn = Enigma.getConsole("");
    private static EnigmaWrapper wrapper;
	private static int action = 1;
	private static int keyPattern[] = new int[10]; // 37 -> left, 38 -> up, 39 -> right, 40 -> down, 87 -> W, 65 -> A, 83 -> S, 68 -> D
	private static double prevTime = System.currentTimeMillis();
	private static short pr = 0;
	
	static void start(char[][] mp, boolean energy2x, EnigmaWrapper wr) throws Exception {
		wrapper = wr; map = mp; boolean eUsed = false; float timecount = 0;
		Player player = new Player(wrapper);
		
        while(true) {
    		Thread.sleep(50);
			
        	if(wrapper.getKeypr() == 1) {
        		keyPattern[pr++] = wrapper.getRkey();
        	}	
        	else {
        		keyPattern[pr++] = 1;
        	}
        	wrapper.setKeypr(0);
        	if (timecount >= 3.0) {
				timecount = 0;
				player.addCharacter(map, ItemQueue.getColor(ItemQueue.getFirstItemWithoutDequeue()), Character.toString(ItemQueue.getItem()));
				ItemQueue.writeItemQueue(cn);
			}
        	if(energy2x && System.currentTimeMillis() - prevTime > 250) {
				timecount += 0.25;
        		Player();
        		if(eUsed) {
        			Bot();
        			eUsed = false;
        		}
        		else {eUsed = true;}
        	}
        	else if(System.currentTimeMillis() - prevTime > 500) {
        		if(eUsed == true) {eUsed = false;}
				timecount += 0.5;
        		Player();
        		Bot();
        	}
        }
    }
	
	private static int decPattern(int[] pat) {
		int a = 9;
		boolean endsEmpty = false; //pattern ends with empty
		while(pat[a] == 0) { //remove unassigned numbers from pattern
			a--;
		}
		if(pat[a] == 1) {endsEmpty = true;}
		while(pat[a] == 1 && a > 0) {
			a--;
		}
		for(int x = a; x > 0; x--) {
			if(pat[x] != pat[0]) {
				return pat[a];
			}
		}
		if(endsEmpty && prevAction == pat[a]) {return 1;}
		else {return pat[a];}
		
    }
	
	private static void PlayerAction(){
		
		
	            if (action == 37 && Player.findPx(map) > 0
	                && map[Player.findPy(map)][Player.findPx(map) - 1] != '#') {
	                int cursorx = cn.getTextWindow().getCursorX();
	                int cursory = cn.getTextWindow().getCursorY();

	                map[cursory][cursorx] = ' ';
	                map[cursory][cursorx - 1] = 'P';

	                System.out.println(" "); // delete P

	                cn.getTextWindow().setCursorPosition(cursorx - 1, cursory);
	                wrapper.printInColor(Color.orange, Color.cyan, "P");
	                cn.getTextWindow().setCursorPosition(cursorx - 1, cursory);

	            }
	            if (action == 39 && Player.findPx(map) < map[0].length - 1
	                && map[Player.findPy(map)][Player.findPx(map) + 1] != '#') {
	                int cursorx = cn.getTextWindow().getCursorX();
	                int cursory = cn.getTextWindow().getCursorY();

	                map[cursory][cursorx] = ' ';
	                map[cursory][cursorx + 1] = 'P';

	                System.out.println(" "); // delete P

	                cn.getTextWindow().setCursorPosition(cursorx + 1, cursory);
	                wrapper.printInColor(Color.orange, Color.cyan, "P");
	                cn.getTextWindow().setCursorPosition(cursorx + 1, cursory);
	            }
	            if (action == 38 && Player.findPy(map) > 0
	                && map[Player.findPy(map) - 1][Player.findPx(map)] != '#') {
	                int cursorx = cn.getTextWindow().getCursorX();
	                int cursory = cn.getTextWindow().getCursorY();

	                map[cursory][cursorx] = ' ';
	                map[cursory - 1][cursorx] = 'P';

	                System.out.println(" "); // delete P

	                cn.getTextWindow().setCursorPosition(cursorx, cursory - 1);
	                wrapper.printInColor(Color.orange, Color.cyan, "P");
	                cn.getTextWindow().setCursorPosition(cursorx, cursory - 1);
	            }
	            if (action == 40 && Player.findPy(map) < map.length - 1
	                && map[Player.findPy(map) + 1][Player.findPx(map)] != '#') {
	                int cursorx = cn.getTextWindow().getCursorX();
	                int cursory = cn.getTextWindow().getCursorY();

	                map[cursory][cursorx] = ' ';
	                map[cursory + 1][cursorx] = 'P';

	                System.out.println(" "); // delete P

	                cn.getTextWindow().setCursorPosition(cursorx, cursory + 1);
	                wrapper.printInColor(Color.orange, Color.cyan, "P");
	                cn.getTextWindow().setCursorPosition(cursorx, cursory + 1);
	            }
	            if (action == 87) {

	            }
	            if (action == 83) {

	            }
	            if (action == 65) {

	            }
	            if (action == 68) {

	            }	
		
	}
	
	private static void Player() {
		action = decPattern(keyPattern);
		prevAction = action;      		
		pr = 0;
		keyPattern = new int[10];
		PlayerAction();   		
		prevTime = System.currentTimeMillis();
	}
	
	private static void Bot() {
		
		//Bot hareketleri
	}
	
	
}
