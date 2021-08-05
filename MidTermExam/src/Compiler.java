import java.util.*;
import java.io.*;

public class Compiler {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> st = new Stack<Character>();
		String line;
		boolean isTrue = true;
		while ((line = br.readLine()) != null && isTrue) {
			char[] ch = line.toCharArray();

			for (int i = 0; i < ch.length; i++) {
				
				if (ch[i] == '\"') {
					if (!st.isEmpty()&&st.peek() == '\"') {
						st.pop();
					} else if(st.isEmpty()) {
						st.push(ch[i]);
					}else {
						st.push(ch[i]);
					}
				} else if (ch[i] == '\'') {
					if (!st.isEmpty()&&st.peek() == '\'') {
						st.pop();
					} else if(st.isEmpty()) {
						st.push(ch[i]);
					}else {
						st.push(ch[i]);
					}
				} else if (ch[i] == '(') {
					if (!st.isEmpty()&&st.peek() != '\"' && st.peek() != '\'') {
						st.push(ch[i]);
					} else if(st.isEmpty()) {
						st.push(ch[i]);
					}
				} else if (ch[i] == ')') {
					if(!st.isEmpty()&&st.peek() != '\"' && st.peek() !='\'') {
						if(st.peek() == '(') {
							st.pop();
						}  else {
							isTrue = false;
						}
					}else if(st.isEmpty()) {
						isTrue = false;
					}
				}else if (ch[i] == '{') {
					if (!st.isEmpty()&&st.peek() != '\"' && st.peek() != '\'') {
						st.push(ch[i]);
					} else if(st.isEmpty()) {
						st.push(ch[i]);
					}
				} else if (ch[i] == '}') {
					if(!st.isEmpty()&&st.peek() != '\"' && st.peek() !='\'') {
						if(st.peek() == '{') {
							st.pop();
						}  else {
							isTrue = false;
						}
					}else if(st.isEmpty()) {
						isTrue = false;
					}
				} else if (ch[i] == '[') {
					if (!st.isEmpty()&&st.peek() != '\"' && st.peek() != '\'') {
						st.push(ch[i]);
					} else if(st.isEmpty()) {
						st.push(ch[i]);
					}
				} else if (ch[i] == ']') {
					if(!st.isEmpty()&&st.peek() != '\"' && st.peek() !='\'') {
						if(st.peek() == '[') {
							st.pop();
						}  else {
							isTrue = false;
						}
					}else if(st.isEmpty()) {
						isTrue = false;
					}
				}
			} 
			
		}
		if(!st.isEmpty() && st.peek()!='\'' &&st.peek()!='\"') {
			isTrue = false;
		}
		
		if(isTrue) {
			System.out.println("No Error");
		} else {
			System.out.println("Compile Error");
		}
	}
}
