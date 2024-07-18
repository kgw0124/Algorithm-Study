import java.util.*;

class Solution {
    public int solution(int n) {
        // 10진법 -> 3진법
        String toThree = Integer.toString(n,3);
        // 앞뒤 반전
        String reverse = "";
        for(int i=toThree.length()-1; i>=0; i--){
            reverse += toThree.charAt(i);
        }
        // 3진법 -> 10진법        
        int answer = Integer.parseInt(reverse, 3);
        return answer;
    }
}