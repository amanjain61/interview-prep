package linkedlist;

public class AddNumbersinLinkedLists {

  /**
   * given two linked lists, add the numbers in each node
   *  - if there's a carry, add it to the next node's value
   *  - return the end sum value
   * @param args
   */


  public static void main(String args[]){

    LinkedListUtil util = new LinkedListUtil();
    Node list1 = null;
    int[] arr1 = {9,9,4,5,4};
    for(int val:arr1){
      list1 = util.createCustomLinkedListWithSameHead(val,list1);
    }
    Node list2 = null;
    int[] arr2 = {6,7,1};
    for(int val:arr2){
      list2 = util.createCustomLinkedListWithSameHead(val,list2);
    }
    System.out.print("list 1 :: ");
    util.printLinkedList(list1);
    System.out.print("\nlist 2 :: ");
    util.printLinkedList(list2);


    Node resultList = null;
    int carry = 0;
    while(true){
      if(list1==null && list2==null){
        break;
      }
      int sum = carry;
      sum += (list1!=null?list1.val:0) + (list2!=null? list2.val:0);
      carry = sum/10;
      int sumVal = sum%10;
      resultList = util.createCustomLinkedListWithSameHead(sumVal,resultList);

      if(list1!=null) list1 = list1.next;

      if(list2!=null)  list2 = list2.next;
    }

    /**
     * EDGE CASE => is the carry is not zero, we should append it at the end of the list
     */
    if(carry!=0) resultList = util.createCustomLinkedListWithSameHead(carry,resultList);
    System.out.print("\nResult list :: ");
    util.printLinkedList(resultList);
    System.out.println("\n");
  }
}
