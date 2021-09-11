import java.io.*;
import java.util.*;

public class Fibonacci {
	static HashMap<Integer, nums> map = new HashMap<>();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int b = Integer.parseInt(br.readLine());
			
			nums ns_result = fibo(b);
			System.out.println(ns_result.n_zero + " " + ns_result.n_one);
		}
	}

	static nums fibo(int n) {
		if(n==0) {
			return new nums(1,0);
		} else if(n==1) {
			return new nums(0,1);
		} else if(map.get(n) !=null) {
			return map.get(n);
		} else {
			nums ns1 = fibo(n-1);
			nums ns2 = fibo(n-2);
			nums ns_res = new nums(ns1.n_zero+ns2.n_zero,ns1.n_one+ns2.n_one);
			map.put(n, ns_res);
			return ns_res;
		}
	}

	static class nums {
		int n_zero, n_one;

		public nums(int n_zero, int n_one) {
			this.n_one = n_one;
			this.n_zero = n_zero;
		}
	}
}
