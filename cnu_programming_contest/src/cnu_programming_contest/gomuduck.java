package cnu_programming_contest;
import java.util.*;
import java.io.*;
public class gomuduck {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		Stack<Integer> stack = new Stack<>();
		if(s.equals("고무오리 디버깅 시작")) {
			String ip = new String();
			while(!ip.equals("고무오리 디버깅 끝")) {
				ip=br.readLine();
				if(ip.equals("문제")) {
					stack.push(1);
				} else if(ip.equals("고무오리")) {
					if(!stack.isEmpty()) {
					stack.pop();
					} else {
						stack.push(1);
						stack.push(1);
					}
				}
			}
			if(stack.isEmpty()) {
				System.out.println("고무오리야 사랑해");
			} else {
				System.out.println("힝구");
			}
		}
	}

}
