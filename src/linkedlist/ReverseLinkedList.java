package linkedlist;

public class ReverseLinkedList {



  public static Node iterativeApproach(Node headNode){
    System.out.println("\nReversed Linked List");
    // newHead = null
    // while(head!=null){
      // keep a next pointer to have a hold on the next pointer
      // point head's next to newHead
      // newHead = head
      // head = next
    //}

    Node newHead = null;
    while(headNode!=null){
      Node next = headNode.next;
      headNode.next = newHead;
      newHead = headNode;
      headNode = next;
    }
    return newHead;
  }

  public static Node recursiveApproach(Node head,Node newHead){
    // need a new Head pointer that will return the new Head
    if(head.next==null){
      newHead = head;
      return newHead;
    }
    newHead = recursiveApproach(head.next,newHead);
    //break the link of current node
    Node nextNode = head.next;
    nextNode.next = head;
    head.next=null;
    return newHead;
  }

  public static void main(String args[]){
    Node head =null;
    LinkedListUtil util = new LinkedListUtil();
    head = util.createLinkedList(5,head);
    util.printLinkedList(head);
    head = iterativeApproach(head);
    util.printLinkedList(head);
    System.out.print("\nReversing again\n");
    Node newhead = null;
    newhead = recursiveApproach(head,null);
    util.printLinkedList(newhead);
  }

}
