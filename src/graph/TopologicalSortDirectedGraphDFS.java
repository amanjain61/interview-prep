package graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDirectedGraphDFS {


  // use a stack where we do first in last out
  // a--> b -->c => the topological order for this should be abc
  // in the above graph, we'll push c first, using DFS and then b and then A then pop things from the stack one by one
  // this will give us the topological order
  // if there are nodes u->v then u should always come before v - this is the topological rule



  public static void topologicalSort(int vertex,List<List<Integer>> graph,boolean[] visited, Stack<Integer> stack){
      visited[vertex] = true;
      for(Integer node:graph.get(vertex)){
        if(!visited[node]){
          topologicalSort(node,graph,visited,stack);
        }
      }
    stack.push(vertex);
  }


  public static void main(String args[]){
    List<List<Integer>> graph = new GraphObjectService().getDirectedGrapWithoutCycle();
    boolean[] visited = new boolean[graph.size()];
    Stack<Integer> stack = new Stack<>();
    Arrays.fill(visited,false);
    for(int i=0;i<graph.size();i++){
      if(!visited[i]){
        topologicalSort(i,graph,visited,stack);
      }
    }

    System.out.println("Using reduce to find the min element :: "+stack.stream().reduce((val1,val2)-> val1<val2?val1:val2).get());
    System.out.println("Using reduce to find the max element :: "+stack.stream().reduce((val1,val2)-> val1<val2?val2:val1).get());

    System.out.println("Topological order ==> ");
    Iterator iter = stack.iterator();
    while(iter.hasNext()){
      System.out.print(iter.next()+" ");
    }
    System.out.print("\n ");
    for(Integer val:stack){
      System.out.print(val+" ");
    }
    System.out.print("\n ");
    for(int i=stack.size()-1;i>=0;i--){
      System.out.print(stack.get(i)+" ");
    }
    System.out.print("\n ");
    while (!stack.isEmpty()){
      System.out.print(stack.pop()+" ");
    }


//    stack.stream().forEach(val->{
//
//    });

  }
}
