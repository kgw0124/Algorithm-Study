import java.util.*;

class Solution {
    public int solution(int order) {
        String s_order = Integer.toString(order); // charAt()을 사용 가능하도록 int -> String 자료형 변환
        int answer = 0;
        
        for(int i=0; i<s_order.length(); i++){
            if(s_order.charAt(i) == '3' | s_order.charAt(i) == '6' | s_order.charAt(i) == '9'){
                answer++;
            }
        }

        return answer;
    }
}