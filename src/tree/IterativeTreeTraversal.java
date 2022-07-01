package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class IterativeTreeTraversal {

  // postorder --> left,  right ,root
  // use the stack and keep pushing untill we reach left most
  // on reaching the end, check the stack and go for right
  // if no right exist, its a leaf node, print it
  // keep the reference to the printed node and for the next node in the stack check if it was the left child of the root
  // if yes, iterate to the right if no, if it was the right child, print the root and pop it from the stack
  // repeat the same thing

/**
 *          1
 *      2      3
 *    4   5  6    7
 *
 *    post order : 4,5,2,6,7,3,1
 */

public static List<Integer> postOrderIterativeTraversal(Node root){
  List<Integer> result = new ArrayList<>();
  Stack<Node> st = new Stack<Node>();

  while(root!=null || !st.isEmpty()){

    if(root!=null){
      st.push(root);
      root = root.left;
    }else{
      Node temp = st.peek().getRight();
      // right is not null, right is null
      // if right is null its the leaf node
      if(temp==null){
        temp = st.pop();
        result.add(temp.val);
        while(!st.isEmpty() && temp==st.peek().right){
            temp = st.pop();
            result.add(temp.val);
        }
      }else{
        root = temp;
      }
    }

  }

  return result;
}



  public static void main(String args[]){
    BinaryTreeUtils util = new BinaryTreeUtils();
    int[] arr = {8,5,4,6,7,10};
    Node root = null;
    for(int val:arr) root = util.insert(val,root);
    System.out.println(Arrays.toString(postOrderIterativeTraversal(root).toArray()));

  }

}
