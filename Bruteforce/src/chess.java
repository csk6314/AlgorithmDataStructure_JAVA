import java.io.*;

public class chess {
	static char map[][];
	static int N, M;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new char[N][M];
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				result = Math.min(check(j, i), result);
			}
		}
		System.out.println(result);

	}

	static int check(int x, int y) {
		int res = Integer.MAX_VALUE;
		for (int m = 0; m < 2; m++) {
			int cnt = 0;
			char fc;
			if (m == 0) {
				fc = 'B';
			} else {
				fc = 'W';
			}
			for (int i = y; i < y + 8; i++) {
				for (int j = x; j < x + 8; j++) {
					if (map[i][j] != fc) {
						cnt++;
					}
					if (fc == 'B') {
						fc = 'W';
					} else {
						fc = 'B';
					}

				}
				if (fc == 'B') {
					fc = 'W';
				} else {
					fc = 'B';
				}
			}
			res = Math.min(cnt,res);
		}
		return res;

	}
}
