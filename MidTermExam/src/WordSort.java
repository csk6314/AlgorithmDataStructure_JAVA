import java.util.*;
import java.io.*;

public class WordSort {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> s = new HashSet<String>();
		for(int i =0;i<N;i++) {
			s.add(br.readLine());
		}
		ArrayList<String> list = new ArrayList<String>(s);
		
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1,String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				return s1.length()-s2.length();
			}
		});
		
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		

		
		
		bw.flush();
		br.close();
		bw.close();
	}
}
