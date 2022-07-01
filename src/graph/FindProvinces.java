package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindProvinces{

  public static List<Integer> getProvinces(int vertex,List<List<Integer>> graph,boolean[] visited){

    // this stores single province details
    List<Integer> province = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(vertex);
    // keep traversing through the queue to get all linked nodes that forms a province
    while(!queue.isEmpty()){
      int node = queue.poll();
      if(!province.contains(node)) {
        province.add(node);
      }

      for(Integer val:graph.get(node)){
        if(!province.contains(val)){
          // using the visited array in the outer loop to make sure we don't visit the same node again
            visited[val] = true;
            province.add(val);
            queue.add(val);
        }
      }
    }
    return province;
  }

  public static void main(String args[]){
    int vertex = 6;
    List<List<Integer>> graphList = new ArrayList<>();
    for(int i=0;i<vertex;i++){ graphList.add(new ArrayList<>()); }
    graphList.get(0).add(1);
    graphList.get(0).add(0);

    graphList.get(1).add(0);
    graphList.get(1).add(1);
//    graphList.get(1).add(2);

//    graphList.get(2).add(1);
    graphList.get(2).add(2);
//    graphList.get(2).add(4);
//    graphList.get(2).add(5);

    graphList.get(3).add(3);

//    graphList.get(4).add(2);
    graphList.get(4).add(4);

//    graphList.get(5).add(2);
    graphList.get(5).add(5);

    List<List<Integer>> provinces = new ArrayList<>();
    boolean[] visited = new boolean[vertex];

    for(int i=0;i<vertex;i++){
      if(!visited[i]){
        provinces.add(getProvinces(i,graphList,visited));
      }
    }

    System.out.println("There are "+provinces.size()+" provinces");
    for(int i=0;i<provinces.size();i++){
      System.out.println("Province "+(i+1));
      System.out.println(String.valueOf(provinces.get(i))+"\n");
    }

  }

}

