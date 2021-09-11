import java.io.*;
public class RGBstreet {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int R[] = new int[N+1];
		int G[] = new int[N+1];
		int B[] = new int[N+1];
		
		for(int i =1;i<=N;i++) {
			String input[] = br.readLine().split(" ");
			int rv = Integer.parseInt(input[0]);
			int gv = Integer.parseInt(input[1]);
			int bv = Integer.parseInt(input[2]);
			if(i==1) {
				R[i] = rv;
				G[i] = gv;
				B[i] = bv;
			} else {
				R[i] = Math.min(G[i-1],B[i-1])+rv;
				G[i] = Math.min(R[i-1], B[i-1]) + gv;
				B[i] = Math.min(R[i-1],G[i-1]) + bv;
			}
		}
		System.out.println(Math.min(G[N], Math.min(R[N], B[N])));
	}
}
