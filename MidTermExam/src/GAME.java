	import java.io.*;
	public class GAME {
		public static void main(String args[]) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] input = br.readLine().split(" ");
			
			int X = Integer.parseInt(input[0]);
			int Y = Integer.parseInt(input[1]);
			
			long Z = (long) Y*100/X;
			
			long left = 0;
			long right = X;
			long mid;
			long result = -1;
			while(left<=right) {
				mid = (left+right)/2;
				long v = (Y+mid)*100/(X+mid);
				if(v>Z) {
					result = mid;
					right = mid-1;
				} else {
					
					left=mid+1;
				}
			}
			
			System.out.println(result);
			
		}
	}
