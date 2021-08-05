import java.io.*;
import java.util.*;
public class SortingGame {
	static class nc {
		StringBuilder seqc;
		int cnt;
		public nc(StringBuilder seqc,int cnt) {
			this.seqc = seqc;
			this.cnt = cnt;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		Queue<nc> q = new LinkedList<nc>();
		String input[] = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		String num_s[] = br.readLine().split(" ");
		StringBuilder seq = new StringBuilder();
		boolean FLAG = false;
		for(int i =0;i<num_s.length;i++) {
			seq.append(num_s[i]);
		}
		Arrays.sort(num_s);
		StringBuilder answer = new StringBuilder();
		for(int i =0;i<num_s.length;i++) {
			answer.append(num_s[i]);
		}

		//bfs
		q.add(new nc(seq,0));
		map.put(seq.toString(), map.getOrDefault(seq, 0)+1);
		while(!q.isEmpty()) {
			nc ncp = q.poll();
			StringBuilder nsb = ncp.seqc;
			if(nsb.toString().equals(answer.toString())) {
				System.out.println(ncp.cnt);
				FLAG=true;
				break;
			}
			for(int i =1;i<=N-K+1;i++) {
				StringBuilder tmp = reverse(nsb,i,K);
				if(map.getOrDefault(tmp.toString(),0)==0) {
					q.add(new nc(tmp,ncp.cnt+1));
					map.put(tmp.toString(), map.getOrDefault(tmp,0)+1);
				}
			}
			
		}
		if(!FLAG) {
			System.out.println(-1);
		}
		
		
	}
	static StringBuilder reverse(StringBuilder seq,int strt,int K) {
		StringBuilder temp = new StringBuilder();
		StringBuilder news= new StringBuilder();
		news.append(seq.toString());
		temp.append(news.substring(strt-1,strt+K-1));
		temp.reverse();
		news.replace(strt-1, strt+K-1, temp.toString());
		return news;
	}
}
