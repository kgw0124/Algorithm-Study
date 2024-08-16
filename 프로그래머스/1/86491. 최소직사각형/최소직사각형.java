import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxWeight = 0;
        int maxHeight = 0;
        for(int[] s: sizes){
            // 1.
            int weight = Math.min(s[0], s[1]);
            int height = Math.max(s[0], s[1]);
            
            // 2.
            maxWeight = Math.max(maxWeight, weight);
            maxHeight = Math.max(maxHeight, height);
        }
        
        int answer = maxWeight * maxHeight;
        return answer;
    }
}