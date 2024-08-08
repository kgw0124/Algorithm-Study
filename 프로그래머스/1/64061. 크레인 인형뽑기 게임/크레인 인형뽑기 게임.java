import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        
        for(int m: moves){
            for(int i=0; i<board.length; i++){
                int item = board[i][m-1];
                System.out.println(item);
                if(item == 0){
                    continue;
                }
                
                if(basket.isEmpty()){
                    basket.push(item);
                }else{
                    if(basket.peek() == item){
                        basket.pop();
                        answer += 2;
                    }else{
                        basket.push((item));
                    }
                }
                board[i][m-1] = 0;
                break;
            }
        }
        
        return answer;
    }
}