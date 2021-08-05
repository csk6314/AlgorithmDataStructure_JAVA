import java.io.*;
import java.util.*;

public class getMinimum {
	static class Num {
		int index;
		int value;
		public Num(int index,int value) {
			this.index = index;
			this.value = value;
		}
		
		public int getIndex() {
			return this.index;
		}
		
		public int getValue() {
			return this.value;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Num> stack = new Stack<Num>();
		int N = Integer.parseInt(br.readLine());
		int push_cnt = 0;
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			if (input[0].equals("Push")) {
				push_cnt++;
				if (stack.isEmpty()) {
					stack.push(new Num(push_cnt,Integer.parseInt(input[1])));
				} else if (!stack.isEmpty()) {
					
					if (Integer.parseInt(input[1]) <= stack.peek().value) {
						
						stack.push(new Num(push_cnt,Integer.parseInt(input[1])));
					} else {
						stack.push(new Num(stack.peek().index,stack.peek().value));
					}
					
				}
				
			} else {
				System.out.println(stack.peek().getIndex() + " " + stack.pop().getValue());
			}
		}
	}
}
