package cnu_programming_contest;

import java.io.*;
import java.util.*;

public class Boss {
	static char map[][];
	static boolean visited[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static HashMap<Character, player> pmap = new HashMap<>();

	static class player {
		int dmg;
		boolean dmged;
		Cell c;

		public player(int x, int y) {
			c = new Cell(x, y, 0);
			dmged = false;
		}
	}

	static class Cell {
		int x, y, sec;

		public Cell(int x, int y, int sec) {
			this.x = x;
			this.y = y;
			this.sec = sec;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ip[] = br.readLine().split(" ");
		Queue<player> q = new LinkedList<>();
		int M = Integer.parseInt(ip[0]);
		int N = Integer.parseInt(ip[1]);
		int P = Integer.parseInt(ip[2]);
		map = new char[M][N];
		visited = new boolean[M][N];
		int p_cnt = 0;
		for (int i = 0; i < M; i++) {
			String info = br.readLine();
			for (int j = 0; j < N; j++) {
				char ch = info.charAt(j);
				map[i][j] = ch;
				visited[i][j] = false;
				if (ch >= 'a' && ch <= 'z') {
					pmap.put(ch, new player(j, i));
					q.add(pmap.get(ch));
				}
			}
		}
		for (int i = 0; i < P; i++) {
			ip = br.readLine().split(" ");
			char name = ip[0].charAt(0);
			int dmg = Integer.parseInt(ip[1]);
			pmap.get(name).dmg = dmg;

		}
		int hp = Integer.parseInt(br.readLine());

		while (!q.isEmpty()) {
			player cp = q.poll();
			Cell c = cp.c;
			boolean FLAG = false;
			Queue<Cell> qc = new LinkedList<>();
			qc.add(c);
			visited[c.y][c.x] = true;
			while (!qc.isEmpty()) {
				Cell current_c = qc.poll();
				if (map[current_c.y][current_c.x] == 'B') {
					cp.c.sec = current_c.sec;
					//System.out.println(cp.dmg + " " + cp.c.sec);
					break;
				} else {
					for (int i = 0; i < 4; i++) {
						int nx = current_c.x + dx[i];
						int ny = current_c.y + dy[i];
						if (nx >= 0 && nx < N && ny >= 0 && ny < M) {

							if (map[ny][nx] != 'X' && !visited[ny][nx]) {
								qc.add(new Cell(nx, ny, current_c.sec + 1));
								visited[ny][nx] = true;
							}
						}
					}
				}
			}
			reset();
		}
		int secs = 0;
		int res = 0;
		while (hp > 0) {
			for (Map.Entry<Character, player> entrySet : pmap.entrySet()) {
				player p = entrySet.getValue();
				if (p.c.sec <= secs) {
					if (!p.dmged) {
						res++;
						p.dmged=true;
					}
					hp -= p.dmg;
				}
			}
			secs++;

		}
		System.out.println(res);

	}

	static void reset() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				visited[i][j] = false;
			}
		}
	}

}
