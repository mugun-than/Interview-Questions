import java.util.*;

public class Parenthisis {
    public static void main(String[] a) {
        Stack<Character> stack = new Stack<>();
        String s = "System.out.";
        boolean flag = false;
        for(char c : s.toCharArray()) {
            if(flag) break;
            switch(c) {
                case '(': 
                    stack.push(')');
                    break;
                case '{': 
                    stack.push('}');
                    break;
                case '[': 
                    stack.push(']');
                    break;
                case ')':
                    if(!stack.isEmpty() && stack.pop() != c){
                        flag = true;
                        System.out.println("INVALID");
                    }
                    break;
                case ']':
                if(!stack.isEmpty() && stack.pop() != c){
                    flag = true;
                    System.out.println("INVALID");
                }
                break;
                case '}':
                    if(!stack.isEmpty() && stack.pop() != c){
                        flag = true;
                        System.out.println("INVALID");
                    }
                    break;
            }
        }

        if(!flag && stack.isEmpty()) System.out.println("VALID");
    }
}
