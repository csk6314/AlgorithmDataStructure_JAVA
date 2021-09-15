package cnu_programming_contest;

import java.io.*;


public class appleTree {
	static int box[][];
	static int pre[][];
	static int maxBenefit=Integer.MIN_VALUE;
	static int N;
	static int dx[] = {0,1,0,1};
	static int dy[] = {0,0,1,1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		box = new int[N][N];
		pre = new int[N][N];
		for(int i =0;i<N;i++) {
			String ip[] = br.readLine().split(" ");
			for(int j =0;j<N;j++) {
				int v =Integer.parseInt(ip[j]);
				box[i][j]=v;
				maxBenefit =Math.max(maxBenefit, v);
			}
		}
		setPreArray();
		getMax();
		System.out.println(maxBenefit);
		
	}
	static void setPreArray() {
		for(int i=0;i<N;i++) {
			if(i>0) {
				pre[i][0] = pre[i-1][0] + box[i][0];
			} else {
				pre[i][0] = box[i][0];
			}
		}
		for(int i=0;i<N;i++) {
			if(i>0) {
				pre[0][i] = pre[0][i-1] + box[0][i];
			} else {
				pre[0][i] = box[0][i];
			}
		}
		for(int i=1;i<N;i++) {
			for(int j=1;j<N;j++) {
				pre[i][j] = pre[i][j-1] + pre[i-1][j] -pre[i-1][j-1]+box[i][j];
			}
		}
		
	}
	static void getMax() {
		for(int i =1;i<N;i++) {
			//i=합 정사각형의 변의 길이 -1
			for(int j=i;j<N;j++) {
				for(int k = i;k<N;k++) {
					// j는 정사각형의 세로 왼쪽아래 꼭지점위치 ,
					// k는 왼쪽아래 가로 꼭지점위치
					int sum= 0;
					if(j-i>0 && k-i>0) {
						sum = pre[j][k] - pre[j][k-(i+1)] -pre[j-(i+1)][k]+pre[j-(i+1)][k-(i+1)];
					} else if(j-i>0) {
						sum = pre[j][k] - pre[j-(i+1)][k];
					} else if(k-i > 0) {
						sum = pre[j][k]-pre[j][k-(i+1)];
					} else {
						sum = pre[j][k];
					}
					maxBenefit= Math.max(sum, maxBenefit);				}
			}
		}
	}
	

}
