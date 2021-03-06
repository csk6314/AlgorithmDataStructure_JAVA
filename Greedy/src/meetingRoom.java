import java.io.*;
import java.util.*;

public class meetingRoom {
	static class MR implements Comparable<MR>{
		int start,end;
		int times;
		public MR(int start,int end) {
			this.start =start;
			this.end = end;
			times = end-start;
		}
		
		@Override
		public int compareTo(MR m) {
			if(this.end==m.end) {
				return this.start-m.start;
			}
			return this.end-m.end;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		MR rooms[] = new MR[N+1];
		rooms[0] = new MR(0,0);
		for(int i =0;i<N;i++) {
			String input[] = br.readLine().split(" ");
			int st=Integer.parseInt(input[0]);
			int ed = Integer.parseInt(input[1]);
			rooms[i+1] = new MR(st,ed);
		}
		Arrays.sort(rooms);
		int cnt = 1;
		int lastend=rooms[1].end;
		for(int i =2;i<N+1;i++) {
			if(lastend <= rooms[i].start) {
				cnt++;
				lastend = rooms[i].end;
			}
		}
		System.out.println(cnt);
		
	}
}
