import java.util.Arrays;
import java.io.*;

public class MaxHeap {
	static int size = 0;

	static void add(long a[], long x) {
		if (size == 0) {
			a[0] = x;
			size++;
			return;
		}

		size += 1;
		int idx = size - 1;
		int p_idx = (idx - 1) / 2;
		a[idx] = x;
		long tmp = a[idx];
		while (idx > 0 && a[p_idx] < tmp) {
			a[idx] = a[p_idx];
			idx = p_idx;
			p_idx = (idx - 1) / 2;
		}
		a[idx] = tmp;

	}

	static void heapify(long a[], int i, int n) {
		long ai = a[i];
		while (i < n / 2) {
			int j = i * 2 + 1;
			if (j + 1 < n && a[j + 1] > a[j])
				++j;
			if (a[j] <= ai)
				break;
			a[i] = a[j];
			i = j;
		}
		a[i] = ai;

	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long ary[] = new long[N];
		for (int i = 0; i < N; i++) {
			long x = Long.parseLong(br.readLine());
			if (x == 0) {
				if (size == 0) {
					System.out.println(0);
				} else {
					System.out.println(ary[0]);
					ary[0] = ary[--size];
					ary[size] = 0;
					heapify(ary, 0, size);
				}
			} else {
				add(ary, x);
			}

		}
	}

}
