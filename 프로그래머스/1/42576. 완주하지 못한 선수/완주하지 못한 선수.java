import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 1. participant, completion 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        // 2. participant, completion 비교
        for(int i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i]; // 답이 중간에 위치한 경우
            }
        }
        
        // 3.
        String answer = participant[participant.length - 1]; // 답이 마지막에 위치한 경우
        return answer;
    }
}