import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        // 성격 지표
        String[] name = new String[4];
        name[0] = "RT";
        name[1] = "CF";
        name[2] = "JM";
        name[3] = "AN";
        int[][] score = new int[4][2];
        
        // 성격 점수 채점
        int size = survey.length;
        for(int i=0; i<size; i++){
            int choice = choices[i];
            
            String type = "";
            if(choice == 4){
                continue;
            }else if(choice <= 3){ // 비동의
                type = survey[i].charAt(0) + "";
            }else if(choice >= 5){ // 동의
                type = survey[i].charAt(1) + "";
            }
            
            int typeNum = getTypeNum(type);
            int typeIndex = getTypeIndex(type);
            switch(choice){
                case 1, 7:
                    score[typeNum][typeIndex] = score[typeNum][typeIndex] + 3;
                    break;
                case 2, 6:
                    score[typeNum][typeIndex] = score[typeNum][typeIndex] + 2;
                    break;                    
                case 3, 5:
                    score[typeNum][typeIndex]++;
                    break;
            }
        }
        
        // 결과 도출
        String answer = "";
        for(int i=0; i<4; i++){
            int score1 = score[i][0];
            int score2 = score[i][1];
            
            String temp = "";
            if(score1 >= score2){
                temp = name[i].charAt(0) + ""; 
            }else{
                temp = name[i].charAt(1) + "";
            }
            answer += temp;
        }
        return answer;
    }
    
    public int getTypeNum(String type){
        int typeNum = 0;
        switch(type){
            case "R", "T":
                typeNum = 0;
                break;
            case "C", "F":
                typeNum = 1;
                break;
            case "J", "M":
                typeNum = 2;
                break;
            case "A", "N":
                typeNum = 3;
                break;
        }
        return typeNum;
    }
    
    public int getTypeIndex(String type){
        int typeIndex = 0;
        switch(type){
            case "R", "C", "J", "A":
                typeIndex = 0;
                break;
            case "T", "F", "M", "N":
                typeIndex = 1;
                break;
        }
        return typeIndex;
    }
}