import java.io.*;
import java.util.*;

public class parenthese {
	static int cnt = 0;
	static class parent {
		int l,r;
		parent(int l , int r) {
			this.l = l;
			this.r = r;
			
		}
		
	}
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		parent p = new parent(n,n);
		dfs(p);
		System.out.println(cnt);
		
	}
	static void dfs(parent p) {
		if(p.l ==0 && p.r == 0) {
			cnt++;
			return;
		}
		if(p.l>0)	dfs(new parent(p.l-1,p.r));
		if( p.r >0&&p.r>p.l) {
		dfs(new parent(p.l,p.r-1));
		}
	}
}
