import java.util.*;

class Person implements Comparable<Person> {
	String name;
	int id;
	
	public Person(String name, int id) {
		this.name = name;
		this.id = id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public boolean equals(Person o) {
		Person p = (Person) o;
		return p.id == o.id;
	}
	public int compareTo(Person o) {
		Person p = (Person) o;
		if(id > o.id) {
			return 1;
		} else if(id < o.id) {
			return -1;
		} else {
			return 0;
		}
			
		
	}
}
public class TreeSetPerson {
	public static void main(String args[]) {
		TreeSet<Person> tset = new TreeSet<Person>();
		System.out.println("\t TreeSet ");
		tset.add(new Person("lee",1111));
		tset.add(new Person("kim",3333));
		tset.add(new Person("chae",2222));
		tset.add(new Person("hae",4444));
		tset.add(new Person("Jung",1111));
		
		for(Person t : tset) {
			System.out.println(t.name + "\t" + t.id);
		}
	}

}
