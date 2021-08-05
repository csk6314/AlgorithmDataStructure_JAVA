import java.io.*;
public class ggulPartTimeJob {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int d1 = Integer.parseInt(input[0]);
		int d2 = Integer.parseInt(input[1]);
		
		long[] ary = new long[d1];
		long sum = 0;
		input = br.readLine().split(" ");
		for(int i=0;i<d1;i++) {
			sum += Integer.parseInt(input[i]);
			ary[i] = sum;
			
		}
		long max=0;
		for(int i =0;i<d1-d2;i++) {
			long t_sum;
			if (i==0) {
				t_sum = ary[d2-1];
			} else {
				t_sum = ary[i+d2-1] - ary[i-1];
			}
			if(t_sum >= max) {
				max = t_sum;
			}
		}
		
		System.out.println(max);
		
	}
}
