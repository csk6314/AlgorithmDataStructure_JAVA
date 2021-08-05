import java.io.*;
import java.util.*;
public class Tree {
	static class Node {
		int data;
		Node left,right;
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	static class bTree {
		Node root;
		int size=0;
		public bTree() {
			root = null;
		}
		public void add(Node r) {
			size++;
			Queue<Node> q = new LinkedList<>();
			if(root==null) {
				root = r;
				return;
			}
			q.add(root);
			while(!q.isEmpty()) {
				Node n = q.poll();
				if(n.left != null) {q.add(n.left);}
				else {
					n.left = r;
					return;
				}
				if(n.right!=null) {q.add(n.right);}
				else {
					n.right = r;
					return;
				}
			}
			
			
		}
		public void remove(int idx) {
			Queue<Node> q = new LinkedList<>();
			boolean isLeft = true;
			if(idx %2==0) {
				isLeft = false;
			} else {
				isLeft= true;
			}
			int pidx = (idx-1)/2;
			q.add(root);
			int current=-1;
			while(!q.isEmpty()) {
				Node n = q.poll();
				current++;
				if(current == idx) {
					
					return;
				}
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
			}
		}
		
	}
	public static void main(String args[]) throws IOException {
		
	}

}
