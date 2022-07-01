package linkedlist;

  public class LinkedListUtil {

    public Node createLinkedList(int noOfNodes,Node headNode) {
      for (int i = noOfNodes; i > 0; i--) {
        Node newNode = new Node();
        newNode.val = i;
        newNode.next = headNode;
        headNode = newNode;
      }
      return headNode;
    }

    public Node createCustomLinkedList(int value,Node headNode) {
        Node newNode = new Node();
        newNode.val = value;
        newNode.next = headNode;
        headNode = newNode;
        return headNode;
    }

    public Node createCustomLinkedListWithSameHead(int value,Node headNode) {
      Node temp = headNode;
      if(temp==null){
        return new Node(value);
      }
      while(true){
        if(temp.next!=null) {
          temp = temp.next;
        }else {
          break;
        }
      }
      temp.next = new Node(value);
      return headNode;
    }

    public void printLinkedList(Node headNode){
      System.out.println();
      Node temp = headNode;
      while(temp!=null){
        System.out.print("("+temp.val+") --> ");
        temp=temp.next;
      }
    }

    public void printReversedLinkedList(Node headNode){
      if(headNode==null) return;
      printReversedLinkedList(headNode.next);
      System.out.print(headNode.val+" --> ");
    }
  }
