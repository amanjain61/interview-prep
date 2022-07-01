package linkedlist;

public class PalindromeLinkedList {

  static Node reverseLinkedList(Node head){
    Node newHead = null;
    while(head!=null){
      Node next = head.next;
      head.next = newHead;
      newHead = head;
      head = next;
    }
    return newHead;
  }

  public static boolean isPalindrome(Node head){

    Node slow = head;
    Node fast = head;

    while(fast.next!=null && fast.next.next!=null){
      slow = slow.next;
      fast = fast.next.next;
    }
    // reversed the linked list
    Node reversedHalf = reverseLinkedList(slow.next);
    Node midPointer = reversedHalf;
    Node dummy = head;
    boolean isPalindrome = true;
    while(reversedHalf!=null){
      if(dummy.val!=reversedHalf.val){
        isPalindrome = false;
        break;
      }
      dummy = dummy.next;
      reversedHalf = reversedHalf.next;
    }
    Node reverseAgain = reverseLinkedList(midPointer);
    slow.next = reverseAgain;
    return isPalindrome;
  }

  public static void main(String args[]){
      LinkedListUtil util = new LinkedListUtil();
      Node n1 = new Node(1);
      Node n2 = new Node(2);
      Node n3 = new Node(3);
      Node n4 = new Node(2);
      Node n5 = new Node(5);

      n1.next = n2;
      n2.next = n3;
      n3.next = n4;
      n4.next = n5;

    System.out.println(isPalindrome(n1));
    util.printLinkedList(n1);
  }
}
