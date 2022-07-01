package graph;

import java.util.List;

/**
 * https://youtu.be/uzVUw90ZFIg?list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw
 */
public class CycleDetectionInDirectedGraph {

  public static boolean detectCycleUsingDFS(List<List<Integer>> graph,boolean[] visited,boolean[] dfsVisited,int vertex){

    visited[vertex] = true;
    // need the dfsVisited array to check if a node is visited in the current DFS call
    // for a directed graph, the cycle has to happen starting from one node and reaching to the same node
    // that's not possible if we follow the same approach as DFS of UnDirected graph
    dfsVisited[vertex] = true;
    for(Integer node:graph.get(vertex)){
      if(!visited[node]){
        return detectCycleUsingDFS(graph,visited,dfsVisited,node);
      }else if(dfsVisited[vertex]){
          return true;
      }
    }
    dfsVisited[vertex] = false;
    return false;
  }

  public static void  main(String args[]){
    List<List<Integer>> graph = new GraphObjectService().getDirectedGrapWithCycle();
    boolean[] visited = new boolean[graph.size()];
    boolean[] dfsVisited = new boolean[graph.size()];

    for(int i=0;i<graph.size();i++){
      if(!visited[i]){
        boolean cycleExists = detectCycleUsingDFS(graph,visited,dfsVisited,i);
        if(cycleExists){
          System.out.println("CYCLE EXISTS");
          break;
        }
      }
    }
  }

}
