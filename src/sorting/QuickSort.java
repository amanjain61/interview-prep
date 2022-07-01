package sorting;

import java.util.Arrays;

public class QuickSort {

  public static void main(String args[]){
    int arr[] = {8,3,4,7,5,1,2,7,9,0,6};
    Arrays.toString(arr);
    quickSort(arr,0,arr.length-1);
    System.out.println(Arrays.toString(arr));
  }

  public static void quickSort(int[] arr, int lb, int ub){
    if(lb<ub)
      System.out.println("Lower bound : "+lb+" Upper bound : "+ub+" going into the loop\n");
    else
      System.out.println("Lower bound : "+lb+" Upper bound : "+ub+" NOT GOING INTO the loop\n");

    if(lb<ub){
      System.out.println("Passing the whole array with lb : "+lb +" and ub : "+ub);
      int pos = partition(arr,lb,ub);
      System.out.println("Passing left array with pos as : "+pos);
      quickSort(arr,lb,pos-1);
      System.out.println("Passing right array with pos as : "+pos);
      quickSort(arr,pos+1,ub);
    }
  }

  public static void swap(int[] arr,int i,int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr,int i,int j){
    System.out.print("\n");
    for(;i<=j;i++){
      System.out.print(arr[i]+", ");
    }
  }
  public static int partition(int[] arr,int lb, int ub){
    // set the first element as pivot
    int pivot = lb;
    int start = lb;
    int end = ub;
    print(arr,lb,ub);
    System.out.println("\nCurr pivot pos : "+ pivot+" and value : "+arr[pivot]);
    System.out.println("Lower bound : "+lb+" and Upper bound : "+ub);

    //while start is less than end, even if they're both equal, we don't need to sort them
    while(start<end){
      //keep traversing until the values are lesser
      while( start <arr.length && arr[start]<=arr[pivot]){
        start++;
      }
      //keep traversing backward until the values are greater
      while(end >= 0 && arr[end]>arr[pivot]){
        end--;
      }

      //swap the start and end if start < end
      if(start<end)  { swap(arr,start,end); }
    }
    //swap the pivot with end element
    swap(arr,pivot,end);
    System.out.print("END is : "+end+" with Resultant Array: ");
    print(arr,lb,ub);
    System.out.println("\n--------------------------------------------\n");
    return end;
  }

}
