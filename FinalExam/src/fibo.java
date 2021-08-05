import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class fibo {
	static BigInteger ary[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ary = new BigInteger[N+1];
		System.out.println(fibo(N));
	}
	static BigInteger fibo(int n) {
		if(ary[n] != null) { 
			return ary[n];
		} 
		if(n==0) {
			ary[n] = BigInteger.ZERO;
			return BigInteger.ZERO;
		} else if(n==1) {
			ary[n] = BigInteger.ONE;
			return BigInteger.ONE;
		} else {
			BigInteger r = fibo(n-1).add(fibo(n-2));
			ary[n] = r;
			return r;
		}
	}
}
