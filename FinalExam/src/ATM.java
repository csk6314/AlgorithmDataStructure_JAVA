import java.io.*;
import java.util.Arrays;
public class ATM {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int times[] = new int[N];
		int sums[] = new int[N];
		String input[] = br.readLine().split(" ");
		for(int i =0;i<N;i++) {
			times[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(times);
		int sum = 0;
		for(int i =0;i<N;i++) {
			sum += times[i];
			sums[i] = sum;		}
		int realSum = 0;
		for(int i =0;i<N;i++) {
			realSum+=sums[i];
		}
		System.out.println(realSum);
	}
}
