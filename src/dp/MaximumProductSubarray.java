package dp;

public class MaximumProductSubarray {

  // keep a max and min at every index
  // multiply the current index value with max and min
  // if any of these values exceeds the max value then update the max value


  public static int findMaximumProductSubarray(int arr[]){
    if(arr.length==0) return 0;
    if(arr.length==1) return arr[0];
    int min = arr[0];
    int max = arr[0];
    int res = Integer.MIN_VALUE;

    for(int i=1;i<arr.length;i++){
      int min_prod = arr[i] * min;
      int max_prod = arr[i] * max;

      min = min_prod>max_prod?min_prod:max_prod;
      if(arr[i] < min_prod) min = arr[i];
      max = min_prod<max_prod?min_prod:max_prod;
      if(arr[i] > max_prod) max = arr[i];

      if(max > res) res = max;

    }
    return res;
  }

  public static void main(String args[]){

    int[] arr = {-1,-3,10,0,60};
    System.out.println("The max product subArray is :: "+findMaximumProductSubarray(arr));

  }
}
