package tree;

import java.util.AbstractQueue;
import java.util.PriorityQueue;

public class BinaryTreeUtils {

  Node newNode = new Node(0);
  Node head = newNode;

  public Node increasingBST(Node root) {

    AbstractQueue<Integer> queue = new PriorityQueue<>();
    queue.remove();
    if (root == null) {
      return null;
    }
    if(root.left!=null)  increasingBST(root.left);
    {
      newNode.right = new Node(root); newNode.left = null; newNode = newNode.right;
    }
    if(root.right!=null) increasingBST(root.right);
    return head.right;
  }

  public Node insert(int val,Node rootNode){
    if(rootNode==null){
        rootNode = new Node();
        rootNode.setVal(val);
        return rootNode;
    }
    // check if val > or < rootNode.val
    // if greater, pass right Node into the insert op
    // else pass left node into the insert op
    if(val > rootNode.getVal()){
      rootNode.setRight(insert(val,rootNode.getRight()));
    }else{
      rootNode.setLeft(insert(val,rootNode.getLeft()));
    }
    return rootNode;
  }

  public void delete(int val,Node rootNode){

  }

  public void search(int val, Node rootNode){
      if(rootNode==null) {
        System.out.println("\nELEMEMT NOT FOUND: "+val);
        return;
      }
      if(val==rootNode.getVal()){
        System.out.println("\nELEMEMT FOUND: "+val);
        return;
      }
      if(val > rootNode.getVal()){
        search(val,rootNode.getRight());
        return;
      }else{
        search(val,rootNode.getLeft());
        return;
      }
  }


  public void traverse(TraversalOrder traversalOrder,Node node){

    switch (traversalOrder){
      case IN_ORDER : {
        if(node==null){
          return;
        }
        traverse(traversalOrder,node.getLeft());
        System.out.print(node.getVal()+ " ,");
        traverse(traversalOrder,node.getRight());
        break;
      }
      case PRE_ORDER : {
        if(node==null){
          return;
        }
        System.out.print(node.getVal()+ " ,");
        traverse(traversalOrder,node.getLeft());
        traverse(traversalOrder,node.getRight());
        break;
      }
      case POST_ORDER : {

        if(node==null){
          return;
        }
        traverse(traversalOrder,node.getLeft());
        traverse(traversalOrder,node.getRight());
        System.out.print(node.getVal()+ " ,");
        break;
      }
    }


  }

}
