package arrays;

import java.math.RoundingMode;
import java.sql.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class BaseBallGame {

  public  static void main(String args[]){

    DecimalFormat df = new DecimalFormat("#.##");
    df.setRoundingMode(RoundingMode.CEILING);
    Double sa = 1119.121212;
    System.out.println(df.format(sa));

    String ops[] = {"5","2","C","D","+"};

    List<Integer> list = new ArrayList<Integer>();
    for(String op:ops){
      System.out.println(String.valueOf(list));
      switch(op){
          case "+":
            Integer sum = list.get(list.size()-1) + list.get(list.size()-2);
            list.add(sum);
            break;

        case "D":
          Integer doub = list.get(list.size()-1) * 2;
          list.add(doub);
          break;

        case "C":
          list.remove(list.size()-1);
          break;
        default:
          System.out.println(String.valueOf(list));
          list.add(Integer.valueOf(op));
          break;
      }
    }
    int sum=0;
    for(Integer l:list){
      sum+=l;
    }

    System.out.println(sum);
  }


}
