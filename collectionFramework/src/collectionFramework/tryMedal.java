package collectionFramework;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Students implements Comparable<Students> {
	String name;
	int try_num;
	int score;

	public Students(String name, int score, int try_num) {
		this.name = name;
		this.try_num = try_num;
		this.score = score;
	}

	public String getName() {
		return this.name;
	}

	public int gettry_num() {
		return this.try_num;
	}

	public int getScore() {
		return this.score;
	}

	@Override
	public int compareTo(Students s) {
		if (this.score < s.getScore()) {
			return 1;
		} else if (this.score > s.getScore()) {
			return -1;
		} else if (this.score == s.getScore()) {
			if (this.try_num > s.gettry_num())
				return 1;
			else if (this.try_num < s.gettry_num())
				return -1;
		}
		return 0;
	}
}

public class tryMedal {
	
	public static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		PrintStream out;
		List<Students> list = new ArrayList<Students>();
		
		try {
			out = new PrintStream(System.out, true, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return;
		}

		String str = input.nextLine();
		int num_line = Integer.parseInt(str);

		for (int i = 0; i < num_line; i++) {
			str = input.nextLine();
			String[] inf = str.split(" ");
			String name = inf[0];
			int score = Integer.parseInt(inf[1]);
			int trynum = Integer.parseInt(inf[2]);
			list.add(new Students(name, score, trynum));
		}
		Collections.sort(list);
		for(int i=0;i<3;i++)
		list.remove(0);
		
		
		Comparator<Students> mycom = new Comparator<Students>() {
			@Override
			public int compare(Students s1, Students s2) {
				return s2.gettry_num() - s1.gettry_num();
			}
		};
		Collections.sort(list,mycom);
		Iterator it = list.iterator();
		while (it.hasNext()) {
			Students st1 = (Students) it.next();
			System.out.println(st1.getName());
		}

	}
}
