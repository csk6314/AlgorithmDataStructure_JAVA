import java.io.*;
public class Hanjo {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String ip[] = br.readLine().split(" ");
		int mt[] = new int[ip.length];
		for(int i=0;i<ip.length;i++) {
			mt[i] =Integer.parseInt(ip[i]);
		}
		int max=  mt[0];
		int cnt=0;
		int res = 0;
		for(int  i=1;i<mt.length;i++) {
			if(max>mt[i]) {
				cnt++;
			} else {
				res=Math.max(res,cnt);
				cnt=0;
				max=mt[i];
			}
		}
		res=Math.max(res,cnt);
		System.out.println(res);
	}
}
