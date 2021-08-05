import java.io.*;
import java.util.*;
public class SerialNum {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<String>();
		for(int i =0;i<N;i++) {
			list.add(br.readLine());
		}
		
		Collections.sort(list,new Comparator<String>() {
			@Override
			public int compare(String s1,String s2) {
				if(s1.length()==s2.length()) {
					int sum1=0,sum2=0;
					for(int i=0;i<s1.length();i++) {
						if(Character.isDigit(s1.charAt(i))) {
							sum1+=Character.valueOf(s1.charAt(i))-Character.valueOf('0');
						}
					}
					for(int i=0;i<s2.length();i++) {
						if(Character.isDigit(s2.charAt(i))) {
							sum2+=Character.valueOf(s2.charAt(i))-Character.valueOf('0');
						}
					}
					if(sum1==sum2) {
						return s1.compareTo(s2);
					}
					return sum1-sum2;
				}
				return s1.length()-s2.length();
			}
		});
		Iterator it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
