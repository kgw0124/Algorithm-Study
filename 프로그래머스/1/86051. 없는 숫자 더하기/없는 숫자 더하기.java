import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        for(int i=0; i<=9; i++){
            if(!contain(numbers, i)){
                answer += i;
            }
        }
        
        return answer;
    }
    
    public boolean contain(int[] numbers, int num){
        for(int i=0; i<numbers.length; i++){
            if(num == numbers[i]){
                return true;
            }
        }
        return false;
    }
}