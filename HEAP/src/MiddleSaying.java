import java.util.*;
import java.io.*;

public class MiddleSaying {
	public static void main(String args[]) throws IOException {
		PriorityQueue<Integer> min_que = new PriorityQueue<Integer>();
		PriorityQueue<Integer> max_que = new PriorityQueue<Integer>(Collections.reverseOrder());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int mid = 0;
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(br.readLine());
			if (min_que.isEmpty() && max_que.isEmpty()) {
				max_que.add(value);
				mid = value;
				bw.write(mid + "\n");
			} else {
				if (mid >= value) {
					max_que.add(value);
					if (max_que.size() > min_que.size() + 1)min_que.add(max_que.poll());
					mid = max_que.peek();
					bw.write(mid + "\n");
				} else if (value > mid) {
					min_que.add(value);
					if (min_que.size() > max_que.size()) max_que.add(min_que.poll());
					mid = max_que.peek();
					bw.write(mid + "\n");
				}
			}
		}
		bw.close();
	}

}
