import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {        
        int zeroCount = 0;
        int min = 0;
        for(int i=0; i<6; i++){
            if(lottos[i] == 0){ // lottos 구성 숫자가 0인 경우
                zeroCount++;
                continue;
            }
            for(int j=0; j<6; j++){ // lottos 구성 숫자 중 win_nums에 포함된 경우
                if(lottos[i] == win_nums[j]){ 
                    min++;
                }
            }
        }
        int max = Math.min(6, zeroCount + min);
        
        int[] answer = new int[2];
        answer[0] = toRank(max);
        answer[1] = toRank(min);
        return answer;
    }
    
    public int toRank(int num){
        switch(num){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}