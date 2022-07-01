package linkedlist;

public class MiddleOfLinkedList {

  public static void main(String args[]){
    LinkedListUtil util = new LinkedListUtil();
    Node head = util.createLinkedList(6,null);

    Node slow = head;
    Node fast = head;

    while(fast!=null && fast.next!=null){
      slow = slow.next;
      if(fast.next!=null)  fast = fast.next.next;
    }
    System.out.println("Middle node is : "+slow.val);

  }
}
