package phonepe;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {

  /**
   * Example 1:
   * input : n=4  transactions = [[0,1,10],[1,0,1],[1,2,5],[2,0,5]]
   * Output: 1
   *
   * input : n=3  transactions = [[0,1,10],[1,0,1],[2,0,5]]
   * 0→ 10 - 1 -5⇒ 4
   * 1 → - 10  + 1 ⇒ -9
   * 2 → 5
   *
   * 1,0 ⇒ 4
   * 2,0 ⇒ 5
   * Gave = +
   * Gets = -ve
   *
   * 0 => 10 - 1 -5 => 4
   * 1 => -10 + 1  + 5 = -4
   * 2 => -5 + 5  =0;
  */
  public static void main(String args[]){


      int n = 4;
      int[][] transactions = new int[n][3];
    transactions = new int[][]{{0, 1, 10}, {1, 0, 1}, {1, 2, 5}, {2, 0, 5}};
    Map<Integer,Integer> map = new HashMap<>();
    // map[0, 4],
    // map [1,-4]
    // map[2,0]
    // 0 ==> 4
    //
    int output = 0;
    for(int i=0;i<n;i++){

      int giver = transactions[i][0];
      int taker = transactions[i][1];
      int amount = transactions[i][2];
      System.out.println(giver+" "+taker+" "+amount);
      if(map.containsKey(giver)){
        map.put(giver,map.get(giver)+amount);
      }else{
        map.put(giver,amount);
      }
      if(map.containsKey(taker)){
        map.put(taker,map.get(taker)-amount);
      }else{
        map.put(taker,-amount);
      }
      System.out.println(map);
    }

    System.out.println(map);


    // 0 -> 0
    // 1 -> 0
    // 2 -->
    for(Entry<Integer,Integer> transaction:map.entrySet()){
      int tosettle = transaction.getValue();
      for(Entry<Integer,Integer> checkSettle:map.entrySet()){
        if(checkSettle.getKey()!=transaction.getKey() && (-checkSettle.getValue())>=tosettle){
          map.put(checkSettle.getKey(),checkSettle.getValue()+tosettle);
          map.put(transaction.getKey(),0);
          output++;
          break;
        }
      }

    }
    System.out.println("The output is "+output);


  }
}
