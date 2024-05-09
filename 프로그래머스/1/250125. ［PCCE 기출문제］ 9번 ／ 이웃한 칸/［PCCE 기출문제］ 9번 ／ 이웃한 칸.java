class Solution {
    public int solution(String[][] board, int h, int w) {
        // 1.
        int n = board.length;
        
        // 2.
        int count = 0;
        
        // 3.
        int[] dh = new int[]{0, 1, -1, 0}; // 세로 비교
        int[] dw = new int[]{1, 0, 0, -1}; // 가로 비교
        
        System.out.println("기준 : " + board[h][w]);
        // 4.
        for(int i=0; i<4; i++){
            // 4-1.
            int h_check = h + dh[i]; // 세로 비교
            int w_check = w + dw[i]; // 가로 비교
            // 4-2.
            if(0<=h_check&&h_check<n && 0<=w_check&&w_check<n){
                // 4-3.
                if(board[h][w].equals(board[h_check][w_check])){
                    count++;
                }
            }
            
        }
        
        // 5.
        return count;
    }
}