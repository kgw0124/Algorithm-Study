import java.util.*;

class Solution {
    public int[] scores = new int[4];
    public int idx = 0;
    
    public int solution(String dartResult) {    
        int i=0;
        while(i<dartResult.length()){
            char temp1 = dartResult.charAt(i);
            char temp2 = dartResult.charAt(Math.min(i+1, dartResult.length()-1));
            
            // 10 이다.
            String isTen = temp1 + "" + temp2;
            if(isTen.equals("10")){
                calcScore(10);
                i+=2;
                continue;
            }
            
            // 10 아니다.
            switch(temp1){
                case '*', '#':
                    calcOption(temp1);
                    break;
                case 'S', 'D', 'T':
                    calcBonus(temp1);
                    break;
                default:
                    calcScore(temp1 - 48);
                    break;
            }
            i++;
        }
        
        int answer = 0;
        for(int score:scores){
            System.out.println(score);
            answer += score;
        }
        return answer;
    }
    
    public void calcOption(char type){
        int nowIdx = idx-1;
        int pastIdx = idx-2;        
        switch(type){
            case '*':
                scores[nowIdx] *= 2;
                if(pastIdx>=0){
                    scores[pastIdx] *= 2;
                }
                break;
            default: // #
                scores[nowIdx] *= -1;
                break;
        }
    }
    
    public void calcBonus(char type){
        int score = scores[idx-1];
        switch(type){
            case 'D':
                scores[idx-1] = score*score;
                break;
            case 'T':
                scores[idx-1] = score*score*score;
                break;
            default: // S
                break;
        }
    }
    
    public void calcScore(int score){
        scores[idx] = score;
        idx++;
    }
}