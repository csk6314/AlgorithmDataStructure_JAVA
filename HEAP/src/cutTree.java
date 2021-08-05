import java.util.*;
import java.io.*;

public class cutTree {
	static int cnt2  =0 ;
	public static void main(String args[]) throws IOException {
		Queue<Integer> q = new LinkedList<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int K = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < input.length; i++) {
			int v = Integer.parseInt(input[i]);
			if (K < v) {
				q.add(v);
			}
		}
		/*int cnt=0;
		while (!q.isEmpty()) {
			int v = q.poll();
			cnt++;
			int big = v * 2 / 3;
			int small = v/3;
			if(big > K) {
				q.add(big);
			}
			if(small > K) {
				q.add(small);
			}
		}
		bw.write(cnt + "");*/
		while(!q.isEmpty()) {
			int v = q.poll();
			cut(v,K);
		}
		bw.write(cnt2 + "");
		bw.close();
	}
	static void cut(int n,int k) {
		int big = n*2/3;
		int small = n/3;
		if(big > k) {
			cut(big,k);
		}
		if(small > k) {
			cut(small,k);
		}
		cnt2++;
		return;
	}

}
