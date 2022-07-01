package bitmanipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintAllTheSubSets {

  private Map<String,Long> apiCallMap = new HashMap<>();
  private Map<String,Integer> limitsMap = new HashMap<>();
  private Map<String,Long> apiReqMap = new HashMap<>();

  private long canExecute(String resourceId, String customerId) {
  List<String> limits = new ArrayList<>();
    for(String limit:limits){
      String[] arr = limit.split(" ");
      limitsMap.put(arr[0]+"_"+arr[1] , Integer.valueOf(arr[2]));
      Integer sa  = Integer.MIN_VALUE;
    }

    Long currTime = System.currentTimeMillis();
    String resourceCustomerKey = resourceId+"_"+customerId;
    if(apiCallMap.containsKey(resourceCustomerKey)){
      Long lastExecTime = apiCallMap.get(resourceCustomerKey);
      if(currTime >= (lastExecTime + 1000)){
        return 0;
      }else{
          return lastExecTime + 1000 - currTime;
      }
    }else{
      apiCallMap.put(resourceCustomerKey,currTime);
    }
    return 0;
  }

  public static void main(String args[]){
    char[] arr = {'A','B','C'};

    System.out.println("the total : "+ Math.pow(2,arr.length)+"\n");

    for(int i=0;i<Math.pow(2,arr.length);i++){
      System.out.print("{");

      for(int j=0;j<arr.length;j++){

        if((i & (1<<j)) > 0){
          System.out.print(arr[j]+" ");
        }

      }

      System.out.println("}");
    }
  }
}
