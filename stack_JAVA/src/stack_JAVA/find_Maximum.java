package stack_JAVA;

import java.io.*;
import java.util.Stack;

public class find_Maximum {
	static class a {
		int index;
		int value;

		public a(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<a> stack = new Stack<a>();
		Stack<Integer> stack2 = new Stack<Integer>();
		int cnt = Integer.parseInt(br.readLine());
		int push = 1;
		for (int i = 0; i < cnt; i++) {
			String[] input = br.readLine().split(" ");
			if (input[0].equals("Push")) {
				if(!stack.isEmpty() && stack.peek().value <= Integer.parseInt(input[1])) {
				stack.push(new a(push++, Integer.parseInt(input[1])));
				} else if(stack.isEmpty()) {
					stack.push(new a(push++,Integer.parseInt(input[1])));
				} else {
					push++;
				}
				stack2.push(Integer.parseInt(input[1]));
				

			} else if (input[0].equals("Pop")) {
				if(stack2.peek() ==stack.peek().value) {
					System.out.println(stack.peek().index + " " + stack.peek().value);
					stack.pop();
					stack2.pop();
				}
				else {
				System.out.println(stack.peek().index + " " + stack.peek().value);
				stack2.pop();
				}
			}

		}
	}

}
