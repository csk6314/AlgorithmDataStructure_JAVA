package cnu_programming_contest;
import java.util.*;
import java.io.*;
public class gomuduck {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		Stack<Integer> stack = new Stack<>();
		if(s.equals("������ ����� ����")) {
			String ip = new String();
			while(!ip.equals("������ ����� ��")) {
				ip=br.readLine();
				if(ip.equals("����")) {
					stack.push(1);
				} else if(ip.equals("������")) {
					if(!stack.isEmpty()) {
					stack.pop();
					} else {
						stack.push(1);
						stack.push(1);
					}
				}
			}
			if(stack.isEmpty()) {
				System.out.println("�������� �����");
			} else {
				System.out.println("����");
			}
		}
	}

}
