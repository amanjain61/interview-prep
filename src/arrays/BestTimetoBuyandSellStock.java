package arrays;

public class BestTimetoBuyandSellStock {

  public static void main(String[] args){
    int[] prices = {7,1,5,3,6,4};
    int[] prices1 = {7,6,4,3,1};


    prices = new int[]{7,1,5,3,6,4};
    System.out.println(maxProfit(prices));
    System.out.println(maxProfit(prices1));
  }

  public static int maxProfit(int[] prices) {
    int buyPrice = prices[0];
    int profit = 0;
    for(int i=1;i<prices.length;i++){
      if(prices[i]<buyPrice){
        buyPrice = prices[i];
      }else if((prices[i] - buyPrice) > profit){
        profit = (prices[i] - buyPrice);
      }
    }
    return profit;
  }
}
