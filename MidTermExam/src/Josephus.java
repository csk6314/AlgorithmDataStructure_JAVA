import java.util.*;
import java.io.*;
public class Josephus {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int num = Integer.parseInt(input[0]);
		int start = Integer.parseInt(input[1]);
		
		Queue<Integer> q = new LinkedList<Integer>();
		int[] result = new int[num];
		
		for(int i =1;i<=num;i++) {
			q.offer(i);
		}
		int cnt = 0;
		while(!q.isEmpty()) {
			for(int i =0;i<start-1;i++) {
				q.add(q.poll());
			}
			result[cnt] = q.poll();
			cnt++;
		}
		System.out.print("<");
		for(int i=0;i<num;i++) {
			if(i==num-1) {System.out.print(result[i] + ">");}
			else {
			System.out.print(result[i] + ", ");
			}
		}

 	}
}
