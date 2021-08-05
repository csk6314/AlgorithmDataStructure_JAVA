import java.io.*;
import java.util.*;


public class Maze {
	static int map[][];
	static boolean v[][];
	static int dx[] = { 1, -1, 0, 0, };
	static int dy[] = { 0, 0, 1, -1 };

	static class grid {
		int x, y;
		int cnt;

		public grid(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		map = new int[N + 1][M + 1];
		v = new boolean[N + 1][M + 1];
		for (int i = 1; i < N + 1; i++) {
			String s = br.readLine();
			for (int j = 1; j < M + 1; j++) {
				int n = s.charAt(j - 1) - '0';
				map[i][j] = n;
				v[i][j] = false;
			}
		}
		bfs();

	}

	static void bfs() {
		int N = map.length;
		int M = map[0].length;
		int result = Integer.MAX_VALUE;
		Queue<grid> q = new LinkedList<>();
		v[1][1] = true;
		q.add(new grid(1, 1, 1));
		while (!q.isEmpty()) {
			grid g = q.poll();
			if (g.x == M-1 && g.y == N-1) {
				result = Math.min(result, g.cnt);
			} else {
				for (int i = 0; i < 4; i++) {
					int nx = g.x + dx[i];
					int ny = g.y + dy[i];
					if (nx >= 1 && nx < M && ny >= 1 && ny < N) {
						if (v[ny][nx] == false && map[ny][nx] == 1) {
							q.offer(new grid(nx, ny, g.cnt + 1));
							v[ny][nx] = true;
						}
					}
				}
			}
		}
		System.out.println(result);

	}
}
