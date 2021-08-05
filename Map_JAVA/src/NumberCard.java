import java.io.*;
import java.util.*;

public class NumberCard {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
		String[] input = br.readLine().split(" ");
		if (input.length == n) {
			for (int i = 0; i < input.length; i++) {
				int num = Integer.parseInt(input[i]);
				Integer freq = m.get(num);
				m.put(num, (freq == null) ? 1 : freq + 1);
			}
		}
		int n2 = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");
		if (input.length == n2) {
			for (int i = 0; i < input.length; i++) {
				if (m.get(Integer.parseInt(input[i])) != null) {
					sb.append(m.get(Integer.parseInt(input[i]))+ " ");
				} else {
					sb.append(0 + " ");
				}
			}
		}
		System.out.println(sb.toString());
	}
}
