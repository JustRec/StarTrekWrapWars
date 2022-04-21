import enigma.core.Enigma;
import java.awt.Color;

public class Game {
	private static int prevAction = 1;
  	private static char[][] map;
  	public static enigma.console.Console cn = Enigma.getConsole("");
    public static EnigmaWrapper wrapper;
	private static int action = 1;
	private static int keyPattern[] = new int[10]; // 37 -> left, 38 -> up, 39 -> right, 40 -> down, 87 -> W, 65 -> A, 83 -> S, 68 -> D
	private static double prevTime = System.currentTimeMillis();
	private static short pr = 0;
	public static double energy2x = 50;
	public static int Score = 0;
	public static double Time = 0;
	private static boolean game = true;
	private static boolean is_updated = false;
	public static int[] new_robot_location = new int[2];
	private static Robot[] robots = new Robot[50];
	public static Devices devices = new Devices();
	public static Points points = new Points();
	public static Device[] device = new Device[50];
	private static int robot_counter = 0;
	static void start(char[][] mp, EnigmaWrapper wr, Player player) throws Exception {
		wrapper = wr; map = mp; boolean eUsed = false; double timecount = 0;
		
		//place number of objects at the start
		ItemQueue.writeFirstTimeQueue(map, wrapper, player, robots, robot_counter);

        while(game) { //-- Main loop --
    		Thread.sleep(50);
			
    		// catch keypress
        	if(wrapper.getKeypr() == 1) {
        		keyPattern[pr++] = wrapper.getRkey();
        	}	
        	else {
        		keyPattern[pr++] = 1;
        	}
        	
        	wrapper.setKeypr(0);
        		
        	//Player and Bot(same as !energy2x) (energy2x)
        	if(energy2x != 0 && System.currentTimeMillis() - prevTime > 250) {
				Time += 0.25; timecount += 0.25;
				is_updated = false;
				energy2x -= 0.25;
        		Player();
        		if(eUsed) {
        			Bot();
        			eUsed = false;
        		}
        		else {eUsed = true;}

        		printStat();

				map = TrapDevices.isTrapped(map);
				map = TrapDevices.timeForTrap(map, 0.25);
				map = NumberMovement.randomMovement(map, 0.25, wrapper);

        	}
        	
        	// !energy2x
        	else if(System.currentTimeMillis() - prevTime > 500) {
        		if(eUsed == true) {
					eUsed = false;
				}
        		Time += 0.5;
            is_updated = false;
				timecount += 0.5;
        		Player();
        		Bot();
            printStat();
				map = TrapDevices.isTrapped(map);
				map = TrapDevices.timeForTrap(map, 0.5);
				map = NumberMovement.randomMovement(map, 0.5, wrapper);
        	}
        	
        	//Devices - every 1 second
        	if((timecount == 1 || timecount == 2) && !is_updated) {
        		updateDevice();
				is_updated = true;
        	}
        	
        	//ItemQueue (+Devices) - every 3 seconds
        	else if(timecount == 3) {
        		timecount = 0;
        		
        		updateDevice();
				char item = ItemQueue.getFirstItemWithoutDequeue();
				player.addCharacter(map, ItemQueue.getColor(ItemQueue.getItem()), Character.toString(item));
				ItemQueue.writeItemQueue(cn);
				if(item == '4' || item == '5' || item == 'C'){
					robots[robot_counter++] = new Robot(map, item);
				}			
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
		if (action == 87 && !(Backpack.isEmpty())) {
			if(retCol(0,-1) == ' ' && (Backpack.peekItem().toString().charAt(0)=='*'||Backpack.peekItem().toString().charAt(0)=='=')) {	
				PlayerThrow(0,-1);
			}
			else if(Backpack.peekItem().toString().charAt(0)!='*'&& Backpack.peekItem().toString().charAt(0)!='='){
				PlayerThrow(0,-1);
			}	
			}
		if (action == 83 && !(Backpack.isEmpty())) {
			if(retCol(0,1) == ' ' && (Backpack.peekItem().toString().charAt(0)=='*'||Backpack.peekItem().toString().charAt(0)=='=')) {	
				PlayerThrow(0,1);
			}
			else if(Backpack.peekItem().toString().charAt(0)!='*'&& Backpack.peekItem().toString().charAt(0)!='='){
				PlayerThrow(0,1);
			}	
			}
		if (action == 65 && !(Backpack.isEmpty())) {
			if(retCol(-1,0) == ' ' && (Backpack.peekItem().toString().charAt(0)=='*'||Backpack.peekItem().toString().charAt(0)=='=')) {	
				PlayerThrow(-1,0);
			}
			else if(Backpack.peekItem().toString().charAt(0)!='*'&& Backpack.peekItem().toString().charAt(0)!='='){
				PlayerThrow(-1,0);
			}				
			}
		if (action == 68 && !(Backpack.isEmpty())) {
			if(retCol(1,0) == ' ' && (Backpack.peekItem().toString().charAt(0)=='*'||Backpack.peekItem().toString().charAt(0)=='=')) {	
				PlayerThrow(1,0);
			}
			else if(Backpack.peekItem().toString().charAt(0)!='*'&& Backpack.peekItem().toString().charAt(0)!='='){
				PlayerThrow(1,0);
			}	
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
		int i = 0;
		while(robots[i] != null) {
			if(!robots[i].getIsAlive()){
				robots[i] = null;
				i++;
				continue;
			}
			if(robots[i].getHasATarget()) {
				robots[i].move();
			}
			else {
				robots[i].pathFinding();
			}
			i++;
		}
	}

	private static void updateDevice(){
		
		for (int i = 0; i < device.length; i++) {
			if(device[i] != null){
				if(device[i].getIs_alive()){
					device[i].passTime();
				}
				else{
					device[i] = null;
				}
			}
		}
	}
	
	private static char retCol(int x, int y) { //return collision on relative locations
		return map[Player.Py + y][Player.Px + x];
	}
	
	public static void Draw(int x, int y, char c, boolean displace) {
		map[Player.Py + y][Player.Px + x] = c;
		if(displace) {
	        map[Player.Py][Player.Px] = ' ';
			cn.getTextWindow().setCursorPosition(Player.Px, Player.Py);
	    	System.out.println(" ");
	    	cn.getTextWindow().setCursorPosition(Player.Px + x, Player.Py + y);
	        wrapper.printInColor(Color.orange, Color.cyan, Character.toString(c));
	        Player.Py += y; Player.Px += x;
		}
		else {
	        cn.getTextWindow().setCursorPosition(Player.Px + x, Player.Py + y);
	        wrapper.printInColor(Color.orange, Color.cyan, Character.toString(c));
		}
	}
	
	private static void PlayerMove(int x, int y) {	
		char col = retCol(x,y);
		

				
			switch(col) {
		case '1':
			Score += 1;
			Draw(x,y,'P',true);
			break;
		case '2':
			Score += 5;
			if(energy2x < 30) {energy2x = 30;}
			Draw(x,y,'P',true);
			break;
		case '3':
			if(!Backpack.isFull()) {
				Score += 15;
				Backpack.takeItem('3');
				Draw(x,y,'P',true);
			}
			break;
		case '4':
			Score += 50;
			energy2x = 240;
			Draw(x,y,'P',true);
			break;
		case '5':
			if(!Backpack.isFull()) {
				Score += 150;
				Backpack.takeItem('5');
				Draw(x,y,'P',true);
			}
			break;
		case '=':
			if(!Backpack.isFull()) {
				Backpack.takeItem('=');
				Draw(x,y,'P',true);
			}
			break;
		case '*':
			if(!Backpack.isFull()) {
				Backpack.takeItem('*');
				Draw(x,y,'P',true);
			}
			break;
		case 'C':
			Draw(x,y,'P',true);
			endGame();
			break;
		default:
			Draw(x,y,'P',true);
		}
		
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
		//sayılar oyun alanına geri eklenmek yerine silinir
		if(!Backpack.isEmpty()) {
			if(Backpack.peekItem().toString().charAt(0)=='='||Backpack.peekItem().toString().charAt(0)=='*')
			Draw(x,y,(char)Backpack.removeItem(), false);
			else {
				Backpack.removeItem();
			}
		}
	}

	public static void setMap(char[][] map) {
        Game.map = map;
    }

	public static char[][] getMap(){
		return Game.map;
	}
	
	public static void printStat() {
    	print(0,String.format("P.Energy: %s     ", Integer.toString((int)energy2x)));        	
    	print(1,String.format("P.Score: %s    ", Points.getPlayer()));
    	print(5,String.format("Time: %s", Integer.toString((int)Time)));
	}
}
