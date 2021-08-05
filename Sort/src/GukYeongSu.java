import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class GukYeongSu {
	static class Student {
		String name;
		int g,e,m;
		public Student(String name,int g,int e,int m) {
			this.name = name;
			this.g = g;
			this.e = e;
			this.m = m;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Student> list = new ArrayList<Student>();
		int N = Integer.parseInt(br.readLine());
		String[] input;
		for(int i =0;i<N;i++) {
			input = br.readLine().split(" ");
			String name = input[0];
			int g_score = Integer.parseInt(input[1]);
			int e_score = Integer.parseInt(input[2]);
			int m_score = Integer.parseInt(input[3]);
			list.add(new Student(name,g_score,e_score,m_score));
		}
		
		Collections.sort(list,new Comparator<Student>() {
			@Override
			public int compare(Student s1,Student s2) {
				if(s1.g == s2.g) {
					if(s1.e == s2.e) {
						if(s1.m == s2.m) {
							return s1.name.compareTo(s2.name);
						}
						return s2.m - s1.m;
					}
					return s1.e-s2.e;
				}
				return s2.g-s1.g;
			}
		});
		Iterator<Student> it = list.iterator();
		while(it.hasNext()) {
			Student s = (Student) it.next();
			System.out.println(s.name);
		}
		
	}

}
