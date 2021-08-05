import java.util.*;
import java.io.*;
public class TOP {
	static class top {
		int index;
		int value;
		public top(int index,int value) {
			this.index = index;
			this.value = value;
		}
		
		public int getValue() {
			return this.value;
		}
		public int getIndex() {
			return this.index;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<top> stack = new Stack<top>();
		int[] ary = new int[N];
		String[] input = br.readLine().split(" ");
		for(int i =0;i<N;i++) {
			int v = Integer.parseInt(input[i]);
			if(stack.isEmpty()) {
				stack.push(new top(1,v));
				ary[i] = 0;
				
			} else {
				while(!stack.isEmpty()&&stack.peek().value < v) {
					stack.pop();
				}
				if(stack.isEmpty()) {
					stack.push(new top(i+1,v));
					ary[i] = 0;
				} else {
					if(stack.peek().value == v) {
						ary[i] = stack.peek().index;
						stack.pop();
						stack.push(new top(i+1,v));
						
					} else {
						ary[i] = stack.peek().index;
						stack.push(new top(i+1,v));
						
					}
				}
		
			}
		}
		for(int i =0;i<N;i++) {
			System.out.print(ary[i] + " ");
		}
		
	}
}




