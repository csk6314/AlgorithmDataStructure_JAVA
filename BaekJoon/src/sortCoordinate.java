import java.io.*;
import java.util.Arrays;
import java.util.Collections;
public class sortCoordinate {
	static class Point implements Comparable<Point> {
		int x,y;
		public Point(int x,int y) {
			this.x =x;
			this.y =y;
		}
		@Override
		public int compareTo(Point p) {
			if(this.x==p.x) {
				return this.y-p.y;
			}
			return this.x-p.x;
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Point pa[] = new Point[N];
		for(int i=0;i<N;i++) {
			String input[] = br.readLine().split(" ");
			pa[i] = new Point(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
		}
		Arrays.sort(pa);
		for(int i=0;i<N;i++) {
			System.out.println(pa[i].x + " " + pa[i].y);
		}
	}
}
