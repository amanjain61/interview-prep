package tree;

public class DepthOfBST {

  public static int maxDepth(Node root){
    if(root == null) return 0;
    int lh =  maxDepth(root.left);
    int rh =  maxDepth(root.right);
    return 1+Math.max(lh,rh);
  }



  public static void main(String args[]){

    BinaryTreeUtils impl = new BinaryTreeUtils();
    int[] values = {2,1,4,3,5,6};
    Node rootNode = null;
    for(int val:values){
      rootNode = impl.insert(val,rootNode);
    }
    System.out.println("The max height is :: "+maxDepth(rootNode));

    System.out.println("The height of left subtree is :: "+maxDepth(rootNode.left));

    System.out.println("The max height right subtree is :: "+maxDepth(rootNode.right));


  }
}
