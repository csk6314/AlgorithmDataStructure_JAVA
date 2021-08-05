import java.io.*;

public class NumberSort {
	static int[] temp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] ary1 = new int[N];
		temp = new int[N];
		for(int i =0;i<ary1.length;i++) {
			ary1[i] = Integer.parseInt(br.readLine());
		}
		divide(ary1,0,ary1.length-1);
		for(int i =0;i<ary1.length;i++) {
			sb.append(Integer.toString(ary1[i]) + "\n");
		}
		bw.write(sb.toString());
		bw.close();
	}
	static void divide(int[] ary,int start,int end) {
		if ( start < end) {
			int mid = (start+end)/2;
			divide(ary,start,mid);
			divide(ary,mid+1,end);
			merge(ary,start,mid,end);
			
		}
	}
	static void merge(int[] ary,int start,int mid,int end) {
		int i = start;
		int j = mid+1;
		int temp_index = i;
		
		while(i<=mid&&j<=end) {
			if(ary[i] < ary[j]) {
				temp[temp_index++] = ary[i++];
			} else {
				temp[temp_index++] = ary[j++];
			}
		}
		
		while(i<=mid) {
			temp[temp_index++] = ary[i++];
		}
		while(j<=end) {
			temp[temp_index++] = ary[j++];
		}
		
		for(int idx = start;idx<temp_index;idx++) {
			ary[idx] = temp[idx];
		}
	}
}
