package linkedlist;

public class MergeTwoSortedList {

  public static void main(String args[]){
    LinkedListUtil util = new LinkedListUtil();
    Node list1 = util.createLinkedList(5,null);
    Node list2 = util.createLinkedList(10,null);


    Node newList = new Node();
    Node temp = newList;

    while(list1!=null && list2!=null){
        if(list1.val<list2.val){
          newList.next = new Node(list1.val);
          newList = newList.next;
          list1 = list1.next;
        }else{
          newList.next = new Node(list2.val);
          newList = newList.next;
          list2 = list2.next;
        }
    }

    while(list1!=null){
      newList.next = new Node(list1.val);
      newList = newList.next;
      list1 = list1.next;
    }

    while(list2!=null){
      newList.next = new Node(list2.val);
      newList = newList.next;
      list2 = list2.next;
    }

    util.printLinkedList(temp.next);
  }
}
