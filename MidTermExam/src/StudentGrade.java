import java.util.*;
import java.io.*;

public class StudentGrade {
	static class Student implements Comparable<Student> {
		int score;
		String name;
		boolean isRetake;
		public Student(String name,int score,boolean isRetake) {
			this.name = name;
			this.score = score;
			this.isRetake = isRetake;
		}
		
		public String getName() {
			return this.name;
		}
		public int getScore() {
			return this.score;
		}
		public boolean getRetake() {
			return this.isRetake;
		}

		@Override
		public int compareTo(Student o) {
			if(this.score > o.getScore()) {
				return -1;
			} else if(this.score < o.getScore()) {
				return 1;
			} else {
				if (this.isRetake == true && o.isRetake ==false) {
					return 1;	
				} else if(this.isRetake == false && o.isRetake == true) {
					return -1;
				} else {
					return 0;
				}
			}
		}
		
		
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Student> list = new ArrayList<Student>();
		
		for(int i =0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			String name = input[0];
			int score = Integer.parseInt(input[1]);
			Boolean isRetake;
			if(input[2].equals("true")) {
				isRetake = true;
			} else {
				isRetake = false;
			}
			list.add(new Student(name,score,isRetake));
			
		}
		
		Collections.sort(list);
		
		
		
		Iterator it = list.iterator();
		 PrintStream out;
	        try {
	            out = new PrintStream(System.out, true, "UTF-8");
	        } catch (UnsupportedEncodingException e) {
	            return;
	        }
	        
		while(it.hasNext()) {
			Student s = (Student) it.next();
			out.println(s.getName());
		}
		
	}
}
