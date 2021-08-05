import java.util.Random;

public class compareSearch {
	public static void main(String args[]) {
		for(int i=1000;i <=100000;i += 1000) {
			System.out.printf("%d %d %d\n", i, timeLinear(i),timeBinary(i));
		}
	}
	
	static int[] generateTable(int n) {
		int[] a = new int[n];
		
		for(int i=0;i<n;i++) {
			a[i] = i+1;
			
		}
		
		return a;
	}
	static int findSeq(int[] a,int n ) {
		for(int i =0;i<a.length;i++) {
			if(a[i]==n) return 1;
			
		}
		return -1;
	}
	static int findBinary(int[] a, int l,int r,int n) {
		if(l > r) return -1;
		int mid = (l + r) / 2;
		if (n<a[mid]) {
			findBinary(a,l,mid-1,n);
		} else if (n > a[mid]) {
			findBinary(a,mid+1,r,n);
		}
		return mid;
	}
	
	static long timeLinear(int n) {
		Random rn = new Random();
		int[] arr = generateTable(n);
		
		long start = System.nanoTime();
			
		for(int i =0;i<1000;i++) {
			findSeq(arr,rn.nextInt(n)+1);
		}
		long stop = System.nanoTime() - start;
		return stop/1000;
	}
	
	static long timeBinary(int n) {
		Random rn = new Random();
		int[] arr = generateTable(n);
		
		long start = System.nanoTime();
		
		for(int i =0;i<1000;i++) {
			findBinary(arr,0,arr.length-1,rn.nextInt(n)+1);
		}
		
		long stop = System.nanoTime() - start;
		return stop/1000;
	}
	
	
}
