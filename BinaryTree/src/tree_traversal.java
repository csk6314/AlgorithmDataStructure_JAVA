import java.io.*;
import java.util.*;
public class tree_traversal {
	static class Node {
		String data;
		Node left,right;
		Node(String data) {
			this.data = data;
			left = null;
			right =null;
		}
	}
	Node root;
	tree_traversal() {
		root = null;
	}
	public void setRoot(String a) {
		if(root == null) {
			root = new Node(a);
		}
		
	}
	public void add(Node r,String a,String b,String c) {
		if(r == null) {
			return;
		}
		if(r.data.equals(a)) {
			if(!b.equals(".")) r.left = new Node(b);
			if(!c.equals(".")) r.right = new Node(c);
		} else {
			add(r.left,a,b,c);
			add(r.right,a,b,c);
		}
	}
	public void preorder(Node r) {
		System.out.print(r.data+ " ");
		if(r.left != null) preorder(r.left);
		if(r.right != null) preorder(r.right);
	}
	public void inorder(Node r) {
		if(r.left != null) inorder(r.left);
		System.out.print(r.data+ " ");
		if(r.right != null) inorder(r.right);
	}
	public void postorder(Node r) {
		if(r.left != null) postorder(r.left);
		if(r.right != null) postorder(r.right);
		System.out.print(r.data+" ");
	}
	public void levelorder(Node r) {
		Queue<Node> q = new LinkedList<>();
		q.add(this.root);
		while(!q.isEmpty()) {
			Node n= q.poll();
			System.out.print(n.data+ " ");
			if(n.left!=null)q.add(n.left);
			if(n.right!=null)q.add(n.right);
		}
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		tree_traversal t = new tree_traversal();
		for(int i =0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			t.setRoot(input[0]);
			t.add(t.root, input[0], input[1], input[2]);
		}
		t.preorder(t.root);
		System.out.println();
		t.inorder(t.root);
		System.out.println();
		t.postorder(t.root);
		System.out.println();
		t.levelorder(t.root);
		
	}
}
