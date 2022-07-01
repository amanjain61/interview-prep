package recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

  /** the problem gives an array with elements and a value k
   * we need to find the combinations from the array that would sum to k
   *
   *    ex: [2,3,6,7] ; k = 7
   *
   *   [2,2,3] => adding these values gives us the result 2+2+3 = 7;
   *   just this subsequence [7]  will give us the sum = 7
   *
   *   here, we can take the same element multiple times
  */

  // subsequence usually works behind the intuition of picking an element or not picking an element
  // in this case, of combination sum, we can also pick the same element multiple times
  // so, we also have to decide if we're going to pick the same element again
  //  or if we're going to move on to the next element.
  // the ususal code goes this way for finding a sum k
  public static void doCombinationSum(int i, int arr[], int arrLen, int target, List<Integer> res){
    if(i>arrLen){
      if(target==0){
        System.out.println(Arrays.toString(res.toArray()));
      }
      return;
    }

    /** we also need to add if we're going to repeat picking the same element or not
        ==>  this condition will depened based on the target t
        ==> if, the target becomes less than 0, we can't pick the same element
        ==> if the target is greater than 0, we can pick the same element and go on with the recursion
    */


    // pick an element
    if(arr[i] <= target){
      res.add(arr[i]);
      doCombinationSum(i,arr,arrLen,target-arr[i],res);
      res.remove(Integer.valueOf(arr[i]));
    }
    // don't pick the element

    doCombinationSum(i+1,arr,arrLen,target,res);
  }




  public static void main(String args[]){

    int arr[] = {2,3,6,7};
    int k = 7;
    doCombinationSum(0,arr,arr.length-1,k,new ArrayList<>());
  }
}
