import java.util.*;
import java.io.*;
public class cantseehear {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		TreeSet<String> s1 = new TreeSet<String>();
		TreeSet<String> s2 = new TreeSet<String>();
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			s1.add(str);
		}
		for(int i=0;i<m;i++) {
			String str = br.readLine();
			s2.add(str);
		}
		
		s1.retainAll(s2);
		
		System.out.println(s1.size());
		for(String s:s1) {
			System.out.println(s);
		}
	}
}
