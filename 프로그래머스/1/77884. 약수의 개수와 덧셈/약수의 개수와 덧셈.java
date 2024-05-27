class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i=left; i<=right; i++){
            int measureCount = 0;
            for(int j=1; j<=i; j++){
                if(i%j==0){
                    measureCount++;
                }
            }
            
            if(measureCount%2==0){
                answer += i;
                continue;
            }
            answer -= i;
        }
        return answer;
    }
    
}