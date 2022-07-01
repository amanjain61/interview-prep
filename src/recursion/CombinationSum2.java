package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

  /**
   *  given a target find the combination of all unique elements that sums to the given target
   *  there shouldn't be duplicates
   */

  public static void combinationSumII(int index, int[] arr, int target, int arrLen, List<Integer> res){
    if(target==0){
      System.out.println(Arrays.toString(res.toArray()));
    }
    for(int i=index;i<=arrLen;i++){
      if(i > index && arr[i]==arr[i-1]) continue;
      if(arr[i] > target) return;

      res.add(arr[i]);
      combinationSumII(i+1,arr,target-arr[i],arrLen,res);
      res.remove(Integer.valueOf(arr[i]));
    }
  }



  public static void main(String args[]){
    int arr[] = {10,1,2,7,6,1,5};
    int target = 8;
    Arrays.sort(arr);
    combinationSumII(0,arr,target,arr.length-1,new ArrayList<>());

    int arr1[] = {1,1,1,2,2};
    target = 4;
    Arrays.sort(arr1);
    combinationSumII(0,arr1,target,arr1.length-1,new ArrayList<>());
  }

}
