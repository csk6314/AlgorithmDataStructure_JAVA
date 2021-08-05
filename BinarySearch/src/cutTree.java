import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class cutTree {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int tree_cnt = Integer.parseInt(input[0]);
		int height_get = Integer.parseInt(input[1]);
		int[] tree_height = new int[tree_cnt];
		
		input = br.readLine().split(" ");
		for (int i = 0; i < tree_cnt; i++) {
			tree_height[i] = Integer.parseInt(input[i]);
		}
		
		Arrays.sort(tree_height);
		System.out.println(binarySearch(tree_height,height_get));
	}
	
	static int binarySearch(int[] h,int get) {
		int left = 0;
		int right = h[h.length-1]-1;
		int mid=0;
		int result = -Integer.MAX_VALUE;
		
		while(left<=right) {
			mid = (left+right)/2;
			if(canGetTree(h,mid,get)) {
				result = (mid>=result) ? mid : result;
				left = mid+1;
			} else {
				right = mid-1;
			}
 		}
		
		return result;
		
	}
	
	static boolean canGetTree(int[] h,int mid,int get)  {
		long sum = 0;
		for(int i =0;i<h.length;i++) {
			if(h[i]>mid) {
				sum+=(h[i]-mid);
			}
		}
		if (get<=sum) {
			return true;
		} else {
			return false;
		}
	}
}
