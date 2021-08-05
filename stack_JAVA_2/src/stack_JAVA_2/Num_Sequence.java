package stack_JAVA_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Num_Sequence {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> st1 = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int max =0;
		boolean isCan = true;
		for(int i =max+1;i<=n;i++) {
			int value = Integer.parseInt(br.readLine());
			
			if (value > max) {
				for(int j = max+1;j<=value;j++) {
					st1.push(j);
					sb.append("+\n");
				}
				max = value;
			} else if (value != st1.peek()) {
				isCan = false;
				break;
			}
			st1.pop();
			sb.append("-\n");
			
			
		}
		if ( isCan) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
	}
}
