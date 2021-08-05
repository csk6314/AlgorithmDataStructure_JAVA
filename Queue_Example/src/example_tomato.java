import java.util.*;
import java.io.*;
class example_tomato {
	static int N;
	static int M;
	static int[][] box;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static class Cell {
		int x;
		int y;
		int day;
		
		public Cell(int x, int y, int day) {
			this.x= x;
			this.y=y;
			this.day =day;
			
		}
	}
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		box = new int[M][N];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		
	}
	
	static void bfs() {
		Queue<Cell> q = new LinkedList<Cell>();
		int day = 0;
		
		for(int i=0;i<M;i++) {
			for (int j=0;j<N;j++) {
				if (box[i][j] == 1) {
					q.offer(new Cell(j,i,day));
				}
			}
		}
		
		while(!q.isEmpty()) {
			Cell c = q.poll();
			day = c.day;
			
			for (int i =0;i<4;i++) {
				int nx = c.x + dx[i];
				int ny = c.y + dy[i];
				if (nx>=0 && nx<N && ny>=0 && ny<M) {
					if(box[ny][nx] == 0) {
						box[ny][nx] = 1;
						q.offer(new Cell(nx,ny,day+1));
					}
				}
			}
			
		}
		
		if (chkTomato()) {
			System.out.println(day); 
		} else {
			System.out.println(-1);
		}
	}
	
	static boolean chkTomato() {
		for(int i =0;i<M;i++) {
			for (int j=0;j<N;j++) {
				if (box[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}