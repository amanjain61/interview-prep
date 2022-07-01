package dp;

public class
KnapsackProblem {

  static void findMaxValue(int index,int maxSoFar,int currWt,
      int wt[],int val[],int W,int[] res){
    if(currWt>W) return;
    if(index>wt.length-1){
      if(currWt<=W && res[0] < maxSoFar){
        res[0] = maxSoFar;
      }
      return;
    }
    if(currWt<=W && res[0] < maxSoFar){
      res[0] = maxSoFar;
    }
    maxSoFar += val[index];
    currWt += wt[index];
    // val = 1 ; wt = 4
    findMaxValue(index+1,maxSoFar,currWt,wt,val,W,res);

    maxSoFar -= val[index];
    currWt -= wt[index];
    // val = 0,wt = 0, res[0] = 1
    findMaxValue(index+1,maxSoFar,currWt,wt,val,W,res);

  }

  public static void main(String args[]){
    int[] wt = {4,5,1};
    int[] val = {1,2,3};
    int W = 4;
    int[] res = new int[1];
    findMaxValue(0,0,0,wt,val,W,res);
    System.out.println("the result is :: "+res[0]);
  }


}
