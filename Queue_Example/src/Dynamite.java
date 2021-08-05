import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Dynamite {
	static int N;
	static int M;
	static int[][] b_print;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][] visited;


	static class Cell {
		int x;
		int y;
		int sec;

		public Cell(int x, int y, int sec) {
			this.x = x;
			this.y = y;
			this.sec = sec;

		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		b_print= new int[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				b_print[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = false;
			}
		}

		bfs();

	}

	static void bfs() {
		Queue<Cell> q = new LinkedList<Cell>();
		int sec = 0;

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (b_print[i][j] == 0) {
					q.offer(new Cell(i, j, sec));
					visited[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			Cell c = q.poll();
			sec = c.sec;
			if (b_print[c.x][c.y] > 0) {
				q.offer(new Cell(c.x, c.y, sec + 1));
				b_print[c.x][c.y] -= 1;
			} else {
				for (int i = 0; i < 4; i++) {
					int nx = c.x + dx[i];
					int ny = c.y + dy[i];
					if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
						if (b_print[nx][ny] > 0 && !visited[nx][ny]) {	

							q.offer(new Cell(nx, ny, sec + 1));
							visited[nx][ny] = true;
							b_print[nx][ny] -= 1;
						}
					}
				}

			}
		}
		if (check()) {
			System.out.println(sec);
		} else {
			System.out.println(-1);
		}
	}

	static boolean check() {
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {

				if (b_print[i][j] >0) {

					return false;
				}
			}
		}
		return true;
	}
}
