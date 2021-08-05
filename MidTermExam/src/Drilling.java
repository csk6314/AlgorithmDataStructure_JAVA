import java.io.*;

public class Drilling {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		long[] ary = new long[N];
		for(int i = 0;i<M;i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int r_c = Integer.parseInt(input[2]);
			
			ary[a-1] -=r_c;
			if(b<=N-1) {
			ary[b] += r_c;
			}
		}
		long r_c2 = 0;
		for(int i =0;i<N;i++) {
			r_c2 += ary[i];
			ary[i] = r_c2;
		}
		
		long min= 0;
		for(int i =0;i<N;i++) {
			if (ary[i] <= min) {
				min = ary[i];
			}
		}
		
		System.out.println(-min);
		
	}
}
