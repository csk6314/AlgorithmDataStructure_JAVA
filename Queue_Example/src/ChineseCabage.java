import java.io.*;
import java.util.*;
public class ChineseCabage {
	static int dx[] = {1,-1,0,0};
	static int dy[] = {0,0,1,-1};
	static int map[][];
	static boolean visited[][];
	static class Cell {
		int x,y;
		public Cell(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String input[] = br.readLine().split(" ");
			int M = Integer.parseInt(input[0]);
			int N = Integer.parseInt(input[1]);
			int K = Integer.parseInt(input[2]);
			map = new int[N][M];
			visited = new boolean[N][M];
			int cnt = 0;
			Queue<Cell> q = new LinkedList<Cell>();
			// reset
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					map[j][k] = 0;
					visited[j][k] = false;
				}
			}
			// put cabbage in map
			for(int j =0;j<K;j++) {
				String input2[] = br.readLine().split(" ");
				int X = Integer.parseInt(input2[0]);
				int Y = Integer.parseInt(input2[1]);
				map[Y][X] = 1;
				
			}
			//find cabbage
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(map[j][k]==1 && visited[j][k] == false) {
						q.add(new Cell(k,j));
						visited[j][k] = true;
						while(!q.isEmpty()) {
							Cell c = q.poll();
							for(int l=0;l<4;l++) {
								int nx = c.x + dx[l];
								int ny = c.y + dy[l];
								if(nx < M && nx >= 0 && ny < N && ny >= 0) {
									if(map[ny][nx] == 1 && visited[ny][nx] == false) {
										q.offer(new Cell(nx,ny));
										visited[ny][nx] = true;
									}
								}
							}
						}
						cnt++;
					}
				}
			}
			//output result
			System.out.println(cnt);
			
			
		}
	}
}
