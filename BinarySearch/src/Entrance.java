import java.io.*;
import java.util.*;

public class Entrance {
	public static void main(String args[]) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[] ary =new int[N];
		for(int i =0;i<N;i++) {
			ary[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(ary);

		long left=0;
		long right = ary[ary.length-1] * M;
		long mid=0;
		long canpass = 0;
		long result=0;
		while(left<=right) {
			mid = (left+right)/2;
			canpass = 0;
			for(int i=0;i<ary.length;i++) {
				canpass += mid/ary[i];
			}
			if(canpass >= M) {
				
				right = mid-1;
			} else {
				left = mid +1;
			}
		}
		System.out.println(left);
	}
}
