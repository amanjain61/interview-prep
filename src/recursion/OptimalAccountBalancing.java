package recursion;

public class OptimalAccountBalancing {

  /**
   * the problem statement is to balance the transactions between different people with minumum number of transactions
   * - basically splitvise algorithm to settle all balances between people
   */

  public static int findMinTransaction(int index,int[] balances){
    if(index == balances.length) return 0;
    int curr = balances[index];
    if(curr == 0 ) return findMinTransaction(index+1,balances);

    int min = Integer.MAX_VALUE;
    for(int i=index+1;i<balances.length;i++){
      int next = balances[i];
      if(next * curr<0){
        balances[i] = curr+next;
        min = Math.min(min,1+findMinTransaction(index+1,balances));
        balances[i]=next;
        if(curr+next == 0) break;
      }
    }
    return min;
  }

  public static void main(String args[]){

    // it can be broken into a sub problem where
    //  Given two arrays array POS with positive numbers and array NEG with negative numbers,
    // find the minimum number of transactions requried to make all the numbers to 0 in both arrays
    // given that the sum of values in the pos array + the sum of negative values in the neg array will always return 0


    int[] balances = {10,2,4,-12,-4}; // min 3
    int[] neg = {-12,-4,};

    System.out.println("Minimum transactions required :: "+findMinTransaction(0,balances));
// 1. index
// 2. possibility on the given index
// 3. take the best among them




  }
}
