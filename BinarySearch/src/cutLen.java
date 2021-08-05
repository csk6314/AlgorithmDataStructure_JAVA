import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class cutLen {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int len_num = Integer.parseInt(input[0]);
		int need_len = Integer.parseInt(input[1]);
		if (len_num>need_len) {System.exit(0);}
		int[] len_size = new int[len_num];
		
		
		for (int i = 0; i < len_num; i++) {
			len_size[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(len_size);
		System.out.println(binarySearch(len_size,need_len));
	}
	
	static long binarySearch(int[] h,int get) {
		long left = 1;
		long right = h[h.length-1];
		long mid=0;
		long result = -Integer.MAX_VALUE;
		
		while(left<=right) {
			mid = (left+right)/2;
			if(meetNum(h,mid,get)) {
				result = (mid >= result) ? mid : result;
				left = mid+1;
			} else {
				right = mid-1;
			}
 		}
		
		return result;
		
	}
	
	static boolean meetNum(int[] h,long mid,int get)  {
		long sum = 0;
		for(int i =0;i<h.length;i++) {
			sum += h[i]/mid;
		}
		if (sum>=get) {
			return true;
		} else {
			return false;
		}
	}
}
