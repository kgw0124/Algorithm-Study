import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int idx=0; idx<commands.length; idx++){
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];

            ArrayList<Integer> temp = new ArrayList<>();
            for (int idx2=i; idx2<=j; idx2++){
                temp.add(array[idx2-1]);
            }
            Collections.sort(temp);
            answer[idx] = temp.get(k-1);
        }
        
        return answer;
    }
}