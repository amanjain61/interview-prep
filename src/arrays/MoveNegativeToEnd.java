package arrays;

import java.util.Arrays;

public class MoveNegativeToEnd {

  public static void main(String[] args)
  {
    //int arr[] = {1, -1, 3, 2, -7, -5, 11, 6};
    int arr[] = {3,-2,5,-4,1,6};
    int n = 6;
    //bruteForce(arr,n);
    rightShiftValues(arr,n);
    System.out.println(Arrays.toString(arr));
  }

  public static void leftShiftElements(int[] arr, int start, int end){
    while(start < end){
      int temp = arr[start];
      arr[start] = arr[start+1];
      arr[start+1] = temp;
      start++;
    }

  }

  public static void rightShiftValues(int arr[], int n){
    int up = n-1;
    //setting the upper bound for storing negative elements
    while(arr[up]<0 && up>=0){
      System.out.println("Value of up is: "+up);
      up--;
    }
    for(int i=n-1;i>=0;i--){
      if(i< up && arr[i] < 0){
        leftShiftElements(arr, i, up);
        System.out.println(Arrays.toString(arr));
        up--;
      }
    }
  }

}
