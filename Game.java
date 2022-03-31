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
	public static int Score = 0;
	
	static void start(char[][] mp, boolean energy2x, EnigmaWrapper wr) throws Exception {
		wrapper = wr; map = mp; boolean eUsed = false; float timecount = 0;
		Player player = new Player(wrapper);

        while(true) { //-- Game loop --
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
		while(pat[a] == 0) { //remove unassigned numbers
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
	
	private static void InitPlayerAction(){

		if (action == 37 && Player.findPx(map) > 0 && retCol(-1,0) != '#') {PlayerAction(-1,0);}
		if (action == 39 && Player.findPx(map) < map[0].length - 1 && retCol(1,0) != '#') {PlayerAction(1,0);}
		if (action == 38 && Player.findPy(map) > 0 && retCol(0,-1) != '#') {PlayerAction(0,-1);}
		if (action == 40 && Player.findPy(map) < map.length - 1 && retCol(0,1) != '#') {PlayerAction(0,1);}
	
	}
	
	private static void Player() {
		action = decPattern(keyPattern);
		prevAction = action;      		
		pr = 0;
		keyPattern = new int[10];
		InitPlayerAction();   		
		prevTime = System.currentTimeMillis();
	}
	
	private static void Bot() {
		
		//Bot hareketleri
	}
	
	private static char retCol(int x, int y) { //return collision on relative locations
		return map[Player.findPy(map) + y][Player.findPx(map) + x];
	}
	
	private static void Draw(int x, int y, char c) {
		
		int cursorx = cn.getTextWindow().getCursorX();
        int cursory = cn.getTextWindow().getCursorY();
        
        map[cursory][cursorx] = ' ';
        map[cursory + y][cursorx + x] = c;
        System.out.println(" ");
        cn.getTextWindow().setCursorPosition(cursorx + x, cursory + y);
        wrapper.printInColor(Color.orange, Color.cyan, Character.toString(c));
        cn.getTextWindow().setCursorPosition(cursorx + x, cursory + y);
	}
	
	private static void PlayerAction(int x, int y) {	
		char col = retCol(x,y);
		Draw(x,y,'P');

		switch(col) {
		case 'C':
			endGame();
			break;
		case '1':
			Score += 1;
			printScore();
			break;
		case '2':
			Score += 5;
			Backpack.takeItem('2');
			printScore();
			break;
		case '3':
			Score += 15;
			Backpack.takeItem('3');
			printScore();
			break;
		case '4':
			Score += 50;
			Backpack.takeItem('4');
			printScore();
			break;
		case '5':
			Score += 150;
			Backpack.takeItem('5');
			printScore();
			break;
		case '=':
			Backpack.takeItem('=');
			break;
		case '*':
			Backpack.takeItem('*');
			break;
		}
		
	}
	
	private static void endGame() {
		//
	}
	
	private static void printScore() {
		int x = cn.getTextWindow().getCursorX(), y = cn.getTextWindow().getCursorY();
		cn.getTextWindow().setCursorPosition(57, 15);
		System.out.printf("Score: %s", Score);
		cn.getTextWindow().setCursorPosition(x, y);
	}
}
