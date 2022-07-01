package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSOnGraph {

  public static void simpleTraversal(int vertices, List<List<Integer>> adjencencyList){
    // this boolean keep record of visited nodes
    boolean[] visited = new boolean[vertices];
    for(int i=0;i<vertices;i++){

      if(!visited[i]){
        // this adds the values to the queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = true;

        // iterate for all values in the queue
        while(!queue.isEmpty()){

          // take the value from queue and parse all the adjacent nodes of that value
          int vertex = queue.poll();
          for(Integer val:adjencencyList.get(vertex)){
            if(val!=vertex && !visited[val]){
              queue.add(val);
              visited[val] = true;
            }
          }
        }
      }
    }
    for(int i=0;i<vertices;i++){
      System.out.println( i+" is "+(visited[i]?"visited":"not visited"));
    }
  }

  public static void dfs(int[][] graph,int[] visited,Queue<Integer> queue){
    // take all the adjacent vertex and push them in a stack and run the same dfs for the vertex and repeat
    int vertex = queue.poll();
    if(visited[vertex]==1) return;
    for(int i=0;i<graph.length;i++){
      //	if two vertex are connected, push them in the stack
      if(graph[vertex][i]==1){
        visited[i]=1;
        queue.add(i);
      }
    }

    while(!queue.isEmpty()){
      dfs(graph,visited,queue);
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

    simpleTraversal(vertex,graphList);

    /**
     graph[0][0] = 1; graph[0][1] = 1;
     graph[1][0] = 1; graph[1][1] = 1; graph[1][2] = 1;
     graph[2][1] = 1; graph[2][2] = 1;
     graph[3][3] = 1;
     int count = 0;
     int[] visited = new int[vertex];
     Queue<Integer> queue = new LinkedList<>();
     for(int i=0;i<vertex;i++){
     if(visited[i]==0){
     count++;
     queue.add(i);
     dfs(graph,visited,queue);
     }
     }
     System.out.println("No.of.provinces :: "+count);
     **/
  }
}
