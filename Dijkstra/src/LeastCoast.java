import java.io.*;
import java.util.*;

public class LeastCoast {

	static class city implements Comparable<city> {
		int index, cost;

		public city(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(city c2) {
			return this.cost - c2.cost;
		}
	}

	static List<city> adjust[];
	static int costs[];
	static boolean checked[];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// input section
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		adjust = new ArrayList[N + 1];
		checked = new boolean[N + 1];
		costs = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			adjust[i] = new ArrayList<city>();
			costs[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < M; i++) {
			String input[] = br.readLine().split(" ");
			int s_ct = Integer.parseInt(input[0]);
			int d_ct = Integer.parseInt(input[1]);
			int c_ct = Integer.parseInt(input[2]);
			adjust[s_ct].add(new city(d_ct, c_ct));
		}
		String input[] = br.readLine().split(" ");
		int start = Integer.parseInt(input[0]);
		int end = Integer.parseInt(input[1]);

		dijkstra(start, end);
		System.out.println(costs[end]);
	}

	static void dijkstra(int st, int ed) {
		PriorityQueue<city> q = new PriorityQueue<city>();
		costs[st] = 0;
		q.add(new city(st, 0));
		while (!q.isEmpty()) {
			city c = q.poll();
			if (c.index == ed)
				break;
			if (checked[c.index]) {
				continue;
			} else {
				checked[c.index] = true;
				for (city d_c : adjust[c.index]) {
					if (costs[d_c.index] > costs[c.index] + d_c.cost) {
						costs[d_c.index] = costs[c.index] + d_c.cost;
						q.add(new city(d_c.index, costs[d_c.index]));
					}
				}
			}
		}

	}
}
