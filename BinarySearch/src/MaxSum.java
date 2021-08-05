import java.util.*;
import java.io.*;


public class MaxSum {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		int[] ary = new int[N];
		for(int i =0;i<N;i++) {
			ary[i] = Integer.parseInt(input[i]);
		}
		System.out.println(dp(ary));
	}
	
	static int dp(int[] ary) {
		int sum = ary[0];
		int parSum=ary[0];
		for(int i =1;i<ary.length;i++) {
			parSum = Math.max(ary[i],parSum+ary[i]);
			sum = Math.max(sum, parSum);
		}
		return sum;
	}
}
