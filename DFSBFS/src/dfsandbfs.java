import java.io.*;
import java.util.*;
public class dfsandbfs {
	static int[][] vertex;
	static boolean[] visited;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int V = Integer.parseInt(input[2]);
		vertex = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i =0;i<M;i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			
			vertex[start][end] = 1;
			vertex[end][start] = 1;
		}
		reset();
		dfs(V);
		reset();
		bfs(V);
		
		
	}
	static void reset() {
		for(int i=0;i<visited.length;i++) {
			visited[i] = false;
		}
	}
	static void dfs(int s) {
		int N = visited.length-1;
		System.out.print(s + " ");
		visited[s] = true;
			for(int j =1;j<=N;j++) {
				if(vertex[s][j] == 1 && visited[j]==false) {
					dfs(j);
				}
			}
		
	}
	static void bfs(int s) {
		int N = visited.length-1;
		Queue<Integer> q = new LinkedList<Integer>();
		visited[s] = true;
		System.out.print("\n" + s + " ");
		q.add(s);
		while(!q.isEmpty()) {
			int c = q.poll();
			for(int i=1;i<=N;i++) {
				if(vertex[c][i]==1 && visited[i]==false) {
					q.offer(i);
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}

}
