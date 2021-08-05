import java.util.*;
import java.io.*;

public class MartStock {
	static abstract class Goods implements Comparable<Goods> {
		String name;
		int stock;

		public Goods(String name, int stock) {
			this.name = name;
			this.stock = stock;
		}

		@Override
		public int compareTo(Goods o) {
			if (this.getClass() == o.getClass()) {
				return this.compare(o);
			} else {
				return this.getClass().toString().compareTo(o.getClass().toString());
			}
		}

		abstract public int compare(Object o);
	}

	static class Electrics extends Goods {
		int model;

		public Electrics(String name, int stock, int model) {
			super(name, stock);
			this.model = model;
		}

		public String getName() {
			return super.name;
		}

		public int getStock() {
			return super.stock;
		}

		public int getModel() {
			return this.model;
		}

		public int compare(Object o) {
			Electrics e = (Electrics) o;
			if (this.model > e.getModel()) {
				return 1;
			} else if (this.model < e.getModel()) {
				return -1;
			} else {
				if (this.stock > e.stock) {
					return -1;
				} else if (this.stock < e.stock) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}

	static class Fruits extends Goods {
		String type;

		public Fruits(String name, int stock, String type) {
			super(name, stock);
			this.type = type;
		}

		public String getName() {
			return super.name;
		}

		public int getStock() {
			return super.stock;
		}

		public String getType() {
			return this.type;
		}

		public int compare(Object o) {
			Fruits f = (Fruits) o;
			if (f.type.equals(this.type)) {
				return -(this.stock - f.stock);
			}
			return this.type.compareTo(f.type);
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Goods> list = new ArrayList<Goods>();
		PrintStream out;
		try {
			out = new PrintStream(System.out, true, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return;
		}
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			if (input[0].equals("F")) {
				String name = input[1];
				String type = input[2];
				int stock = Integer.parseInt(input[3]);
				list.add(new Fruits(name, stock, type));
			} else {
				String name = input[1];
				int model = Integer.parseInt(input[2]);
				int stock = Integer.parseInt(input[3]);
				list.add(new Electrics(name, stock, model));
			}
		}
		Collections.sort(list);

		Iterator it = list.iterator();
		while (it.hasNext()) {
			Goods g = (Goods) it.next();
			if (g.getClass().getSimpleName().equals("Electrics")) {
				Electrics e = (Electrics) g;
				out.println(e.getName() + ", " + e.getModel() + ", " + e.getStock());
			} else {
				Fruits f = (Fruits) g;
				out.println(f.getName() + ", " + f.getType() + ", " + f.getStock());
			}
		}
	}
}
