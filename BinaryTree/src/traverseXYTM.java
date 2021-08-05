import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.io.*;

class tmNode implements Comparable<tmNode> {
	public int x;
	public int y;
	public int label;
	public tmNode left;
	public tmNode right;
	
	public tmNode(int x,int y,int label) {
		this.x = x;
		this.y = y;
		this.label = label;
	}
	@Override
	public int compareTo(tmNode target) {
		if(this.y == target.y) {
			if(this.x > target.x) return 1;
			else return -1;
		} else if(this.y<target.y) return 1;
		else return -1;
	}
	@Override
	public String toString() {
		return(this.x + " " + this.y + " [" + this.label + "]\n");
	}
}
class tmBinaryTree {
	public tmNode root;
	
	private tmNode add(tmNode target,tmNode newtmNode) {
		if(target==null) {
			return newtmNode;
		}
		if(newtmNode.x < target.x) {
			target.left = add(target.left,newtmNode);
		} else {
			target.right = add(target.right,newtmNode);
		}
		return target;
	}
	public tmBinaryTree(TreeMap<tmNode,Integer> nodes) {
		for(Map.Entry<tmNode, Integer> entry : nodes.entrySet()) {
			tmNode key = entry.getKey();
			Integer value = entry.getValue();
			root = add(root,key);
			
		}
	}
	public void preorder(tmNode node) {
		if(node == null) return;
		System.out.print(node.label + " ");
		preorder(node.left);
		preorder(node.right);
	}
	public void postorder(tmNode node) {
		if(node==null) return;
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.label + " ");
	}
}
public class traverseXYTM {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		TreeMap<tmNode,Integer> input = new TreeMap<>();
		int label=1;
		
		for(int i =0;i<n;i++) {
			String[] xy = br.readLine().split(" ");
			input.put(new tmNode(Integer.parseInt(xy[0]),Integer.parseInt(xy[1]),label),label++);
		}
		

		for(Map.Entry<tmNode,Integer> entry : input.entrySet()) {
			System.out.print(entry.getKey());
		}
		
		tmBinaryTree tree = new tmBinaryTree(input);
		tree.preorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);
		System.out.println();
		
	}

}
