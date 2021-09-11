import java.io.*;
import java.util.*;
public class onetwothree {
	static HashMap<Integer,Integer> map = new HashMap<>();
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i =0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(getRes(N));
		}
	}
	
	static int getRes(int n) {
		if(n==1) {
			return 1;
		} else if(n==2) {
			return 2;
		} else if(n==3) {
			return 4;
		} else if(map.getOrDefault(n, 0)!=0){
			return map.get(n);
		} else {
			int v= getRes(n-3) + getRes(n-2) + getRes(n-1);
			map.put(n, v);
			return v;
		}
	}
}
