import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class rangeSum {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String[] str = (br.readLine()).split(" ");
		int isum = 0;
		int[] sum = new int[n+1];
		if (str.length > n) 
			System.exit(0);
		sum[0] = 0;
		for (int i =0;i<n;i++) {
			isum += Integer.parseInt(str[i]);
			sum[i+1] = isum;	
		}
		
		n = Integer.parseInt(br.readLine());
		
		for(int i = 0;i<n;i++) {
			String[] str2 = (br.readLine()).split(" ");
			sb.append(sum[Integer.parseInt(str2[1])]-sum[Integer.parseInt(str2[0])-1]).append("\n");
		}
	

		bw.write(sb.toString());
		bw.flush();
		bw.close();	
	}
}
