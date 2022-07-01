package linkedlist;

public class IntersectionPoint {


  public static Node findIntersectionWithoutExtraSpace(Node head1,Node head2){

    /** while(true){
     *    --> keep moving head1 & head2 simultaneously
     *    --> if head1 or head2 reaches the end i.e., null
     *    --> shift head1 pointer to head2's head or
     *    --> shift head2 pointer to head1's head
     *    --> as soon as head1's and head2's values matches, return the node
     */
    Node temp1 = head1;
    Node temp2 = head2;
    while(true){
      if(temp1==null && temp2==null) {
        break;
      }
      if(temp1==null){
        temp1 = head2;
      }
      if(temp2==null){
        temp2 = head1;
      }
      if(temp1.val==temp2.val){
        return temp1;
      }
      temp1 = temp1.next;
      temp2 = temp2.next;
    }

    return null;
  }

  public static Node traverseGivenLength(Node head1,int lengthToTraverse,Node head2){
    Node temp1 = head1;
    Node temp2 = head2;
    while (lengthToTraverse > 0){
      temp1 = temp1.next;
      lengthToTraverse--;
    }

    while(temp1!=null && temp2!=null){
      if(temp1.val== temp2.val) return temp1;
        temp1 = temp1.next;
        temp2 = temp2.next;
    }
    return null;
  }

  public static Node findIntersection(Node head1,Node head2){
    Node temp1 = head1; int l1 = 0;
    Node temp2 = head2; int l2 = 0;
    while(temp1!=null){
      temp1 = temp1.next;
      l1++;
    }

    while(temp2!=null){
      temp2 = temp2.next;
      l2++;
    }

//    System.out.println("\nLength of first list :: "+l1);
//    System.out.println("\nLength of second list :: "+l2);
    int l3 = l1-l2;
    return traverseGivenLength(l1>l2?head1:head2 , Math.abs(l3),l1>l2?head2:head1);

  }

  public static void main(String args[]){
    LinkedListUtil util = new LinkedListUtil();
    Node list1 = null;
    int[] arr1 = {1,2};
    for(int val:arr1){
      list1 = util.createCustomLinkedListWithSameHead(val,list1);
    }
    Node list2 = null;
    int[] arr2 = {3,4,5,9,8,6,7};
    for(int val:arr2){
      list2 = util.createCustomLinkedListWithSameHead(val,list2);
    }
    System.out.print("list 1 :: ");
    util.printLinkedList(list1);
    System.out.print("\nlist 2 :: ");
    util.printLinkedList(list2);

    Node intersectionNode = findIntersection(list1,list2);
    System.out.print("\nIntersection Node :: "+(intersectionNode!=null? intersectionNode.val:" doesn't Exist")+"\n");

    Node intersectionNode1 = findIntersectionWithoutExtraSpace(list1,list2);
    System.out.print("\nIntersection Node :: "+(intersectionNode1!=null? intersectionNode1.val:" doesn't Exist")+"\n");

  }
}
