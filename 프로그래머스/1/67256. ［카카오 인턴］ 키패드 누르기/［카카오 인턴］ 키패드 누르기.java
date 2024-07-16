import java.util.*;

class Solution {
    static HashMap<Integer, int[]> index = new HashMap<>();
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        // 1. 키패드의 각 칸마다 좌표 부여
        index.put(1, new int[]{0,0});
        index.put(2, new int[]{0,1});
        index.put(3, new int[]{0,2});
        index.put(4, new int[]{1,0});
        index.put(5, new int[]{1,1});
        index.put(6, new int[]{1,2});
        index.put(7, new int[]{2,0});
        index.put(8, new int[]{2,1});
        index.put(9, new int[]{2,2});
        index.put(10, new int[]{3,0}); // *
        index.put(0, new int[]{3,1});
        index.put(11, new int[]{3,2}); // #
        
        // 2.
        int left = 10;
        int right = 11;
        for(int i=0; i<numbers.length; i++){
            int temp = numbers[i];
            // 1, 4, 7인 경우
            if(temp == 1 || temp == 4 || temp == 7){
                answer += "L";
                left = temp;
                continue;
            }
            
            // 3, 6, 9인 경우
            if(temp == 3 || temp == 6 || temp == 9){
                answer += "R";
                right = temp;
                continue;
            }
            
            // 2, 5, 8, 0인 경우
            int fromLeft = calc(left, temp);
            int fromRight = calc(right, temp);
            
            if(fromLeft > fromRight){
                answer += "R";
                right = temp;
                continue;
            }
            
            if(fromLeft < fromRight){
                answer += "L";
                left = temp;
                continue;
            }
            
            // fromLeft = fromRight
            if(hand.equals("left")){
                answer += "L";
                left = temp;
                continue;
            }
            if(hand.equals("right")){
                answer += "R";
                right = temp;
                continue;
            }
        }
        
        return answer;
    }
    
    // 두 점 사이의 거리 구하기 by. 맨하탄
    public int calc(int from, int to){
        int[] fromIndex = index.get(from);
        int[] toIndex = index.get(to);
        int distance = Math.abs(toIndex[0] - fromIndex[0]) + Math.abs(toIndex[1] - fromIndex[1]);
        return distance;
    }
}