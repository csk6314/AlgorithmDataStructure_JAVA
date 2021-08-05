import java.util.*;
import java.io.*;

public class Ecology {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Integer> m = new HashMap<String, Integer>();
		int cnt = 0;
		String str = br.readLine();
		while (true) {

			if (str==null) {
				break;
			}

			m.put(str, m.getOrDefault(str, 0) + 1);
			cnt++;
			str = br.readLine();	

		}
		if (!m.isEmpty()) {
			Object[] mapkey = m.keySet().toArray();
			Arrays.sort(mapkey);

			StringBuilder sb = new StringBuilder();

			for (Object key : mapkey) {
				String str2 = (String) key;
				double key_d = (double) m.get(str2) / cnt;
				double percentage = Math.round(key_d * 1000000) / 10000.0;

				sb.append(str2 + " " + String.format("%.4f", percentage) + "\n");

			}
			System.out.println(sb.toString());
		}
	}

}
