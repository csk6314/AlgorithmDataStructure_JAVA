import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Symmetric_Set {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Integer> s1 = new HashSet<Integer>();
		HashSet<Integer> s2 = new HashSet<Integer>();
		HashSet<Integer> s3 = new HashSet<Integer>();
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		input = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			s1.add(Integer.parseInt(input[i]));
		}
		input = br.readLine().split(" ");
		for(int i=0;i<m;i++) {
			s2.add(Integer.parseInt(input[i]));
		}
		s3 = new HashSet<Integer>(s1);
		s3.removeAll(s2);
		s2.removeAll(s1);
		s3.addAll(s2);
		
		System.out.println(s3.size());
		
	}
}
