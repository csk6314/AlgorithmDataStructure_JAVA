import java.util.*;
import java.io.*;
public class SimpleSort {
	static class Student{
		String name;
		double score;
		public Student(String name,double score) {
			this.name = name;
			this.score = score;
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		List<Student> lst = new ArrayList<Student>();
		for(int i =0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			String name = input[0];
			double score = Double.parseDouble(input[1]);
			lst.add(new Student(name,score));
		}
		Collections.sort(lst,new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if(s2.score>s1.score) {
					return 1;
				} else if (s2.score == s1.score) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		 PrintStream out;
	        try {
	            out = new PrintStream(System.out, true, "UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            return;
	        }
		Iterator it = lst.iterator();
		while(it.hasNext()) {
			Student s = (Student) it.next();
			out.println(s.name);
		}
	}
}
