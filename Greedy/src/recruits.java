import java.io.*;
import java.util.*;

public class recruits {
	static class emp implements Comparable<emp>{
		int drank,mrank;
		public emp(int drank,int mrank) {
			this.drank =drank;
			this.mrank = mrank;
		}
		@Override
		public int compareTo(emp e) {
			return this.drank-e.drank;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			emp ranks[] = new emp[N];
			for(int j=0;j<N;j++) {
				String ip[] = br.readLine().split(" ");
				int d_rank = Integer.parseInt(ip[0]);
				int m_rank = Integer.parseInt(ip[1]);
				ranks[j] = new emp(d_rank,m_rank);
			}
			Arrays.sort(ranks);
			int canpass = N;
			int maxrank = ranks[0].mrank;
			for(int j=1;j<N;j++) {
				if(ranks[j].mrank > maxrank) {
					canpass--;
				} else {
					maxrank = ranks[j].mrank;
				}
			}
			System.out.println(canpass);
		}
	}
}
