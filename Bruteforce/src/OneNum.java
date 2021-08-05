import java.io.*;

public class OneNum {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		if (N < 100) {
			System.out.println(N);
		} else if (N >= 100) {
			for (int i = 100; i <= N; i++) {
				int fst = i / 100;
				int tst = (i % 100) / 10;
				int ttst = (i % 100) % 10;
				if ((tst - fst) == (ttst - tst)) {
					sum++;
				}
			}
			System.out.println((99+sum));
		}
	}
}
