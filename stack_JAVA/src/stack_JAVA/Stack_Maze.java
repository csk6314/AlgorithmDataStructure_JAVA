package stack_JAVA;

import java.util.StringTokenizer;

import java.util.Stack;
import java.io.*;

public class Stack_Maze {
	static class way {
		int x;
		int y;
		int index;

		public way(int X,int Y,int index) {
			this.x = X;
			this.y = Y;
			this.index = index;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] maze = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(str[j]);
				
			}
		}

		solveMaze(maze);
	}

	private static void solveMaze(int[][] maze) {
		Stack<way> stack = new Stack<way>();
		Stack<way> stack2 = new Stack<way>();
		
		int[][] mz = maze;
		int N = maze.length;
		int M = maze[0].length;
		int []dx = {1,-1,0,0};
		int []dy = {0,0,1,-1};
		boolean noway = false;
		boolean dif_way = false;
		int num_move = 1;
		stack.push(new way(0,0,0));
		
		while(!noway) {
			
			int x1 = stack.peek().x;
			int y1 = stack.peek().y;
			noway = true;
			dif_way = false;
			num_move++;
			for(int i =0;i<4;i++) {
				int x2= x1+dx[i];
				int y2= y1 + dy[i];
				if (x2>=0 && y2>=0 && x2<N && y2<M) {
					if(mz[x2][y2] == 1 && !dif_way) {
						mz[x1][y1] = -1;
						stack.push(new way(x2,y2,num_move));
						noway = false;
						dif_way =true;
					}  else if (mz[x2][y2]==1 && dif_way) {
						stack2.push(new way(x1,y1,num_move-1));
						break;
					} 
				}
				
			}
			
			
			if (stack.peek().x == N-1 && stack.peek().y == M-1) {
				break;
			}
			if(noway  && !stack2.isEmpty()) {
				mz[stack.peek().x][stack.peek().y] = -1;
				while(stack.peek().index > stack2.peek().index) {
					stack.pop();
					
				}
				mz[stack.peek().x][stack.peek().y] = 1;
				num_move = stack2.peek().index;
				noway = false;
				stack2.pop();
			}
			
		}
		System.out.println(stack.peek().index); 
		
		
			
		
	}

}
