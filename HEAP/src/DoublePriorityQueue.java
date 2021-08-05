import java.io.*;
import java.util.*;

public class DoublePriorityQueue {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> maxq = new PriorityQueue<Integer>(Collections.reverseOrder());
			PriorityQueue<Integer> minq = new PriorityQueue<Integer>();
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int j = 0; j < k; j++) {
				String[] input = br.readLine().split(" ");
				int value = Integer.parseInt(input[1]);
				if (input[0].equals("I")) {
					maxq.add(value);
					minq.add(value);
					map.put(value, map.getOrDefault(value, 0) + 1);
				} else {
					if (value == 1) {
						if (map.isEmpty())
							continue;
						while (!maxq.isEmpty()) {
							int v = maxq.poll();
							int v_g = map.getOrDefault(v, 0);
							if (v_g == 0)
								continue;
							else if (v_g == 1) {
								map.remove(v);
							} else if (v_g > 1) {
								map.put(v, v_g - 1);
							}
							break;
						}

					} else {
						if (map.isEmpty())
							continue;
						while (!minq.isEmpty()) {
							int v = minq.poll();
							int v_g = map.getOrDefault(v, 0);
							if (v_g == 0)
								continue;
							else if (v_g == 1) {
								map.remove(v);
							} else if (v_g > 1) {
								map.put(v, v_g - 1);
							}
							break;
						}

					}
				}
			}
			if (map.isEmpty()) {
				System.out.println("EMPTY");
			} else {
				int maxv = 0;
				int minv = 0;
				while (!maxq.isEmpty()) {
					int v = maxq.poll();
					if (map.getOrDefault(v, 0) > 0) {
						maxv = v;
						break;
					}
				}
				while (!minq.isEmpty()) {
					int v = minq.poll();
					if (map.getOrDefault(v, 0) > 0) {
						minv = v;
						break;
					}
				}
				System.out.println(maxv + " " + minv);
			}
		}
	}
}