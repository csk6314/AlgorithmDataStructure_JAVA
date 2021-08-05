import java.util.*;
import java.io.*;

public class difference_SET {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<Integer> s1 = new TreeSet<Integer>();
		TreeSet<Integer> s2 = new TreeSet<Integer>();
		TreeSet<Integer> s3 = new TreeSet<Integer>();

		String[] input = br.readLine().split(" ");
		int s1_size = Integer.parseInt(input[0]);
		int s2_size = Integer.parseInt(input[1]);

		input = br.readLine().split(" ");
		if (input.length == s1_size) {
			for (int i = 0; i < input.length; i++) {
				s1.add(Integer.parseInt(input[i]));
			}
		}
		input = br.readLine().split(" ");
		if (input.length == s2_size) {
			for (int i = 0; i < input.length; i++) {
				s2.add(Integer.parseInt(input[i]));
			}
		}

		s3 = new TreeSet<Integer>(s1);
		s3.removeAll(s2);
		System.out.println(s3.size());
		for (int i : s3) {
			System.out.print(i + " ");
		}	
		
	}
}
