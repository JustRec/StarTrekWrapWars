import enigma.core.Enigma;

public class Backpack {

		private static enigma.console.Console cn = Enigma.getConsole("");
		private static Stack s = new Stack(8);
		private static int x,y;
		public static double energy2x = Game.energy2x;
		// Print the backpack to the console
		static void printBackpack(){
			x = cn.getTextWindow().getCursorX(); y = cn.getTextWindow().getCursorY();
			for(int y=5;y<15;y++) {
				if(y<13) {
					cn.getTextWindow().setCursorPosition(57,y);
					System.out.printf("| %c |",(char)s.getItem(12-y));
				}
				else if(y<14){
					cn.getTextWindow().setCursorPosition(57,y);
					System.out.println("+---+");
				}
				else {
					cn.getTextWindow().setCursorPosition(57,y);
					System.out.println("P.Backpack");
				}
			}
			cn.getTextWindow().setCursorPosition(x, y);
		}	
		
		//Add item to backpack
		static void takeItem(char item) {
			
				// Create new ability if two same numbers matched
				if(s.peek() != null && (char)s.peek() == item && (item == '3' || item == '5')) {
					s.pop();
					if(item == '3') {s.push('=');}
					if(item == '5') {s.push('*');}
				}
				// Put new item in the backpack otherwise
				else {s.push(item);}
				printBackpack();
				
		}
		
		static Object removeItem() {
			if(!s.isEmpty()) {
				Object ret = s.pop();
				printBackpack();
				return ret;
				}
			return null;
		}

		static boolean isFull() {
			return s.isFull();
		}
		
		static boolean isEmpty() {
			return s.isEmpty();
		}
		
		static Object peekItem() {
			if(!s.isEmpty()) {
				return s.peek();
			}
			return null;
		}
}


