import enigma.core.Enigma;

public class Backpack {

	private static enigma.console.Console cn = Enigma.getConsole("");
	private static Stack s = new Stack(8);
	private static int x, y;
	//public static double energy2x = Game.energy2x;

	// Print the backpack to the console
	static void printBackpack() {
		x = cn.getTextWindow().getCursorX();
		y = cn.getTextWindow().getCursorY();
		for (int y = 5; y < 15; y++) {
			if (y < 13) {
				cn.getTextWindow().setCursorPosition(57, y);
				System.out.printf("| %c |", (char) s.getItem(12 - y));
			} else if (y < 14) {
				cn.getTextWindow().setCursorPosition(57, y);
				System.out.println("+---+");
			} else {
				cn.getTextWindow().setCursorPosition(57, y);
				System.out.println("P.Backpack");
			}
		}
		cn.getTextWindow().setCursorPosition(x, y);
	}

	// Add item to backpack
	static void takeItem(char item) {

		if(!s.isFull()) {
			// Create new ability if two same numbers matched
			if(s.peek() != null && (char)s.peek() != '=' && (char)s.peek() != '*' && (char)s.peek() == item) {
				s.pop();
				switch(item) {
					case '2':
						Game.energy2x += 30;
						break;
					case '3':
						s.push('=');
						break;
					case '4':
						Game.energy2x += 240;
						break;
					case '5':
						s.push('*');
						break;
				}
				printBackpack();
			}
			// Put new item in the backpack otherwise
			else if(item != '1') {s.push(item);}
			printBackpack();
		}
		removeNotIdenticalItems();
	}
	
	static void removeNotIdenticalItems() {
		if(s.size() > 1) {
			Object temp = s.pop();
			if (s.peek().toString().charAt(0) != '=' && s.peek().toString().charAt(0) != '*' && temp.toString().charAt(0)!='='&& temp.toString().charAt(0)!='*' && s.peek() != temp) {
				s.pop();
			}
			else {
				s.push(temp);
			}
		}
		printBackpack();
	}

	static Object removeItem() {
		if (!s.isEmpty()) {
			Object ret = s.pop();
			printBackpack();
			return ret;
		}
		return 'N';
	}

	static boolean isFull() {
		return s.isFull();
	}

	static boolean isEmpty() {
		return s.isEmpty();
	}

	static Object peekItem() {
		if (!s.isEmpty()) {
			return s.peek();
		}
		return null;
	}
}
