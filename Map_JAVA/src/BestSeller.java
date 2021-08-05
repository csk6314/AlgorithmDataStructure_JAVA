import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BestSeller {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String,Integer> m = new HashMap<String,Integer>();
		ArrayList<String> list = new ArrayList<String>();
		int max = 0;
		for(int i =0;i<N;i++) {
			String input = br.readLine();
			int freq = m.getOrDefault(input, 0);
			m.put(input, freq+1);
			if (freq+1 >= max) {
				max = freq+1;
			}
		}
		for(Map.Entry<String,Integer> ent : m.entrySet()) {
			if(ent.getValue() == max) {
				list.add(ent.getKey());
			}
		}
		Collections.sort(list);
		
		System.out.println(list.get(0));
	}
}
