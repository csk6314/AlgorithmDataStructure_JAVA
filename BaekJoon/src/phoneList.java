import java.io.*;
import java.util.*;

public class phoneList {
	static class tree {
		tree child[];
		boolean isEnd;

		public tree(boolean isEnd, tree child[]) {
			this.isEnd = isEnd;
			this.child = child;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			boolean result = true;
			String numbers[] = new String[n];
			for(int j =0;j<n;j++) {
				numbers[j] = br.readLine();
			}
			Arrays.sort(numbers);
			tree root = new tree(false, new tree[10]);
			tree next = root;
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < numbers[j].length(); k++) {
					char ch = numbers[j].charAt(k);
					int chNum = ch - '0';
					if(next.isEnd) {
						result =false;
						break;
					}
					if (next.child[chNum] == null) {
						if (k != numbers[j].length() - 1) {
							next.child[chNum] = new tree(false, new tree[10]);
						} else {
							next.child[chNum] = new tree(true, null);
						}
						next = next.child[chNum];
					} else {
						next = next.child[chNum];
					}
				}
				next= root;
				if(!result) {
					break;
				}
			}

			if (result) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
	}
}
