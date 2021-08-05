import java.util.*;
import java.io.*;
public class Budget {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] ip = br.readLine().split(" ");
		int[] ary = new int[N];
		for(int i =0;i<N;i++) {
			ary[i] = Integer.parseInt(ip[i]);
		}
		Arrays.sort(ary);
		long all = Integer.parseInt(br.readLine());
		
		binarySearch(ary,all);
	}
	
	static void binarySearch(int[] ary, long all) {
		long left = 0;
		long right = ary[ary.length-1];
		long mid;
		long sum;
		long result = 0;
		while(left <= right) {
			mid = (left+right) / 2;
			sum = 0;
			for(int i =0;i<ary.length;i++) {
				if(ary[i] <mid) {
					sum += ary[i];
				} else {
					sum += mid;
				}
			}
			
			if(sum <= all) {
				
				left = mid +1;
				result = (result < mid) ? mid : result;
			} else {
				right = mid-1;
			}
			
		}
		System.out.println(result);
	}
}
