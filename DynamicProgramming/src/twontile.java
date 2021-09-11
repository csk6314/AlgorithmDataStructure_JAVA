import java.io.*;

public class twontile {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int dp[] = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		if (a > 2) {
			for (int i = 3; i <= a; i++) {
				int temp = dp[i - 1] + dp[i - 2];
				if (temp > 10007) {
					dp[i] = temp % 10007;
				} else {
					dp[i] = temp;
				}

			}
		}
		System.out.println(dp[a]);
	}
}
