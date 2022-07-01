package dp;

public class HouseRobberIteration {

  public static int max(int i, int j){
    return i>j?i:j;
  }
  public static void main(String args[]){
    int[] arr = {2,7,9,3,1};
    int[] dp = new int[arr.length];
    dp[0] = arr[0];
    dp[1] = max(arr[0],arr[1]);
    for(int i=2;i<arr.length;i++){
      dp[i] = max((arr[i]+dp[i-2]) , dp[i-1]);
    }
    for(int i=0;i<arr.length;i++)
    System.out.println("best val at "+i+" is :: "+dp[i]);
  }

}
