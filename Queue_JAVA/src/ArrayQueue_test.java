
public class ArrayQueue_test {
	public static void main(String args[]) {
		ArrayQueue arque = new ArrayQueue();
		
		arque.Enqueue(3);
		arque.Enqueue(4);
		arque.Enqueue(5);
		System.out.println(arque.getFront() + " " + arque.size());
		arque.Dequeue();
		System.out.println(arque.getFront() + " " + arque.size());
		arque.Dequeue();
		System.out.println(arque.getFront() + " " + arque.size());
	}
}
