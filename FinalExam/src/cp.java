import java.io.*;

public class cp {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		int nums[] = new int[N];
		for(int i =0;i<N;i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
	}
}
