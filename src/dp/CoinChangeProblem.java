package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CoinChangeProblem {


  /**
   *
   * PICK, NO-PICK
   * func(index,arr,target){
   *   if(index==0){
   *     if target%arr[index==0]? 1 : 0;
   *   }
   * }
   *
   */

  public static int findNoOfWays(int index, int[] arr, int target, int[][] dp){
    if(index==0){

      dp[index][target]=(target%arr[index]==0)?1:0;
      System.out.println("The answer at dp["+index+"]["+target+"] is :: "+dp[index][target]);
      return dp[index][target];
    }
    if(dp[index][target]!=-1) {
      System.out.println("Returning pre-stored-value dp["+index+"]["+target+"] is :: "+dp[index][target]);
      return dp[index][target];
    }

    int take = 0;
    if(arr[index]<=target){
      take = findNoOfWays(index,arr,target-arr[index],dp);
    }

    int noTake = findNoOfWays(index-1,arr,target,dp);

    dp[index][target] = take + noTake;
    System.out.println("The answer at dp["+index+"]["+target+"] is :: "+dp[index][target]);
    return dp[index][target];
  }

  /**
   * given a set of coins and a number,
   * find out the minumum number of coins would be needed to sum and equal to the given number
   */

  public static void coinChangeProblemSolution(int index, int target, int arr[],
      List<Integer> tempres,int dp[]){

    if(index>arr.length-1){
      if(target==0){
        System.out.println(Arrays.toString(tempres.toArray()));
      }
      return;
    }
    if(arr[index] <= target){
      tempres.add(arr[index]);
      //pick the same element
      coinChangeProblemSolution(index, target-arr[index],arr,tempres,dp);
      tempres.remove(Integer.valueOf(arr[index]));
    }

    coinChangeProblemSolution(index+1, target,arr,tempres,dp);
  }

  public static void main(char args[]){
    System.out.println("asas");
  }

  public static void main(String args[]){

    int[] arr = {1,2,3};
    int target = 7;
//    coinChangeProblemSolution(0,target,arr,new ArrayList<>(),arr);

    int[][] dp = new int[arr.length][target+1];
    for(int i=0;i<arr.length;i++)
      for(int j= 0;j<target+1;j++)
        dp[i][j] = -1;
    System.out.println("no.of.ways :: "+findNoOfWays(arr.length-1,arr,target,dp));
  }

}
