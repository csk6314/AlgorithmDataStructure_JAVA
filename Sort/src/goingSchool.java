import java.io.*;
import java.util.*;
public class goingSchool {
	static class student {
		int distance;
		int time;
		public student(int distance,int time) {
			this.distance = distance;
			this.time =time;
		}
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		List<student> list = new ArrayList<student>();
		int n = Integer.parseInt(input[0]);
		int total_distance= Integer.parseInt(input[1]);
		for(int i=0;i<n;i++) {
			input  =br.readLine().split(" ");
			int distance = total_distance - Integer.parseInt(input[0]);
			int time = distance/Integer.parseInt(input[1]);
			list.add(new student(distance,time));
		}
		Collections.sort(list,new Comparator<student>() {
			@Override
			public int compare(student s1,student s2) {
				return s1.distance-s2.distance;
			}
		});
		
		Iterator it = list.iterator();
		int group = 0;
		int t = Integer.MIN_VALUE;
		while(it.hasNext()) {
			student s  = (student) it.next();
			if(t<s.time) {
				t = s.time;
				group++;
			}
		}
		System.out.println(group);
	}
}
