import java.io.*;
import java.util.*;
public class commonDivide {
	
	static int GCD;
	static long small_ans,big_ans;
	public static void main(String args[]) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String ip[] = br.readLine().split(" ");
		GCD = Integer.parseInt(ip[0]);
		int LCM = Integer.parseInt(ip[1]);
	
		int mltvalue =  LCM/GCD;
		getCD(mltvalue);
		
		System.out.println(small_ans*GCD + " " + big_ans*GCD);
	}
	static void getCD(int a) {
		for(int i = (int)Math.sqrt((double)a);i>0;i--) {
			if(a%i==0) {
				if(GCD==1 && getGCD(i,a/i)!=1) 
					continue;
				if(getGCD((a/i)*GCD,i*GCD)==GCD) {
					small_ans = i;
					big_ans = a/i;
					break;
				}
			}
		}
	}
	static long getGCD(long a,long b) {
		while(b>0) {
			long temp=a%b;
			a = b;
			b = temp;
		}
		return a;
	}
}