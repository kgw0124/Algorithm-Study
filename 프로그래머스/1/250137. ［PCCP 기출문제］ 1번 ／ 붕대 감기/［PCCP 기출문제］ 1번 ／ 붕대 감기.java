import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // 1. bandage 처리
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];
        
        // 2.
        int tempHealth = health;
        
        int attackTimeIndex = 0;
        int extraTime = 0;
        int endTime = attacks[attacks.length - 1][0];
        
        for(int i=0; i<=endTime; i++){
            if(tempHealth <= 0){
                break;
            }
            if(i == attacks[attackTimeIndex][0]){ // 공격을 받았을 때
                tempHealth -= attacks[attackTimeIndex][1];
                tempHealth = Math.min(tempHealth, health);
                
                attackTimeIndex++;
                extraTime = 0;
            }else{ // 공격을 안 받았을 때
                tempHealth += x;
                extraTime++;
                if(extraTime == t){
                    tempHealth += y;
                    extraTime = 0;
                }
                tempHealth = Math.min(tempHealth, health);
            }
        }
        
        // 3.
        int answer = (tempHealth <= 0)?-1:tempHealth;
        return answer;
    }
}