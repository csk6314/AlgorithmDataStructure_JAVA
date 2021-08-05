
public class AppTest {
	public static void main(String[] args) {
		MyList<Integer> lst = new MyList<Integer>();
		
		lst.add(3);
		lst.add(5);
		lst.add(6);
		lst.add(9);
		lst.add(3,12);
		System.out.println(lst.remove(4));
	}

}
