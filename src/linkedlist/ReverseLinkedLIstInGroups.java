package linkedlist;

public class ReverseLinkedLIstInGroups {

  public static Node reverseListInGroup(Node head, int k){
    int n = 1;
    Node newNode = null;
    while(n<k){
      Node next = head.next;
      head.next = newNode;
      newNode = head;
      head = next;
      n++;
    }
    return newNode;
  }

  public static Node parseInGroupReturnNext(Node head, int k){
    if(head==null) return null;
    int n=1;
    Node temp = head;
    while(n<k){
      if(temp.next==null) return null;
      temp = temp.next;
      n++;
    }
    return temp;
  }

  public static Node reverseInGroups(Node head, int k){

    Node dummy = head;
    int iteration = 0;
    while(true){
      Node endNode = parseInGroupReturnNext(dummy,k);
      if(endNode==null) return head;
      Node next = endNode.next;
      Node reversedList = reverseListInGroup(dummy,k);
      // we need the head reference for the very firstly reversed linkedlist group

      if(iteration==0){
        head = reversedList;
        iteration++;
      }
      while(reversedList.next!=null){
        reversedList = reversedList.next;
      }
      reversedList.next = next;
      dummy = next;

    }
  }

  public static void main(String args[]){
    LinkedListUtil util = new LinkedListUtil();
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);

    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = n5;

    // input :: 1 --> 2 --> 3 --> 4 --> 5
    // result :: 2 --> 1 --> 4 --> 3 --> 5
    reverseInGroups(n1,2);
    util.printLinkedList(n1);
  }
}
