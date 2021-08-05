import java.util.*;
import java.io.*;
public class GreenOnion {
	static int max_index=0;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[] g_o = new int[N];
		int min=0;
		for(int i =0;i<N;i++) {
			g_o[i] = Integer.parseInt(br.readLine());
			if(i==0) {
				min = g_o[i];
			} else if(min<g_o[i]) {
				min = g_o[i];
				max_index = i;
				
			}
		}
		
		binarySearch(g_o,M);
	}
	
	static void binarySearch(int[] ary,int get) {
		long left = 1;
		long right = ary[max_index];
		long mid;
		long result=0;
		long cnt = 0;
		while(left<=right) {
			mid = (left+right)/2;
			cnt=0;
			for(int i =0;i<ary.length;i++) {
				cnt += ary[i]/mid;
			}
			if(cnt < get) {
				right = mid -1;
				
			} else {
				result = (result <= mid) ? mid : result;
				left = mid+1;
			
			
			}
		}
		long sum = 0;
		for(int i=0;i<ary.length;i++) {
			sum += ary[i];
		}
		System.out.println(sum-(result*get));
	}

	
}
