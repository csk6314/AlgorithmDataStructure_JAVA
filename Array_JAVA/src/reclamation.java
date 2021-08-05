import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class reclamation {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a_Range = Integer.parseInt(br.readLine());
		if (a_Range < 1 && a_Range > 10000000)
			System.exit(0);
		int[] a = new int[a_Range];
		long[] b = new long[a_Range];

		int n = Integer.parseInt(br.readLine());
		if (n < 1 && n > 10000000)
			System.exit(0);
		for (int i = 0; i < n; i++) {
			String[] str = (br.readLine()).split(" ");
			a[Integer.parseInt(str[0]) - 1] += Integer.parseInt(str[2]);
			if (Integer.parseInt(str[1]) != a_Range)
				a[Integer.parseInt(str[1])] -= Integer.parseInt(str[2]);
		}
		long c = 0;

		for (int i = 0; i < b.length; i++) {
			c += a[i];
			b[i] = c;

		}
		br.close();

		System.out.println(highest(b));

	}

	public static long highest(long[] ary) {
		long tmp = ary[0];
		for (int i = 1; i < ary.length; i++) {
			if (tmp < ary[i]) {
				tmp = ary[i];
			}

		}
		return tmp;
	}

}
