package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInUndirectedGraph {

  /**
   * we don't need a visited array here as we only push data into the queue
   *  - if there are changes made to the distanceArr array to update the shortest path
   * @param distanceArr
   * @param graph
   * @param sourceVertex
   * @return
   */
  public static int[] shortestPathUsingBFS(int[] distanceArr,List<List<Integer>> graph,int sourceVertex){

    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(sourceVertex);
    distanceArr[sourceVertex] = 0;
    while(!queue.isEmpty()){
      Integer currNode = queue.poll();
//      visited[currNode] = true;
      for(Integer node:graph.get(currNode)){
        // check if the currdistance + 1 gives a better result than the existing result
        // since we're just checking adjacent nodes, it makes sense to just add 1 and check if the distance is better
        if(distanceArr[currNode]+1 < distanceArr[node]){
          distanceArr[node] = distanceArr[currNode]+1;
          queue.add(node);
        }
//        // if a vertex is not visited yet, add it in the queue and check for distance from source to that node
//        if(!visited[node]){
//
//        }
      }
    }
    return distanceArr;
  }

  public static void main(String args[]){
    List<List<Integer>> graph = new GraphObjectService().getUndirectedGraph();
    int[] distanceArr = new int[graph.size()];
    Arrays.fill(distanceArr,Integer.MAX_VALUE);
//    boolean[] visited = new boolean[graph.size()];
//    Arrays.fill(visited,false);
    int source = 0;
    shortestPathUsingBFS(distanceArr,graph,source);

    for(int i=0;i<distanceArr.length;i++){
      System.out.println("Distance from "+source+" to "+i+" is "+distanceArr[i]);
    }

  }

}
