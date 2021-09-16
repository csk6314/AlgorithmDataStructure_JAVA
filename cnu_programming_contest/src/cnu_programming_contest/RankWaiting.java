package cnu_programming_contest;
import java.io.*;
import java.util.*;
public class RankWaiting {
	static class player implements Comparable<player> {
		String nickname;
		int level;
		public player(String nickname,int level) {
			this.nickname=nickname;
			this.level=level;
		}
		public int compareTo(player p) {
			return this.nickname.compareTo(p.nickname);
		}
	}
	static ArrayList<player> room[];
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ip[] = br.readLine().split(" ");
		int p = Integer.parseInt(ip[0]);
		int m = Integer.parseInt(ip[1]);
		room = new ArrayList[p];
		player Players[] = new player[p];
		for(int i =0;i<p;i++) {
			ip = br.readLine().split(" ");
			int level = Integer.parseInt(ip[0]);
			String nickname=  ip[1];
			Players[i] = new player(nickname,level);
		}
		for(int i=0;i<p;i++) {
			room[i] = new ArrayList<player>();
		}
		for(int i=0;i<p;i++) {
			player py = Players[i];
			for(int j=0;j<p;j++) {
				if(!room[j].isEmpty() && (room[j].get(0).level + 10 < Players[i].level || 
						room[j].get(0).level -10 > Players[i].level || room[j].size()>=m)) {
					continue;
				}
				room[j].add(py);
				break;
			}
		}
		
		//System.out.println(createdRoom);
		for(int i =0;i<p;i++) {
			if(room[i].isEmpty()) break;
			Collections.sort(room[i]);
			if(room[i].size()==m) {
				System.out.println("Started!");
			} else {
				System.out.println("Waiting!");
			}
			for(player pl : room[i]) {
				System.out.println(pl.level + " " + pl.nickname);
			}
		}
		
	}
}
