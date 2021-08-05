package stack_JAVA;

public class test {
	public static void main(String args[]) {
		MyStack st= new MyStack();
		st.push("1st");
		st.push("2st");
		st.push("3st");
		System.out.println("stack size : " + st.size());
		System.out.println("stack pop : " + st.pop() );
		System.out.println("stack pop : " + st.pop() );
		System.out.println("stack size : " + st.size());
		
		ArrayStack st2 = new ArrayStack(3);
		st2.push("1st 2");
		st2.push("2st 2");
		st2.push("3st 2");
		System.out.println("stack size : " + st2.size());
		System.out.println("stack pop : " + st2.pop() );
		System.out.println("stack pop : " + st2.pop() );
		System.out.println("stack size : " + st2.size());
		
	}
}
