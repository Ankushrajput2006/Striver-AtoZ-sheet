
public class RemoveOuterMostParentheses {
 public static void main(String[] args) {
  String s = "(()())(())";
  System.out.println(removeOuterParentheses(s));
 }
 public static String removeOuterParentheses(String s) {
  StringBuilder result = new StringBuilder();
  int openCount = 0;

  for (char c : s.toCharArray()) {
    if (c == ')') {
      openCount--;
    }
    if (openCount!= 0) {
      result.append(c);
    }
    if(c == '('){
    openCount++;
    }
  }

  return result.toString();
 }
    
}