package recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetSum {


  public static Set powerSetToFindSubSetSum(int arr[]){
    /**
     * the idea is :
     * for each number from 0 --> (2^n -1) get all the set bits and make it a subset
     * [1,2,3]
     */

    Set<Integer> res = new HashSet<>();
    double n = Math.pow(2, arr.length);
    for(int i=0;i<n;i++){
      int sum  = 0;
        for(int j=0;j<arr.length;j++){
          if( (i & (1<<j))  > 0){
            sum +=arr[j];
          }
        }
        System.out.print(sum+" ");
      res.add(sum);
    }

    return res;
  }

  public static void subSetSum(int index, int arr[],int sum, Set<Integer> set){
    if(index >=arr.length){
      set.add(sum);
      return;
    }

    sum+=arr[index];
    subSetSum(index+1,arr,sum,set);

    sum-=arr[index];
    subSetSum(index+1,arr,sum,set);

    List<List<Integer>> as  = new ArrayList<List<Integer>>();
  }

  /**
   *
   * func(int index, int[]arr, tempres){
   *   if(index>=arr.len){
   *     add.to.subset
   *     return;
   *   }
   *
   *   tempres.add(arr[index])
   *   func(index+1,arr,tempres)
   *
   *   not pick
   *   tempres.remove(arr[index])
   *   func(index+1,arr,tempres)
   *
   * }
   *
   */


  public static void main(String args[]){

    Set<Integer> set = new HashSet<>();
    int arr[] = {1,2,5};
    subSetSum(0,arr,0,set);
    for(int val:set){
      System.out.print(val+" ,");
    }

    System.out.println(" ");
    set =  powerSetToFindSubSetSum(arr);

  }
}
