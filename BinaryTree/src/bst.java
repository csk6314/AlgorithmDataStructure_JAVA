import java.io.*;
import java.util.*;


public class bst {
	static class Node {
		int data;
		Node left,right;
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	static void add(Node r,int data) {
		Node current = r;
		if(current.data > data) {
			if(current.left==null) {
				current.left = new Node(data);
			} else {
				add(current.left,data);
			}
		} else {
			if(current.right==null) {
				current.right = new Node(data);
			} else {
				add(current.right,data);
			}
		}
		
	}
	static void preorder(Node r) {
		System.out.print(r.data+ " ");
		if(r.left != null) preorder(r.left);
		if(r.right != null) preorder(r.right);
	}
	static void inorder(Node r) {
		if(r.left != null) inorder(r.left);
		System.out.print(r.data+ " ");
		if(r.right != null) inorder(r.right);
	}
	static void postorder(Node r) {
		if(r.left != null) postorder(r.left);
		if(r.right != null) postorder(r.right);
		System.out.print(r.data+" ");
	}
	static void levelorder(Node r) {
		Queue<Node> q = new LinkedList<>();
		q.add(r);
		while(!q.isEmpty()) {
			Node n= q.poll();
			System.out.print(n.data+ " ");
			if(n.left!=null)q.add(n.left);
			if(n.right!=null)q.add(n.right);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=  Integer.parseInt(br.readLine());
		String[] input =br.readLine().split(" ");
		Node root = null;
		for(int i=0;i<N;i++) {
			if(i==0) {
				root = new Node(Integer.parseInt(input[i]));
			} else {
				add(root,Integer.parseInt(input[i]));
			}
		}
		preorder(root);
		System.out.println();
		inorder(root);
		System.out.println();
		postorder(root);
		System.out.println();
		levelorder(root);
		
	}
}
