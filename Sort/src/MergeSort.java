import java.util.Arrays;

public class MergeSort {
	static int[] temp = new int[8];
	public static void main(String[] args) {
		int[] ary1 = { 9 , 5 , 2 , 4 , 3 ,6 ,8 , 7};
		divide(ary1,0,ary1.length-1);
		for(int i =0;i<ary1.length;i++) {
			System.out.println(ary1[i]);
		}
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
