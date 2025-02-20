import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int temp = nums.length / 2;
        
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        
        if (temp < set.size()){
            return temp;
        }else{
            return set.size();
        }
    }
}