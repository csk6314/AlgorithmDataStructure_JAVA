package collectionFramework;

import java.util.Scanner;

public class Convert {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num_line = Integer.parseInt(input.nextLine());
		Temperature tp = new Mytemperature(0, 'C');

		for (int i = 0; i < num_line; i++) {
			String n_line = input.nextLine();
			String[] str = n_line.split(" ");
			if (Character.toUpperCase(str[1].charAt(0)) == 'C') {
				tp.setCelsius(Double.parseDouble(str[0]));
				System.out.println(tp.getFahrenheit());
			}

			else {
				tp.setFahrenheit(Double.parseDouble(str[0]));
				System.out.println(tp.getCelsius());
			}	

		}

	}
}
