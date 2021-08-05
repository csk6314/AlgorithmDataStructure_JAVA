import java.io.*;
import java.util.*;

public class hideandseek3 {
	static class place implements Comparable<place> {
		int index,depth;
		public place(int index,int depth) {
			this.index = index;
			this.depth = depth;
		}
		
		@Override
		public int compareTo(place p) {
			return this.depth-p.depth;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N =Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		int check[] = new int[100001];
		PriorityQueue<place> q = new PriorityQueue<place>();
		q.add(new place(N,0));
		int result = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			place current = q.poll();
			if(check[current.index]==1) continue;
			if(current.index==K) {
				result = Math.min(current.depth, result);
				break;
			}
			check[current.index] = 1;
			
			if(current.index * 2 <= 100000 && check[current.index*2] == 0 && current.index<K) {
				q.offer(new place(current.index*2,current.depth));
			}
			if(current.index+1 <= 100000 && check[current.index+1]==0 && current.index<K) {
				q.offer(new place(current.index+1,current.depth+1));
			}
			if(current.index-1 >= 0 && check[current.index-1]==0) {
				q.offer(new place(current.index-1,current.depth+1));
			}
		}
		System.out.println(result);
	}
}
