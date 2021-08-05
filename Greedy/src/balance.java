import java.io.*;
import java.util.Arrays;
public class balance {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String ip[] = br.readLine().split(" ");
		int weights[] = new int[N];
		for(int i =0;i<N;i++) {
			weights[i] = Integer.parseInt(ip[i]);
		}
		Arrays.sort(weights);
		long sum=0;
		for(int i =0;i<weights.length;i++) {
			if(i==0) {
				if(weights[i]==1) {
					sum+=1;
					continue;
				}
			}
			if(sum+1 >= weights[i]) {
				sum+=weights[i];
			} else {
				break;
			}
		}
		
		System.out.println(sum+1);
	}
	}

