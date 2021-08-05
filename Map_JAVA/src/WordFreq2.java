import java.util.*;
import java.io.*;
public class WordFreq2 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine().toLowerCase();
		HashMap<Character,Integer> m = new HashMap<Character,Integer>();
		int max_num =0;
		Character c = null;
		boolean same = true;
		for(int i =0;i<a.length();i++) {
			Integer Freq = m.get(a.charAt(i));
			m.put(a.charAt(i), (Freq==null) ? 1 : Freq+1);
			if(a.length()==1) {
				same = false;
				c = a.charAt(i);
			}
			if (Freq!=null&&max_num < Freq+1 ) {
				max_num = Freq+1;
				c = a.charAt(i);
				same = false;
			} else if (Freq!=null && max_num == Freq+1) {
				same =true;
			} 
		}
		if(same) {
			System.out.println("?");
		} else {
			System.out.println(Character.toUpperCase(c));
		}
	}
}
