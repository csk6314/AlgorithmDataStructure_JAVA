import java.io.*;
import java.util.*;


public class bst2 {
	static Node root = null;
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
		if(r == null) {
			root = new Node(data);
			return;
		}
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

	static void postorder(Node r) {
		if(r.left != null) postorder(r.left);
		if(r.right != null) postorder(r.right);
		System.out.println(r.data+" ");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line=br.readLine())!=null) {
			add(root,Integer.parseInt(line));
		}
		

		postorder(root);

		
	}
}
