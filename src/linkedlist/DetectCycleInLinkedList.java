package linkedlist;

public class DetectCycleInLinkedList {

  /**
   * slow and fast pointer method to detect cycle in the linked list
   */
  public static boolean findCycle(Node head){
    Node slow = head;
    Node fast = head;

    while (fast!=null){
      slow = slow.next;
      fast = fast.next.next;
      if(fast==null || fast.next==null) return false;
      if(slow.val == fast.val) return true;
    }

    return false;
  }


  public static void main(String args[]){
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n2;

    System.out.println("Cycle "+(findCycle(n1)?"exists":"doesn't exist"));
  }
}
