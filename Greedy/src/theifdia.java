import java.io.*;
import java.util.*;
public class theifdia {
	static class dia implements Comparable<dia>{
		int w, price;
		public dia(int w,int price) {
			this.w = w;
			this.price = price;
		}
		@Override
		public int compareTo(dia d) {
			return this.w-d.w;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ip[] = br.readLine().split(" ");
		PriorityQueue<dia> q = new PriorityQueue<>();
		int N = Integer.parseInt(ip[0]);
		int K = Integer.parseInt(ip[1]);
		int bags[] = new int[K];
		for(int i =0;i<N;i++) {
			ip = br.readLine().split(" ");
			q.offer(new dia(Integer.parseInt(ip[0]),Integer.parseInt(ip[1])));
		}
		for(int i=0;i<K;i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bags);
		
		long res=0;
		PriorityQueue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<K;i++) {
			while(!q.isEmpty()) {
				dia d = q.poll();
				if(bags[i] >= d.w) {
					q2.offer(d.price);
				} else {
					q.offer(d);
					break;
				}
			}
			if(!q2.isEmpty()) {
				res+=q2.poll();
			}
		}
	System.out.println(res);
	}
}
