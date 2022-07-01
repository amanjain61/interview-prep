package linkedlist.lrucache;

import java.util.HashMap;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;
import javax.naming.OperationNotSupportedException;
import linkedlist.LinkedListUtil;
import linkedlist.Node;

public class LRUCacheUsingLinkedList {

  /**
   * the idea is :
   *
   * Create a map that stores the key,value
   * --> key is the key of the cache & value is the address of the Node of the  in the doubly linked list
   * --> We'll have a start and end node by default and we keep adding/removing nodes
   * --> adding/updating/reading a node means the node is recently uses,
   *     so we remove it from wherever it already is and add it right after the start node
   * --> removing a node means we have to look at the prev of the curr_node and point it to the next of the curr_node
   */


  private Map<Integer, DoubleLinkNode> map = new HashMap<>();
  private int capacity;
  private DoubleLinkNode head = new DoubleLinkNode(null,null,null);
  private DoubleLinkNode tail = new DoubleLinkNode(null,null,null);

  /**
   *
   * @param _capacity defines the capacity of the cache
   */
  public LRUCacheUsingLinkedList(int _capacity){
    this.capacity = _capacity;
    head.next = tail;
    tail.prev = head;
  }

  public DoubleLinkNode get(Integer key)
      throws OperationNotSupportedException, ResourceNotFoundException {
    try{
      if(map.containsKey(key)){
        DoubleLinkNode node = map.get(key);
        remove(node);
        DoubleLinkNode newNode = insertNodeAfterHead(new DoubleLinkNode(node.key,node.val));
        map.put(key,newNode);
      }else{
        throw new ResourceNotFoundException("Key Not FOUND :: "+key);
      }
    }catch(Exception ex){
      System.out.println("\n\n"+ex);
//      ex.printStackTrace();
    }
    return null;
  }

  public DoubleLinkNode insertNodeAfterHead(DoubleLinkNode insertNode){
    DoubleLinkNode headNext = head.next;
    insertNode.next = headNext;
    insertNode.prev = head;
    headNext.prev = insertNode;
    head.next = insertNode;
    return insertNode;
  }

  public DoubleLinkNode addorUpdate(Integer key,Integer value) throws OperationNotSupportedException {
    int currCapacity = map.size();
    if(currCapacity >= capacity) {
      System.out.println("Cache capacity is full, "
          + "removing the least recently used data from the cache :: "+tail.prev.key);

      remove(tail.prev.key);
    }
    if(map.containsKey(key)){
      remove(key);
    }
    DoubleLinkNode insertNode = new DoubleLinkNode(key,value);
    insertNodeAfterHead(insertNode);
    map.put(key,insertNode);
    return null;
  }

  private boolean remove(DoubleLinkNode removeNode){
    if(removeNode==null) {
      System.out.println("Node doesn't exist");
      return false;
//      throw new OperationNotSupportedException("Node doesn't exist");
    }
    DoubleLinkNode prevNode = removeNode.prev;
    DoubleLinkNode nextNode = removeNode.next;
    prevNode.next = nextNode;
    nextNode.prev = prevNode;
    return true;
  }

  public DoubleLinkNode remove(Integer key) throws OperationNotSupportedException {
    DoubleLinkNode removeNode = map.get(key);
    if(removeNode==null) {
      System.out.println("Node doesn't exist");
      return null;
    }
    remove(removeNode);
    map.remove(key);
    return null;
  }

  public void printLinkedList(DoubleLinkNode headNode){
    DoubleLinkNode temp = headNode;
    System.out.println();
    while(temp!=null){
      System.out.print("("+temp.val+") --> ");
      temp=temp.next;
    }
  }

  public static void main(String args[])
      throws OperationNotSupportedException, ResourceNotFoundException {
    LRUCacheUsingLinkedList lruCache = new LRUCacheUsingLinkedList(3);
    lruCache.printLinkedList(lruCache.head);

    lruCache.addorUpdate(1,1); // head --> (1) --> tail
    lruCache.printLinkedList(lruCache.head);

    lruCache.addorUpdate(2,2); // head --> (2) --> (1) --> tail
    lruCache.printLinkedList(lruCache.head);

    lruCache.addorUpdate(3,3); // head --> (3) --> (2) --> (1) --> tail
    lruCache.printLinkedList(lruCache.head);

    lruCache.get(2); // head --> (2) --> (3) --> (1) --> tail
    lruCache.printLinkedList(lruCache.head);
    // more than capacity, should remove the least used data
    lruCache.addorUpdate(4,4); // head --> (4) --> (2) --> (3) --> tail
    lruCache.printLinkedList(lruCache.head);

    lruCache.get(2); // head --> (2) --> (4) --> (3) --> tail
    lruCache.printLinkedList(lruCache.head);

    lruCache.get(3); // head --> (2) --> (4) --> (3) --> tail
    lruCache.printLinkedList(lruCache.head);


    lruCache.remove(2); // head --> (4) --> (3) --> tail
    lruCache.printLinkedList(lruCache.head);

    lruCache.get(2); // head --> (2) --> (4) --> (3) --> tail
    lruCache.printLinkedList(lruCache.head);

    lruCache.printLinkedList(lruCache.head);
  }
}
