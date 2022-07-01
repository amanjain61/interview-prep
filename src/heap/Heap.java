package heap;

public class Heap {

  public static void main(String args[]){
    int[] arr = {5,10,2,1,6,8,9,7,4,3};
    int[] arr1 = {5,2,1,4,3};
//    deleteFromTop(create(arr));
    heapify(arr);
    sortAscending(arr);
  }

  //create a new heap - a new array of the same size
  public static int[] create(int[] arr){
    int[] newArr = new int[arr.length];
    for(int i=0;i<arr.length;i++){
      newArr[i] = arr[i];
      checkSanityForMaxHeap(i,newArr);
    }
    print(newArr);
    return newArr;
  }

  public static void checkSanityForMaxHeap(int pos,int[] arr){
    int parentPos = parent(pos);
    if(parentPos>=0 && arr[pos] > arr[parentPos]){
      swap(pos,parentPos,arr);
      checkSanityForMaxHeap(parentPos,arr);
    }
  }

  public static void checkSanityForMinHeap(int pos,int[] arr){
    int parentPos = parent(pos);
    if(parentPos>=0 && arr[pos] < arr[parentPos]){
      swap(pos,parentPos,arr);
      checkSanityForMinHeap(parentPos,arr);
    }
  }

  public static int parent(int i){
    return ((i-1)/2);
  }

  public static int leftChild(int i){
    return ((i*2) + 1);
  }

  public static int rightChild(int i){
    return ((i*2) + 2);
  }
  // delete from the top of a heap --> basically push the elements in the end
  public static void deleteFromTop(int[] arr){
    swap(0, (arr.length-1), arr);
    maxHeapify(0,arr.length-2,arr);
    print(arr);
  }

  public static void maxHeapify(int parentPos,int heapLength,int[] arr){

    //check which one is greates --> left child or the right one and take that position
    int leftPos = leftChild(parentPos); int rightPos = rightChild(parentPos);
    int maxPos = parentPos;
    //for leaf nodes, when there are no children
    if(rightPos > heapLength && leftPos > heapLength){
      return;
      //for nodes with only leftnode and no right node
    }else if(rightPos > heapLength && leftPos <=heapLength){
      maxPos = leftPos;
    }else{
      //for nodes with both left and right nodes
      maxPos = arr[leftPos] > arr[rightPos]?leftPos:rightPos;
    }
    //check if the child is greater than parent - if yes, swap them and call the function again to check
    if(arr[maxPos] > arr[parentPos]){
      swap(maxPos,parentPos,arr);
      maxHeapify(maxPos,heapLength,arr);
    }
  }

  // heapify an existing array to make it a heap
  public static void heapify(int arr[]){
    for(int i=((arr.length/2 )-1) ;i>=0;i--){
      maxHeapify(i,arr.length-1,arr);
    }
    print(arr);
  }

  // - ascending sort --> from max heap deletion
  public static void sortAscending(int[] arr){
    for(int i=arr.length-1;i>=1;i--){
      swap(0, i, arr);
      maxHeapify(0,i-1,arr);
    }
    print(arr);
  }

  // - descending sort --> from min heap deletion
  public static void sortDescending(){

  }

  // deleting a random element
  public static void deleteRandom(){

  }

  // searching in a heap
  public static void search(){

  }

  // priority queue
  public static void priorityQueue(){

  }

  public static void swap(int i,int j, int[] arr){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr){
    System.out.print("[");
    for(int item:arr){
      System.out.print(item+ ",");
    }
    System.out.print("]\n");
  }
}
