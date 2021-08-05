import java.io.*;
import java.util.*;

public class Hashing {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		String input = br.readLine();
		char[] ch = input.toCharArray();
		long sum=0;
		long r=1;
		for(int i =0;i<len;i++) {
			int c = ch[i]-96;
			long c2 = c*r;
			long hashv = c2%1234567891;
			sum += hashv;	
			r= (r*31)%1234567891;
		}
		System.out.println(sum%1234567891);
	}

}
