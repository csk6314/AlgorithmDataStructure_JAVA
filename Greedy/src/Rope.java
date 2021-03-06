import java.io.*;
import java.util.*;
public class Rope {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ropes[] = new int[N];
		for(int i=0;i<N;i++) {
			ropes[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(ropes);
		int result = 0;
		for(int i =0;i<N;i++) {
			result = Math.max(result, ropes[i]*(N-i));
		}
		System.out.println(result);
	}
}
