import java.util.*;

public class TestBuildHeap {
	public TestBuildHeap() {
		int a[] = {22,33,44,55,66,77,88,99};
		System.out.println(Arrays.toString(a));
		buildHeap(a,0,a.length);
		System.out.println(Arrays.toString(a));
	}
	void buildHeap(int a[], int i , int n) {
		if(i>=n/2) return;
		buildHeap(a,i*2+1,n);
		buildHeap(a,i*2+2,n);
		heapify(a,i,n);
	}
	void heapify(int a[], int i , int n) {
		int ai = a[i];
		System.out.println("Heapify at Node " + i + " a[i] " + ai);
		System.out.println("Before heapify" + Arrays.toString(a));
		while(i < n/2) {
			int j = i*2 + 1;
			if(j+1<n && a[j+1] > a[j]) ++j;
			if(a[j] <= ai) break;
			a[i] = a[j];
			i=j;
		}
		a[i] = ai;
		System.out.println("After Heapify" + Arrays.toString(a));
	}
	
	public static void main(String args[]) {
		new TestBuildHeap();
	}

}
