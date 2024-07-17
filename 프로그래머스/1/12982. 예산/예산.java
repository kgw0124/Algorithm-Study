import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        // 1. 배열 오름차순 정렬
        Arrays.sort(d);
        
        // 2.
        int i;
        int sum = 0;
        for(i=0; i<d.length; i++){
            sum += d[i];
            if(sum > budget){
                break;
            }
        }        
        
        int answer = i;
        return answer;
    }
}