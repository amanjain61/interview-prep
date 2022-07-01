package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInDirectedAcylicGraph {

  private static class Node{
    Integer adjNode;
    Integer nodeDistance;

    Node(Integer adjNode,Integer nodeDistance){
      this.adjNode = adjNode;
      this.nodeDistance = nodeDistance;
    }
  }

  public static int[] findShortestPathInDAG(int[] distanceArr,Integer source,List<List<Node>> graph){
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(source);
    distanceArr[source] = 0;
    while(!queue.isEmpty()){
      Integer currNode = queue.poll();

      // the Node stored adjacentNode and its distance
      for(Node adjNode: graph.get(currNode)){
        Integer distance = adjNode.nodeDistance;
        Integer adjNodeVal = adjNode.adjNode;

        // if the given distance + the distance from current node is lesser, add to the final result otherwise let it be
        if(distanceArr[currNode]+distance < distanceArr[adjNodeVal]){
          distanceArr[adjNodeVal] = distanceArr[currNode]+distance;
          queue.add(adjNodeVal);
        }
      }

    }
    return distanceArr;
  }

  public static void main(String args[]){

    List<List<Node>> graph = getDAGWithWeights();
    int distanceArr[] = new int[graph.size()];
    Arrays.fill(distanceArr,Integer.MAX_VALUE);
    Integer source = 1;
    findShortestPathInDAG(distanceArr,source,graph);

    for(int i=0;i<distanceArr.length;i++){
      System.out.println("Distance from "+source+" to "+i+" is "+distanceArr[i]);
    }


  }

  public static List<List<Node>> getDAGWithWeights(){
    List<List<Node>> graph = new ArrayList<>();
    Integer vertex = 6;
    for(int i=0;i<vertex;i++){
        graph.add(new ArrayList<>());
    }
    // 0->1 : 2 , 0->4 : 1
    graph.get(0).add(new Node(1,2));
    graph.get(0).add(new Node(4,1));
    // 1-> 2 : 3
    graph.get(1).add(new Node(2,3));
    // 2-> 3; 6
    graph.get(2).add(new Node(3,6));

    // 4-> 2 : 4 , 4-> 5 : 4
    graph.get(4).add(new Node(2,2));
    graph.get(4).add(new Node(5,4));

    // 5-> 3 : 1
    graph.get(5).add(new Node(3,1));

    return graph;
  }

}
