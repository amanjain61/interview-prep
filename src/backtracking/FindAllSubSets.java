package backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubSets {

  public static void main(String args[]){
    int[] arr = {1,2,3,4};
    List<List<Integer>> result= new ArrayList<List<Integer>>();
    backTrackForSubsets(0,arr,new ArrayList<Integer>(),result);
    for(List list:result){
      System.out.println(list.toString());
    }
  }

  public static void backTrackForSubsets(int curr_ind,int[] arr, List<Integer> subset,List<List<Integer>> result){
      if(curr_ind==arr.length){
        result.add(subset);
        return;
      }
    //don't include current value in subset
    backTrackForSubsets(curr_ind+1,arr,new ArrayList<>(subset),result);
    //include the curr value in subset
    subset.add(arr[curr_ind]);
    backTrackForSubsets(curr_ind+1,arr,new ArrayList<>(subset),result); // why new ArrayList<>(subset)????
  }

}
