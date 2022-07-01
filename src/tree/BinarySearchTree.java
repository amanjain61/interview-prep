package tree;

public class BinarySearchTree {

  public static void main(String args[]){
    BinaryTreeUtils impl = new BinaryTreeUtils();
//    int[] values = {10,8,20,6,9,15,21};
    int[] values = {2,1,4,3};
    Node rootNode = null;
    for(int val:values){
      rootNode = impl.insert(val,rootNode);
    }

    Node result = impl.increasingBST(rootNode);

    System.out.println(TraversalOrder.IN_ORDER.getValue());
    impl.traverse(TraversalOrder.IN_ORDER,result);

   /*
    System.out.println(TraversalOrder.IN_ORDER.getValue());
    impl.traverse(TraversalOrder.IN_ORDER,rootNode);

    System.out.println("\n"+TraversalOrder.PRE_ORDER.getValue());
    impl.traverse(TraversalOrder.PRE_ORDER,rootNode);

    System.out.println("\n"+TraversalOrder.POST_ORDER.getValue());
    impl.traverse(TraversalOrder.POST_ORDER,rootNode);

    impl.search(100,rootNode);
    impl.search(9,rootNode);
    impl.search(101,rootNode);
    impl.search(10,rootNode);
    */
  }
}
