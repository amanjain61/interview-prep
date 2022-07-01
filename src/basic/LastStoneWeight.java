package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class LastStoneWeight {

  public int usingOrderOf1(){
return 0;
  }
  public static void main(String arh[]){
    int[] asa = {8,7,4,2,1,1};
    List<Integer> list = Arrays.stream(asa).boxed().collect(Collectors.toList());
    System.out.println(list);

//    System.out.println(bruteForce(list));
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());
    heap.addAll(list);
    System.out.println(usingPriorityHeap(heap));
  }

  public static int bruteForce(List<Integer> stones){

    if(stones.size()==0){
      return 0;
    }
    if(stones.size()==1){
      return stones.get(0);
    }

    Collections.sort(stones,Collections.reverseOrder());

    Integer bal = stones.get(0) - stones.get(1);
    stones.remove(0);
    stones.remove(0);
    stones.add(bal);
    return bruteForce(stones);

  }

  public static int usingPriorityHeap(PriorityQueue<Integer> heap){

    if(heap.size()==0){
      return 0;
    }
    if(heap.size()==1){
      return heap.poll();
    }
    Integer bal = heap.poll() - heap.poll();
    heap.add(bal);
    return usingPriorityHeap(heap);
  }

}
