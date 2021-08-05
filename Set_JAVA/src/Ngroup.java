import java.util.*;
import java.io.*;

public class Ngroup {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<HashSet<String>> l = new ArrayList<HashSet<String>>();
		String[] input = br.readLine().split(" ");
		int g_num = Integer.parseInt(input[0]);
		int name_num = Integer.parseInt(input[1]);
		
		for(int i=0;i<g_num;i++) {
			l.add(new HashSet<String>());
		}
		for(int i =0;i<name_num;i++) {
			input = br.readLine().split(" ");
			l.get(Integer.parseInt(input[0])).add(input[1]);
		}
		int q_num = Integer.parseInt(br.readLine());
		HashSet<String> s_U = new HashSet<String>();
		HashSet<String> s_I= new HashSet<String>();
		HashSet<String> s_D = new HashSet<String>();
		for(int i =0;i<q_num;i++) {
			input = br.readLine().split(" ");
			
			if(input[0].equals("U")) {
				s_U = new HashSet<String>(l.get(Integer.parseInt(input[1])));
				s_U.addAll(l.get(Integer.parseInt(input[2])));
				s_U.addAll(l.get(Integer.parseInt(input[3])));
				System.out.println(s_U.size());
			} else if(input[0].equals("I")) {
				s_I = new HashSet<String>(l.get(Integer.parseInt(input[1])));
				s_I.retainAll(l.get(Integer.parseInt(input[2])));
				s_I.retainAll(l.get(Integer.parseInt(input[3])));
				System.out.println(s_I.size());
			} else if (input[0].equals("D") && g_num >2 ) {
				s_D = new HashSet<String>(l.get(Integer.parseInt(input[1])));
				s_D.removeAll(l.get(Integer.parseInt(input[2])));	
				s_D.removeAll(l.get(Integer.parseInt(input[3])));
				System.out.println(s_D.size());
			}
		}
	}
}
