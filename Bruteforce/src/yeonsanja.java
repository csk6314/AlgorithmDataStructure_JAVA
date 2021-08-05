import java.io.*;

public class yeonsanja {
	static int oper[];
	static int an[];
	static long result = Integer.MIN_VALUE;
	static long result2 = Integer.MAX_VALUE;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input[] = br.readLine().split(" ");
		an = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			an[i] = Integer.parseInt(input[i]);
		}
		input = br.readLine().split(" ");
		oper = new int[4];
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(input[i]);
		}
		dfs(an[0], 1);
		System.out.println(result + "\n" + result2);

	}

	static void dfs(long answer, int depth) {
		if (depth == an.length) {
			result = Math.max(result, answer);
			result2 = Math.min(result2, answer);
			return;
		} else {
			for (int i = 0; i < 4; i++) {
				switch (i) {
				case 0:
					if (oper[i] > 0) {
						oper[i]--;
						dfs(answer + an[depth], depth + 1);
						oper[i]++;
					}
					break;
				case 1:
					if (oper[i] > 0) {
						oper[i]--;
						dfs(answer - an[depth], depth + 1);
						oper[i]++;
					}
					break;
				case 2:
					if (oper[i] > 0) {
						oper[i]--;
						dfs(answer * an[depth], depth + 1);
						oper[i]++;
					}
					break;
				case 3:
					if (oper[i] > 0) {
						oper[i]--;
						dfs(answer / an[depth], depth + 1);
						oper[i]++;
					}
					break;
				default:
					break;
				}
				
			}
		}

	}
}
