package stack_JAVA_2;

import java.io.*;
import java.util.*;

public class MakeBig {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		String value = br.readLine();
		int idx = N-K;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < value.length(); i++) {
			char ch = value.charAt(i);
			if (stack.isEmpty()) {
				stack.push(ch);
			} else {
				while(!stack.isEmpty() && stack.peek() < ch) {
					if(stack.size()+(N-i-1) <N-K) {
						break;
					}
					stack.pop();
				}
				stack.push(ch);
				
			}
		}
		
	
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stack.size(); i++) {
			sb.append(stack.get(i));
		}
		System.out.println(sb.toString());

	}

}
