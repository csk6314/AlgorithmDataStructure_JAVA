import java.io.*;
import java.util.*;
public class OverTake {
	static class start_end{
		int start,end;
		public start_end(int start,int end) {
			this.start =start;
			this.end =end;
		}
	}
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String,start_end> map = new HashMap<String,start_end>();
		int N = Integer.parseInt(br.readLine());
		for(int i =0;i<N;i++) {
			map.put(br.readLine(),new start_end(i,0));
		}
		int cnt=0;
		for(int i=0;i<N;i++) {
			String name = br.readLine();
			map.put(name,new start_end(map.get(name).start,i));
		}
		for(Map.Entry<String,start_end> ent:map.entrySet()) {
			for(Map.Entry<String,start_end> ent2:map.entrySet()) {
				if(ent.getValue().start>ent2.getValue().start && ent.getValue().end < ent2.getValue().end) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);	
	}
}
