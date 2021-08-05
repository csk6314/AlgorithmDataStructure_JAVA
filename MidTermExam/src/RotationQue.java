import java.io.*;
import java.util.*;

public class RotationQue {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		int[] get = new int[M];
		for(int i =0;i<M;i++) {
			get[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> q = new ArrayDeque<Integer>();
		for(int i =0;i<N;i++) {
			q.offer(i+1);
		}
		int result = 0;
		for(int i =0;i<M;i++) {
			Iterator it = q.iterator();
			int idx = 1;
			while(it.hasNext()) {
				int n = (Integer) it.next();
				if(n == get[i]) {
					break;
				}
				idx++;
			}
			double mid = (double) (q.size()+1) / 2;
			if(idx > mid) {
				while(q.peek() != get[i]) {
					q.addFirst(q.removeLast());
					result++;
				}
				q.poll();
			} else {
				while(q.peek() != get[i]) {
					q.addLast(q.poll());
					result++;
				}
				q.poll();
			}
		}
		
		System.out.println(result);
	}
}
