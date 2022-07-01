package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CycleDetectionInUndirectedGraph {

  /**
    The idea is to use BFS and keep marking nodes as visited.
    Store the prev node value from where the current node has come from.
    If a visited node gets visited again and if the visited node's value isn't equal to the prev node
    there's a cycle in the graph
  */
  public static boolean detectCycle(int vertex,List<List<Integer>> graph,boolean[] visited){

    visited[vertex] = true;
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(vertex);
    Integer prev = null;
    while(!queue.isEmpty()){
      Integer currNode = queue.poll();
      for(Integer node:graph.get(currNode)){
        if(!visited[node]){
          visited[node] = true;
          queue.add(node);
        }else if(node != prev && visited[node]){
          return true;
        }
      }
      prev = currNode;
    }
    return false;
  }

  public static void main(String[] args){
    List<List<Integer>> graph = new GraphObjectService().getUndirectedGraph();
    boolean[] visited = new boolean[graph.size()];
    Arrays.fill(visited,false);
    for(int i=0;i<graph.size();i++){
      if(!visited[i]){
        boolean cycleExists = detectCycle(i,graph,visited);
        System.out.println("Cycle "+(cycleExists?"EXISTS":"Doesn't EXIST")+" in the Graph");
      }
    }
  }
}
