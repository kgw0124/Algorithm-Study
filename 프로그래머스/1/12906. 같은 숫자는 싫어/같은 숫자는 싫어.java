import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        // 1. 초기화
        stack.push(arr[0]);
        
        // 2. 연속적인 숫자인지 확인
        for(int i=1; i<arr.length; i++){
            int past = stack.peek();
            if(arr[i] == past){
                continue;
            }
            stack.push(arr[i]);
        }
        
        // 3.
        int[] answer = new int[stack.size()];
        for(int i=0; i<stack.size(); i++){
            answer[i] = stack.get(i);
        }
        return answer;
    }
}