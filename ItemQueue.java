import java.util.Random;

public class ItemQueue {
	private static Random rand = new Random();
	private static boolean firstrun = true;
	static Queue iq = new Queue(32000);
	private static int a;
	
	private static char randItem() {
		    a = rand.nextInt(40);
		if(a == 39) {return '*';}
		if (a > 36) {return '=';}
		if (a > 34) {return 'C';}
		if (a > 30) {return '5';}
		if (a > 25) {return '4';}
		if (a > 19) {return '3';}
		if (a > 11) {return '2';}
		else	    {return '1';}
	}
	
	static char get() {
		if(firstrun) { for(int x = 0; x < 15; x++) {iq.enqueue(randItem());} firstrun = false;} 
		iq.enqueue(randItem());
		return (char)iq.dequeue();
	}
	
	static void init() { //tercihe bağlı, InputQueue'nun oyun başlamadan önce oluşturulabilmesi için metod
		for(int x = 0; x < 15; x++) {iq.enqueue(randItem());}
		firstrun = false;
	}
}
