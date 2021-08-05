import java.util.*;
import java.io.*;
public class ConnectNumber {
	static int upc;
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Long> st = new HashSet<Long>();
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		upc = input[0].length();
		int cnt = 0;
		long sum = 0;
		boolean flag= true;
		do {
			sum = sum*Math.round(Math.pow(10, upc)) + N;
			sum%=K;
			if(st.contains(sum)) {
				flag= false;
				break;
			}	
			st.add(sum);
			cnt++;
	
		} while(sum!=0);
		if(flag) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
		
	}
	
	

}
