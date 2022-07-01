package recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {


  /**
   * the idea is to keep one item as fixed in every iteration and pick other item as the first item
   * ex: 1 2 3 4 --> in the first iteration keep 1 as fixed and pick it as the first item
   *    ==> then parse through all the other elements one by one and keep adding it to the result string
   *
   * ex: 1 2 3 4 --> in the second iteration keep 2 as fixed and pick it as the first item
   *    ==> then parse through all the other elements one by one and keep adding it to the result string
   *    [2 1 3 4], [2 1 4 3] , [2 3 1 4] , [2 3 4 1] , [2 4 1 3] , [2 4 3 1]
   */


  public static void findPermutations(int[] arr, List<Integer> tempAns,List<List<Integer>> result,boolean[] taken){

    if(tempAns.size() == arr.length){
      result.add(new ArrayList<>(tempAns));
      return;
    }

    for(int i=0;i<arr.length;i++){
      if(!taken[i]){
        taken[i] = true;
        tempAns.add(arr[i]);
        findPermutations(arr,tempAns,result,taken);
        taken[i] = false;
        tempAns.remove(Integer.valueOf(arr[i]));
      }
    }

  }

  public static void main(String args[]){

    int num[] = {1,2,3,4};
    boolean[] freq = new boolean[num.length];
    List<List<Integer>> result = new ArrayList<>();
    findPermutations(num,new ArrayList<>(),result,freq);
    for(List val:result){
      System.out.println(Arrays.toString(val.toArray())+ "  ");
    }
  }
}
