import java.util.*;

public class PQHEAP {
	public static void main(String args[]) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		pQueue.add(10);
		pQueue.add(30);
		pQueue.add(20);
		pQueue.add(400);
		
		System.out.println("Head value using peek Function:" + pQueue.peek());
		
		System.out.println("The Queue Elements : ");
		Iterator<Integer> it = pQueue.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		pQueue.poll();
		System.out.println("After removing an element " + "with poll function :");
		it = pQueue.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}
