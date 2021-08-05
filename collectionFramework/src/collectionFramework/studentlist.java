package collectionFramework;
/*
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

abstract class Students implements Comparable<Students> {
	public String name;

	public Students(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Students o) {
		if (this.getClass() == o.getClass()) {
			return this.compare(o);
		} else {
			return this.getClass().toString().compareTo(o.getClass().toString());
		}
	}

	abstract public int compare(Object o);
}

class Human extends Students {
	int id;

	public Human(String name, int id) {
		super(name);
		this.id = id;
	}

	public int getid() {
		return this.id;
	}

	public String getname() {
		return this.name;
	}

	@Override
	public int compare(Object o) {
		Human h = (Human) o;
		if (this.getid() < h.getid()) {
			return -1;
		} else if (this.getid() > h.getid())
			return 1;

		return 0;
	}

}

class Android extends Students {
	String model;
	String serial;

	public Android(String name, String model, String serial) {
		super(name);
		this.model = model;
		this.serial = serial;
	}

	public String getmodel() {
		return this.model;
	}

	public String getname() {
		return this.name;
	}

	public String getserial() {
		return this.serial;
	}

	@Override
	public int compare(Object o) {
		Android a = (Android) o;
		if(this.getmodel().compareTo(a.getmodel()) == 0) 
			return this.getserial().compareTo(a.getserial());
		else
			return this.getmodel().compareTo(a.getmodel());
	}
	
	
}

public class studentlist {
	private static final Scanner input = new Scanner(System.in);
	public static void main(String args[]) {
		PrintStream out;
		List<Students> list = new ArrayList<Students>();
		try {
			out = new PrintStream(System.out, true, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return;
		}

		String str = input.nextLine();
		int num_line = Integer.parseInt(str);
		
		for(int i =0;i<num_line;i++) {
			str = input.nextLine();
			String[] inf = str.split(" ");
			if (inf.length == 2) {
				String name = inf[0];
				int id = Integer.parseInt(inf[1]);
				list.add(new Human(name,id));
				
			} else if(inf.length == 3) {
				String name = inf[0];
				String model = inf[1];
				String serial = inf[2];
				list.add(new Android(name,model,serial));
			}
		}
		Collections.sort(list);	
		Iterator it = list.iterator();
		while(it.hasNext()) {
			Students st = (Students)it.next();
			out.println(st.name);
		}
		

	}

}*/
