package stack_JAVA;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class infix2postfix {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//int cnt = Integer.parseInt(br.readLine());
		
		//while(cnt-->0) {
			String input = br.readLine();
			String output = convertPostfix(input);
			System.out.println(output);
		//}
		
		
	}
	
	public static String convertPostfix(String s) {
		String input = s;
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		
		for(int i =0;i<input.length();i++) {
			Character ch = input.charAt(i);
			int p = priority(ch);
			
			if(ch.equals('+') || ch.equals('-') || ch.equals('/') || ch.equals('*')) {
				while(!stack.isEmpty() && priority(stack.peek()) >= p) {
					sb.append(stack.pop());
				}
				stack.push(ch);
			} else if(ch.equals('(')) {
				stack.push(ch);
			} else if (ch.equals(')')) {
					while(!stack.isEmpty() && priority(stack.peek())!=priority('(')) {
						sb.append(stack.pop());
					}
					stack.pop();
			} else {
				sb.append(ch);
			}
			
			
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		return sb.toString();
		
	}
	public static int priority(Character ch) {
		if (ch.equals('*') || ch.equals('/')) {
			return 2;
		} else if(ch.equals('+') || ch.equals('-')) {
			return 1;
		} else if(ch.equals('(') || ch.equals(')')) {
			return 0;
		} else
			return -1;
	}
}
