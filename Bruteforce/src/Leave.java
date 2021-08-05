import java.io.*;
public class Leave {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int Tnary[] = new int[N+1];
		int Pnary[] = new int[N+1];
		int dp[] = new int[N+2];
		for(int i=1;i<=N;i++) {
			String input[] = br.readLine().split(" ");
			Tnary[i] = Integer.parseInt(input[0]);
			Pnary[i] = Integer.parseInt(input[1]);
			
		}
		int result = 0;
		for(int i=1;i<=N;i++) {
			dp[i] = Math.max(dp[i-1], dp[i]);
			if(i+Tnary[i]<N+2) {
			dp[i+Tnary[i]] =Math.max(dp[i+Tnary[i]], dp[i] + Pnary[i]);
			}
			result = Math.max(dp[i], result);
		}
		result = Math.max(result,dp[N+1]);
		System.out.println(result);
		
	}
}
