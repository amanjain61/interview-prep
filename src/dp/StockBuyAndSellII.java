package dp;

import java.util.Arrays;

public class StockBuyAndSellII {

  /**
   *
   * @param index - specifies the current index
   * @param buy - specifies if we can buy on the given index - day or not
   * @return max profit
   */
  public static int findMaxProfit(int index, int buy,int[] prices,int dp[][]){
    int profit = 0;
    if(index>prices.length-1){
      return profit;
    }

    if(dp[index][buy]!=-1) return dp[index][buy];
    if(buy==1){
      // bought the stock so when we sell it we do sellprice - buyprice which is equals to( - buyprice + sellprice)
      int buyProfit = -prices[index] + findMaxProfit(index+1,0,prices,dp);
      // if we don't buy the stock on the given index day then we skip to the next day and do the same thing
      int noBuyProfit = 0 + findMaxProfit(index+1,buy,prices,dp);
      profit = Math.max(buyProfit,noBuyProfit);

    }else{
      int sellProfit = prices[index]  + findMaxProfit(index+1,1,prices,dp);
      int noSellProfit = 0 + findMaxProfit(index+1,buy,prices,dp);
      profit = Math.max(sellProfit,noSellProfit);
    }

    return dp[index][buy] = profit;
  }

  public static void main(String args[]){
    int[] prices = {1,5,3,7,4};
    int dp[][] = new int[prices.length+1][2];

    for(int i=0;i<dp.length;i++){
      dp[i][1] = dp[i][0] = -1;
      System.out.print("{"+dp[i][0]+" ,"+dp[i][1]+"} ");
    }
    System.out.println("\nMax profit is :: "+findMaxProfit(0,1,prices,dp));

    for(int i=0;i<dp.length;i++){
      System.out.print("{"+dp[i][0]+" ,"+dp[i][1]+"} ");
    }
  }
}
