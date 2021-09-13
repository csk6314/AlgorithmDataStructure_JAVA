package divideAndConquer;

import java.io.*;

public class stars1 {
	static char box[][];

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		box = new char[N][N];
		makeStar(0,0,N/3,false);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(box[i][j]);
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

	static void makeStar(int st_x, int st_y, int dv,boolean makeEmpty) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				
				if (dv == 1) {
					if (i == 1 && j == 1 || makeEmpty) {
						box[st_y + i][st_x + j] = ' ';
					}  else {
						box[st_y + i][st_x + j] = '*';
					}
				} else { 
					if(i==1 && j==1 || makeEmpty) {
						makeStar(st_x + j * dv, st_y + i * dv, dv / 3,true);
					}else {
					makeStar(st_x + j * dv, st_y + i * dv, dv / 3,false);
					}
				}
			}
		}
	}

}
