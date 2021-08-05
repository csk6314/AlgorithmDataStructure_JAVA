import java.io.*;
import java.util.*;
public class chickentTopN {
	static int temp[];
	static int s_end =0;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int czip[] = new int[N];
		temp = new int[N];
		for(int i =0;i<N;i++) {
			czip[i] = Integer.parseInt(input[i]);
		}
		int k= Integer.parseInt(br.readLine());
		for(int i =0;i<=20;i++) {
			if(Math.round(Math.pow(2, i))==k) {
				s_end=i;
				break;
			}
		}
		divide(czip,0,czip.length-1,0);
		for(int i =0;i<czip.length;i++)
			System.out.print(czip[i] + " ");
		
	}
	static void divide(int[] ary,int start,int end,int lv) {
		if(start < end) {
			int mid = (start+end)/2;
			divide(ary,start,mid,lv+1);
			divide(ary,mid+1,end,lv+1);
			if(lv>=s_end) {
			merge(ary,start,mid,end);
			}
		}
	}
	static void merge(int[] ary,int start,int mid,int end) {
		int i = start;
		int j = mid+1;
		int tmp_idx = start;
		while(i<=mid && j<=end) {
			if(ary[i] < ary[j]) {
				temp[tmp_idx++] = ary[i++];
			} else {
				temp[tmp_idx++] = ary[j++];
			}
		}
		while(i<=mid) {
		
			temp[tmp_idx++] = ary[i++];
		}
		while(j<=end) {
			temp[tmp_idx++] = ary[j++];
		}
		for(int n = start;n<=end;n++) {
			ary[n] = temp[n];
		}
	}
}
