import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class travelsalofTree {
	static StringBuilder sb = new StringBuilder();
	static int[] postorder,inorder;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		postorder = new int[N];
		inorder = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			inorder[i] = Integer.parseInt(input[i]);
		}
		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			postorder[i] = Integer.parseInt(input[i]);
		}
		sort(0,N-1,0,N-1);
		System.out.println(sb.toString());
	}

	static void sort(int p_s,int p_e, int i_s,int i_e) {
		if(p_e<p_s || i_e<i_s) return;
		int root=postorder[p_e];
		sb.append(root + " ");
		int r_index = 0;
		for (int i = i_s; i < i_e+1; i++) {
			if (inorder[i] == root) {
				r_index = i;
				break;
			}
		}
		int left_num = r_index-i_s;
		sort(p_s,p_s+left_num-1,i_s,r_index-1);
		sort(p_s+left_num,p_e-1,r_index+1,i_e);

	}
}
