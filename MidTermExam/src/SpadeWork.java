import java.io.*;
import java.util.*;

public class SpadeWork {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int[] ary = new int[N];
		int[] ca = new int[N];
		input = br.readLine().split(" ");
		if (input.length != N)
			System.exit(0);
		for (int i = 0; i < N; i++) {
			ary[i] = Integer.parseInt(input[i]);
		}
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c_height = Integer.parseInt(input[2]);

			ca[a - 1] += c_height;
			if (b < N)
				ca[b] -= c_height;

		}
		int ac = 0;
		
		for (int i = 0; i < N; i++) {
			ac+=ca[i];
			ca[i] = ac;
			ary[i] += ca[i];
			System.out.print(ary[i] + " ");
		}
		
	}
}
