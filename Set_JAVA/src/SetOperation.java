import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SetOperation {
	public static void main(String args[]) throws IOException {
		Set<Integer> s1 = new HashSet<Integer>();
		Set<Integer> s2 = new HashSet<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < input.length; i++) {
			Integer input_v = Integer.parseInt(input[i]);
			s1.add(input_v);
		}
		input = br.readLine().split(" ");
		for (int i = 0; i < input.length; i++) {
			Integer input_v = Integer.parseInt(input[i]);
			s2.add(input_v);
		}
		Set<Integer> result = s1;
		result.addAll(s2);
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
		result = new HashSet<Integer>(s1);
		result.retainAll(s2);
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
		result = new HashSet<Integer>(s1);
		result.removeAll(s2);
		for (int i : result) {
			System.out.print(i + " ");
		}

	}
}
