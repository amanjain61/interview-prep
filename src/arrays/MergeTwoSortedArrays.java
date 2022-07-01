package arrays;

public class MergeTwoSortedArrays {

  public static void main(String args[]){
    int[] arr1 = {1,2,4};
    int[] arr2 = {1,3,4};
    int len = (arr1.length + arr2.length);
    int[] res = new int[len];
    int i=0;
    int j=0;
    int k=0;
    while(i<arr1.length  && j< arr2.length){
      if(arr1[i] < arr2[j]){
        res[k] = arr1[i];
        i++;
        k++;
      }else{
        res[k] = arr2[j];
        j++;
        k++;
      }
    }

    while(i<arr1.length){
      res[k] = arr1[i];
      i++;
      k++;
    }

    while(j< arr2.length){
      res[k] = arr2[j];
      j++;
      k++;
    }

    for(int l=0;l<k;l++){
      System.out.print(res[l]+" ");
    }

  }


}
