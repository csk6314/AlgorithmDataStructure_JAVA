package divideAndConquer;

import java.io.*;

public class QuadTree {
	static int data[][];
	
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		for(int i =0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<N;j++) {
				char ch = s.charAt(j);
				int value = ch-'0';
				data[i][j]=value;
			}
		}
		print_compress(0,0,N/2);
		System.out.println(sb.toString());
		
	}
	static void compress(int st_x,int st_y,int dv) {
		for(int i =0;i<2;i++) {
			for(int j=0;j<2;j++) {
				int st_dx = st_x + j*dv;
				int st_dy = st_y + i*dv;
				if(dv==1) {
						sb.append(data[st_dy][st_dx]);
				} else {
				print_compress(st_dx,st_dy,dv/2);
				}
			}
		}
	}
	static void print_compress(int st_x,int st_y,int dv) {
		sb.append("("); 
		compress(st_x,st_y,dv);
		// 0000 or 1111반복시 괄호 및 숫자 제거 후 추가
		//git testtest2
		if(sb.substring(sb.length()-4, sb.length()).equals("0000")) {
			sb.delete(sb.length()-5, sb.length());
			sb.append("0");
		} else if(sb.substring(sb.length()-4, sb.length()).equals("1111")) {
			sb.delete(sb.length()-5, sb.length());
			sb.append("1");
		} else {
			sb.append(")");
		}
	}
}
