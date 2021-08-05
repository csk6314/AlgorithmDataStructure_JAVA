import java.io.*;
public class Virus {
	static int cnt = 0;
	static boolean visited[];
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int nw[][] = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i =0;i<N+1;i++) {
			visited[i] = false;
		}
		visited[1] = true;
		for(int  i=0;i<M;i++) {
			String input[] = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			nw[start][end] = 1;
			nw[end][start] = 1;
		}
		dfs(nw,1);
		System.out.println(cnt);

	}
	static void dfs(int[][] nw,int s) {
		for(int i =1;i<nw[0].length;i++) {
			if(nw[s][i]==1 && visited[i]==false) {
				cnt++;
				visited[i]=true;
				dfs(nw,i);
			}
		}
	}
}
