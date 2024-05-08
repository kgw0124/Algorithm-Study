import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int size = friends.length;
        
        // 1. friendsMap 생성
        Map<String, Integer> friendsMap = new HashMap<>();
        for(int i=0; i<size; i++){
            friendsMap.put(friends[i], i);
        }
        
        // 2. A와 B 간의 주고받은 선물, 선물 지수 표 생성
        int[][] giftGraph = new int[size][size];
        int[][] countGraph = new int[size][2]; // 0:준 선물, 1:받은 선물
        
        for(String gift : gifts){
            String A = gift.split(" ")[0];
            String B = gift.split(" ")[1];
            
            Integer indexA = friendsMap.get(A);
            Integer indexB = friendsMap.get(B);
            
            giftGraph[indexA][indexB]++;
            countGraph[indexA][0]++;
            countGraph[indexB][1]++;
        }

        // 3. 다음 달 선물 예측
        ArrayList<Integer> nextMonth = new ArrayList<>(); // 밑에서 최댓값 편하게 구하기 위해서 배열 대신 사용
        for(int i=0; i<size; i++){
            nextMonth.add(0);
        }
        
        for(int A=0; A<size; A++){
            for(int B=0; B<size; B++){
                if(A == B){
                    continue;    
                }
                
                if(giftGraph[A][B] > giftGraph[B][A]){
                    nextMonth.set(A, nextMonth.get(A)+1);
                    continue;
                }
                
                if(giftGraph[A][B]==0&&giftGraph[B][A]==0 || giftGraph[A][B]==giftGraph[B][A]){
                    int countA = countGraph[A][0] - countGraph[A][1];
                    int countB = countGraph[B][0] - countGraph[B][1];
                    if(countB < countA){
                        nextMonth.set(A, nextMonth.get(A)+1);
                    }
                }
            }
        }

        // 4.
        int answer = Collections.max(nextMonth);
        return answer;
    }
}