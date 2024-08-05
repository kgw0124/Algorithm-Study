import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 1.
        int[] fail = new int[N+1];
        int[] total = new int[N+1];
        for(int i=0; i<stages.length; i++){
            int index = stages[i];
            // 1-1. 마지막 스테이지까지 성공
            if(index == N+1){
                for(int j=1; j<=N; j++){
                    total[j]++;
                }
                continue;
            }
            
            // 1-2. index 스테이지 실패 처리 + index 이전 스테이지 성공 처리
            fail[index]++;
            for(int j=1; j<=index; j++){
                total[j]++;
            }
        }    
    
        // 2. 실패율 계산
        HashMap<Integer, Double> rates = new HashMap<>();
        for(int i=1; i<=N; i++){
            if(total[i]==0){
                rates.put(i,0.0);
                continue;
            }
            rates.put(i, (double)fail[i]/total[i]);
        }
        
        // 3. 실패율 정렬
        List<Map.Entry<Integer, Double>> entryList = new LinkedList<>(rates.entrySet());
        entryList.sort(((o1, o2) -> rates.get(o2.getKey()).compareTo(rates.get(o1.getKey()))));
        
        // 4.
        int[] answer = new int[N];
        int index = 0;
        for(Map.Entry<Integer, Double> entry : entryList){
            answer[index] = entry.getKey();
            index++;
        }
        return answer;
    }
}