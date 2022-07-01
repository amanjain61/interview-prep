package graph;

import java.util.List;
import java.util.ArrayList;

public class GraphRepresentation {

  public static void main(String args[]){
    int vertices = 4;
    // adjacency matrix representation of a graph
    int[][] graph = new int[vertices][vertices];

    /** 0,1,2,3
     0-->1 , 0-->2
     1-->3 , 2--> 3
     **/

    graph[0][1] = 1;
    graph[0][2] = 1;
    graph[1][3] = 1;
    graph[2][3] = 1;


    for(int i=0;i<vertices;i++){
      for(int j=0;j<vertices;j++){
        if(graph[i][j]==1)
          System.out.println(" vertices "+i+" and "+j+" are connected");
      }
    }

    adjacencyList();
  }

  public static void adjacencyList(){

    int vertices = 4;
    List<List<Integer>> graph = new ArrayList<List<Integer>>();
    for(int i=0;i<vertices;i++){
      graph.add(new ArrayList<>());
    }

    /** 0,1,2,3
     0-->1 , 0-->2
     1-->3 , 2--> 3
     **/
    List<Integer> tempList = new ArrayList<Integer>();
    tempList.add(1);
    tempList.add(2);
    graph.get(0).addAll(tempList);

    tempList = new ArrayList<Integer>();
    tempList.add(3);
    graph.get(1).addAll(tempList);

    tempList = new ArrayList<Integer>();
    tempList.add(3);
    graph.get(2).addAll(tempList);

    for(int i=0;i<graph.size();i++){
      for(Integer vertex:graph.get(i)){
        System.out.println("vertex "+i+" and "+vertex+" are connected");
      }
    }
  }

}
