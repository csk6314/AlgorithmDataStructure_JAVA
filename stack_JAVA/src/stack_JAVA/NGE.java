package stack_JAVA;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class NGE {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt = Integer.parseInt(br.readLine());
		
		int[] b= new int[cnt];
		
		cnt = 0;
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
			b[cnt] = Integer.parseInt(st.nextToken());
			cnt++;
		}
		
		getNGE(b);
		
	}
	static void getNGE(int[] a) throws IOException{
		int[] ary = a;
		Stack<Integer> stack = new Stack<Integer>();
		int[] result = new int[ary.length];
		
		stack.push(0);
		for(int i=1;i<a.length;i++) {
			while(!stack.isEmpty() && a[i] > a[stack.peek()] ) {
				result[stack.pop()] = a[i];
				
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			result[stack.pop()] = -1;
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i =0;i<ary.length;i++)
			bw.write(result[i] + " ");
		bw.flush();
		
	}
}
