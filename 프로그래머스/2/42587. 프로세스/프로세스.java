import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 1.
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int p: priorities){
            queue.add(p);
        }
        
        // 2.
        int answer = 0;
        while(!queue.isEmpty()){
            for(int i=0; i<priorities.length; i++){
                if(priorities[i] == queue.peek()){
                    queue.poll();
                    answer++;
                    if(i == location){
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}