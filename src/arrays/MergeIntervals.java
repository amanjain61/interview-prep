package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {

  class Interval{
    Interval(int start,int end){
      this.start = start;
      this.end = end;
    }

    int start;
    int end;
  }

  public int[][] mergeIntervals(int[][] intervals) {

    Interval[] arr = new Interval[intervals.length];
    for(int i=0;i<intervals.length;i++){
      Interval in = new Interval(intervals[i][0],intervals[i][1]);
      arr[i] = in;
    }
    Comparator<Interval> comp = new Comparator<Interval>(){
      @Override
      public int compare(Interval i1,Interval i2){
        return i1.start-i2.start;
      }
    };

    Arrays.sort(arr,comp);

    int index = 0;

    for(int i=1;i<arr.length;i++){

      //merge if prev interval end is greater than curr interval's start
      if(arr[index].end  >= arr[i].start){
        arr[index].end = arr[i].end>arr[index].end?arr[i].end:arr[index].end;
      }else{
        index++;
        arr[index] = arr[i];
      }
    }

    int[][] res = new int[index+1][2];
    for(int i=0;i<=index;i++){
      res[i][0] = arr[i].start;
      res[i][1] = arr[i].end;
    }
    return res;

  }

  public static void main(String args[]){

    int[][] arr = {{1,2},{1,5},{2,3},{3,4}};
//    int[][] arr = {{1,2},{2,3},{5,5}};
//    int[][] arr = {{1,1},{2,2},{3,3}};
//    int[][] arr = {{1,4},{6,7},{4,5}};
    int[][] res = new MergeIntervals().mergeIntervals(arr);
    for(int i=0;i<res.length;i++){
      System.out.print(" {"+res[i][0]+","+res[i][1]+"}");
    }
  }

}
