import java.util.*;
import java.io.*;
public class IMZINWAERAN {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i =0;i<N;i++) {
			map.put(input[i],i+1);
		}
		input = br.readLine().split(" ");
		int[] ary = new int[N];
		for(int i =0;i<N;i++) {
			ary[i] = map.get(input[i]);
		}
		int correct = 0;
		int all = N*(N-1)/2;
		for(int i =0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(ary[i] < ary[j]) {
					correct++;
				}
			}
		}
		
		System.out.println(correct + "/" + all);
	}
}
