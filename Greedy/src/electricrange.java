import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class electricrange {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int kinds[] = {300,60,10};
		int time = Integer.parseInt(br.readLine());
		int cnt[] = new int[3];
		for(int i =0;i<kinds.length;i++) {
			while(time >= kinds[i]) {
				cnt[i]++;
				time-=kinds[i];
			}
		}
		if(time>0) {
			System.out.println(-1);
		}else {
			for(int i =0;i<cnt.length;i++) {
				System.out.print(cnt[i]  + " ");
			}
		} 
		
	}
}
