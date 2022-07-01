package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

  private static int max(int x,int y){
    return x>y?x:y;
  }

  public static void main(String args[]){
    int[] arr = { 10,9,2,5,3,7,101,18};
//    int[] arr = {0,1,0,3,2,3};
    int[] res = new int[arr.length];

  for(int i=0;i<res.length;i++){
    res[i] = 1;
  }
    for(int i=1;i<arr.length;i++){
      for(int j=0;j<i;j++){
        if(arr[j]<arr[i]){
         res[i] = max(res[j]+1 , res[i]);
        }
      }
    }
    for(int i=0;i<res.length;i++){
      System.out.print(res[i] + " ,");
    }
    System.out.println("");
    Arrays.sort(res);

    System.out.println(res[res.length-1]);

  }
}
