import java.util.*;
import java.io.*;
public class GasStation {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] city = new int[N];
		int[] road = new int[N-1];
		
		String[] input = br.readLine().split(" ");
		for(int i =0;i<N-1;i++) {
			road[i] = Integer.parseInt(input[i]);
		}
		input = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			city[i] = Integer.parseInt(input[i]);
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(city[0]);
		long cost = 0;
		for(int i=1;i<=N-1;i++) {
			cost += (long) stack.peek() * road[i-1];
			if(stack.peek() > city[i]) {
				stack.push(city[i]);
			}
		}
		
		System.out.println(cost);
	}
}
