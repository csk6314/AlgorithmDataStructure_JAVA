import java.util.*;
import java.io.*;

public class parWordFreq {
	static class Num {
		int value;
		int level;

		public Num(int level, int value) {
			this.value = value;
			this.level = level;
		}
	}

	static class parMap {
		String ch;
		HashMap<String, Integer> m;

		public parMap(String ch, HashMap<String, Integer> m) {
			this.ch = ch;
			this.m = m;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		Stack<parMap> mstack = new Stack<parMap>();
		Stack<Integer> maxstack = new Stack<Integer>();
		Stack<Num> vstack = new Stack<Num>();
		int lv = 0;
		boolean isCan = true;
		maxstack.push(0);
		mstack.push(new parMap("f", new HashMap<String, Integer>()));
		while ((line = br.readLine()) != null) {
			String[] input = line.split(" ");
			for (int i = 0; i < input.length; i++) {
				String ch = input[i].toLowerCase();
				if (!ch.isEmpty()) {
					if (ch.equals("(")) {
						mstack.push(new parMap("(", new HashMap<String, Integer>()));
						maxstack.push(0);
						lv++;
					} else if (ch.equals(")")) {
						if (!mstack.peek().ch.equals("(")) {
							isCan = false;
						} else {
							int v = 0;
							v += maxstack.pop();
							if (!vstack.isEmpty() && vstack.peek().level > lv) {
								while (!vstack.empty()) {
									v += vstack.pop().value;
								}
							}
							vstack.push(new Num(lv, v * 2));
							mstack.pop();
							lv--;
						}
					} else if (ch.equals("{")) {
						mstack.push(new parMap("{", new HashMap<String, Integer>()));
						maxstack.push(0);
						lv++;
					} else if (ch.equals("}")) {
						if (!mstack.peek().ch.equals("{")) {
							isCan = false;
						} else {
							int v = 0;
							v += maxstack.pop();
							if (!vstack.isEmpty() && vstack.peek().level > lv) {
								while (!vstack.empty()) {
									v += vstack.pop().value;
								}
							}
							vstack.push(new Num(lv, v * 3));
							mstack.pop();
							lv--;
						}
					} else if (ch.equals("[")) {
						mstack.push(new parMap("[", new HashMap<String, Integer>()));
						maxstack.push(0);
						lv++;
					} else if (ch.equals("]")) {
						if (!mstack.peek().ch.equals("[")) {
							isCan = false;
						} else {
							int v = 0;
							v += maxstack.pop();
							if (!vstack.isEmpty() && vstack.peek().level > lv) {
								while (!vstack.empty()) {
									v += vstack.pop().value;
								}
							}
							vstack.push(new Num(lv, v * 4));
							mstack.pop();
							lv--;
						}
					} else {
						int freq = mstack.peek().m.getOrDefault(ch, 0) + 1;
						mstack.peek().m.put(ch, freq);
						if (maxstack.peek() < freq) {
							maxstack.pop();
							maxstack.push(freq);
						}
					}
				}
			}
		}
		br.close();
		if (!mstack.isEmpty() && !mstack.peek().ch.equals("f")) {
			isCan = false;
			System.out.println(2);
		}

		if (!isCan) {
			System.out.println(-1);
		} else {
			if (!maxstack.isEmpty() && !mstack.isEmpty() &&!vstack.isEmpty()) {
				int v2 = maxstack.pop();
				mstack.pop();
				int sum = 0;
				while(!vstack.isEmpty()) {
					sum += vstack.pop().value;
				}
				System.out.println(sum + v2);
			}
		}
	}
}
