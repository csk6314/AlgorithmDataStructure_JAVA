package stack_JAVA_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Calculation {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String output = convertPostfix(input);
		
		System.out.println(output);
		System.out.println(getResult(output));
		

	}

	public static String convertPostfix(String s) {
		String[] input = s.trim().split(" ");
		Stack<String> stack = new Stack<String>();
		StringBuilder sb = new StringBuilder();
		
		
		for (int i = 0; i < input.length; i++) {
			String ch = input[i];
			int p = priority(ch);

			if (ch.equals("+") || ch.equals("-") || ch.equals("/") || ch.equals("*") || ch.equals("^")
					|| ch.equals("%")) {
				while (!stack.isEmpty() && priority(stack.peek()) >= p) {
					sb.append(stack.pop() + " ");
					
				}
				stack.push(ch);
			} else if (ch.equals("(")) {
				stack.push(ch);
			} else if (ch.equals(")")) {
				while (!stack.isEmpty() && priority(stack.peek()) != priority("(")) {
					sb.append(stack.pop() + " ");
				}
				stack.pop();
			} else {
				sb.append(ch + " ");
			}

		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + " ");
		}

		return sb.toString();

	}

	public static long getResult(String s) {
		String[] input = s.trim().split(" ");
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < input.length; i++) {
			String ch = input[i];
			long a, b,c;
			
			if (ch.equals("^")) {
				b = Long.parseLong(stack.pop());
				a = Long.parseLong(stack.pop());
				c = Math.round(Math.pow(a, b));
				stack.push(Long.toString(c));
			} else if (ch.equals("*")) {
				b = Long.parseLong(stack.pop());
				a = Long.parseLong(stack.pop());
				c = a * b;
				stack.push(Long.toString(c));
			} else if (ch.equals("/")) {
				b = Long.parseLong(stack.pop());
				a = Long.parseLong(stack.pop());
				c = a / b;
				stack.push(Long.toString(c));
			} else if (ch.equals("%")) {
				b = Long.parseLong(stack.pop());
				a = Long.parseLong(stack.pop());
				c = a % b;
				stack.push(Long.toString(c));
			} else if (ch.equals("+")) {
				b = Long.parseLong(stack.pop());
				a = Long.parseLong(stack.pop());
				c = a + b;
				stack.push(Long.toString(c));
			} else if (ch.equals("-")) {
				b = Long.parseLong(stack.pop());
				a = Long.parseLong(stack.pop());
				c = a - b;
				stack.push(Long.toString(c));
			} else {
			stack.push(ch);
			}
		}
		return Long.parseLong(stack.peek());

	}

	public static int priority(String ch) {
		if (ch.equals("^")) {
			return 3;
		} else if (ch.equals("*") || ch.equals("/") || ch.equals("%")) {
			return 2;
		} else if (ch.equals("+") || ch.equals("-")) {

			return 1;
		} else if (ch.equals("(") || ch.equals(")")) {
			return 0;
		} else
			return -1;
	}
}
