package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DFSOnGraph {


  public static void dfsOnGraph(Integer vertex,List<List<Integer>> graph,boolean[] visited) {
    if(visited[vertex]) return;
    visited[vertex] = true;
    System.out.println("Visiting the vertex "+ vertex);
    for (Integer node:graph.get(vertex)){
      dfsOnGraph(node,graph,visited);
  }

  }
  public static void main(String[] args){
    int vertex = 4;
    int[][] graph = new int[vertex][vertex];
    List<List<Integer>> graphList = new ArrayList<>();
    for(int i=0;i<vertex;i++){ graphList.add(new ArrayList<>()); }
    graphList.get(0).add(1);
    graphList.get(0).add(0);

    graphList.get(1).add(0);
    graphList.get(1).add(1);
    graphList.get(1).add(2);

    graphList.get(2).add(1);
    graphList.get(2).add(2);

    graphList.get(3).add(3);
    boolean[] visited = new boolean[vertex];
    for(int i=0;i<vertex;i++){
      if(!visited[i]){
        dfsOnGraph(i,graphList,visited);
      }
    }
    for(int i=0;i<vertex;i++){
      System.out.println( i+" is "+(visited[i]?"visited":"not visited"));
    }

  }
}
