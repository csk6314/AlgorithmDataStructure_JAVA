import java.util.*;
import java.io.*;

class tNode implements Comparable<tNode> {
	public int x;
	public int y;
	public int label;
	public tNode left;
	public tNode right;
	
	public tNode(int x,int y,int label) {
		this.x = x;
		this.y = y;
		this.label = label;
	}
	@Override
	public int compareTo(tNode target) {
		if(this.y == target.y) {
			if(this.x > target.x) return 1;
			else return -1;
		} else if(this.y<target.y) return 1;
		else return -1;
	}
	@Override
	public String toString() {
		return(this.x + " " + this.y + " \n");
	}
		
}
class BinaryTree {
	public tNode root;
	private tNode add(tNode target,tNode newtNode) {
		if(target == null) {
			return newtNode;
		}
		if(newtNode.x < target.x) {
			target.left = add(target.left,newtNode);
		} else {
			target.right = add(target.right,newtNode);
		}
		return target;
	}
	public BinaryTree(List<tNode> nodes) {
		nodes.forEach(i->root=add(root,i));
	}
	public void preorder(tNode node) {
		if(node == null) return;
		System.out.print(node.label + " ");
		preorder(node.left);
		preorder(node.right);
	}
	public void postorder(tNode node) {
		if(node==null) return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.label + " ");
	}
}
public class tranverseXY {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<tNode> input = new ArrayList<>();
		int label=1;
		
		for(int i =0;i<n;i++) {
			String[] xy = br.readLine().split(" ");
			input.add(new tNode(Integer.parseInt(xy[0]),Integer.parseInt(xy[1]),label++));
		}
		
		Collections.sort(input);
		input.forEach(xy->System.out.print(xy));
		System.out.println();
		
		BinaryTree tree = new BinaryTree(input);
		tree.preorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);
		System.out.println();
		
	}

}
