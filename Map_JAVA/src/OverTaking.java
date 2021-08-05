import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OverTaking {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String,Integer> daesik = new HashMap<String,Integer>();
		HashMap<String,Integer> youngun = new HashMap<String,Integer>();
		int cnt = 0;
		for(int i = 1;i<=N;i++) {
			daesik.put(br.readLine(),i);
		}
		for(int i = 1;i<=N;i++) {
			youngun.put(br.readLine(),i);
		}

		for(String n : youngun.keySet()) {
			if(youngun.get(n) - daesik.get(n) <= 0) {
				cnt ++;
			} 
		}
		System.out.println(cnt);
		
	}
}
