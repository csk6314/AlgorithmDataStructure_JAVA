import java.util.*;
import java.io.*;
public class NGE2 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		int[] ary=  new int[N];
		for(int i=0;i<N;i++) {
			ary[i] = Integer.parseInt(input[i]);
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(ary[0]);
		for(int i =1;i<ary.length;i++) {
			if(stack.peek() <= ary[i]) {
				while(!stack.isEmpty() && stack.peek() <= ary[i]) {
					stack.pop();
					System.out.print(ary[i] + " ");
				}
			}
			stack.push(ary[i]);
		}
		while(!stack.isEmpty()) {
			stack.pop();
			System.out.println(-1 + " ");
		}
		
	}
}
