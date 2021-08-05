import java.util.*;
import java.io.*;

public class FindPassword {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		HashMap<String,String> m =new HashMap<String,String>();
		for(int i =0;i<N;i++) {
			input = br.readLine().split(" ");
			m.put(input[0], input[1]);
		}
		for(int i=0;i<M;i++) {
			String site = br.readLine();
			bw.write(m.get(site) + "\n");
			
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
