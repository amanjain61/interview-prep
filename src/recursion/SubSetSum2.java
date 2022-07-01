package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetSum2 {

  public static void getSubsetSum2(int index, int arr[],List<Integer> tempres,List<List<Integer>> finalRes){
    finalRes.add(new ArrayList<>(tempres));
    for(int i = index;i<arr.length;i++){
      if(i!=index && arr[i]==arr[i-1]) continue;
      tempres.add(arr[i]);
      getSubsetSum2(i+1,arr,tempres,finalRes);
      tempres.remove(tempres.size()-1);
    }
  }

  /**
   *
   *
   */

  public static void main(String args[]){

    int arr[] = {1,2,2,2,3,3};
    Arrays.sort(arr);
    List<List<Integer>> res = new ArrayList<>();
    getSubsetSum2(0,arr,new ArrayList<>(),res);
    for(List val:res){
      System.out.println(Arrays.toString(val.toArray()));
    }
  }

}
