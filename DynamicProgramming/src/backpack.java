import java.io.*;
import java.util.*;
public class backpack {
	static class thing implements Comparable<thing> {
		int W,V;
		public thing(int W,int V) {
			this.W = W;
			this.V = V;
		}
		@Override
		public int compareTo(thing t) {
			return this.W-t.W;
		}
		
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ip[] = br.readLine().split(" ");
		int N = Integer.parseInt(ip[0]);
		int K = Integer.parseInt(ip[1]);
		thing things[] = new thing[N];
		for(int  i=0;i<N;i++) {
			String ip2[] = br.readLine().split(" ");
			things[i] = new thing(Integer.parseInt(ip2[0]),Integer.parseInt(ip2[1]));
		}
		Arrays.sort(things);
		thing dp[] = new thing[N];
		dp[0] = things[0];
		
		
		
	}
}
