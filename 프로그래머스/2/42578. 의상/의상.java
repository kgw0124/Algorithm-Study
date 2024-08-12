import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 1.
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            if(!map.containsKey(key)){ // 새로운 key값
                map.put(key, 2); // 2인 이유: 해당 value 입는 경우 + 안 입는 경우
            }else{
                map.put(key, map.get(key)+1); // 이미 존재하는 key값
            }
        }
        
        // 2.
        int answer = 1;
        Collection<Integer> arr = map.values();
        for(int i: arr){
            answer *= i;
        }
        answer -= 1;
        
        return answer;
    }
}