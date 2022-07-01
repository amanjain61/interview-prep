package linkedlist.lrucache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LFUCache {

  /**
   * concept:
   *
   * while removing a node or data from the cache we're supposed to remove the least frequently used cache
   * - no matter the order of the insertion
   *  example: 1 --> 2 --> 3 : Frequency of 1 : 1 ;  Frequency of 2 : 3;  Frequency of 3 : 2
   *   1 will be removed from the cache because that's the least frequently used data
   *
   *   => now, there could be a case where the used frequency of different data can be same
   *    - in this case, we're supposed to remove the least recently used data
   *
   *    example: 1 --> 2 --> 3 : Frequency of 1 : 1 ;  Frequency of 2 : 1;  Frequency of 3 : 2
   *      (Node 2 ) will be removed from the cache because that's the least recently used among 1 & 2
   *
   */

  Map<Integer, List<DoubleLinkNode>> frequencyMap;
  Map<Integer, DoubleLinkNode> cacheMap;
  int lowestFrequency;
  int capacity;
  int currSize;

  public LFUCache(int _capacity){
    this.capacity = _capacity;
    currSize = 0;
    lowestFrequency = 0;
    frequencyMap = new HashMap<>();
    cacheMap = new HashMap<>();
  }


  public int get(Integer key){
    DoubleLinkNode node =  cacheMap.get(key);
    if(node!=null){
      update(node);
      return cacheMap.get(key).val;
    }
    return -1;
  }

  public void put(int key,int value){
    if(capacity==0){
      return;
    }
    if(cacheMap.containsKey(key)){
      DoubleLinkNode currNode = cacheMap.get(key);
      currNode.val = value;
      update(currNode);
    }else{
      currSize++;
      if(currSize >  capacity){

      }
    }

  }

  public void update(DoubleLinkNode node){
    int frequency = node.frequency;
    List<DoubleLinkNode> currList = frequencyMap.get(frequency);
    currList.remove(node);
    if(frequency == lowestFrequency && currList.size()==0){
      lowestFrequency++;
    }
    node.frequency++;
    List<DoubleLinkNode> newList = frequencyMap.getOrDefault(node.frequency,new ArrayList<>());
    newList.add(node);
    frequencyMap.put(node.frequency,newList);
  }

  public void remove(){

  }
  public static void main(String args[]){

  }


}
