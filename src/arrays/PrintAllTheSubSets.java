package arrays;

public class PrintAllTheSubSets {

  public static void main(String args[]){
    char[] arr = {'A','B','C'};

    System.out.println("the total : "+ Math.pow(2,arr.length)+"\n");

    for(int i=0;i<Math.pow(2,arr.length);i++){
      System.out.print("{");

      for(int j=0;j<arr.length;j++){

        if((i & (1<<j)) > 0){
          System.out.print(arr[j]+" ");
        }

      }

      System.out.println("}");
    }
  }
}
