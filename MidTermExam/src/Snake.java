import java.util.*;
import java.io.*;
public class Snake {
	static class snake {
		int x,y;
		public snake(int x,int y) {
			this.x =x;
			this.y=y;
			
		}
	}
	static int[][] ground;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static HashMap<Integer,String> dir_map = new HashMap<Integer,String>();
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ground = new int[N][N];
		for(int i =0;i<N;i++) {
			for(int j=0;j<N;j++) {
				ground[i][j] = 0;
			}
		}
		int a_N = Integer.parseInt(br.readLine());
		for(int i=0;i<a_N;i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			ground[a-1][b-1] = 1;
		}
		int turn_N = Integer.parseInt(br.readLine());
		for(int i =0;i<turn_N;i++) {
			String[] input = br.readLine().split(" ");
			dir_map.put(Integer.parseInt(input[0]), input[1]);
		}
		
		start();
	}
	
	static void start() {
		Queue<snake> q = new LinkedList<snake>();
		q.add(new snake(0,0));
		int dir = 0;
		int sec = 0;
		boolean isFinished = false;
		
		snake head = q.peek();
		
		while(!isFinished) {
			if(dir_map.get(sec)!=null) {
				if(dir_map.get(sec).equals("D")) {
					dir++;
					if(dir>3) {
						dir -=4;
					}
				} else {
					dir--;
					if(dir<0) {
						dir += 4;
					}
				}
			}
			if (head.x+dx[dir] <0 || head.x+dx[dir]>=ground[0].length || head.y+dy[dir]< 0 || head.y+dy[dir]>=ground.length) {
				isFinished = true;
				sec++;
				
				break;
			}
			if(!collision(head.x+dx[dir],head.y+dy[dir],q)) {
				isFinished = true;
				sec++;
				break;
			}
			q.add(new snake(head.x+dx[dir],head.y+dy[dir]));
			if(ground[head.y+dy[dir]][head.x+dx[dir]]==1) {
				ground[head.y+dy[dir]][head.x+dx[dir]] = 0;
			} else {
				q.poll();
			}
			head = new snake(head.x+dx[dir],head.y+dy[dir]);
			
			sec++;
		}
		System.out.println(sec);
		
	}
	static boolean collision(int x,int y,Queue<snake> snk) {
		Queue<snake> q_s = snk;
		Iterator it = q_s.iterator();
		while(it.hasNext()) {
			snake s = (snake) it.next();
			if(x == s.x && y==s.y) {
				return false;
			}
		}
		return true;
	}

}
