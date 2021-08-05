import java.io.*;
public class Alpahbet {
	static char map[][];
	static boolean v[][];
	static int dx[] = { 1, -1, 0, 0, };
	static int dy[] = { 0, 0, 1, -1 };
	static int c[] = new int[26];
	static int result = 0;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input[] = br.readLine().split(" ");
		int R = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		map = new char[R+1][C+1];
		v = new boolean[R+1][C+1];
		for(int i=1;i<R+1;i++) {
			String s = br.readLine();
			for(int j =1;j<C+1;j++) {
				map[i][j] = s.charAt(j-1);
				v[i][j] = false;
			}
		}
		
		dfs(1,1,1);
		System.out.println(result);
		
	}
	static void dfs(int x,int y,int depth) {
		result = Math.max(result, depth);
		c[map[y][x]-'A']++;
		v[y][x] = true;
		for(int i =0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=1 && nx<map[0].length && ny >=1 && ny<map.length) {
				if(c[map[ny][nx]-'A']==0 && v[ny][nx] == false) {
					dfs(nx,ny,depth+1);
				
				}
			}
		}
		c[map[y][x]-'A']--;
		v[y][x] = false;
	}
			
}
