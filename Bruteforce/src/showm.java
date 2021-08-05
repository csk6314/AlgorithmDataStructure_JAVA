import java.io.*;
public class showm {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result =0;
		int num = 0;
		while(N>0) {
			num++;
			if(String.valueOf(num).contains("666")) {
				N--;
				result = num;
			}
		}
		System.out.println(result);
	}
}
