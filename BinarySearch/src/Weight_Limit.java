import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
class bridge {
	int next,weight;
	public bridge(int next,int weight) {
		this.next =next;
		this.weight = weight;
	}
}
public class Weight_Limit {
	static boolean[] visited;
	static LinkedList<bridge>[] blist;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int i_num = Integer.parseInt(input[0]);
		int b_num = Integer.parseInt(input[1]);
		int w_max = 0;
		blist = new LinkedList[i_num];
		visited = new boolean[i_num];
		for(int i =0;i<blist.length;i++) {
			blist[i] = new LinkedList<bridge>();
		}
		for(int i =0;i<b_num;i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			w_max = (w>w_max) ? w : w_max;
			blist[a-1].add(new bridge(b,w));
			blist[b-1].add(new bridge(a,w));
		}
		
		input = br.readLine().split(" ");
		int a_f = Integer.parseInt(input[0]);
		int b_f = Integer.parseInt(input[1]);
		
		System.out.println(binarySearch(a_f,b_f,w_max));
		
	}
	
	static int binarySearch(int start,int end,int max) {
		int left = 1;
		int right = max;
		int mid = 0;
		int result = 0;
		while(left<= right) {
			mid = (left+right)/2;
			if(cango(start,end,mid)) {
				result = (mid>result) ? mid : result;
				left = mid + 1;
			} else {
				right = mid-1;
			}
		}
		return result;
		
	}
	
	static boolean cango(int start,int end,int mid) {
		Queue<Integer> q = new LinkedList<>();
		for(int i =0;i<visited.length;i++) {
			visited[i] = false;
		}
		q.offer(start);
		visited[start-1] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == end) {
				return true;
			}
			
			Iterator<bridge> iter = blist[now-1].iterator();
			while(iter.hasNext()) {
				bridge value = iter.next();
				if(!visited[value.next-1] && value.weight >= mid) {
					q.offer(value.next);
					visited[value.next-1] = true;
				}
			}
		}
		return false;
		
	}

}
