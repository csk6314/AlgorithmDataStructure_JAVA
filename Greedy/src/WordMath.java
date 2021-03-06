import java.io.*;
import java.util.*;

public class WordMath {
	public static void main(String args[]) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int alpha[] = new int[26];
		String word[] = new String[N];
		for(int  i=0;i<N;i++) {
			word[i] = br.readLine();
		}
		for(int i =0;i<word.length;i++) {
			for(int j =word[i].length()-1;j>=0;j--) {
				char c = word[i].charAt(j);
				alpha[c-'A'] += (int)Math.pow(10.0, (double)(word[i].length()-1-j));
			}
		}
		Arrays.sort(alpha);
		int sum=0;
		for(int i=0;i<=9;i++) {
			sum+= (9-i)*alpha[25-i];
		}
		System.out.println(sum);

	}
}
