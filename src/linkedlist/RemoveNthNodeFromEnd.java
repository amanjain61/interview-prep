package linkedlist;

public class RemoveNthNodeFromEnd {

  static int nodeCount = 5;

  public static Node removeNodeStriverMethod(Node node, int n){
      Node start = new Node();
      start.next = node;
      Node slow = start;
      Node fast = start;

      for(int i=0;i<n;i++)
        fast = fast.next;

      while(fast.next!=null){
        fast = fast.next;
        slow = slow.next;
      }
      slow.next = slow.next.next;

      return start.next;
  }

  public static void removeNodeByRecursion(int n,Node head){
//    System.out.println("val of nodeCount : "+nodeCount);
    if(head==null){
      return;
    }
//    nodeCount = nodeCount+1;
    removeNodeByRecursion(n,head.next);
    if(nodeCount<0) return;
    nodeCount--;
    System.out.println("val of nodeCount : "+nodeCount+" and node val : "+head.val);
    // come to n+1 th node from the end of the list
    // basically decrement n after we have reached the end
    // when n is 0, perform below operations
    // head.next = removeNode;
    // head.next = removeNode.next;
    if(-1==nodeCount){
      Node removeNode = head.next;
      head.next = removeNode.next;
    }
  }

  public static void main(String args[]){
    LinkedListUtil util = new LinkedListUtil();
    Node head = util.createLinkedList(10,null);
    removeNodeByRecursion(nodeCount,head);
    util.printLinkedList(head);
    System.out.println("\n");
    util.printLinkedList(removeNodeStriverMethod(head,9));
  }
}
