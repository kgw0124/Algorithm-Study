import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>(); // answer의 길이가 가변적이라 int[] 대신 ArrayList 사용
        
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){ // numbers의 길이 범위가 좁아서 중첩 반복문 사용해도 괜찮다.
                int temp = numbers[i] + numbers[j];
                if(!answer.contains(temp)){ // [함수 암기] ArrayList의 포함 여부 판단
                    answer.add(numbers[i] + numbers[j]);
                }
            }
        }
        
        Collections.sort(answer); // [함수 암기] ArrayList의 정렬 수행
        
        return answer;
    }
}