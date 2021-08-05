import java.util.*;
import java.io.*;

public class aaa {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("index.txt"));
      String str;
      String mostWord = null;
      int numBig = 1;
      int[] whrLine = new int[100];
      int arrNum = 0;
      int arrLine = 1;
      Map<String, Integer> map = new HashMap<>();
      
      while ((str = br.readLine()) != null) {
         boolean isBig = false;
         String[] line = str.split(" "); 
         for (int i = 0; i < line.length; i++) {
            String tmpstr = line[i].toLowerCase();
            if(!map.containsKey(tmpstr)) {
               map.put(tmpstr, 1);
            }else {
               int tmp = map.get(tmpstr)+1;
               map.put(tmpstr, tmp);
               if(numBig < tmp) {
                  numBig = tmp;
                  mostWord = tmpstr;
                  isBig = true;
               }
            }
         }
         if(isBig) {
            whrLine[arrNum++] = arrLine;
         }
         arrLine++;
      }
      System.out.print(mostWord + " ");
      for(int i = 0; i < arrNum; i++) {
         System.out.print(whrLine[i] + " ");
      }
   }
}