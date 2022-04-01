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
	private static double energy2x = 0;
	public static int Score = 0;
	public static double Time = 0;
	private static boolean game = true;
	private static boolean debug = false;
	static void start(char[][] mp, EnigmaWrapper wr) throws Exception {
		wrapper = wr; map = mp; boolean eUsed = false; float timecount = 0;
		Player player = new Player(wrapper);

        while(game) { //-- Game loop --
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
        	if(energy2x != 0 && System.currentTimeMillis() - prevTime > 250) {
				timecount += 0.25; Time += 0.25;
				energy2x -= 0.25;
        		Player();
        		if(eUsed) {
        			Bot();
        			eUsed = false;
        		}
        		else {eUsed = true;}
        	}
        	else if(System.currentTimeMillis() - prevTime > 500) {
        		if(eUsed == true) {eUsed = false;}
        		Time += 0.5;
				timecount += 0.5;
        		Player();
        		Bot();
        	}
        	
        	print(0,String.format("P.Energy: %s     ", Integer.toString((int)energy2x)));        	
        	print(1,String.format("P.Score: %s    ", Score));
        	print(5,String.format("Time: %s", Integer.toString((int)Time)));
        	if(debug) {
        	print(6,"kp-> " + keyPattern[0] + "  ");
        	print(7,"kp-> " + keyPattern[1] + "  ");
        	print(8,"kp-> " + keyPattern[2] + "  ");
        	print(9,"kp-> " + keyPattern[3] + "  ");
        	print(10,"kp-> " + keyPattern[0] + "  ");
        	print(11,"kp-> " + keyPattern[1] + "  ");
        	print(12,"kp-> " + keyPattern[2] + "  ");
        	print(13,"kp-> " + keyPattern[3] + "  ");
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

		if (action == 37 && Player.Px > 0 && retCol(-1,0) != '#') {
			PlayerMove(-1,0);
			}
		if (action == 39 && Player.Px < map[0].length - 1 && retCol(1,0) != '#') {
			PlayerMove(1,0);
			}
		if (action == 38 && Player.Py > 0 && retCol(0,-1) != '#') {
			PlayerMove(0,-1);
			}
		if (action == 40 && Player.Py < map.length - 1 && retCol(0,1) != '#') {
			PlayerMove(0,1);
			}
		if (action == 87 && retCol(0,1) == ' ') {
			PlayerThrow(0,-1);
			}
		if (action == 83 && retCol(0,1) == ' ') {
			PlayerThrow(0,1);
			}
		if (action == 65 && retCol(0,1) == ' ') {
			PlayerThrow(-1,0);
			}
		if (action == 68 && retCol(0,1) == ' ') {
			PlayerThrow(1,0);
			}
	
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
		return map[Player.Py + y][Player.Px + x];
	}
	
	private static void Draw(int x, int y, char c, boolean displace, boolean isPlayer) {
		
		int cursorx = cn.getTextWindow().getCursorX();
        int cursory = cn.getTextWindow().getCursorY();
        map[cursory + y][cursorx + x] = c;
        if(displace) {
        	map[cursory][cursorx] = ' ';
        	System.out.println(" ");
        	}
        cn.getTextWindow().setCursorPosition(cursorx + x, cursory + y);
        wrapper.printInColor(Color.orange, Color.cyan, Character.toString(c));
        if(!displace) {
        	cn.getTextWindow().setCursorPosition(cursorx, cursory);
        }
        else {
        	cn.getTextWindow().setCursorPosition(cursorx + x, cursory + y);
        }
        if(isPlayer) {Player.Py += y; Player.Px += x;}
	}
	
	private static void PlayerMove(int x, int y) {	
		char col = retCol(x,y);
		
		if(col == 'C') {
			Draw(x,y,'P', true, true);
			endGame();
			}
		
		if(!Backpack.isFull()) {
			Draw(x,y,'P', true, true);
			switch(col) {
		case '1':
			Score += 1;
			if(energy2x < 30.0) {energy2x = 30.0;}
			break;
		case '2':
			Score += 5;
			Backpack.takeItem('2');
			break;
		case '3':
			Score += 15;
			Backpack.takeItem('3');
			break;
		case '4':
			Score += 50;
			energy2x = 240.0;
			Backpack.takeItem('4');
			break;
		case '5':
			Score += 150;
			Backpack.takeItem('5');
			break;
		case '=':
			Backpack.takeItem('=');
			break;
		case '*':
			Backpack.takeItem('*');
			break;
		}}
		
		
		
	}
	
	private static void endGame() {
		print(7, "You Lost");
		game = false;
	}
	
	private static void print(int o, String s) {
		int x = cn.getTextWindow().getCursorX(), y = cn.getTextWindow().getCursorY();
		cn.getTextWindow().setCursorPosition(57, 15+o);
		System.out.println(s);
		cn.getTextWindow().setCursorPosition(x, y);
	}
	
	private static void PlayerThrow(int x, int y) {
		
		if(!Backpack.isEmpty()) {
			char c = (char)Backpack.peekItem();
			if(c == '=' || c == '*') {
				Draw(x,y,(char)Backpack.removeItem(),false,false);	
			}
		}
	}
}
