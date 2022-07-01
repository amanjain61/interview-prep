package tree;

public class Node {

  public int val;
  public Node left;
  public Node right;

  public Node(){}

  public Node(Node node){
    this.val = node.val;
  }

  public Node(int val){
    this.val = val;
  }

  public Node(int val, Node left, Node right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }
}
