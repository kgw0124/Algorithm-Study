import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        // 1.        
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<progresses.length; i++){
            int day = (int)Math.ceil((100.0 - progresses[i])/speeds[i]);
            queue.add(day);
        }
        
        // 2.
        ArrayList<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()){
            int temp = 1;
            int top = queue.poll();
            while(!queue.isEmpty() && top >= queue.peek()){
                top = Math.max(top, queue.poll()); // ** top 갱신 조심
                temp++;
            }
            answer.add(temp);
        }
        
        return answer;
    }
}