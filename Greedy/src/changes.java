import java.io.*;
public class changes {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int kinds[] = {500,100,50,10,5,1};
		int money = 1000 - Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i =0;i<kinds.length;i++) {
			while(money >= kinds[i]) {
				cnt++;
				money-=kinds[i];
			}
		}
		System.out.println(cnt);
	}
}
