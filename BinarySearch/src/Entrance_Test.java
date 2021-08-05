import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Entrance_Test {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int test_cnt = Integer.parseInt(input[0]);
		long user_cnt = Long.parseLong(input[1]);
		long max_time = 0;
		long[] test_time = new long[test_cnt];
		
		for(int i =0;i<test_cnt;i++) {
			test_time[i] = Integer.parseInt(br.readLine());
		}
		
		
		Arrays.sort(test_time);
		max_time = test_time[test_cnt-1] * user_cnt;
		System.out.println(BinarySearch(test_time,user_cnt,max_time));
		
	}
	
	static long BinarySearch(long[] a,long n,long max) {
		long left = 0;
		long mid = 0;
		long right = max;
		long result = right;
		
		while(left <= right) {
			mid = (left+right) / 2;
			if (canPass(a,n,mid)) {
				right = mid - 1;
				result = (result>mid) ? mid : result;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}
	static boolean canPass(long[] a,long n,long time) {
		long passUser =0;
		for(int i =0;i<a.length;i++) {
			passUser += time / a[i];	
		}
		if(passUser >= n) {
			return true;
		} else {
			return false;
		}
	}
}
