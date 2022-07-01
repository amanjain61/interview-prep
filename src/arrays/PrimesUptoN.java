package arrays;

import java.util.ArrayList;
import java.util.List;

public class PrimesUptoN {

  public static void main(String arg[]) {
    List<Integer> res = new ArrayList<Integer>();
    int n=5;
    for(int i=2;i<=n;i++){

      int limit = i/2;

      System.out.println("CHECK PRIME for i =  "+i+" % "+limit);

      boolean isPrime = true;

      while(limit > 1){

        System.out.println("CHECK PRIME for i =  "+i+" % "+limit);

        if(i % limit == 0){
//          System.out.println(" NOT A PRIME for i =  "+i+" % "+limit);
          isPrime = false;
          break;
        }
        limit--;
      }
      if(isPrime){
        res.add(i);
      }
    }

    System.out.println(res);
  }
}
