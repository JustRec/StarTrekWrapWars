import enigma.core.Enigma;

public class Backpack {

		private static enigma.console.Console cn = Enigma.getConsole("");
		private int top;
		private int scoreIncrease;
		private Object[] elements;
		
		Backpack() {
			elements = new Object[8];
			top = -1;
		}
		Object peek() {
			if(isEmpty()) {
				System.out.println("Stack is empty");
				return null;
			}
			else
				return elements[top];
		}
		
		boolean isEmpty() {
			return (top == -1);
		}
		boolean isFull() {
			return (top + 1 == elements.length);
		}
			
		// Backpack

		// Add WASD keys
		
		// Print the backpack to the console
		public static void printBackpack(){
			for(int y=5;y<15;y++) {
				if(y<13) {
					cn.getTextWindow().setCursorPosition(60,y);
					System.out.println("|   |");
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
		
		//Add item to backpack and show it in the screen(cursor position)
		void takeItem(Object item) {
			//Push to stack and check the last two items
			Object lastItem=null;
			if(isFull()) {
			}
			else if(item.toString().charAt(0)=='1') {
				scoreIncrease++;
			}
			else {
				if(top!=-1) {
				 lastItem = elements[top];
				}
				top++;
				elements[top] = item;
				// Get the score of the number
				switch (item.toString().charAt(0)) {
				case '2':
					scoreIncrease+=5;
				case '3':
					scoreIncrease+=15;
				case '4':
					scoreIncrease+=50;
				case '5':
					scoreIncrease+=150;
				}
				// Show in console
				cn.getTextWindow().setCursorPosition(62,12-top);
				System.out.println(item);
				
				// Need to fix the change in the cursor position
				if((top!=-1)&&(lastItem == item)&&(item.toString().charAt(0)!='*')&&(item.toString().charAt(0)!='=')) {
					for(int x=0;x<2;x++) {
					elements[top]=null;
					top--;
					cn.getTextWindow().setCursorPosition(62, 12-top);
					System.out.println(" ");
					}
						
					switch (item.toString().charAt(0)){
					case '2':
						// Eng for 30 secs
					case '3':
						top++;
						elements[top] = '=';
						cn.getTextWindow().setCursorPosition(62, 12-top);
						System.out.println('=');
					case '4':
						// Eng for 240 secs
					case '5':
						top++;
						elements[top] = '*';
						cn.getTextWindow().setCursorPosition(62, 12-top);
						System.out.println('*');
					}
				}
				else if((top!=-1)&&(item.toString().charAt(0)!='*')&&(item.toString().charAt(0)!='=')){
					for(int x=0;x<2;x++) {
						elements[top]=null;
						top--;
						cn.getTextWindow().setCursorPosition(62, 12-top);
						System.out.println(" ");
						}
				}
			}		
		}
		Object removeItem() {
			//Push to stack
			if(isEmpty()) {
				return null;
			}
			else {
				Object item = elements[top];
				top--;
				
				//Show in console
				cn.getTextWindow().setCursorPosition(62, 12-top);
				System.out.println(" ");
				return item;
			}		
		}
}


