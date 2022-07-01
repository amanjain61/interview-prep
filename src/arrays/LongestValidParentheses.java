package arrays;

import java.util.Stack;

public class LongestValidParentheses {

  /**
   * Given a string containing just the characters '(' and ')', find the length of the longest valid
   * (well-formed) parentheses substring.
   */


  public static void main(String args[]) {
    String s = "()()(())";
    Stack<Character> stack = new Stack<Character>();
    boolean start = false;
    int len = 0;
    int lastValidIndex = 0;
    for (int i = 0; i < s.length(); i++) {
      // the string didn't start yet
      if (!start) {
        if (s.charAt(i) == ')') {
          if (!stack.isEmpty()) {
            char c = stack.peek();
            if (c == '(') {
              stack.pop();
              start = true;
              len += 2;
              lastValidIndex = i;
            }
          } else {
            stack.push(s.charAt(i));
          }
        } else {
          stack.push(s.charAt(i));
        }
      }else {

        if (s.charAt(i) == ')') {
          if (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(') {
              if(i-lastValidIndex>2) break;
              start = true;
              len += 2;
              lastValidIndex = i;
            } else {
              break;
            }
          }
        }else {
          stack.push(s.charAt(i));
        }
      }
    }
    System.out.println("LongestValidParentheses length: " + len);
  }
}
