import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {   
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++){
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;          
            if(start == end){ // [4,4,1]과 같은 경우
                answer[i] = array[start];
                continue;
            }
            int find = commands[i][2] - 1; 
            
            int[] temp = new int[end - start + 1];
            int tempIndex = 0;
            for(int j=start; j<=end; j++){ // array 및 commands의 길이 범위가 작아서 중첩 반복문 사용해도 괜찮다.
                temp[tempIndex] = array[j];
                tempIndex++;
            }

            Arrays.sort(temp); // 정렬 수행
            
            answer[i] = temp[find];
        }
        
        return answer;
    }
}