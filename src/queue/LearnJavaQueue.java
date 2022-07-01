package queue;

import java.util.LinkedList;
import java.util.Queue;

public class LearnJavaQueue {

  public static void main(String[] args){
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);

    System.out.println("peek the queue :: " +queue.peek());
    System.out.println("Iterating the queue after peek :: ");
    queue.stream().forEach(val->{
      System.out.print(val+" ,");
    });

    System.out.println("poll the queue :: " +queue.poll());
    System.out.println("poll the queue :: " +queue.poll());
    System.out.println("Iterating the queue after poll :: ");
    queue.stream().forEach(val->{
      System.out.print(val+" ,");
    });

  }

}
