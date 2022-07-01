package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllSubSequences {


  public static int getCountOfSubsequenceWithSumK(int i,int arr[],int arrLength,int k, int sum){
    if(sum>k) return 0;
    if(i>arrLength){
        if(sum==k){
          return 1;
        }
        return 0;
    }
    sum+=arr[i];
    int l = getCountOfSubsequenceWithSumK(i+1,arr,arrLength,k,sum);
    sum-=arr[i];
    int r = getCountOfSubsequenceWithSumK(i+1,arr,arrLength,k,sum);
    return r+l;
  }

  public static void printSubsequenceWithSumKNoResArray(int i, int arr[],int arrLength,int k,int sum){
    if(sum>k) return;
    if(i>arrLength){
      if(sum==k)  {System.out.println("Sum exists ");}
      return;
    }
    sum+=arr[i];
    printSubsequenceWithSumKNoResArray(i+1,arr,arrLength,k,sum);
    sum-=arr[i];
    printSubsequenceWithSumKNoResArray(i+1,arr,arrLength,k,sum);
  }

  public static boolean printOnlyOneSubsequenceWithSumK(int i, int arr[],int arrLength, List<Integer> res,int k){
    if(i>arrLength){
      int sum = 0;
      for(int val:res){
        sum +=val;
      }
      if(sum==k)  {
        System.out.println(Arrays.toString(res.toArray()));
        return true;
      }
      return false;
    }
    res.add(arr[i]);
    if(printOnlyOneSubsequenceWithSumK(i+1,arr,arrLength,res,k)){
      return true;
    }
    res.remove(Integer.valueOf(arr[i]));
    if(printOnlyOneSubsequenceWithSumK(i+1,arr,arrLength,res,k)){
      return true;
    }
    return false;
  }

  public static void printSubsequenceWithSumK(int i, int arr[],int arrLength, List<Integer> res,int k){
    if(i>arrLength){
      int sum = 0;
      for(int val:res){
        sum +=val;
      }
      if(sum==k)  {System.out.println(Arrays.toString(res.toArray()));}
      return;
    }
    res.add(arr[i]);
    printSubsequenceWithSumK(i+1,arr,arrLength,res,k);
    res.remove(Integer.valueOf(arr[i]));
    printSubsequenceWithSumK(i+1,arr,arrLength,res,k);
  }

  public static void findSubSequences(int i, int arr[],int arrLength, List<Integer> res){

    if(i>arrLength){
      System.out.print(Arrays.toString(res.toArray())+"  ");
      return;
    }
    // take the current index
    res.add(arr[i]);
    findSubSequences(i+1,arr,arrLength,res);
    // remove the current idex
    res.remove(Integer.valueOf(arr[i]));
    findSubSequences(i+1,arr,arrLength,res);
  }
  public static void main(String args[]){
    int arr[] = {3,2,1};
    findSubSequences(0,arr,arr.length-1,new ArrayList<>());
    printSubsequenceWithSumK(0,arr,arr.length-1,new ArrayList<>(),3);
    printSubsequenceWithSumKNoResArray(0,arr,arr.length-1,3,0);
    printOnlyOneSubsequenceWithSumK(0,arr,arr.length-1,new ArrayList<>(),3);

    System.out.println("Total number of subsequences with sum K : "
        +getCountOfSubsequenceWithSumK(0,arr,arr.length-1,3,0));

  }

}
