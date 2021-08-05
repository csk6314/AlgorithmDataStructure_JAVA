import java.io.*;
import java.util.*;
public class LeastDistance {
	static class edge implements Comparable<edge> {
		int index,weight;
		public edge(int index, int weight) {
			this.index=index;
			this.weight=weight;
		}
		@Override
		public int compareTo(edge e) {
			return -(e.weight-this.weight);
		}
	}
	static int V;
	static List<edge>[] adj;
	static boolean checked[];
	static int dist[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		V=Integer.parseInt(input[0]);
		int E = Integer.parseInt(input[1]);
		int K =Integer.parseInt(br.readLine());
		adj = new ArrayList[V+1];
		checked = new boolean[V+1];
		dist = new int[V+1];
		for(int i =1;i<V+1;i++) {
			adj[i] = new ArrayList<edge>();
		}
		for(int i =0;i<E;i++) {
			String i_e[] = br.readLine().split(" ");
			int u = Integer.parseInt(i_e[0]);
			int v = Integer.parseInt(i_e[1]);
			int w = Integer.parseInt(i_e[2]);
			adj[u].add(new edge(v,w));
		}
		for(int i =1;i<=V;i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dijk(K);
		for(int i =1;i<=V;i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
		
	}
	static void dijk(int k) {
		PriorityQueue<edge> q = new PriorityQueue<edge>();
		dist[k] = 0;
		q.add(new edge(k,0));
		while(!q.isEmpty()) {
			edge e = q.poll();
			int idx = e.index;
			int wt= e.weight;
			if(checked[idx]) {
				continue;
			} else {
				checked[idx] = true;
				for(edge e2: adj[idx]) {
					if(dist[e2.index] > e2.weight + dist[idx]) {
						dist[e2.index] = e2.weight + dist[idx];
						q.add(new edge(e2.index,dist[e2.index]));
					}
				}
			}
		}
	}
}
