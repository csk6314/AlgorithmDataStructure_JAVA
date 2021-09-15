package cnu_programming_contest;

import java.io.*;
import java.util.Arrays;

public class riceCake {
	static int adj[][];
	static long d[];
	static boolean check[];
	static int N, M;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ip[] = br.readLine().split(" ");
		N = Integer.parseInt(ip[0]);
		M = Integer.parseInt(ip[1]);
		int X = Integer.parseInt(ip[2]);
		int Y = Integer.parseInt(ip[3]);

		adj = new int[N][N];
		d = new long[N];
		check = new boolean[N];
		// 거리 및 방문현황 초기화
		for (int i = 0; i < N; i++) {
			d[i] = Integer.MAX_VALUE;
			check[i] = false;
		}
		// 간선 (도로) 초기화
		for (int i = 0; i < M; i++) {
			ip = br.readLine().split(" ");
			int st = Integer.parseInt(ip[0]);
			int ed = Integer.parseInt(ip[1]);
			int roadDistance = Integer.parseInt(ip[2]);

			adj[st][ed] = roadDistance;
			adj[ed][st] = roadDistance;
		}

		// 다익스트라 사용 ~> 각 집들의 최솟값 구하기
		dijk(Y);

		//
		Arrays.sort(d);
		boolean FLAG = false;
		if(d[N-1]*2 > X) {
			System.out.println(-1);
		} else {
			int res=1;
			int cango=X;
			for(int i =0;i<N;i++) {
				if(cango<d[i]*2) {
					cango=X;
					res++;
					cango-=d[i]*2;
				} else {
					cango-=d[i]*2;
				}
			}
			System.out.println(res);
		}
	}

	static void dijk(int start) {
		d[start] = 0;
		int idx = -1;
		for (int j = 0; j < N - 1; j++) {
			// 최단거리에 있는 집의 인덱스와 거리 구하기. (방문 X)
			long min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				if (d[i] < min && !check[i]) {
					min = d[i];
					idx = i;
				}
			}
			// idx와 연결되있는 집들 최단거리 초기화
			for (int i = 0; i < N; i++) {
				if (i == idx)
					continue;
				if (!check[i] && adj[idx][i] != 0 && d[i] > d[idx] + adj[idx][i]) {
					d[i] = d[idx] + adj[idx][i];
				}
			}
			// 볼일이 끝났으니 체크.
			check[idx] = true;
		}

	}
}

