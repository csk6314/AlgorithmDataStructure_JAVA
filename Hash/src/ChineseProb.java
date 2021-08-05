import java.io.*;
import java.util.*;

public class ChineseProb {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		Map<String,Integer> hm = new HashMap<String,Integer>();
		for(int i =0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			String name = input[0];
			int v = Integer.parseInt(input[1]);
			hm.put(name, hm.getOrDefault(name, 0) + v);
		}
		Object[] k = hm.keySet().toArray();
		Arrays.sort(k,new Comparator<Object>() {
			@Override
			public int compare(Object o1,Object o2) {
				String s1 = (String) o1;
				String s2 = (String) o2;
				if(s1.length()==s2.length()) {
					return s1.compareTo(s2);
				}
				return s1.length()-s2.length();
				
			}
		});
		for(Object o : k) {
			System.out.println((String)o + " " +hm.get((String)o));
		}
		
		
		}
}
