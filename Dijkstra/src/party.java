import java.io.*;
import java.util.*;
public class party {
	
	//road 클래스 선언
	static class road implements Comparable<road> {
		int dest,time;
		public road(int dest,int time) {
			this.dest =dest;
			this.time = time;
		}
		@Override
		public int compareTo(road r2) {
			return this.time - r2.time;
		}
	}
	
	//정적 변수 선언
	static List<road> adjust[];
	static boolean check[];
	static int time_sum[];
	
	public static void main(String args[]) throws IOException {
		// 입력 및 변수 초기화
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int X = Integer.parseInt(input[2]);
		
		adjust = new ArrayList[N+1];
		check = new boolean[N+1];
		time_sum = new int[N+1];
		
		for(int i =1;i<=N;i++) {
			adjust[i] = new ArrayList<road>();
			time_sum[i] = Integer.MAX_VALUE;
		}
		
		for(int i =0;i<M;i++) {
			input = br.readLine().split(" ");
			int st = Integer.parseInt(input[0]);
			int ed=Integer.parseInt(input[1]);
			int ti = Integer.parseInt(input[2]);
			adjust[st].add(new road(ed,ti));
		}
		int result = 0;
		for(int i=1;i<=N;i++) {
			//파티가 열리는 마을에있는 학생은 PASS
			if(i==X) { 
				continue;
			} else {
				int current_value = 0;
				//가는길
				current_value += dijk(i,X);
				reset();
				//오는길
				current_value += dijk(X,i);
				reset();
				result = Math.max(current_value,result);
				
			}
		}
		System.out.println(result);
		
	}
	
	/* 다익스트라 알고리즘
	   각 마을에서 다른 마을까지의 최단거리를 구함 */
	static int dijk(int start,int end) {
		PriorityQueue<road> q = new PriorityQueue<road>();
		time_sum[start] = 0;
		q.add(new road(start,0));
		while(!q.isEmpty()) {
			road r = q.poll();
			if(r.dest == end) {return time_sum[end];}
			//방문 여부 체크
			if(check[r.dest]) {
				continue;
			} else {
				check[r.dest] = true;
				for(road next : adjust[r.dest]) {
					if(time_sum[next.dest] > time_sum[r.dest] + next.time) {
						time_sum[next.dest] = time_sum[r.dest] + next.time;
						q.add(new road(next.dest,time_sum[next.dest]));
					}
				}
			}
		}
		return -1;
	}
	
	// 배열 초기화 메소드
	static void reset() {
		for(int i =1;i<=adjust.length-1;i++) {
			check[i] = false;
			time_sum[i] = Integer.MAX_VALUE;
		}
	}
}
