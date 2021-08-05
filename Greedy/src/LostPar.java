import java.io.*;
import java.util.*;
public class LostPar {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<Integer>();
		String exp = br.readLine();
		String p_exp[] = exp.split("-");
		for(int i=0;i<p_exp.length;i++) {
			String numbers[] = p_exp[i].split("\\+");
			int sum=0;
			for(int j=0;j<numbers.length;j++) {
				sum+=Integer.parseInt(numbers[j]);
			}
			q.add(sum);
		}
		int s_value = q.poll();
		while(!q.isEmpty()) {
			s_value -= q.poll();
		}
		System.out.println(s_value);
	}
}
