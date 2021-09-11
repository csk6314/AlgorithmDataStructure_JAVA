import java.io.*;
import java.util.*;

public class makeone {
	static HashMap<Integer, Integer> map = new HashMap<>();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(getRes(N));
	}

	static int getRes(int n) {
		if (n == 1) {
			return 0;
		} else if (n == 2 || n == 3) {
			return 1;
		} else if (map.getOrDefault(n, 0) != 0) {
			return map.get(n);
		} else {
			int ans = Integer.MAX_VALUE;
			if (n % 2 == 0) {
				ans = Math.min(ans, 1 + getRes(n / 2));
			}
			if (n % 3 == 0) {
				ans = Math.min(ans, 1 + getRes(n / 3));
			}
			if (n > 1) {
				ans = Math.min(ans, 1 + getRes(n - 1));
			}
			map.put(n, ans);
			return ans;
		}
	}
}
