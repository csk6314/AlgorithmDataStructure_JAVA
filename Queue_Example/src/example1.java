import java.io.*;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class example1 {
	public static void main(String args[]) throws IOException {
		Queue<Integer> que = new LinkedList<>();
		Stack<Integer> stack = new Stack<Integer>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		if (input[0].equals("Stack")) {
			for (int i = 0; i < Integer.parseInt(input[1]); i++) {
				String[] input2 = br.readLine().split(" ");
				if (Integer.parseInt(input2[0]) == 0) {
					System.out.println(stack.size());
				} else if (Integer.parseInt(input2[0]) == 1) {
					if (!stack.isEmpty()) {
						System.out.println(stack.peek());
					}
				} else if (Integer.parseInt(input2[0]) == 2) {
					if (!stack.isEmpty()) {
						stack.pop();
					}
				} else if (Integer.parseInt(input2[0]) == 3) {
					stack.push(Integer.parseInt(input2[1]));
				}
			}
		} else if (input[0].equals("Queue")) {
			for (int i = 0; i < Integer.parseInt(input[1]); i++) {
				String[] input2 = br.readLine().split(" ");
				if (Integer.parseInt(input2[0]) == 0) {
					System.out.println(que.size());
				} else if (Integer.parseInt(input2[0]) == 1) {
					if(!que.isEmpty()) {
					System.out.println(que.peek());
					}
				} else if (Integer.parseInt(input2[0]) == 2) {
					if(!que.isEmpty()) {
						que.poll();
					}
				} else if (Integer.parseInt(input2[0]) == 3) {
					que.offer(Integer.parseInt(input2[1]));
				}
			}

		}
	}
}
