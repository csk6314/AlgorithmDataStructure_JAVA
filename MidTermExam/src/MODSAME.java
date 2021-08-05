import java.io.*;
public class MODSAME {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] ary = new int[N];
		for(int i =0;i<N;i++) {
			ary[i] = Integer.parseInt(br.readLine());
		}
		
		int 	gap = Math.abs(ary[1]-ary[0]);
		for(int i=1;i<N-1;i++) {
			gap = gcd(gap,Math.abs(ary[i+1]-ary[i]));
		}
		
		for(int i =2;i<=gap;i++) {
			if(gap%i==0) {
				System.out.print(i + " ");
			}
		}
		
	}
	static int gcd(int a,int b) {
		while(b!=0) {
			int r = a%b;
			a=b;
			b=r;
			
		}
		return a;
	}
}
