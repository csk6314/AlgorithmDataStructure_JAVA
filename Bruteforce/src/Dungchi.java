import java.io.*;
import java.util.*;

public class Dungchi {
	static class human {
		int w, h;
		int rank;

		public human(int weight, int height) {
			this.w = weight;
			this.h = height;
			rank = 1;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<human> list = new ArrayList<human>();
		for (int i = 0; i < N; i++) {
			String input[] = br.readLine().split(" ");
			list.add(new human(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if(i==j) continue;
				if(list.get(i).w < list.get(j).w && list.get(i).h < list.get(j).h) {
					list.get(i).rank++;
				}
			}
		}
		for(int i =0;i<list.size();i++) {
			System.out.print(list.get(i).rank + " ");
		}
	}
}
