import java.io.*;
import java.util.Arrays;
public class hIndex {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().trim().split(" ");
		
		int[] int_input = new int[input.length];
		for(int i = 0;i<input.length;i++) {
			int_input[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(int_input);
		
		int result = Integer.MIN_VALUE;
		int h_index =0;
		
		for(int i =0;i<input.length;i++) {
			h_index = Math.min(int_input[i], input.length-i);
			result = Math.max(h_index, result);
		}
		System.out.println(result);
	}

}
