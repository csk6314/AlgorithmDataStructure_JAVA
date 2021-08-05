	
public class binarySearchTree {
	 static class Node {
		private int data;
		private Node left,right;
		public Node(int data) {
			this.data = data;
			this.left =null;
			this.right=null;
		}
		
	}
	 public Node root;
	 public binarySearchTree() {
		 this.root = null;
	 }
	 public boolean find(int id) {
		 Node current = root;
		 while(current!=null) {
			 if(current.data == id) {
				 return true;
			 }
			 if(current.data > id) {
				 current = current.left;
			 } else {
				 current = current.right;
			 }
		 }
		 return false;
	 }
	 public Node getSuccessor(Node delNode) {
		 Node successor = null;
		 Node successorp = null;
		 Node current = delNode.left;
		 while(current!=null) {
			 successorp = successor;
			 successor = current;
			 current = current.right;
		 }
		 if(successor != delNode.left) {
			 successorp.right = successor.left;
			 successor.left = delNode.left;
		 }
		 
		 return successor;
	 }
	 public boolean delete(int id) {
		 Node parent = root;
		 Node current = root;
		 boolean isLeftChild = false;
		 while(current.data!=id) {
			 parent = current;
			 if(current.data > id) {
				 current = current.left;
				 isLeftChild = true;
			 } else {
				 current= current.right;
				 isLeftChild = false;
			 }
			 if (current==null) {
				 return false;
			 }
		 }
		 
		 if(current.left == null & current.right == null) {
			 if(current==root) {
				 root = null;
			 } 
			 if(isLeftChild) {
				 parent.left = null;
			 } else {
				 parent.right = null;
			 }
		 } else if (current.right == null) {
			 if(current == root) {
				 root  = current.left;
			 }
			 if(isLeftChild) {
				 parent.left = current.left;
			 } else {
				 parent.right = current.left;
			 }
		 } else if (current.left == null) {
			 if(current==root) {
				 root = current.right;
			 } else if(isLeftChild) {
				 parent.left = current.right;
			 } else {
				 parent.right = current.right;
			 }
		 } else if(current.left != null && current.right!=null) {
			 Node scr = getSuccessor(current);
			 if(current == root) {
				 root = scr;
			 } else if (isLeftChild) {
				 parent.left = scr;
			 } else {
				 parent.right= scr;
			 }
			 scr.right = current.right;
		 }
		 return true;
		 
		 
		 
		 
		 
	 }
	 public void insert(int id) {
		 Node newNode = new Node(id);
		 if(root==null) {
			 root = newNode;
			 return;
		 }
		 Node current = root;
		 Node parent = null;
		 while(true) {
			 parent = current;
			 if(id<current.data) {
				 current= current.left;
				 if(current == null) {
					 parent.left = newNode;
					 return;
				 }
			 } else {
				 current = current.right;
				 if(current == null) {
					 parent.right = newNode;
					 return;
				 }
			 }
			 
		 }
		 
	 }
	 public void display(Node root,int lv) {
		 if(root!=null) {
			 display(root.left,lv+1);
			 System.out.print(" (" +root.data + "," + lv + ")");
			 display(root.right,lv+1);
		 }
	 }
	 public static void main(String args[]) {
		 binarySearchTree b = new binarySearchTree();
		 b.insert(3);b.insert(8);
		 b.insert(1);b.insert(5);b.insert(9);b.insert(10);b.insert(20);b.insert(6);
		 b.delete(3);
		 b.display(b.root,0);
		 System.out.println(b.find(3));
	 }
}
