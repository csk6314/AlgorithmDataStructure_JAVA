import java.io.*;
public class GCDSUM {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i =0;i<t;i++) {
			String ip[] = br.readLine().split(" ");
			int n = Integer.parseInt(ip[0]);
			int numbers[] = new int[n];
			for(int j=0;j<n;j++) {
				numbers[j] = Integer.parseInt(ip[j+1]);
			}
			int sum = 0;
			for(int j =0;j<n-1;j++) {
				for(int k =j+1;k<n;k++) {
					sum+=getGCD(numbers[j],numbers[k]);
				}
			}
			System.out.println(sum);
		}
	}
	static int getGCD(int a,int b) {
		while (b>0) {
			int temp = a%b;
			a=b;
			b=temp;
		}
		return a;
	}
}
