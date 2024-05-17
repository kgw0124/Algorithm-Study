import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        for(int x=0; x<nums.length; x++){
            for(int y=x+1; y<nums.length; y++){
                for(int z=y+1; z<nums.length; z++){
                    int num1 = nums[x];
                    int num2 = nums[y];
                    int num3 = nums[z];
                    int total = num1 + num2 + num3;
                    if(isPrime(total)){
                        answer++;
                    }
                }
            }
        }
        
        return answer;
    }
    
    public boolean isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}