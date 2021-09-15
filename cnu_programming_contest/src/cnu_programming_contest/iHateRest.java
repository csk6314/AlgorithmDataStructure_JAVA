package cnu_programming_contest;
import java.io.*;
public class iHateRest {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Long sons[] = new Long[N];
		Long moms[] = new Long[N];
		for(int i =0;i<N;i++) {
			String ip[] = br.readLine().split(" ");
			Long son = Long.parseLong(ip[0]);
			Long mom = Long.parseLong(ip[1]);
			long irred = gcd(son,mom);
			//�Է¹����� ���м�
			if(irred > 1) {
				son /= irred;
				mom /=irred;
			}
			sons[i] = son;
			moms[i] =mom;
		}
		long l = moms[0];
		long r_son = 0;
		//l�� �ּҰ���� 
		for(int i=1;i<N;i++) {
			long tmp = gcd(l,moms[i]);
			l = (l/tmp) * (moms[i]/tmp) * tmp;
			long m = l/moms[i];
			
		}
		//���� �ִ����� ���ϱ�
		for(int i=0;i<N;i++) {
			long m = l/moms[i];
			sons[i] *= m;
			if(i==0) {
				r_son = sons[0];
			} else {
			r_son = gcd(sons[i],r_son);
			}
		}
		
			
		System.out.println(r_son + " " + l);
		
	}
	static long gcd(long a,long b) {
		while(b>0) {
			long temp=a;
			a = b;
			b = temp%a;
		}
		return a;
	}
}
