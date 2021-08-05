import java.util.*;
import java.io.*;

public class WordInedx {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		Map<String,Integer> m = new HashMap<String,Integer>();
		String line;
		int line_number = 0;
		int max_freq = 0;
		String max_word = "";
		
		while ((line = br.readLine()) != null) {
			String[] str = line.split(" ");
			for(String s : str) {
				Integer freq = m.get(s);
				m.put(s,(freq==null)?1:freq+1);
				if (freq!=null && freq+1 > max_freq) {
					max_freq = freq+1;
					max_word = s;
				}
			}
			System.out.println(line);
		}
		br.close();
		System.out.print(max_word + " ");
		br = new BufferedReader(new FileReader("input.txt"));
		while ((line = br.readLine()) != null) {
			line_number++;
			String[] str = line.split(" ");
			for(String s: str) {
				if (s.equals(max_word)) {
					System.out.print(line_number + " ");
				}
			}
		
		}
		br.close();
		
	}
}
