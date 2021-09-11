import java.io.*;

public class GCDandLCM {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ip[] = br.readLine().split(" ");
		int fNum = Integer.parseInt(ip[0]);
		int sNum = Integer.parseInt(ip[1]);
		int gcd = getGCD(fNum,sNum);
		System.out.println(gcd);
		int lcm = (fNum*sNum) / gcd;
		System.out.println(lcm);
	}
	
	static int getGCD(int fNum,int sNum) {
		int a = fNum;
		int b= sNum;
		while(b>0) {
			int temp = a%b;
			a = b;
			b= temp;
		}
		return a;
	}
}
