import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NumberCard {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c_num = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] c = new int[c_num];
		for(int i =0;i<c.length;i++) {
			c[i] = Integer.parseInt(input[i]);
		}
		int c2_num = Integer.parseInt(br.readLine());
		int[] c2 = new int[c2_num];
		input = br.readLine().split(" ");
		for(int i =0;i<c2_num;i++) {
			c2[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(c);
		for(int i =0;i<c2_num;i++) {
			System.out.print(binarySearch(c,c2[i]) + " ");
		}
		
	}
	
	static int binarySearch(int[] ary, int n) {
		int left = 0;
		int right = ary.length-1;
		int mid = 0;
		
		while(left<=right) {
			mid = (left+right)/2;
			if(ary[mid] > n) {
				right = mid - 1;
			} else if(ary[mid] < n) {
				left = mid+1;
			} else {
				return 1;
			}
		}
		return 0;
	}
}
