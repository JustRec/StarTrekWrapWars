import enigma.core.Enigma;

public class Backpack {

		private static enigma.console.Console cn = Enigma.getConsole("");
		private static Stack s = new Stack(8);
		private static int x,y;
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
			if(!s.isFull()) {
				// Create new ability if two same numbers matched
				if(s.peek() != null && (char)s.peek() == item) {
					s.pop();
					switch(item) {
						case '2':
							//eng for 30 seconds
							break;
						case '3':
							s.push('=');
							break;
						case '4':
							//eng for 240 seconds
							break;
						case '5':
							s.push('*');
							break;
						}}
				// Put new item in the backpack otherwise
				else if(item != '1') {s.push(item);}
				printBackpack();
				}		
			}
		
		static Object removeItem() {
			if(!s.isEmpty()) {Object ret = s.pop(); printBackpack(); return ret;}
			return null;
		}
		
		static boolean isFull() {
			return s.isFull();
		}
}


