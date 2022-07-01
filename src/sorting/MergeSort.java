package sorting;

public class MergeSort extends SortingAlgorithms{

  public static void main(String args[]){
    int[] arr = {3,4,10,9,2,8,1,5,6,7};
    int[] arr1 = {3,4,5,6,7};
    int[] arr2 = {1,2,8,9,10};
    mergeSort(arr,0,arr.length-1);
    print(arr);
//    towWayMergeSort(arr1,arr2);
  }

  public static void mergeSort(int[] arr,int l ,int r){
    if(l<r){
      int mid = l+(r-l)/2;
      mergeSort(arr,l,mid);
      mergeSort(arr,mid+1,r);
      merge(arr,l,mid,r);
    }
  }

  // 1,2,3,4,5,6,7,8,9,10 ; mid = 2 ; l =0 ; r = 4
  // mid - l = 2-0 = 2
  // r - mid = 4-2 = 2
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

  public static void towWayMergeSort(int[] arr1, int[] arr2){
    int[] arr = new int[((arr1.length)+(arr2.length))];
    int i=0;int j=0;int k=0;
      while(i<arr1.length && j<arr2.length){
        if(arr1[i]<arr2[j]){
          arr[k] = arr1[i];
          i++; k++;
        }else{
          arr[k] = arr2[j];
          j++; k++;
        }
      }
    for(;i<arr1.length;i++,k++){
      arr[k]=arr1[i];
    }
    for(;j<arr2.length;j++,k++){
      arr[k]=arr2[j];
    }
    print(arr);
  }
}
