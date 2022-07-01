package linkedlist;

public class DeleteNode {


  public static Node delateandReturnNewHead(Node head,int del){
    System.out.println("\nItem to delete ::"+del);
    if(head.val == del) return head.next;
    Node temp = head;
    // to delete, 3:
    //find 3, point its prev node to 3's next node
    while(temp.next!=null && temp.next.val!=del){
        temp= temp.next;
    }
    if(temp.next==null){
      System.out.println("Item doesn't exist ::"+del);
      return head;
    }
    temp.next = temp.next.next;
    return head;
  }
  public static void main(String args[]){
      LinkedListUtil util = new LinkedListUtil();
      Node head = null;
      head = util.createLinkedList(5,head);
      util.printLinkedList(head);
      int delete = 3;
      head = delateandReturnNewHead(head,delete);
      util.printLinkedList(head);

      delete = 1;
      head = delateandReturnNewHead(head,delete);
      util.printLinkedList(head);

      delete = 6;
      head = delateandReturnNewHead(head,delete);
      util.printLinkedList(head);




  }
}
