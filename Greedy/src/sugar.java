import java.io.*;
public class sugar {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int n= 0;
		int res = Integer.MAX_VALUE;
		while(5*n <= N) {
			int remain = N-(5*n);
			int pos = remain%3;
			int thr=0;
			if(pos==0) {
				thr = remain / 3;
				res=Math.min(res, n+thr);
			}
			n++;
		}
		if(res!=Integer.MAX_VALUE) {
		System.out.println(res);
		}
		else {
			System.out.println(-1);
		}
	}
}
