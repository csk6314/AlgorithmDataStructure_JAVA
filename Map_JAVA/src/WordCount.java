import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class WordCount {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int cnt = 0;
		String max_word = null;
		int max = 0;
		HashMap<String, Integer> m = new HashMap<String, Integer>();
		while ((line = br.readLine()) != null) {
			String[] input = line.split(" ");

			for (int i = 0; i < input.length; i++) {
				if (!input[i].isEmpty() && !input[i].contains("\t")) {
					int freq = m.getOrDefault(input[i].toLowerCase(), 0);
					//System.out.println(input[i]);
					m.put(input[i].toLowerCase(), freq + 1);
					if (max <= freq + 1) {
						max = freq + 1;
						max_word = input[i].toLowerCase();
					}	
					cnt++;
				} else if(!input[i].isEmpty() && input[i].contains("\t")) {
					String[] input2 = input[i].split("\t");
					int freq = m.getOrDefault(input2[i].toLowerCase(), 0);
					//System.out.println(input[i]);
					m.put(input2[i].toLowerCase(), freq + 1);
					if (max <= freq + 1) {
						max = freq + 1;
						max_word = input2[i].toLowerCase();
					}
					cnt++;
				}
			}
		}
		br.close();
		double result = Math.round(((double) max / (double) cnt) * 100.0) / 100.0;
		PrintStream out;
		try {
			out = new PrintStream(System.out, true, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return;
		}

		out.println(max_word + " " + result);
	}

}
