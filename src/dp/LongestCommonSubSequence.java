package dp;

public class LongestCommonSubSequence {

  /**
   * index will start with the length of the string i.e., ind1 = s1.length() -1 and ind2 = s2.length() -1
   */

  public static int findLongesetCommonSubsequence(int ind1,int ind2,String s1,String s2,int[][] dp){

    if(ind1<0 || ind2<0) return 0;
    if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
    // if matched, add 1 to the result and move to the next index
    if(s1.charAt(ind1)==s2.charAt(ind2)){
      return dp[ind1][ind2] =  1+  findLongesetCommonSubsequence(ind1-1, ind2-1,s1,s2,dp);
    }else {
      return dp[ind1][ind2] = Math.max(findLongesetCommonSubsequence(ind1 - 1, ind2, s1, s2, dp)
          , findLongesetCommonSubsequence(ind1, ind2 - 1, s1, s2, dp));
    }
  }

  /**
   *
   * Rules :
   *
   *  1. Copy the base case
   *  2. Write the changing parameters in opposite fashion
   *  3. copy the recurrence
   *
   * @return
   */
//  public static int tabulationMethod(){
//
//  }

  public static void main(String args[]){
    String s1 = "abc";
    String s2 = "adbcdabc";
    int[][] dp = new int[s1.length()][s2.length()];
    for(int i=0;i<s1.length();i++) {
      for (int j = 0; j < s2.length(); j++){
        dp[i][j] = -1;
      }
    }
    int lcs = findLongesetCommonSubsequence(s1.length()-1,s2.length()-1,s1,s2,dp);
    System.out.println("the findLongesetCommonSubsequence is :: "+lcs);

  }

}
