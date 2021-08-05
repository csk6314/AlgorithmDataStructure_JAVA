import java.io.*;
import java.util.Arrays;
public class FindNumber {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] ary1 = new int[N];
		String[] input = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			ary1[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(ary1);
		int M= Integer.parseInt(br.readLine());
		int[] ary2 = new int[M];
		input = br.readLine().split(" ");
		for(int i =0;i<M;i++) {
			ary2[i] = Integer.parseInt(input[i]);
			System.out.println(binarySearch(ary1,ary2[i]));
		}
		
		
		
	}
	
	static int binarySearch(int[] a,int b) {
		int left=0;
		int right =a.length-1;
		int mid;
		while(left<=right) {
			mid = (left+right)/2;
			if(a[mid] > b) {
				right = mid-1;
			} else if(a[mid] <b) {
				left = mid+1;
			} else {
				return 1;
			}
		}
		return 0;
	}
}
