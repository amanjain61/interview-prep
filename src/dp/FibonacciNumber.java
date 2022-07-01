package dp;

import java.util.Arrays;

public class FibonacciNumber {

  // 0 1 2 3 4 5 6  7  8
  // 0 1 1 2 3 5 8 13 21
  public static int fibonacciByRecursion(int n,int[] arr){
    if(n<=1){
//      arr[n] = n;
      return n;
    }
    if(arr[n]!=-1){
      System.out.println("The value for "+n+" is "+arr[n]+"\n");
      return arr[n];
    }
    int l = fibonacciByRecursion(n-1,arr);
    arr[n-1] = l;
    int r = fibonacciByRecursion(n-2,arr);
    arr[n-2] = r;
    return  l+r;
  }
  public static void main(String args[]){

    int n=8;
    int arr[] = new int[n+1];
    Arrays.fill(arr,-1);
    System.out.println(" The "+n+" th number is " +fibonacciByRecursion(n,arr));
    System.out.println(Arrays.toString(arr));
  }

}
