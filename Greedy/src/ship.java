import java.io.*;
import java.util.Arrays;

public class ship {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String ip[] = br.readLine().split(" ");
		int crayne[] = new int[N];
		for (int i = 0; i < N; i++) {
			crayne[i] = Integer.parseInt(ip[i]);
		}
		int M = Integer.parseInt(br.readLine());
		int boxes[] = new int[M];
		ip = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			boxes[i] = Integer.parseInt(ip[i]);
		}
		Arrays.sort(boxes);
		Arrays.sort(crayne);
		if (boxes[M - 1] > crayne[N - 1]) {
			System.out.println(-1);
		} else {
			int cnt[] = new int[N];
			int st = 0;
			for (int i = 0; i < M; i++) {
				if (boxes[i] <= crayne[st]) {
					cnt[st]++;
				} else {
					st++;
					i--;
				}
			}
			boolean isFinish = false;
			int times = -1;
			do {
				isFinish = true;
				times++;
				for(int i =0;i<N;i++) {
					if(cnt[i]>0) { 
						cnt[i]--;
						isFinish=false;
					} else {
						for(int j=i;j>=0;j--) {
							if(j==i) continue;
							if(cnt[j] >0) {
								cnt[j]--;
								isFinish=false;
								break;
							}
						}
					}
				}
				
			} while(!isFinish);
			
			System.out.println(times);

		}
	}
}
