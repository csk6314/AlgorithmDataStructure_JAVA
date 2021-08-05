import java.util.*;
import java.io.*;
public class PrintQue {
	static class num {
		int index,value;
		public num(int index,int value) {
			this.index = index;
			this.value = value;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for(int i =0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			int get = Integer.parseInt(input[1]);
			int siz = Integer.parseInt(input[0]);
			
			input = br.readLine().split(" ");
			Queue<num> q = new LinkedList<num>();
			int max = Integer.parseInt(input[0]);
			q.offer(new num(0,Integer.parseInt(input[0])));
			for(int j=1;j<siz;j++) {
				int v = Integer.parseInt(input[j]);
				q.add(new num(j,v));
			}
			int cnt=0;
			while(!q.isEmpty()) {
				num n = q.poll();
				Iterator it = q.iterator();
				boolean hasMore = false;
				while(it.hasNext() && !hasMore) {
					num n2 = (num) it.next();
					if(n2.value > n.value) {
						hasMore = true;
					}
				}
				if(hasMore) {
					q.add(n);
				} else {
					cnt++;
					if(n.index == get) {
						System.out.println(cnt);
					}
				}
				
				
			}
		}
	}
}
