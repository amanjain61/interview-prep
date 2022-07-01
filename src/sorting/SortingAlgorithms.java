package sorting;

public class SortingAlgorithms {
  public static void main(String args[]){
    int[] array = {3,5,2,1,6,4,10,8,7,9};
    int[] array1 = {1,2,3,4,5,6,7,8,9,10};

    int[] array2 = {5 ,4 ,2 ,5 ,3 ,1};

    int[] twoSortedSubArrays = {1,3,5,6,8,9,0,2,4,7};
//    bubbleSort(array1);
//    selectionSort(array);
//    insertionSort(array);


    int[] arr = {4 ,2 ,5 ,3};
    mergeSort(arr,0,arr.length-1);
    print(arr);

//    mergeTwoSortedSubArrays(twoSortedSubArrays,5,0,twoSortedSubArrays.length-1);
//    print(twoSortedSubArrays);
  }

  public static void insertionSort (int[] arr) {
    long l = 1l;
    int a = (int)l;
    for(int i=1;i<arr.length;i++){
      int j=i;
      while(j>0 && arr[j] < arr[j-1]){
        swap(arr,j,j-1);
        j--;
      }
    }
  }

  public static void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  /**
   * Bubble sort - O(N^2)
   * @param array
   */
  public static void bubbleSortWrongImplementation(int[] array){
    int loopCount = 0;
    for(int i=0;i<array.length;i++){
      for(int j=i+1;j<array.length;j++){
        loopCount++;
        if(array[i] > array[j]){
          int temp = array[i];
          array[i] = array[j];
          array[j] = temp;
        }
      }
    }
    System.out.println("LOOP COUNT :: "+loopCount);
    print(array);
  }

  public static void bubbleSort(int[] array){
    int len = array.length;
    for(int i=0;i<len;i++){
      boolean swapped = false;
      for(int j=0;j< len - i -1 ;j++){
        if(array[j] > array[j+1]){
          swapped= true;
          int temp = array[j];
          array[j] = array[j+1];
          array[j+1] = temp;
        }
      }
      if(!swapped) break;
    }
    print(array);
  }

  /**
   * selection sort finds the minimum element and keeps placing it in the beginning of the array
   */
  public static void selectionSort(int[] arr){
    for(int i=0;i<arr.length-1;i++){
    int minIndex = i;
      for(int j=i+1;j<arr.length;j++){
        if(arr[j]<arr[minIndex]){
          minIndex = j;
        }
      }
      int temp = arr[i];
      arr[i] = arr[minIndex];
      arr[minIndex] = temp;
    }
    print(arr);
  }

  public static void print(int[] arr){
    System.out.print("[");
    for(int item:arr){
      System.out.print(item+ ",");
    }
    System.out.print("]\n");
  }

  public static void sort(int arr[], int l, int r)
  {
    if (l < r) {
      // Find the middle point
      int m =l+ (r-l)/2;

      // Sort first and second halves
      sort(arr, l, m);
      sort(arr, m + 1, r);

      // Merge the sorted halves
      merge(arr, l, m, r);
    }
  }

  public static void mergeSort(int[] arr, int l, int r){
    if(l<r){

      int mid = l+ (r-l)/2;

      mergeSort(arr, l,mid);
      mergeSort(arr, mid+1,r);
      mergeTwoSortedSubArrays(arr,mid,l,r);
    }
  }

  public static void mergeTwoSortedSubArrays(int[] arr, int mid, int l, int r){
    int arr1 = l;
    int arr2 = mid+1;
    int[] res = new int[r-l+1];
    int resInd = 0;
    while(arr1 <=mid && arr2 <=r){
        if(arr[arr1] < arr[arr2]){
          res[resInd] = arr[arr1];
          arr1++; resInd++;
        }else{
          res[resInd] = arr[arr2];
          arr2++;resInd++;
        }
    }
    while(arr1<=mid){
      res[resInd] = arr[arr1];
      arr1++; resInd++;
    }
    while(arr2<=r){
      res[resInd] = arr[arr2];
      arr2++;resInd++;
    }
    for(int i=l,j=0;i<=r;i++,j++){
      arr[i] = res[j];
    }
  }

  public static void merge(int arr[], int l, int m, int r)
  {
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    /* Create temp arrays */
    int L[] = new int[n1];
    int R[] = new int[n2];

    /*Copy data to temp arrays*/
    for (int i = 0; i < n1; ++i)
      L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = arr[m + 1 + j];

    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarray array
    int k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      }
      else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    /* Copy remaining elements of L[] if any */
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    /* Copy remaining elements of R[] if any */
    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }

}
