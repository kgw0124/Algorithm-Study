import java.util.*;

class Solution {
    boolean solution(String s) {
        // 1.
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            switch(s.charAt(i)){
                case '(':
                    stack.push(0);
                    break;
                default: // )
                    if(stack.isEmpty()) return false; // 중간에 ()짝이 안 맞는 경우
                    stack.pop();
                    break;
            }
        }
        
        // 2.
        boolean answer = true;
        if(!stack.isEmpty()){
            answer = false;
        }
        return answer;
    }
}