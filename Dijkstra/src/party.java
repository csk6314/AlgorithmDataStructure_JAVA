import java.io.*;
import java.util.*;
public class party {
	
	//road Ŭ���� ����
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
	
	//���� ���� ����
	static List<road> adjust[];
	static boolean check[];
	static int time_sum[];
	
	public static void main(String args[]) throws IOException {
		// �Է� �� ���� �ʱ�ȭ
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
			//��Ƽ�� ������ �������ִ� �л��� PASS
			if(i==X) { 
				continue;
			} else {
				int current_value = 0;
				//���±�
				current_value += dijk(i,X);
				reset();
				//���±�
				current_value += dijk(X,i);
				reset();
				result = Math.max(current_value,result);
				
			}
		}
		System.out.println(result);
		
	}
	
	/* ���ͽ�Ʈ�� �˰���
	   �� �������� �ٸ� ���������� �ִܰŸ��� ���� */
	static int dijk(int start,int end) {
		PriorityQueue<road> q = new PriorityQueue<road>();
		time_sum[start] = 0;
		q.add(new road(start,0));
		while(!q.isEmpty()) {
			road r = q.poll();
			if(r.dest == end) {return time_sum[end];}
			//�湮 ���� üũ
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
	
	// �迭 �ʱ�ȭ �޼ҵ�
	static void reset() {
		for(int i =1;i<=adjust.length-1;i++) {
			check[i] = false;
			time_sum[i] = Integer.MAX_VALUE;
		}
	}
}
