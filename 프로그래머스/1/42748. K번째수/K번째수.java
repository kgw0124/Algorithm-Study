import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int index=0; index<commands.length; index++){
            int[] command = commands[index];
            
            int i = command[0] -1; // index 처리 : 0부터 시작하니깐 1 빼기
            int j = command[1] -1;
            int k = command[2] -1;
            ArrayList<Integer> temp = cut(array, i, j);
            
            Collections.sort(temp);
            
            answer[index] = temp.get(k);
        }        

        return answer;
    }
    
    public ArrayList<Integer> cut(int[] array, int start, int end){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=start; i<=end; i++){
            temp.add(array[i]);
        }
        return temp;
    }
}