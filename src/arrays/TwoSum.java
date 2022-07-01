package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

  public static void main(String[] args){
    int[] nums = {3,3};
    int target = 6;
    int[] result = twoSum(nums, target);
    for (int i:result){
      System.out.print(i+" ");
    }
  }
  public static int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    Map<Integer,Integer> map = new HashMap<Integer, Integer>();
    for(int i=0;i<nums.length;i++){
      int bal = target-nums[i];
      if(map.containsKey(bal)){
        result[0] = i;
        result[1] = map.get(bal);
        return result;
      }
      map.put(nums[i],i);
    }
    return null;
  }
}
