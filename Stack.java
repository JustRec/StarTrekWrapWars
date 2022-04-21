
public class Stack {

	private int top;
	private Object[] elements;

	Stack(int capacity) {
		elements = new Object[capacity];
		top = -1;

	}

	void push(Object data) {
		if (isFull())
			System.out.println("Stack overflow");
		else {
			elements[++top] = data;
		}
	}

	Object pop() {
		if (isEmpty()) {
			return null;
		} else {
			Object retData = elements[top];
			elements[top--] = null;
			return retData;
		}
	}

	Object peek() {
		if (isEmpty()) {
			return null;
		} else
			return elements[top];
	}

	boolean isEmpty() {
		return (top == -1);
	}

	boolean isFull() {
		return (top + 1 == elements.length);
	}

	int size() {
		return top + 1;
	}

	Stack sortToAlphabethic(Stack s1) {
		Stack tempstack = new Stack(s1.size());
		while (!s1.isEmpty()) {
			String temp = (String) s1.pop();

			while (!tempstack.isEmpty() && 0 < temp.compareTo((String) tempstack.peek())) {
				s1.push(tempstack.pop());
			}
			tempstack.push(temp);
		}
		return tempstack;
	}

	Stack sort(Stack s1) {
		Stack tempstack = new Stack(s1.size());
		while (!s1.isEmpty()) {
			int temp = (int) s1.pop();

			while (!tempstack.isEmpty() && temp > (int) tempstack.peek()) {
				s1.push(tempstack.pop());
			}
			tempstack.push(temp);
		}
		return tempstack;
	}

	Object getItem(int a) {
		if (elements[a] == null) {
			return ' ';
		}
		return elements[a];
	}
}
