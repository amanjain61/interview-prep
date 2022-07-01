package linkedlist.lrucache;

public class DoubleLinkNode {
  Integer key,val;
  DoubleLinkNode prev;
  DoubleLinkNode next;
  int frequency;

  public DoubleLinkNode(){

  }
  public DoubleLinkNode(Integer _key,Integer _val){
    this.key = _key;
    this.val = _val;
  }
  public DoubleLinkNode(Integer _val,DoubleLinkNode _prev, DoubleLinkNode _next){
    this.val = _val;
    this.prev = _prev;
    this.next = _next;
  }
}
