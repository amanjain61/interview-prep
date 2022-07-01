package arrays;

import java.util.HashMap;
import java.util.Map;

public class ValidParantheses {

  public static void main(String args[]){
    String str = "{[()]}";
    Map<Character,Character> map = new HashMap<>();
    map.put('}','{');
    map.put(']','[');
    map.put(')','(');

    int i=0;int j=1;
    boolean isValid = true;
    while(true){
      if(j>str.length()) break;
      if(i==0) i=j-1;
      char curr_char = str.charAt(j);
      if(map.values().contains(str.charAt(j))){
        char prev_char = str.charAt(i);
        System.out.println("curr_char : "+curr_char+" == prev_char : "+prev_char);
          if(map.get(curr_char)==prev_char){
            i--;
            j++;
          }else{
            isValid = false;
            return;
          }
      }else{
        i++;
        j++;
      }
    }
//    if(i!=0 && i!=)


  }
}
