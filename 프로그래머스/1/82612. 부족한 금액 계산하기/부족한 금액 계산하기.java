class Solution {
    public long solution(int price, int money, int count) {
        Long total = 0L;
        for(int i=1; i<=count; i++){
            total += price * i;
        }
        
        // 음수 처리
        Long diff = total - new Long(money);
        if(diff <= 0L){
            diff = 0L;
        }
        
        long answer = diff;
        return answer;
    }
}