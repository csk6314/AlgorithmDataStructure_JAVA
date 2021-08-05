package stack_JAVA;

import java.io.IOException;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class parVaild {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		
		while(cnt-- > 0) {
			Stack<Character> stack = new Stack<Character>();
			boolean isVPS = true;
			String input = br.readLine();
			
			for(int i =0;i<input.length();i++) {
				char temp = input.charAt(i);
				
				if (temp == '(') {
					stack.push(temp);
				} else if (temp == ')') {
					if(stack.empty()) {
						isVPS = false;
					} else {
						stack.pop();
					}
				}
			}
			if (!stack.empty()) {
				isVPS = false;
			}
			if(isVPS)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}
