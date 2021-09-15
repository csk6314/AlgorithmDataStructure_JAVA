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
		// �Ÿ� �� �湮��Ȳ �ʱ�ȭ
		for (int i = 0; i < N; i++) {
			d[i] = Integer.MAX_VALUE;
			check[i] = false;
		}
		// ���� (����) �ʱ�ȭ
		for (int i = 0; i < M; i++) {
			ip = br.readLine().split(" ");
			int st = Integer.parseInt(ip[0]);
			int ed = Integer.parseInt(ip[1]);
			int roadDistance = Integer.parseInt(ip[2]);

			adj[st][ed] = roadDistance;
			adj[ed][st] = roadDistance;
		}

		// ���ͽ�Ʈ�� ��� ~> �� ������ �ּڰ� ���ϱ�
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
			// �ִܰŸ��� �ִ� ���� �ε����� �Ÿ� ���ϱ�. (�湮 X)
			long min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				if (d[i] < min && !check[i]) {
					min = d[i];
					idx = i;
				}
			}
			// idx�� ������ִ� ���� �ִܰŸ� �ʱ�ȭ
			for (int i = 0; i < N; i++) {
				if (i == idx)
					continue;
				if (!check[i] && adj[idx][i] != 0 && d[i] > d[idx] + adj[idx][i]) {
					d[i] = d[idx] + adj[idx][i];
				}
			}
			// ������ �������� üũ.
			check[idx] = true;
		}

	}
}

