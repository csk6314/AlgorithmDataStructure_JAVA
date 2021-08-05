import java.util.*;
import java.io.*;

public class PocketMon {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		HashMap<Integer,String> m = new HashMap<Integer,String>();
		HashMap<String, Integer> m2 = new HashMap<String,Integer>();
		for(int i =1;i<=N;i++) {
			String name = br.readLine();
			m.put(i, name);
			m2.put(name, i);
			
		}
		
		for(int i=0;i<M;i++) {
			String input2 = br.readLine();
			if(Character.isDigit(input2.charAt(0))) {
				System.out.println(m.get(Integer.parseInt(input2)));
			} else if (Character.isAlphabetic(input2.charAt(0))) {
				System.out.println(m2.get(input2));
			}
		}
		
	}
}
