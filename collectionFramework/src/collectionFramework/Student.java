package collectionFramework;

public class Student implements Comparable<Student> {
	String name;
	int id;
	int score;
	
	public Student(String name,int id,int score) {
		this.name = name;
		this.id = id;
		this.score = score;
	}
	
	public String getName() {
	
		return this.name;
	}
	
	public int getId() {
		
		return this.id;
	}
	
	public int getScore() {
		return this.score;
	}
	
	@Override
	public int compareTo(Student s) {
		if(this.id < s.getId()) {
			return -1;
		} else if (this.id > s.getId()) {
			return 1;
		}
		return 0;
	}
}