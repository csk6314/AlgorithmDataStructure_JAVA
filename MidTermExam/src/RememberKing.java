import java.util.*;
import java.io.*;
public class RememberKing {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		for(int i =0;i<N;i++) {
			int N1 = Integer.parseInt(br.readLine());
			HashSet<Integer> s1 = new HashSet<Integer>();
			String[] input = br.readLine().split(" ");
			for(int j =0;j<N1;j++) {
				s1.add(Integer.parseInt(input[j]));
			}
			
			int N2 = Integer.parseInt(br.readLine());
			input = br.readLine().split(" ");
			for(int j=0;j<N2;j++) {
				if(s1.contains(Integer.parseInt(input[j]))) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
