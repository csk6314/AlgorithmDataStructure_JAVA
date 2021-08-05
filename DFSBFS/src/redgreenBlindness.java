import java.io.*;

public class redgreenBlindness {
	static char grid[][];
	static char grid_b[][];
	static boolean v[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static boolean flag = false;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		grid = new char[N + 1][N + 1];
		grid_b = new char[N + 1][N + 1];
		v = new boolean[N + 1][N + 1];
		reset();
		for (int i = 1; i < N + 1; i++) {
			String s = br.readLine();
			for (int j = 1; j < N + 1; j++) {
				char c = s.charAt(j-1);
				grid[i][j] = c;
				if (c == 'G') {
					c = 'R';
				}
				grid_b[i][j] = c;
			}
		}
		int cnt = 0;
		for(int i=1;i<N+1;i++) {
			for(int j =1;j<N+1;j++) {
				char color = grid[i][j];
				if(v[i][j]==false) {
					cnt++;
					dfs(j,i,color);
				}
			}
		}
		System.out.print(cnt + " ");
		cnt = 0;
		reset();
		flag = true;
		for(int i=1;i<N+1;i++) {
			for(int j =1;j<N+1;j++) {
				char color = grid_b[i][j];
				if(v[i][j]==false) {
					cnt++;
					dfs(j,i,color);
				}
				
			}
		}
		System.out.print(cnt);

	}

	static int dfs(int x, int y,char color) {
		int N = v.length;
		if (v[y][x] == true) {
			return 0;
		} else {
			v[y][x] = true;
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx >=1 && nx<N && ny>=1 && ny<N) {
					if(!flag) {
						if(grid[ny][nx] == color&& v[ny][nx] == false) {
							dfs(nx,ny,color);
						}
					} else {
						if(grid_b[ny][nx] == color&& v[ny][nx] == false) {
							dfs(nx,ny,color);
						}
					}
				}
				
			}
			return 1;
		}
	}

	static void reset() {
		int N = v.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				v[i][j] = false;
			}
		}
	}

}
