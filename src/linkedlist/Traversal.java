package linkedlist;

public class Traversal{
  public static void main(String args[]){
    LinkedListUtil util = new LinkedListUtil();
    Node head = null;
    head = util.createLinkedList(5,head);

    recursiveTraversal(head);
    System.out.println("\n");
    util.printLinkedList(head);
  }

  public static void recursiveTraversal(Node head){
    if(head==null){
      return;
    }
    recursiveTraversal(head.next);
    System.out.print(head.val+ " --> ");
  }
}
