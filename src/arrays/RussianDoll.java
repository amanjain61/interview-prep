package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDoll {

  // 1,2,4,5,6,7,8
  // 0,1,2,3,4,5,6
  // start = 0, end = 6, mid = 3
  // end = 3, start = 0 , mid = 0 + (3-0)/2 = 1

  public static int binarySearch(int target,int[] height,int start, int end){
    while(start<end){
      int mid = start+(end-start)/2;
      if(height[mid] == target) return mid;
      else if(height[mid]> target){
        end = mid;
      }else{
        start = mid+1;
      }
    }
    return start;
  }

  /**
   * keep an index =0;
   * find the envelope that could fit and do index++;
   * for all other elements in the loop, compare from the index value to the prev value
   * @param envelopes
   * @return
   */
  public static int maxEnvelopes(int[][] envelopes) {

    Comparator<int[]> comp = new Comparator<int[]>(){
      @Override
      public int compare(int[] i1,int[] i2){
        if(i1[0] == i2[0]) return i2[1]-i1[1];
        else return i1[0]-i2[0];
      };
    };
    Arrays.sort(envelopes,comp);
    int[] height = new int[envelopes.length];
    int maxLen = 0;
    for(int i=0;i<height.length;i++){
      // find the index to place the height of envelope[i]
      int index = binarySearch(envelopes[i][1],height,0,maxLen);
      height[index] = envelopes[i][1];
      if(index==maxLen){
        maxLen++;
      }
    }
    return maxLen;
//    int envs = 1;
//
//    Arrays.sort(envelopes,comp);
//    Arrays.stream(envelopes).forEach(val-> System.out.print(" {"+val[0]+","+val[1]+"}"));
//
//    for(int i=1;i<envelopes.length;i++){
//      for(int j=0;j<i;j++){
//        int w = envelopes[i][0];
//        int h = envelopes[i][1];
//        if(envelopes[j][0] < w && envelopes[j][1] < h
//            && dp[i] < dp[j]+1){
//            dp[i] = dp[i]+1;
//            if(dp[i]>envs) {
//            envs = dp[i];
//          }
//        }
//      }
//    }
//    return envs;
  }

  public static void main(String args[]){
    int arr[] = {1,2,3,4};
    int envelopes[][] = { {2,100}, {3,200}, {4,300}, {5,500}, {5,400}, {5,250}, {6,370}, {6,360}, {7,380}};
    System.out.println("\nMax env no: "+maxEnvelopes(envelopes));
  }
}
