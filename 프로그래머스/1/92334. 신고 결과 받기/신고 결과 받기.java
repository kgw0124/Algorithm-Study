import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        /* (1) id별 고정 index 부여 */
        Integer size = id_list.length;
        HashMap<String, Integer> index = new HashMap<>();
        for(int i=0; i<size; i++){
            index.put(id_list[i], i);
        }
        
        /* (2) 변수 생성 및 초기화 */
        // 2-1. id별 신고 당한 횟수 저장
        int[] count = new int[size];
        // 2-2. id별 신고 날린 id 저장
        ArrayList<Set<String>> from = new ArrayList<>(); 
        for(int i=0; i<size; i++){
            Set<String> temp = new HashSet<>();
            from.add(temp);
        }
        
        
        /* (3) id별 신고 당한 횟수 count */
        for(int i=0; i<report.length; i++){
            String[] temp = report[i].split(" ");
            String id1 = temp[0]; // 신고 날린 id
            String id2 = temp[1]; // 신고 당한 id
            Integer id2_index = index.get(id2);
            
            // 3-1. id2별 id1 정리
            boolean isExist = from.get(id2_index).add(id1);
            
            // 3-1. 이미 신고한 이력이 없을 경우에만, id2별 신고 당한 횟수 count
            if(isExist){
                count[id2_index]++;
            }
        }
    
        /* (4) */
        int[] answer = new int[size];
        for(int i=0; i<size; i++){
            if(count[i] >= k){
                for(String id: from.get(i)){
                    Integer id_index = index.get(id);
                    answer[id_index]++;
                }
            }
        }
        return answer;
    }
}