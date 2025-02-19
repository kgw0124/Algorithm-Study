import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i=0; i<arr.length; i++){
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                continue;
            }
            
            if (stack.peek() == arr[i]){
                continue;
            }
            
            stack.push(arr[i]);
        }
        
        int[] result = new int[stack.size()];
        for (int i=0; i<stack.size(); i++){
            result[i] = stack.get(i);
        }
        return result;
    }
}