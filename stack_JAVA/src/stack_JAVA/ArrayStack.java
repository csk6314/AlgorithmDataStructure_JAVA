package stack_JAVA;

public class ArrayStack implements Stack{
	private Object[] stack;
	int top;
	int size;
	public ArrayStack(int size) {
		this.size = size;
		stack = new Object[size];
		top = -1;
	}
	public Object peek() {
		if (isEmpty()) throw new IllegalStateException("stack is empty");
		return stack[top];
	}
	
	public Object pop() {
		if (isEmpty()) throw new IllegalStateException("stack is empty");
		Object item = stack[top];
		stack[top--] = null;
		return item;
	}
	public void push(Object ob) {
		if (top == stack.length-1) throw new StackOverflowError("스택 공간 부족으로 Push불가능합니다.");
		stack[++top] = ob;
		
	}
	
	public int size() {
		return top+1;
	}
	public boolean isEmpty() {
		return top==-1;
	}
}
