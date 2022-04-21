import java.awt.Color;
import java.util.Random;
import enigma.console.Console;

public class ItemQueue {
	private static Random rand = new Random();
	private static boolean firstrun = true;
	static CircularQueue iq = new CircularQueue(15);
	private static int a;

	private static char randItem() {
		a = rand.nextInt(40);
		if (a == 39) {
			return '*';
		}
		if (a > 36) {
			return '=';
		}
		if (a > 34) {
			return 'C';
		}
		if (a > 30) {
			return '5';
		}
		if (a > 25) {
			return '4';
		}
		if (a > 19) {
			return '3';
		}
		if (a > 11) {
			return '2';
		} else {
			return '1';
		}
	}

	static void fillQueue() {
		if (firstrun) {
			for (int x = 0; x < 14; x++) {
				iq.enqueue(randItem());
			}
			firstrun = false;
		}
		iq.enqueue(randItem());
	}

	static void writeFirstTimeQueue(char map[][], EnigmaWrapper wrapper, Player player, Robot[] robots,
			int robot_counter) {
		for (int x = 0; x < 20; x++) {
			char temp = randItem();
			player.addCharacter(map, getColor(temp), Character.toString(temp));
			if (temp == '4' || temp == '5' || temp == 'C') {
				robots[robot_counter++] = new Robot(map, temp);
			}
		}
	}

	static Color getColor(char input) {
		Color color = Color.white;
		switch (input) {
			case '1', '2', '3':
				return Color.white;
			case '4', '5':
				return Color.magenta;
			case 'C', '=', '*':
				return Color.red;
		}
		return color;
	}

	static char getItem() {
		return (char) iq.dequeue();
	}

	static char getFirstItemWithoutDequeue() {
		return (char) iq.peek();
	}

	static void writeItemQueue(Console cn) {
		fillQueue();
		String queue = "";
		Queue temp = new Queue(iq.size());
		for (int x = 0; x < 15; x++) {
			queue += iq.peek();
			temp.enqueue(iq.dequeue());
		}
		for (int x = 0; x < 15; x++) {
			iq.enqueue(temp.dequeue());
		}

		int cursorx = cn.getTextWindow().getCursorX();
		int cursory = cn.getTextWindow().getCursorY();

		cn.getTextWindow().setCursorPosition(56, 0);
		System.out.print("Input");
		cn.getTextWindow().setCursorPosition(56, 1);
		System.out.print("<<<<<<<<<<<<<<<");
		cn.getTextWindow().setCursorPosition(56, 2);
		System.out.print(queue);
		cn.getTextWindow().setCursorPosition(56, 3);
		System.out.print("<<<<<<<<<<<<<<<");

		cn.getTextWindow().setCursorPosition(cursorx, cursory);
	}

	static void init() { // tercihe bağlı, InputQueue'nun oyun başlamadan önce oluşturulabilmesi için
							// metod
		for (int x = 0; x < 15; x++) {
			iq.enqueue(randItem());
		}
		firstrun = false;
	}
}
