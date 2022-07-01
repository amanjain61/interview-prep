package arrays;

public class SublistSearch {

  public static void main(String args[]){
    int[] res = {1,2,3,5};
    int[] arr = {5,2,1,2,3,1,2,3,4,5,1,2,4};

    int i=0;
    int j=0;

      while(i<res.length && j<arr.length){
        if(res[i] == arr[j]){
          i++;
          j++;
        }else{
          if(i>0 && j>0 && res[i-1]==arr[j-1]){
            i=0;
          }else{
            i=0;
            j++;
          }
        }
        if(i==res.length){
          System.out.println("Sublist exists");
          return;
        }
      }
    System.out.println("Sublist doesn't exists");
  }

}
