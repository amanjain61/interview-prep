package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFSTreeTraversal {

  public static void printBFSTraversal(Node root){
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
      Node node = queue.poll();
      System.out.print(node.val+" ");
      if(node.right!=null) queue.add(node.right);
      if(node.left!=null) queue.add(node.left);
    }
  }

  public static void inOrderIterativeTraversal(Node root){
    System.out.print("\n");
    Stack<Node> stack = new Stack<>();
    Node node = root;
    while(true){
      if(node!=null){
        stack.push(node);
        node = node.left;
      }else{
        if(stack.isEmpty()) break;
        node = stack.pop();
        System.out.print(node.val+" ");
//        stack.push(node);
        node=node.right;
      }
    }

  }

  public static void preOrderIterativeTraversal(Node root){
    System.out.print("\n");
    Stack<Node> stack = new Stack<>();
    stack.add(root);
    while(!stack.isEmpty()){
      Node node = stack.pop();

      if(node.right!=null){
        stack.push(node.right);
      }
      System.out.print(node.val+" ");
      if(node.left!=null){
        stack.push(node.left);
      }
    }
  }

  public static void main(String args[]){
    BinaryTreeUtils impl = new BinaryTreeUtils();
    int[] values = {1,2,3,4,5,6,7,8,9,10};
    Node rootNode = null;
    for(int val:values){
      rootNode = impl.insert(val,rootNode);
    }
    printBFSTraversal(rootNode);
    preOrderIterativeTraversal(rootNode);

    inOrderIterativeTraversal(rootNode);
  }
}
