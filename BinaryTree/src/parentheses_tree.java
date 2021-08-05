import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class parentheses_tree {
	static int cnt = 0;

	static class par {
		int l, r;
		String s;

		par(int l, int r,String s) {
			this.l = l;
			this.r = r;
			this.s = s;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		pardfs(new par(n, n,""));
		System.out.println(cnt);
	}

	public static void pardfs(par p) {
		
		if (p.r == 0 && p.l == 0) {
			cnt++;
			System.out.println(p.s);
		}
		if (p.r - 1 >= p.l && p.r - 1 >= 0) {
			pardfs(new par(p.l, p.r - 1,p.s + ")"));
		}
		if (p.l - 1 >= 0) {
			pardfs(new par(p.l - 1, p.r,p.s + "("));
		}
	}
}
