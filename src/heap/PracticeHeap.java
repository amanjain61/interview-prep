package heap;

import java.util.Arrays;

public class PracticeHeap {

  public static void main(String args[]){
    int element[] = {8,7,6,5,4,3,2,1};
    int heap[] = new int[element.length];
    int n =-1;
    for(int i=0;i<element.length;i++){
      addElementsInMinHeap(heap, element[i],i);
      n++;
    }
    Arrays.stream(heap).forEach(a->{System.out.print(a+" ");});

    System.out.print("\n");
    n = deleteNodeFromMinHeap(1,heap,n);
    Arrays.stream(heap).forEach(a->{System.out.print(a+" ");});

    System.out.print("\n");
    deleteNodeFromMinHeap(1,heap,n);
    Arrays.stream(heap).forEach(a->{System.out.print(a+" ");});
  }

  public static void addElementsInMinHeap(int heap[], int ele, int nextIndex){
    if(nextIndex > heap.length-1) return;
    if(nextIndex==0) {
      heap[nextIndex] = ele;
      return;
    }
    heap[nextIndex] = ele;
    heapifyMinHeapForInsert(heap, nextIndex);
  }

  public static void swap(int i, int j, int[] heap){
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  public static void heapifyMinHeapForInsert(int[] heap, int index){
    if(index<=0) return;
    int parentIndex = (index-1)/2;
    if(heap[index] < heap[parentIndex]){
      swap(index, parentIndex, heap);
      heapifyMinHeapForInsert(heap,parentIndex);
    }

  }

  /**
   *
   * @param ele
   * @param heap
   * @param n
   * @return the new size of the heap
   */
  public static int deleteNodeFromMinHeap(int ele, int[] heap, int n){

    if(n==ele){
      heap[n] = 0;
      return n-1;
    }
    // the last node is swapped with the node to be deleted
    swap(ele, n, heap);
    heap[n] = 0;
    n=n-1;
    heapifyForMinHeapDelete(ele,heap,n);
    return n;
  }

  public static void heapifyForMinHeapDelete(int index, int heap[], int n){

    int leftChild = (2*index)+1;
    int rightChild = (2*index)+2;

    if(leftChild>n || rightChild>n) return;
    int smallest = heap[leftChild] < heap[rightChild]? leftChild:rightChild;
    if(heap[smallest] < heap[index])  {
      swap(index,smallest,heap);
      heapifyForMinHeapDelete(smallest,heap,n);
    }
  }


}
