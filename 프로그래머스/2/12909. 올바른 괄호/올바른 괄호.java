import java.util.*;

class Solution {
    boolean solution(String s) {
        
        Stack<String> stack = new Stack<>();
        
        for (int i=0; i<s.length(); i++){
            char w = s.charAt(i);
            
            if(w == '('){
                stack.push(w + "");
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}