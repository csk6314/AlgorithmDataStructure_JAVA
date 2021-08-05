import java.io.*;
import java.util.*;

public class parentheses {
	static class Node {
		int l,r;
		Node(int l , int r) {
			this.l = l;
			this.r = r;
			
		}
		
	}
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Node> q = new LinkedList<Node>();
		int n = Integer.parseInt(br.readLine());
		Node root = new Node(n,n);
		int cnt = 0;
		q.offer(root);
		while(!q.isEmpty()) {
			Node pnode = q.poll();
			if(pnode.r-1>=pnode.l && pnode.r-1 >=0) {
				q.offer(new Node(pnode.l,pnode.r-1));
			} else if(pnode.r-1 == 0 && pnode.l == 0) {
				q.offer(new Node(0,0));
				cnt++;
			}
			if(pnode.l-1>=0) {
				q.offer(new Node(pnode.l-1,pnode.r));
			}else if(pnode.r-1 == 0 && pnode.l == 0) {
				q.offer(new Node(0,0));
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
