package tree;

public enum TraversalOrder {

  IN_ORDER("In-order traversal"),
  PRE_ORDER("Pre-order traversal"),
  POST_ORDER("Post-order traversal");

  private String value;

  TraversalOrder(String value){
    this.value = value;
  }

  public String getValue(){
    return value;
  }

}
