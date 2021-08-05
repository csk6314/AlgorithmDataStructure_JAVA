import java.io.*;
import java.util.*;
//시간=거리/속도
public class prob3 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input[] = br.readLine().split(" ");
        int count = Integer.parseInt(input[0]);
        int totalLength= Integer.parseInt(input[1]);
        ArrayList<Car> list = new ArrayList<>();
        for(int i=0;i<count;i++){
            input = br.readLine().split(" ");
            list.add(new Car(Integer.parseInt(input[0]),Integer.parseInt(input[1]),totalLength));
        }
        Collections.sort(list);
        int group=1;
        long groupt = list.get(0).t;
        Iterator<Car> iter = list.iterator();
        while(iter.hasNext()){
            Car temp = iter.next();
            if(groupt<temp.t){
                group++;
                groupt=temp.t;
            }
        }
        bw.write(String.valueOf(group));
        bw.close();
    }
}

class Car implements Comparable<Car>{
    int p,v;
    int totalLength;
    long t;
    int thisLength;
    public Car(int p, int v,int totalLength){
        this.p=p;
        this.v=v;
        this.totalLength=totalLength;
        this.thisLength=totalLength-p;
        this.t = Math.round(thisLength/(double)v);
    }
    @Override
    public int compareTo(Car o) {
       if(this.p>o.p){
           return -1;
       }else if(this.p<o.p){
           return 1;
       }else{
           return 0;
       }
    }

    
}