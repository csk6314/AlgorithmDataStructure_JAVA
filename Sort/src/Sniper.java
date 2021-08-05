import java.util.*;
import java.io.*;
public class Sniper {
	static class sniper implements Comparable<sniper>{
		String name;
		int score;
		public sniper(String name,int score) {
			this.name = name;
			this.score = score;
		}
		
		@Override
		public int compareTo(sniper s) {
			return s.score-this.score;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		List<sniper> list = new ArrayList<sniper>();
		while((line = br.readLine())!=null) {
			String[] input = line.split(" ");
			String name= input[0];
			int[] scores = new int[input.length-1];
			for(int i =0;i<scores.length;i++) {
				scores[i] = Integer.parseInt(input[1+i]);
			}
			Arrays.sort(scores);
			int result = Integer.MIN_VALUE;
			int r_score = 0;
			for(int i =0;i<scores.length;i++) {
				r_score = Math.min(scores[i], scores.length-i);
				result = Math.max(result, r_score);
			}
			list.add(new sniper(name,result));
		}
		Collections.sort(list);
		 PrintStream out;
	        try {
	            out = new PrintStream(System.out, true, "UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            return;
	        }
		out.println(list.get(0).name + " " + list.get(0).score);
	}
}
