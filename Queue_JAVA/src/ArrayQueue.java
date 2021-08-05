
public class ArrayQueue implements Queue{
	private static final int MAX_QUEUE = 1000;
	private Object[] obj = new Object[MAX_QUEUE];
	private int size =0;
	private int front,rear = 0;
	
	public void Enqueue(Object object) {
		if ( size >= MAX_QUEUE) {
			System.out.println("The Queue is full");
		} else {
			obj[rear] = object;
			rear++;
			size++;
		}
	}
	
	public Object Dequeue() {
		if (size == 0) {
			throw new IllegalStateException("The Queue is EMPTY");
		} else {
			Object tmp = obj[front];
			size--;
			System.arraycopy(obj, 1, obj, 0,size);
			rear--;
			return tmp;
			
		}
	}
	public Object getFront() {
		if (size == 0) {
			throw new IllegalStateException("The Queue is EMPTY");
		} else {
			return obj[front];
		}
	}
	public int size() {
		return size;
	}
}
