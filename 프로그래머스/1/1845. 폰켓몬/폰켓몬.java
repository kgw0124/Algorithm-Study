import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 1. nums 속 포켓몬 종류
        Set<Integer> setNums = new HashSet<>();
        for(int num : nums){
            setNums.add(num);
        }
        int variation = setNums.size();
        
        // 2. N/2
        int half = nums.length/2;
        
        // 3. 
        int answer = (variation <= half) ? variation : half;
        return answer;
    }
}