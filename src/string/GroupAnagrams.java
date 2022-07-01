package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
  public static void main(String[] args){
    String[] strs = {"eat","tea","tan","ate","nat","bat"};
    System.out.println(groupAnagrams(strs));
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList();
    List<String> list = new ArrayList<>();
    list.add(strs[0]);
    result.add(list);
    for(int i=1;i<strs.length;i++){
      String string = strs[i];
      boolean stringAdded = false;
      for(List<String> subList:result){
        if(isAnagramUsingArrayOptimised(subList.get(0),string)){
          subList.add(string);
          stringAdded = true;
          break;
        }
      }
      if(!stringAdded){
        list = new ArrayList<>();
        list.add(string);
        result.add(list);
      }
    }
    return result;
  }

  public static boolean isAnagramUsingArrayOptimised(String s, String t) {
    if(s.length()!=t.length()) return false;
    int[] sarray = new int[26];
    int asciiStart = (int) 'a';
    for(int i=0;i<s.length();i++){
      sarray[(int) s.charAt(i) - asciiStart] +=1;
      sarray[(int) t.charAt(i) - asciiStart] -=1;
    }
    for(int i=0;i<26;i++){
      if(sarray[i]!=0){
        return false;
      }
    }
    String as = "";
    as.substring(0,2);
    return true;
  }

  public static boolean isAnagramUsingArray(String s, String t) {
    if(s.length()!=t.length()) return false;
    int[] sarray = new int[26];
    int[] tarray = new int[26];
    int asciiStart = (int) 'a';
    for(int i=0;i<s.length();i++){
      char schar = s.charAt(i);
      int currAsciiSchar = (int) schar;
      sarray[currAsciiSchar - asciiStart] +=1;

      char tchar = t.charAt(i);
      int currAsciiTchar = (int) tchar;
      tarray[currAsciiTchar - asciiStart] +=1;
    }
    for(int i=0;i<26;i++){
      System.out.println("char :: "+ ((char)(asciiStart+i)) +" sArray :: "+sarray[i]+"  tarray :: "+tarray[i]);
      if(sarray[i]!=tarray[i]){
        return false;
      }
    }
    return true;
  }

  public static boolean isAnagram(String s, String t) {
    if(s.length()!=t.length()) return false;
    Map<Character,Integer> smap = new HashMap<>();
    Map<Character,Integer> tmap = new HashMap<>();
    for(int i=0;i<s.length();i++){
      if(smap.containsKey(s.charAt(i))){
        smap.put(s.charAt(i),smap.get(s.charAt(i))+1);
      }else{
        smap.put(s.charAt(i),1);
      }
      if(tmap.containsKey(t.charAt(i))){
        tmap.put(t.charAt(i),tmap.get(t.charAt(i))+1);
      }else{
        tmap.put(t.charAt(i),1);
      }
    }
    for(var entry:smap.entrySet()){
      if(!tmap.containsKey(entry.getKey()) || !tmap.get(entry.getKey()).equals(entry.getValue())){
        System.out.println(entry.getKey() +"  ---  "+ entry.getValue());
        System.out.println("t- value for a "+tmap.get(entry.getKey()));
        if(tmap.get(entry.getKey()).equals(entry.getValue())){
          System.out.println("asdasjh");
        }
        if(tmap.get(entry.getKey())==entry.getValue()){
          System.out.println("asdasjh");
        }
        return false;
      }
    }
    return true;
  }
}
