import java.io.*;
import java.util.Arrays;
public class SumArray {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[] A = new int[N+M];

		
		input = br.readLine().split(" ");
		for(int i =0;i<N;i++) {
			A[i] = Integer.parseInt(input[i]);
		}
		
		input = br.readLine().split(" ");
		for(int i =0;i<M;i++) {
			A[i+N] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(A);
		for(int i =0;i<N+M;i++) {
			bw.write(Integer.toString(A[i]) + " ");
		}
		bw.close();
		
		
		
	}
}
