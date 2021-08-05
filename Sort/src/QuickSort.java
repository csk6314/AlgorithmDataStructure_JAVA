
public class QuickSort {
	public static void main(String args[]) {
		int[] num = { 6 , 3 , 9 ,5 ,8,2,4,7,11,12,11};
		quicksort(num,0,num.length-1);
		for(int i =0;i<num.length;i++) {
			System.out.println(num[i]);
		}
	}
	
	static void quicksort(int[] ary,int start,int end) {
		int pivot = ary[(start+end)/2];
		int i = start;
		int j = end;
		
		while(i <= j) {
			while(ary[i] < pivot ) i++;
			while(ary[j] > pivot) j--;
			if(i<=j) {
				int temp = ary[i];
				ary[i] = ary[j];
				ary[j] = temp;
				i++;
				j--;
			} 
		}	
		System.out.println( i + " ," + j);
		if(i<end) {
		quicksort(ary,i,end);
		}
		if(j>start) {
		quicksort(ary,start,j);
		}
		
	}
}
