package collectionFramework;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class testStudentSort {

	public static void main(String[] args) throws java.lang.Exception {
		// TODO Auto-generated method stub
		List <Student> list = new ArrayList<Student>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i =0;i<n;i++) {
			String[] str = br.readLine().split(" ");
			String name = str[0];
			int year =  Integer.parseInt(str[1]);
		    int score = Integer.parseInt(str[2]);
		    list.add(new Student(name,year,score));
		}
		
		br.close();
		
        Collections.sort(list);
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Student str = (Student)it.next();
			System.out.println(str.name + " " +  str.id + " " + str.score);
		}
		
		Comparator<Student> mycom = new Comparator<Student>() {
			@Override
			public int compare(Student s1,Student s2) {
				return s2.getScore() - s1.getScore();
			}
		};
		Collections.sort(list,mycom);
		it = list.iterator();
		while(it.hasNext()) {
			Student str = (Student)it.next();
			System.out.println(str.name + " " +  str.id + " " + str.score);
		}
		
		
		
	}

}
