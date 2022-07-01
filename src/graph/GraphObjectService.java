package graph;

import java.util.ArrayList;
import java.util.List;

public class GraphObjectService {

    public List<List<Integer>> getDirectedGrapWithCycle(){
        int vertex = 9;
        List<List<Integer>> graphList = new ArrayList<>();
        for(int i=0;i<vertex;i++){ graphList.add(new ArrayList<>()); }
        graphList.get(0).add(1);
        graphList.get(1).add(2);
        graphList.get(2).add(3);
        graphList.get(2).add(5);
        graphList.get(3).add(4);
        graphList.get(5).add(4);
        graphList.get(6).add(1);
        graphList.get(6).add(7);
        graphList.get(7).add(8);
        graphList.get(8).add(6);
        return graphList;
    }

    public List<List<Integer>> getDirectedGrapWithoutCycle(){
        int vertex = 9;
        List<List<Integer>> graphList = new ArrayList<>();
        for(int i=0;i<vertex;i++){ graphList.add(new ArrayList<>()); }
        graphList.get(0).add(1);
        graphList.get(1).add(2);
        graphList.get(2).add(3);
        graphList.get(2).add(5);
        graphList.get(3).add(4);
        graphList.get(5).add(4);
        graphList.get(6).add(1);
        graphList.get(6).add(7);
        graphList.get(7).add(8);
//        graphList.get(8).add(6);
        return graphList;
    }

  public List<List<Integer>> getUndirectedGraph(){
      int vertex = 5;
      List<List<Integer>> graphList = new ArrayList<>();
      for(int i=0;i<vertex;i++){ graphList.add(new ArrayList<>()); }
      graphList.get(0).add(1);
      graphList.get(0).add(3);
//      graphList.get(0).add(0);

      graphList.get(1).add(0);
//      graphList.get(1).add(1);
      graphList.get(1).add(2);

      graphList.get(2).add(1);
      graphList.get(2).add(3);
//      graphList.get(2).add(2);

      graphList.get(3).add(2);
      graphList.get(3).add(0);

      graphList.get(2).add(4);
      graphList.get(3).add(4);

      graphList.get(4).add(2);
      graphList.get(3).add(3);



      return graphList;
  }
}
