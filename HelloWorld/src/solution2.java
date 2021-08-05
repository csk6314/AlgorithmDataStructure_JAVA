import java.util.Scanner;
public class solution2 {
	public static final Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		String output = "Hello, CCOJ";
		int repeat = input.nextInt();
		
		for(int i =0;i<repeat;i++) {
			System.out.println(output);
		}
		input.close();
		
	}

}
