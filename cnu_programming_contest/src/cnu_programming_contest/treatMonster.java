package cnu_programming_contest;

import java.io.*;

public class treatMonster {
	static class skill {
		int time, dmg;

		public skill(int time, int dmg) {
			this.time = time;
			this.dmg = dmg;
		}
	}

	static int HP, N;
	static skill skills[];
	static int cooltime[];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ip[] = br.readLine().split(" ");
		N = Integer.parseInt(ip[0]);
		HP = Integer.parseInt(ip[1]);
		skills = new skill[N];
		cooltime = new int[N];
		for (int i = 0; i < N; i++) {
			ip = br.readLine().split(" ");
			skills[i] = new skill(Integer.parseInt(ip[0]), Integer.parseInt(ip[1]));
		}
		System.out.println(getMin(0, 0));
	}

	static int getMin(int dmged, int time) {
		// System.out.println(time+ " " + dmged + " "+cooltime[1] + " " + cooltime[0]);
		//System.out.println(time);
		if (dmged >= HP) {
			return time;
		}
		boolean isCool = true;
		int minCool = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			if(cooltime[i] ==0) {
				isCool=false;
				break;
			} else {
				if(cooltime[i] < minCool) {
					minCool=cooltime[i];
				}
			}
		}
		if(isCool) {
			int ans=0;
			for(int i =0;i<N;i++) {
				cooltime[i] -= minCool;
			}
			ans= getMin(dmged,time+minCool);
			for(int i =0;i<N;i++) {
				cooltime[i] += minCool;
			}
			return ans;
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			skill s = skills[i];
			if (cooltime[i] <= 0) {
				cooltime[i]=s.time;
				boolean isZero[] = new boolean[N];
				for(int j=0;j<N;j++) {
					if(cooltime[j]>0) {
						cooltime[j]-=1;
					}else {
						isZero[j] = true;
					}
				}
				ans = Math.min( ans,getMin(s.dmg + dmged, time + 1));
				for(int j=0;j<N;j++) {
					if(!isZero[j]) {
						cooltime[j]+=1;
					} else {
						isZero[j] = false;
					}
				}
				cooltime[i] = 0;
				//System.out.println(cooltime[0] + " " + cooltime[1] );
			}

		}
		return ans;
	}
}
