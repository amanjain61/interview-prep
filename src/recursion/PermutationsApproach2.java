package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsApproach2 {

  /**
   * in this approach, we're not going to use the extra frequency/ element taken boolean that we use to keep the element in the first position
   *  ==> this approach swaps the elements to the first position and start traversing from there.
   */

  public static void swap(int i, int j, char[] arr){
    char temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void printPermutations(int index, char[] arr, List<List<Integer>> result){
    if(index>=arr.length){
//      System.out.println(Arrays.toString(arr));
      for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]);
      }
      System.out.print("\n");
      List res = Arrays.asList(arr);
      result.add(new ArrayList<>(res));
      return;
    }
    for(int i=index;i<arr.length;i++){
      swap(i,index,arr);
      printPermutations(index+1,arr,result);
      swap(i,index,arr);
    }
  }
  public static void main(String args[]){
    char num[] = {'a','m','a','n','j','a','i','n'};
    List<List<Integer>> result = new ArrayList<>();
    printPermutations(0,num,result);
  }

  /**
   * func(index,arr){
   *   if(index>=arr.len){
   *   add.to.permutation
   *     return;
   *   }
   *   for(int i=index;i<arr.len;i++){
   *   swap(i,index)
   *   func(index+1,arr);
   *   swap(i,index);
   * }
   */
}
