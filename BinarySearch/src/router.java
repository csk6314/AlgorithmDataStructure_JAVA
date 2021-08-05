import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class router {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int house_num = Integer.parseInt(input[0]);
		int router_num = Integer.parseInt(input[1]);
		if (router_num>house_num) {System.exit(0);}
		int[] house = new int[house_num];
		
		
		for (int i = 0; i < house_num; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house);
		System.out.println(binarySearch(house,router_num));
	}
	
	static long binarySearch(int[] h,int get) {
		long left = 1;
		long right = h[h.length-1]-h[0];
		long mid=0;
		long result = -Integer.MAX_VALUE;
		
		while(left<=right) {
			mid = (left+right)/2;
			
			if(meetRouterNum(h,mid,get)) {
				result = (mid >= result) ? mid : result;
				left = mid+1;
			} else {
				right = mid-1;
			}
 		}
		
		return result;
		
	}
	
	static boolean meetRouterNum(int[] h,long mid,int get)  {
		int cnt = 1;
		long a = h[0] + mid;
		for(int i =1;i<h.length;i++) {
			if (h[i] >= a) {
				cnt++;
				a = h[i] + mid;
			}
		}
		if ( cnt >= get) {
			return true;
		} else {
			return false;
		}
	}	
}
