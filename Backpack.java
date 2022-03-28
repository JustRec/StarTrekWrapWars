import enigma.core.Enigma;

public class Backpack {

		private static enigma.console.Console cn = Enigma.getConsole("");
		private static int scoreIncrease;
		private static Stack s = new Stack(8);
		
		// Print the backpack to the console
		static void printBackpack(){
			for(int y=5;y<15;y++) {
				if(y<13) {
					cn.getTextWindow().setCursorPosition(60,y);
					System.out.printf("| %c |",(char)s.getItem(12-y));
				}
				else if(y<14){
					cn.getTextWindow().setCursorPosition(60,y);
					System.out.println("+---+");
				}
				else {
					cn.getTextWindow().setCursorPosition(60,y);
					System.out.println("P.Backpack");
				}
			}		
		}	
		
		//Add item to backpack
		static void takeItem(char item) {
			if(!s.isFull()) {
				// Get the score of the number
				switch (item) {
					case '1':
						scoreIncrease+=1;
					case '2':
						scoreIncrease+=5;
					case '3':
						scoreIncrease+=15;
					case '4':
						scoreIncrease+=50;
					case '5':
						scoreIncrease+=150;
					}
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
}


