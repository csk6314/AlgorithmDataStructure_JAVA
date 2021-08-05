import java.io.*;

public class Coin0 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K =Integer.parseInt(input[1]);
		
		int coins[] = new int[N];
		for(int i =0;i<N;i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		int cnt=0;
		for(int i =N-1;i>=0;i--) {
			if(K<=0) {
				break;
			}
			if(K<coins[i]) {
				continue;
			} else {
				cnt += K/coins[i];
				K -= (K/coins[i])*coins[i];
			}
			
		}
		System.out.println(cnt);
	}
}
