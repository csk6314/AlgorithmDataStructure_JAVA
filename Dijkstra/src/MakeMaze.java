import java.io.*;
import java.util.*;
public class MakeMaze {
	static class Grid implements Comparable<Grid>{
		int x,y,bnum;
		public Grid(int x,int y,int bnum) {
			this.x=x;
			this.y=y;
			this.bnum=bnum;
		}
		@Override
		public int compareTo(Grid g) {
			return this.bnum-g.bnum;
		}
	}
	static int map[][];
	static boolean checked[][];
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,-1,0,1};
	static int n;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		checked = new boolean[n+1][n+1];
		for(int i=1;i<=n;i++) {
			String input = br.readLine();
			for(int j=1;j<=n;j++) {
				map[i][j] = input.charAt(j-1)-'0';
			}
		}
		bfs();
		
	}
	
	static void bfs() {
		PriorityQueue<Grid> q = new PriorityQueue<Grid>();
		q.add(new Grid(1,1,0));
		while(!q.isEmpty()) {
			Grid g = q.poll();
			if(g.x==n && g.y==n) {
				System.out.println(g.bnum); 
				break;
			}
			checked[g.y][g.x]=true;
			for(int  i=0;i<4;i++) {
				int nx = g.x+dx[i];
				int ny = g.y+dy[i];
				if(nx >=1 && nx<=n && ny>=1 && ny<=n) {
					if(!checked[ny][nx]) {
						if(map[ny][nx] == 1) {
							q.offer(new Grid(nx,ny,g.bnum));
						} else {
							q.offer(new Grid(nx,ny,g.bnum+1));
						}
					}
				}
			}
		}
	}
}
