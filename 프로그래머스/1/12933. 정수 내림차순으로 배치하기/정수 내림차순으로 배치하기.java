import java.util.ArrayList;

class Solution {
    public long solution(long n) {
        //(1) 자릿수 추출 및 저장
        ArrayList<Long> numbs = new ArrayList<>();
        while(n>0){
            numbs.add(n % 10);
            n /= 10;
        }
        //(2) 각 자릿수 내림차순 정렬
        for(int i=0; i<numbs.size(); i++){
            for(int j=i+1; j<numbs.size(); j++){
                if(numbs.get(i) < numbs.get(j)){
                    long temp = numbs.get(i);
                    numbs.set(i, numbs.get(j));
                    numbs.set(j, temp);
                }
            }
        }
        //(3) 하나의 수로 합치기
        String result = "";
        for(int i=0; i<numbs.size(); i++){
            result += String.valueOf(numbs.get(i));
        }

        long answer = Long.valueOf(result);
        return answer;
    }
}