import java.util.Random;

public class InputQueue {
	private static Random rand = new Random();
	private static boolean firstrun = true;
	private static int a;
	public static char[] queue = new char[15];
	private static char to_be_returned;
	private static char randItem() {
			a = rand.nextInt(40);
		if(a == 39) {return '*';}
		if (a > 36) {return '=';}
		if (a > 34) {return 'C';}
		if (a > 30) {return '5';}
		if (a > 25) {return '4';}
		if (a > 19) {return '3';}
		if (a > 11) {return '2';}
		else		{return '1';}
	}
	static char get() {
		if(firstrun) {
			for(int x = 0; x < 15; x++) {
				queue[x] = randItem();
			}
		firstrun = false;
		}
		to_be_returned = queue[0];
		for(int x = 0; x < 14; x++) {
			queue[x] = queue[x+1];
		}
		queue[14] = randItem();
		return to_be_returned;
	}
	
	static void init() { //tercihe bağlı, InputQueue'nun oyun başlamadan önce oluşturulabilmesi için metod
		for(int x = 0; x < 15; x++) {
			queue[x] = randItem();
		}
	firstrun = false;
	}
	
	
}
