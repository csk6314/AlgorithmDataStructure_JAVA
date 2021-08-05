import java.util.Scanner;

public class HiJAVA {
	public static final Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		String str = input.nextLine();
		int num_line = Integer.parseInt(str);
		
		str = input.nextLine();
		String[] repeat = str.split(" ");
		for(int i =0;i<num_line;i++) {
			int repeat_num = Integer.parseInt(repeat[i]);
			str = input.nextLine();
			for(int j =0;j<repeat_num;j++) {
				System.out.println(str);
			}
		}

	}
}
