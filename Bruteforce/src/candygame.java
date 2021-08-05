import java.io.*;

public class candygame {
	static char map[][];

	static void swap(int i, int j, int d) {
		if (d == 0) {
			char tmp = map[i][j];
			map[i][j] = map[i][j + 1];
			map[i][j + 1] = tmp;
		} else {
			char tmp = map[i][j];
			map[i][j] = map[i + 1][j];
			map[i + 1][j] = tmp;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		int cnt = 1;
		int maxcnt = 0;
		for (int i = 0; i < N; i++) {
			cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (map[i][j]==map[i][j + 1]) {
					cnt++;
					maxcnt = Math.max(cnt, maxcnt);

				} else {
					cnt=1;
				}
			}
			
		}
		for (int i = 0; i < N; i++) {
			cnt = 1;
			for (int j = 0; j < N - 1; j++) {
				if (map[j][i]==map[j + 1][i]) {
					cnt++;
					maxcnt = Math.max(cnt, maxcnt);

				}else {
					cnt=1;
				}
			}

		}

		//½º¿Ò
		for (int k = 0; k < N; k++) {
			for (int l = 0; l < N - 1; l++) {
				swap(k,l,0);
				for (int i = 0; i < N; i++) {
					cnt = 1;
					for (int j = 0; j < N-1; j++) {
						if (map[i][j]==map[i][j + 1]) {
							cnt++;
							maxcnt = Math.max(cnt, maxcnt);

						}else {
							cnt=1;
						}
					}
				}
				swap(k,l,0);
			}
		}
		for (int k = 0; k < N; k++) {
			for (int l = 0; l < N - 1; l++) {
				swap(k,l,0);
				for (int i = 0; i < N; i++) {
					cnt = 1;
					for (int j = 0; j < N-1; j++) {
						if (map[j][i]==map[j + 1][i]) {
							cnt++;
							maxcnt = Math.max(cnt, maxcnt);

						}else {
							cnt=1;
						}
					}
				}
				swap(k,l,0);
			}
		}
		for (int k = 0; k < N - 1; k++) {
			for (int l = 0; l < N; l++) {
				swap(k,l,1);
				for (int i = 0; i < N; i++) {
					cnt = 1;
					for (int j = 0; j < N-1; j++) {
						if (map[i][j]==map[i][j + 1]) {
							cnt++;
							maxcnt = Math.max(cnt, maxcnt);

						}else {
							cnt=1;
						}
					}
				}
				swap(k,l,1);
			}
		}
		for (int k = 0; k < N - 1; k++) {
			for (int l = 0; l < N; l++) {
				swap(k,l,1);
				for (int i = 0; i < N; i++) {
					cnt = 1;
					for (int j = 0; j < N-1; j++) {
						if (map[j][i]==map[j + 1][i]) {
							cnt++;
							maxcnt = Math.max(cnt, maxcnt);

						}else {
							cnt=1;
						}
					}
				}
				swap(k,l,1);
			}
		}
		System.out.println(maxcnt);
	}
}
