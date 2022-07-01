package dailyhunt;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMIssingNaturalNUmber {

  public static void main(String args[]){
    int[] arr = {-1,2,5,-12,9,1,14,-8,-3};
    int j = arr.length-1;
    while(arr[j]<0){
      j--;
    }
// 14,-12,9,1,-1,-8,-3
// 14,1,9,-12,-1,-8,3
    int i=0;
    while(i<j){
      if(arr[i]<0 && i<j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j--;
      }
      i++;
    }
    System.out.println(Arrays.toString(arr));
    for(int k=0;k<=i;k++){

      int index = Math.abs(arr[k]);
      if(index < arr.length && index>0){
        arr[index-1]=  -arr[index-1];
      }
    }
    for(int k=0;k< arr.length;k++){
      if(arr[k]>0){
        System.out.println("The missing number is "+(k+1));
        break;
      }
    }
    //
    System.out.println(Arrays.toString(arr));
    Map map = new HashMap();
  }
}
