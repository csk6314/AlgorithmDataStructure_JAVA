import java.util.*;
import java.io.*;
public class WordFreq {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] Sample = br.readLine().split(" ");
		Map<String,Integer> m = new HashMap<String,Integer>();
		int max_freq = 0;
		for(String s : Sample) {
			Integer freq = m.get(s);
			m.put(s, (freq==null) ? 1 : freq + 1);
			if(freq != null && freq+1>max_freq) {
				max_freq = freq+1;
			}
		}
		
		System.out.println(max_freq);
		
		
	}
}







